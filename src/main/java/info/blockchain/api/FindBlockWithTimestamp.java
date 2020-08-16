package info.blockchain.api;

import info.blockchain.api.blockexplorer.BlockExplorer;
import info.blockchain.api.blockexplorer.entity.*;
import org.apache.commons.lang3.time.StopWatch;

import java.util.List;

public class FindBlockWithTimestamp {

    public static void main(String[] args) throws Exception, APIException {


        BlockExplorer blockExplorer = new BlockExplorer();


        List<SimpleBlock> SB = blockExplorer.getBlocks(1578006000);
        /*
        for (int i = 0; i < SB.size(); i++) {
            SB.get(i).getHash();
            System.out.println(SB.get(i).getHash());
        }
        */



        LatestBlock latestBlock = blockExplorer.getLatestBlock();
        long latestBlockHeight = latestBlock.getHeight();
        System.out.println(latestBlockHeight);






        // Janvier 2020 : 610 682 à 615 424
        // Fev 2020 : 615 424 à 619 578
        // Mars 2020 :619 578  à 623 823
        // Avril 2020 : 623 823 à 628 331
        // Mai 2020 : 628 331 à 632 533
        // Juin 2020 : 632 533 à 637 078
        // Juillet 2020 : 637 078 à 641 662
        // Aout - 17 Aout 2020 : 641 662 à 644 062

    }
}
