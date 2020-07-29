package neo4j;


import org.neo4j.driver.Transaction;
import org.neo4j.driver.types.Node;

public class Main {


    public static void main( String... args ) throws Exception
    {
      //  try(ConnectNeo4J greeter = new ConnectNeo4J( "bolt://localhost:7687", "neo4j", "root" ) )
      //  {

       //   greeter.addEmployAndMakeFriends();
     //   }
     //   catch (Exception e )
      //  {
      //      e.printStackTrace();
      //  }


         try(GraphManager greeter = new GraphManager( "bolt://localhost:7687", "neo4j", "root" ) )
         {

       //   greeter.addEmployAndMakeFriends();
             greeter.insertBloc(357950,357951);
          }
         catch (Exception e )
          {
             e.printStackTrace();
         }




    }
}
