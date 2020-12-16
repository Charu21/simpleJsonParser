
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

public class SimpleJsonParser {

//    public static void main(String[] args) {
//    }
   private static final JSONParser jsonParser = new JSONParser();

        public static Map<String, List<model>> getCompanyAccordingToSector(String path){
            if(path == null || path.length()==0) return Collections.emptyMap();
            try( Reader reader = new FileReader(path)){
                JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

                JSONArray companies = (JSONArray) jsonObject.get("companies");

                List<model> company = new ArrayList<>();

                for (Object o : companies) {
                    JSONObject entry = (JSONObject) o;
                    //System.out.println(entry);
                    company.add(parseCompanyEntry(entry));
                }


                //group companies according to sector

                return company.stream().collect(Collectors.groupingBy(model::getSector));
//                for(Map.Entry<String,List<model>> m: collect.entrySet()){
//                    System.out.println("Sector - "+ m.getKey());
//                    System.out.println(Arrays.toString(m.getValue().toArray()));
//                }
                //try (
//                Reader reader = new FileReader("d:\\filess\\test.json")) {
//
//            JSONObject jsonObject = (JSONObject) parser.parse(reader);
//            System.out.println(jsonObject);
//
//            String name = (String) jsonObject.get("name");
//            System.out.println(name);
//
//            long age = (Long) jsonObject.get("age");
//            System.out.println(age);
//
//            // loop array
//            JSONArray msg = (JSONArray) jsonObject.get("messages");
//            Iterator<String> iterator = msg.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }

            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
            return Collections.emptyMap();
        }

    private static model parseCompanyEntry(JSONObject jsonObject){
        String name = (String) jsonObject.get("name");
        String sector = (String) jsonObject.get("sector");
        String symbol = (String) jsonObject.get("symbol");
        String isin =(String) jsonObject.get("isin");
        Double price = (Double) jsonObject.get("price");

        return new model(name,sector,symbol,isin,price);
    }
}
