package info.blockchain.api.Graph;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;


public class JsonToGraphML {




    public void Bloc() throws Exception
    {

        JSONParser parser = new JSONParser();

        try
        {
            Object obj = parser.parse(new FileReader("D:\\Bureau\\blocs-610582-610682-infos.json"));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray BlocsLists = (JSONArray) jsonObject.get("Blocs");

            Iterator<JSONObject> iterator = BlocsLists.iterator();
            while (iterator.hasNext())
            {
                System.out.println(iterator.next());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }




    }





    }

