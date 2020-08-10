package neo4j;

import info.blockchain.api.APIException;
import info.blockchain.api.blockexplorer.BlockExplorer;
import info.blockchain.api.blockexplorer.entity.Block;
import info.blockchain.api.blockexplorer.entity.Input;
import info.blockchain.api.blockexplorer.entity.Output;
import org.neo4j.driver.*;

import java.io.IOException;
import java.net.PasswordAuthentication;
import java.sql.PreparedStatement;
import java.util.List;

public class GraphManager implements AutoCloseable {


    private final Driver driver;

    public GraphManager(String uri, String user, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));

    }

    @Override
    public void close() throws Exception {
        driver.close();

    }


    public void insertTransaction(int debutBloc, int finBloc) throws APIException, IOException {


        Session session1 = driver.session();

        BlockExplorer blockExplorer = new BlockExplorer();
        String QueryTransaction = "MERGE (tx:tx {txid:$txid})";
        try {
            for (int j = debutBloc; j < finBloc; j++)
            {
                System.out.println("Passage au block " + j);
                try
                {

                    Block block = blockExplorer.getBlock(j);
                    List<info.blockchain.api.blockexplorer.entity.Transaction> tx = block.getTransactions();
                    for(int t = 0; t < tx.size()  ; t++)
                    {
                        try (Transaction txNEO4J = session1.beginTransaction())
                        {

                            txNEO4J.run(QueryTransaction, Values.parameters("txid", tx.get(t).getHash()));

                            txNEO4J.commit();

                        }
                        System.out.println("Transaction " + t + " OK ! ");
                    }



                }

                catch (Exception e )
                {
                    e.printStackTrace();
                }

            }
            session1.close();

        }
        catch (Exception e)
        {
            System.out.println("Bloc non disponible");
        }





    }



    public void insertInputs(int debutBloc, int finBloc) throws APIException, IOException
    {
        try
        {
            Session session2 = driver.session();
            Session session3 = driver.session();
            BlockExplorer blockExplorer = new BlockExplorer();
            String node_in = "COINBASE";
            String QueryInputCoinBase = "MERGE (tx:tx {txid :$txid }) \n " +
                    "CREATE (value_in:value_in { value : $node_in }) \n" +
                    "MERGE (value_in) -[:value_in {in :$in }]->(tx)" ;
            String QueryInputReal = "MERGE (tx:tx { txid :$txid }) \n " +
                    "CREATE(value_in:value_in {value :$value }) \n" +
                    "MERGE (value_in) -[:in {in :$in}]->(tx) \n" +
                    "MERGE (address_in:address_in {addressid_in : $addresseid_in}) \n" +
                    "MERGE (value_in) -[:unlocked_by {unlocked_by : $unlocked_by }] ->(address_in)";

            for (int j = debutBloc; j < finBloc; j++)
            {
                System.out.println("Passage au block " + j);
                try
                {

                    Block block = blockExplorer.getBlock(j);
                    List<info.blockchain.api.blockexplorer.entity.Transaction> tx = block.getTransactions();
                    for(int t = 0; t < tx.size() ; t++)
                    {

                        List<Input> inputs = tx.get(t).getInputs();



                        for(Input in  : inputs)
                        {
                            if (inputs.isEmpty() || inputs.get(0).getPreviousOutput() == null)
                            {
                                try (Transaction txNEO4JInputCOINBASE = session2.beginTransaction())
                                {
                                    txNEO4JInputCOINBASE.run(QueryInputCoinBase, Values.parameters("txid", tx.get(t).getHash(), "node_in", node_in, "in", inputs.indexOf(in)));
                                    txNEO4JInputCOINBASE.commit();
                                    continue;
                                }

                            }
                            else
                            {
                                try (Transaction txNEO4JInput = session3.beginTransaction())
                                {
                                    txNEO4JInput.run( QueryInputReal, Values.parameters("txid", tx.get(t).getHash(), "value", in.getPreviousOutput().getValueBTC(),
                                            "in", inputs.indexOf(in), "addresseid_in", in.getPreviousOutput().getAddress(), "unlocked_by", in.getPreviousOutput().getAddress()));

                                    txNEO4JInput.commit();
                                }



                            }
                            System.out.println("insertion inputs num : " + inputs.indexOf(in) );
                        }

                    }




                }

                catch (Exception e )
                {
                    e.printStackTrace();
                }


            }
            session2.close();
            session3.close();
        }
        catch (Exception e )
        {
            System.out.println("Bloc non disponible");
        }



    }


    public void insertOutputs(int debutBloc, int finBloc) throws APIException, IOException
    {
        Session session3 = driver.session();
        Session session4 = driver.session();
        String node_out = "NOADDRESS";
        String QueryOutpoutNoAddress = "MERGE (tx:tx { txid :$txid}) \n " +
                        "MERGE(value_out:value_out { value :$value }) \n" +
                        "MERGE (tx) -[:out {out : $out }]->(value_out)";
        String QueryOutpout = "MERGE (tx:tx { txid :$txid }) \n " +
                "CREATE (value_out:value_out {value : $value }) \n" +
                "MERGE (tx) -[:out {out : $out }]->(value_out) \n" +
                "MERGE  (address_out:address_out {addressid_out : $addressid_out}) \n" +
                "MERGE (value_out) -[:locked_by {locked_by : $locked_by }] ->(address_out)";

        BlockExplorer blockExplorer = new BlockExplorer();

        try
        {

            for (int j = debutBloc; j < finBloc; j++)
            {
                System.out.println("Passage au block " + j);
                try
                {

                    Block block = blockExplorer.getBlock(j);
                    List<info.blockchain.api.blockexplorer.entity.Transaction> tx = block.getTransactions();
                    for(int t = 0; t < tx.size() ; t++)
                    {

                        List<Output> outputs = tx.get(t).getOutputs();



                        for(Output out  : outputs)
                        {
                            if (outputs.isEmpty() || outputs.get(0).getAddress()  == null)
                            {
                                try (Transaction txNEO4JOutputNoAddress = session3.beginTransaction())
                                {
                                    txNEO4JOutputNoAddress.run(QueryOutpoutNoAddress, Values.parameters("txid", tx.get(t).getHash(),
                                            "value", node_out, "out", outputs.indexOf(out)));
                                    txNEO4JOutputNoAddress.commit();
                                    continue;
                                }

                            }
                            else
                            {
                                try (Transaction txNEO4JOutput = session4.beginTransaction())
                                {
                                    txNEO4JOutput.run(QueryOutpout, Values.parameters("txid", tx.get(t).getHash(), "value", out.getValueBTC(),
                                            "out", outputs.indexOf(out), "addressid_out", out.getAddress(), "locked_by", out.getValueBTC()  )) ;
                                    txNEO4JOutput.commit();
                                }



                            }
                            System.out.println("insertion outputs num : " + outputs.indexOf(out));
                        }

                    }




                }

                catch (Exception e )
                {
                    e.printStackTrace();
                }


            }
            session3.close();
            session4.close();

        }
        catch (Exception e)
        {
            System.out.println("Bloc non disponible");
        }




    }










    }







