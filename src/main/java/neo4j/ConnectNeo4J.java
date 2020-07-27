package neo4j;

import info.blockchain.api.APIException;
import info.blockchain.api.blockexplorer.BlockExplorer;
import info.blockchain.api.blockexplorer.entity.Block;
import org.neo4j.driver.*;

import java.io.IOException;

import static org.neo4j.driver.Values.parameters;

public class ConnectNeo4J implements AutoCloseable
{
    private final Driver driver;

    public ConnectNeo4J( String uri, String user, String password )
    {
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
    }

    @Override
    public void close() throws Exception
    {
        driver.close();
    }

    public void printGreeting(  int debut,  int fin) throws APIException, IOException
    {

        for(int j = debut; j < fin; j++)
        {

            final BlockExplorer blockExplorer = new BlockExplorer();
            final Block block = blockExplorer.getBlock(j);
            try ( Session session = driver.session() )
            {

                final int finalJ = j;


                String greeting = session.writeTransaction(new TransactionWork<String>()
                {
                    @Override
                    public String execute( Transaction tx )
                    {
                        Result result = tx.run("MERGE (block:block {num:$blocknum})\n" +
                                        "SET block.prevblock=$prevblocknum, \n" +
                                        "block.time=$timestamp, \n" +
                                        "block.txcount=$txcount \n" +
                                        "MERGE (prevblock:block { num:$prevblocknum}) MERGE (block)-[:chain]->(prevblock) \n ",

                                parameters("blocknum", finalJ,
                                        "prevblocknum", finalJ - 1 ,
                                        "timestamp", block.getTimeHuman(),
                                        "txcount", block.getTransactions().size()));
                        // return result.single().get( 0 ).asString();

                        return result.consume().toString();

                    }
                } );
                System.out.println( greeting );
            }
        }


    }







}



