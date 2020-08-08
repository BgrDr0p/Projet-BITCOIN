package neo4j;




public class Main {


    public static void main( String... args ) throws Exception
    {



        try(GraphManager greeter = new GraphManager( "bolt://localhost:7687", "neo4j", "root" ) )
         {
              /*
          BlockExplorer BE = new BlockExplorer();
        // BE.getLatestBlock();

        //  System.out.println( BE.getLatestBlock().getTimeHuman());
        // Last bloc : 641355 ==> 2020-07-29 19:03

        // timespand du 01/01/2019 ==> 1546300800
        //System.out.println(BE.getBlocks("1546300800" ));


        //  List<SimpleBlock> SB =  BE.getBlocks(1546301460);
        //  System.out.println(SB.toString());

        // for(int i = 0;i < SB.size(); i++)
        // {
        // SB.get(i).getHash();
        //     System.out.println(SB.get(i).getHash());
        */






           //  1er bloc de 2019 ==> 556453
            // Last bloc : 641355 ==> 2020-07-29 19:03
             // Donc de 556 453 à 641 355

             // recommenercer a partir de 556526
            greeter.insertBloc(556526,556528);


         }
      catch (Exception e )
       {
            e.printStackTrace();
        }




    }
}
