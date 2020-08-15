package info.blockchain.api;

import com.google.gson.JsonObject;
import info.blockchain.api.blockexplorer.BlockExplorer;
import info.blockchain.api.blockexplorer.entity.Block;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class BuildJsonFiles {

    BlockExplorer blockExplorer = new BlockExplorer();

    public void CreateBlocs(int debutbloc, int finbloc) throws Exception, APIException

    {


        JSONArray arr = new JSONArray();
        HashMap<String, JSONObject> map = new HashMap<String, JSONObject>();
        for(int i = debutbloc ; i < finbloc ; i++)
        {
            Block block = blockExplorer.getBlock(i);

            JSONObject json=new JSONObject();
            json.put("Bloc_num",i);
            json.put("Bloc_hash", block.getHash());
            json.put("Bloc_prevhash", block.getPreviousBlockHash());
            json.put("bloc_time", block.getTimeHuman());
            json.put("bloc_txnb", block.getTransactions().size());

            map.put("Bloc" + i, json);
            arr.put(map.get("Bloc" + i));
            System.out.println("infos du bloc " + arr.toString() + "ok");
        }


        try (FileWriter file = new FileWriter("D:\\Bureau\\Test\\blocs-" + debutbloc + "-"+ finbloc +"-infos"))
        {

            // file.write(arr.toJSONString());
            file.write(arr.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void CreateTransaction(int debutbloc, int finbloc) throws Exception, APIException
    {

        JSONArray arr = new JSONArray();
        HashMap<String, JSONObject> map = new HashMap<String, JSONObject>();
        for(int i = debutbloc ; i < finbloc ; i++)
        {
            Block block = blockExplorer.getBlock(i);

            JSONObject json=new JSONObject();
            json.put("Bloc_num",i);

            map.put("Bloc" + i, json);
            arr.put(map.get("Bloc" + i));
        }
        System.out.println("The json string is " + arr.toString());

        try (FileWriter file = new FileWriter("D:\\Bureau\\Test\\blocs-" + debutbloc + "-"+ finbloc +"-infos"))
        {

            // file.write(arr.toJSONString());
            file.write(arr.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }









    }







































































