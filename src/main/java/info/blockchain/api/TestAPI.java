package info.blockchain.api;

import info.blockchain.api.blockexplorer.BlockExplorer;
import info.blockchain.api.blockexplorer.entity.*;
import org.apache.commons.lang3.time.StopWatch;


import java.util.ArrayList;
import java.util.List;

import static info.blockchain.api.Util.SATOSHI_IN_BTC;

public class TestAPI {


    public static void main(String[] args) throws Exception, APIException {



        BlockExplorer blockExplorer = new BlockExplorer();
        StopWatch stopwatch = new StopWatch();



                for (int i = 556526; i < 556528; i++)

                    try {

                        {
                            stopwatch.start();

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
                                    if (inputs.isEmpty() || inputs.get(0).getPreviousOutput() == null)
                                    {
                                        System.out.println("Création monnaie ");
                                        System.out.println("ici " + inputs.indexOf(in));
                                        continue;
                                        //in.getPreviousOutput()


                                    }
                                    else {
                                        System.out.println("@ICI " +  in.getPreviousOutput().getTxIndex());
                                        System.out.println("@Emetteur " + in.getPreviousOutput().getAddress());
                                        System.out.println("Montant Compte emetteur BITCOIN " + in.getPreviousOutput().getValueBTC());

                                    }


                                }
                                for (Output out : outputs)
                                {
                                    if (outputs.isEmpty() || outputs.get(0).getAddress() == null)
                                    {
                                        System.out.println("Création monnaie ");
                                        System.out.println("ici " + inputs.indexOf(out));

                                        continue;


                                    } else {
                                        System.out.println("@Emetteur " + out.getAddress());

                                        System.out.println("Montant Compte emetteur BITCOIN " + out.getValueBTC());

                                        //System.out.println("ici " + inputs.indexOf(in));
                                        //System.out.println("ici " + inputs.indexOf(in));
                                    }

                                }


                            }


                            System.out.println("##########################################");





                        }
                        stopwatch.stop();
                        long timeTaken = stopwatch.getTime();
                        System.out.println("ca a pris " + timeTaken);
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


























































