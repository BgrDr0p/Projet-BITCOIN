package info.blockchain.api;

import info.blockchain.api.blockexplorer.BlockExplorer;
import info.blockchain.api.blockexplorer.entity.Block;
import info.blockchain.api.blockexplorer.entity.Input;
import info.blockchain.api.blockexplorer.entity.Output;
import info.blockchain.api.blockexplorer.entity.Transaction;
import org.apache.commons.lang3.time.StopWatch;

import javax.swing.text.html.parser.Parser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class InsertCVS {


    public static void main(String[] args) throws Exception, APIException {

        FileWriter csvWriter = new FileWriter("new.csv");

        csvWriter.append("Tx_Hash");
       // csvWriter.append(";");
        //   csvWriter.append("input_adress");
        // csvWriter.append(";");
        //   csvWriter.append("input_value");
        //  csvWriter.append(";");
        // csvWriter.append("output_adress");
        // csvWriter.append(";");
        //  csvWriter.append("output_value");
        csvWriter.append("\n");

        BlockExplorer blockExplorer = new BlockExplorer();
        StopWatch stopwatch = new StopWatch();


        for( int i = 556526; i < 556527; i++)
        {

            stopwatch.start();
            System.out.println(i);
            Block block = blockExplorer.getBlock(i);



            List<Transaction> tx = block.getTransactions();

            for(Transaction transaction : tx)
            {
                csvWriter.append(transaction.getHash());
                csvWriter.append("\n");


            }






        }


        csvWriter.flush();
        csvWriter.close();

        stopwatch.stop();
        double timeTaken = (double) stopwatch.getTime() / 1000;
        System.out.println("ca a pris " + timeTaken + " secondes");



    }
}
