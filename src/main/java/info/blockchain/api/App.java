package info.blockchain.api;

import info.blockchain.api.blockexplorer.BlockExplorer;
import info.blockchain.api.blockexplorer.entity.*;


import java.util.ArrayList;
import java.util.List;

public class App
{



    public static void main(String[] args) throws Exception
    {

        BlockExplorer blockExplorer = new BlockExplorer();


        for (int i = 1; i < 3; i++)
        {

            Block block = blockExplorer.getBlock(i);
            System.out.println("Num block " + i);
            System.out.println("Hash block " + block.getHash());
            System.out.println("Nb de transactions " + block.getTransactions().size());
            System.out.println("Date du block " + block.getTimeHuman());

            List<Transaction> tx = block.getTransactions();

            for(int t = 0; t < block.getTransactions().size() ; t++)
            {
                List<Input> inputs = tx.get(t).getInputs();
                List<Output> outputs = tx.get(t).getOutputs();
                if (inputs.isEmpty() || inputs.get(0).getPreviousOutput() == null)
                {
                    System.out.println("Création monnaie ");
                    continue;
                }
                for (Input in : inputs)
                {
                    System.out.println("@Emetteur " + in.getPreviousOutput().getAddress());
                    System.out.println("Montant Compte emetteur " + in.getPreviousOutput().getValue());

                }

                for (Output out : outputs)
                {

                    System.out.println("@Recepteur " + out.getAddress());
                    System.out.println("Montant compte recepteur " + out.getValue());

                }

            }

            System.out.println("##########################################");
        }





    }
    }



/*
        for (Transaction tx : transactions)
        {
            List<Input> inputs = tx.getInputs();
            if (inputs.isEmpty() || inputs.get(0).getPreviousOutput() == null)
            {
                continue;
            }
            for (Input in : inputs)
            {
                System.out.println(in.getPreviousOutput().getAddress());
              //  wTx.write(generateInputRecord(tx.getIndex(), tx.getHash(),
                 //       in.getPreviousOutput().getAddress(), in
                   //             .getPreviousOutput().getValue())
                     //   + "\n");
            }
            List<Output> outputs = tx.getOutputs();
            for (Output out : outputs)
            {
             //   wTx.write(generateOutputRecord(tx.getIndex(), tx.getHash(),
                //        out.getAddress(), out.getValue()) + "\n");
            }
        }

 */



































