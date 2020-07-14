package info.blockchain.api;

import info.blockchain.api.blockexplorer.BlockExplorer;
import info.blockchain.api.blockexplorer.entity.*;


import java.util.List;

public class App {

    public static void main(String[] args) throws Exception
    {

        BlockExplorer blockExplorer = new BlockExplorer();


        for (int i = 78900; i < 78901; i++)
        {
            Block block = blockExplorer.getBlock(i);
            System.out.println("Num block " + i);
            System.out.println("Hash block " + block.getHash());
            System.out.println("Nb de transactions " + block.getTransactions().size());
            System.out.println("Date du block " + block.getTimeHuman());

            List<Transaction> tx = block.getTransactions();

            for (int j = 0; j < block.getTransactions().size(); j++)
            {
                System.out.println("Hash des transactions " + j + " :  " + tx.get(j).getHash());
                

            }
        }


    }
}


