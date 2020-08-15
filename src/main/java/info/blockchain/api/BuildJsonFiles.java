package info.blockchain.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import info.blockchain.api.blockexplorer.BlockExplorer;

import info.blockchain.api.blockexplorer.entity.Block;
import info.blockchain.api.blockexplorer.entity.Transaction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildJsonFiles {

    BlockExplorer blockExplorer = new BlockExplorer();






    public void BlocJSON(int debutbloc, int finbloc) throws Exception
    {
        JSONObject rootObject = new JSONObject();
        JSONArray Bloc = new JSONArray();
        for (int i = debutbloc; i < finbloc ; i++)
        {
            Block block = blockExplorer.getBlock(i);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Bloc_num", i);
            jsonObject.put("Bloc_hash", block.getHash());
            jsonObject.put("bloc_prevhash", block.getPreviousBlockHash());
            jsonObject.put("bloc_time", block.getTimeHuman());
            jsonObject.put("bloc_txsize", block.getTransactions().size());
            Bloc.add(jsonObject);

            rootObject.put("Blocs", Bloc);

            try (FileWriter file = new FileWriter("D:\\Bureau\\Test\\blocs-" + debutbloc + "-"+ finbloc +"-infos"))
            {

                // file.write(arr.toJSONString());
                file.write(rootObject.toJSONString());
                System.out.println("Bloc " + i + " OK ");
                //  System.out.println("tout les blocs sont inscrit sur le fichier JSON");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }




    }


    public void TransactionJSon(int debutbloc, int finbloc) throws Exception
    {


        JSONObject rootObject = new JSONObject();
        JSONArray Bloc = new JSONArray();
        JsonArray Transaction = new JsonArray();
        JsonArray Input = new JsonArray();
        JsonArray Output = new JsonArray();
        for (int i = debutbloc; i < finbloc ; i++)
        {
            Block block = blockExplorer.getBlock(i);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Bloc_num", i);

            Bloc.add(jsonObject);

            rootObject.put("Transactions", Bloc);

            

            List<Transaction> tx = block.getTransactions();








            try (FileWriter file = new FileWriter("D:\\Bureau\\Test\\blocs-" + debutbloc + "-"+ finbloc +"-transactions"))
            {

                // file.write(arr.toJSONString());
                file.write(rootObject.toJSONString());
                System.out.println("Transactions " + i + " OK ");
                //  System.out.println("tout les blocs sont inscrit sur le fichier JSON");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }






    }


















