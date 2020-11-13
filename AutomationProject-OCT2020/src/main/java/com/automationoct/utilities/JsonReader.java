package com.automationoct.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.automationoct.Users;


public class JsonReader {

	@SuppressWarnings("unchecked")
	public static Object readJson(String JsonFilePath) throws IOException {
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		JSONObject obj = null;
		//Object obj1 = null;
		String a = null;

		try (FileReader reader = new FileReader(JsonFilePath)) {
			// Read JSON file
			obj = (JSONObject) jsonParser.parse(reader);
			
			
			JSONArray testList = new JSONArray();
			testList.add(obj);
			
       Iterator<JSONObject> iterator = testList.iterator();
			while (iterator.hasNext()) {
				//System.out.println(iterator.next());
			//Object insideObj = obj.get("testData");
			System.out.print(obj);
			//System.out.print(testList);
			a = a + obj.toJSONString();
			iterator.next();
				
				
			}
		
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return obj;
		
		
	}
	
	/*   DOESNT WORK
	 public static Object[][] getData(String JsonFilePath)
     {

         JSONParser parser = new JSONParser();
         Map<String, JSONObject> dataMap = new HashMap<String, JSONObject>();
         Iterator entriesIterator = null;
         try  (FileReader reader = new FileReader(JsonFilePath))
         {
             JSONObject contentObj = (JSONObject) parser.parse(reader);
           


             contentObj.keySet().forEach(key -> {
                 dataMap.put(String.valueOf(key), (JSONObject) contentObj.get(key));
             });

             Set entries = contentObj.entrySet();
              entriesIterator = entries.iterator();
         } catch (FileNotFoundException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (ParseException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }


         Object[][] arr = new Object[dataMap.size()][1];
         int i = 0;
         while(entriesIterator.hasNext()){

             Map.Entry mapping = (Map.Entry) entriesIterator.next();

             arr[i][0] = mapping.getKey();
             arr[i][1] = mapping.getValue();

             i++;

         }

         return arr;
     }
*/
}
