package info.blockchain.api;




import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonToNeo4J
{

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ParseException {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        JSONArray a = (JSONArray) jsonParser.parse(new FileReader("D:\\Bureau\\data\\556453.json"));
        try
        {
            /*
            for (Object o : a)
            {
                JSONObject person = (JSONObject) o;

                String name = (String) person.get("name");
                System.out.println(name);

                String city = (String) person.get("city");
                System.out.println(city);

                String job = (String) person.get("job");
                System.out.println(job);

                JSONArray cars = (JSONArray) person.get("cars");

                for (Object c : cars)
                {
                    System.out.println(c+"");
                }
            }
            */
            System.out.println("ok");

        }
        catch (Exception e)
        {
            e.printStackTrace();
    }


    }




}








