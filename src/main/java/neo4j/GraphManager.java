package neo4j;

import info.blockchain.api.APIException;
import info.blockchain.api.blockexplorer.BlockExplorer;
import info.blockchain.api.blockexplorer.entity.Block;
import info.blockchain.api.blockexplorer.entity.Input;
import info.blockchain.api.blockexplorer.entity.Output;
import org.neo4j.driver.*;

import java.io.IOException;
import java.util.List;

public class GraphManager implements AutoCloseable
{


    private final Driver driver;

        public GraphManager( String uri, String user, String password )
        {
            driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
        }

    @Override
    public void close() throws Exception
    {
        driver.close();

    }


        public void insertBloc(int debut, int fin) throws APIException, IOException
        {


            Session session = driver.session();
            BlockExplorer blockExplorer = new BlockExplorer();

            for(int j = debut; j < fin; j++)
            {
                Block block = blockExplorer.getBlock(j);

                try( Transaction txNEO4J = session.beginTransaction() )
                {
                    txNEO4J.run("MERGE (block:block {hash:'"+ block.getHash()+ "'})\n" +
                                    "SET block.prevblock='"+ block.getPreviousBlockHash()+"', \n" +
                                    "block.time='"+ block.getTimeHuman()+"', \n" +
                                    "block.num='"+ j+"', \n" +
                                    "block.txcount='"+ block.getTransactions().size() +"' \n" +
                                    "MERGE (prevblock:block { hash:'"+ block.getPreviousBlockHash()+"'}) MERGE (block)-[:chain]->(prevblock)");
                  //tx.run( "CREATE (n:'Person' {name:'Alice'})" );

                    List<info.blockchain.api.blockexplorer.entity.Transaction> txBloc = block.getTransactions();
                    for(int t = 0; t < block.getTransactions().size() ; t++)
                    {
                        List<Input> inputs = txBloc.get(t).getInputs();
                        List<Output> outputs = txBloc.get(t).getOutputs();

                        txNEO4J.run("MATCH (block :block {hash:'" + block.getHash() + "'})\n" +
                                "MERGE (tx:tx {txid:'"+ txBloc.get(t).getHash() + "'})\n" +
                                "MERGE (tx)-[:inc {i:'"+t +"'}]->(block) \n" +
                                "SET tx += {tx}"
                        );



                    }

                  txNEO4J.commit();





                }
            }




        }





    }
