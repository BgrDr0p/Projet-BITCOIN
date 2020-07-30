package info.blockchain.api;

import info.blockchain.api.blockexplorer.BlockExplorer;
import info.blockchain.api.blockexplorer.entity.*;


import java.util.ArrayList;
import java.util.List;

import static info.blockchain.api.Util.SATOSHI_IN_BTC;

public class TestAPI {


    public static void main(String[] args) throws Exception, APIException {

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

        BlockExplorer blockExplorer = new BlockExplorer();



                for (int i = 556453; i < 556455; i++)
                try {

                    {

                        System.out.println(i);
                        Block block = blockExplorer.getBlock(i);
                        System.out.println("Num block " + i);
                        System.out.println("Hash block " + block.getHash());
                        System.out.println("Nb de transactions " + block.getTransactions().size());
                        //   System.out.println("Date du block " + block.getTimeHuman());

                        List<Transaction> tx = block.getTransactions();

                        for (int t = 0; t < block.getTransactions().size(); t++) {
                            List<Input> inputs = tx.get(t).getInputs();
                            List<Output> outputs = tx.get(t).getOutputs();

                            for (Input in : inputs) {
                                if (inputs.isEmpty() || inputs.get(0).getPreviousOutput() == null) {
                                    System.out.println("Création monnaie ");
                                    System.out.println("ici " + inputs.indexOf(in));
                                    continue;
                                    //in.getPreviousOutput()


                                } else {
                                    System.out.println("@Emetteur " + in.getPreviousOutput().getAddress());
                                    //   System.out.println("Montant Compte emetteur SATO " + in.getPreviousOutput().getValueBTC());
                                    //  System.out.println("Montant Compte emetteur BITCOIN " + in.getPreviousOutput().getValueBTC());


                                    // System.out.println("ici " + inputs.indexOf(in));
                                }


                            }


                        }


                        System.out.println("##########################################");


                    }
                }
                catch (Exception e)
                {
                    System.out.println("BLOC NON INSERES num " + i );

            }
                finally {
                   continue;
                }



    }

}


























































