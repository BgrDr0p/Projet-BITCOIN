package info.blockchain.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import info.blockchain.api.blockexplorer.BlockExplorer;

import info.blockchain.api.blockexplorer.entity.Block;
import info.blockchain.api.blockexplorer.entity.Input;
import info.blockchain.api.blockexplorer.entity.Output;
import info.blockchain.api.blockexplorer.entity.Transaction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class BuildJsonFiles {

    BlockExplorer blockExplorer = new BlockExplorer();


    public void BlocJSON(int debutbloc, int finbloc) throws Exception {
        JSONObject rootObject = new JSONObject();
        JSONArray Bloc = new JSONArray();
        try {
            for (int i = debutbloc; i < finbloc; i++) {
                Block block = blockExplorer.getBlock(i);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("Bloc_num", i);
                jsonObject.put("Bloc_hash", block.getHash());
                jsonObject.put("bloc_prevhash", block.getPreviousBlockHash());
                jsonObject.put("bloc_time", block.getTimeHuman());
                jsonObject.put("bloc_txsize", block.getTransactions().size());
                Bloc.add(jsonObject);

                rootObject.put("Blocs", Bloc);

                try (FileWriter file = new FileWriter("blocs-" + debutbloc + "-" + finbloc + "-infos")) {

                    // file.write(arr.toJSONString());
                    file.write(rootObject.toJSONString());
                    System.out.println("Bloc " + i + " OK ");
                    //  System.out.println("tout les blocs sont inscrit sur le fichier JSON");

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        catch (Exception e )
        {
            e.printStackTrace();
        }


    }


    public void TransactionJSON(int debutbloc, int finbloc) throws Exception {


        JSONObject rootObjectTransaction = new JSONObject();
        JSONArray TransactionS = new JSONArray();
        try {
            for (int i = debutbloc; i < finbloc; i++) {


                Block block = blockExplorer.getBlock(i);
                List<Transaction> tx = block.getTransactions();

                for (int t = 0; t < block.getTransactions().size(); t++) {

                    JSONObject jsonObjectTransaction = new JSONObject();
                    jsonObjectTransaction.put("Bloc_num", i);
                    jsonObjectTransaction.put("Tx_hash", tx.get(t).getHash());
                    TransactionS.add(jsonObjectTransaction);

                    rootObjectTransaction.put("Transactions", TransactionS); // Objet tout en haut


                    List<Input> inputs = tx.get(t).getInputs();


                    JSONArray arrInput = new JSONArray();
                    HashMap<String, JSONObject> mapInput = new HashMap<String, JSONObject>();

                    for (Input in : inputs) {

                        if (inputs.isEmpty() || inputs.get(0).getPreviousOutput() == null) {
                            continue;
                        } else {
                            JSONObject jsonInput = new JSONObject();
                            jsonInput.put("address", in.getPreviousOutput().getAddress());
                            jsonInput.put("value", in.getPreviousOutput().getValueBTC());
                            mapInput.put("Inputs" + i, jsonInput);
                            arrInput.add(mapInput.get("Inputs" + i));
                            jsonObjectTransaction.put("Inputs", arrInput);

                        }

                    }

                    List<Output> outputs = tx.get(t).getOutputs();

                    JSONArray arrOutput = new JSONArray();
                    HashMap<String, JSONObject> mapOutput = new HashMap<String, JSONObject>();

                    for (Output out : outputs) {

                        JSONObject jsonOutput = new JSONObject();
                        jsonOutput.put("address", out.getAddress());
                        jsonOutput.put("value", out.getValueBTC());
                        mapOutput.put("Outputs" + i, jsonOutput);
                        arrOutput.add(mapOutput.get("Outputs" + i));
                        jsonObjectTransaction.put("Outputs", arrOutput);

                    }


                    try (FileWriter file = new FileWriter("D:\\Bureau\\Test\\blocs-" + debutbloc + "-" + finbloc + "-transactions")) {

                        // file.write(arr.toJSONString());
                        file.write(rootObjectTransaction.toJSONString());
                        //  System.out.println("Transactions " + i + " OK ");
                        //  System.out.println("tout les blocs sont inscrit sur le fichier JSON");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                System.out.println("Transactions du bloc " + i + " OK !");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }
}



















