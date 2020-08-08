package info.blockchain.api;

import info.blockchain.api.blockexplorer.BlockExplorer;
import info.blockchain.api.blockexplorer.entity.*;
import org.apache.commons.lang3.time.StopWatch;

import java.util.List;

public class TestAPI2 {

    public static void main(String[] args) throws Exception, APIException {


        BlockExplorer blockExplorer = new BlockExplorer();
        StopWatch stopwatch = new StopWatch();

        List<SimpleBlock> SB = blockExplorer.getBlocks(1548975600);

        for (int i = 0; i < SB.size(); i++) {
            SB.get(i).getHash();
            System.out.println(SB.get(i).getHash());
        }
    }
}
