package com.automationoct.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

	@SuppressWarnings("unchecked")
	public static void readJson(String JsonFilePath) throws IOException {
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader(JsonFilePath)) {
			// Read JSON file
			JSONObject obj = (JSONObject) jsonParser.parse(reader);

			Object question = ((JSONObject) obj.get("quiz")).get("sport");

			System.out.println(question);

			JSONArray testList = new JSONArray();
			testList.add(obj);

			Iterator<JSONObject> iterator = testList.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

	}

}
