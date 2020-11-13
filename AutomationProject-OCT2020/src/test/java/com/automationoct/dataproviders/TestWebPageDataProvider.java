package com.automationoct.dataproviders;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.DataProvider;


import com.automationoct.utilities.JsonReader;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public class TestWebPageDataProvider {

	@DataProvider(name = "data1")
	public Object[][] getUserData() {
		return new Object[][]  { { "Diego1", "password1" }, { "Melanie2", "asdasd1" }, { "Lucky3", "pwpw3" }, };
		
		
		
	}
	
	@DataProvider(name = "data2")
	public Object[][] getUserData2() {
		return new Object[][] { { "Diego2", "password2" }, { "Melanie3", "asdasd" }, { "Lucky3", "bebeasdi" }, };
	}

	
	
	//Following data provider reads from a json file all pairs of usernames and passwords and saves them in a String[] object
	//The Tests using this data provider need to access the elements of each string by using data.split(",") and finally accessing each 
	//of the values with stringName[i]
	
    @DataProvider(name="data3")
    public String[] readJson() throws IOException{
    //  @SuppressWarnings("deprecation")
    //   JsonParser jsonparser = new JsonParser();

      FileReader reader =new FileReader("usernames2.json");
         //  @SuppressWarnings("deprecation")
         //  Object obj = jsonparser.parse(reader); //java object
      	// previous line is deprecated, no longer need to instantiate class JsonParser -> we use static methods
           Object obj = JsonParser.parseReader(reader); //java object
           JsonObject userLoginsJsonObj = (JsonObject)obj;
           JsonArray userLoginsArray =(JsonArray)userLoginsJsonObj.get("testData"); 
           String array[] = new String[userLoginsArray.size()]; 
           for(int i=0; i<userLoginsArray.size();i++) {
               JsonObject users = (JsonObject)userLoginsArray.get(i); 
               String username = users.get("userName").getAsString(); 
              
               String password = users.get("password").getAsString();
               array[i] = username+","+password;
           }
           return array;
       }
	
	}

	

