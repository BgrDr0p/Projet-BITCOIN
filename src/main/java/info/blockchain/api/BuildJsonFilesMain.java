package info.blockchain.api;

public class BuildJsonFilesMain implements Runnable {


    public static void main(String args[]) throws Exception {


        String path = System.getProperty("user.dir");
        System.out.println(path);
        BuildJsonFiles BJF = new BuildJsonFiles();

        BJF.BlocJSON(78920, 78923);
        BJF.TransactionJSON(78920, 78921);


    }


    @Override
    public void run()
    {

    }

}



