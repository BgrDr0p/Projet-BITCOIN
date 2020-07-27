package neo4j;


import org.neo4j.driver.Transaction;

public class Main {


    public static void main( String... args ) throws Exception
    {
        try(ConnectNeo4J greeter = new ConnectNeo4J( "bolt://localhost:7687", "neo4j", "root" ) )
        {
          //  greeter.printGreeting(0,10);

            greeter.printGreeting(0,124);

        }
        catch (Exception e )
        {
            e.printStackTrace();
        }
    }
}
