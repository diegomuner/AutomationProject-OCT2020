package com.automationoct.dataproviders;

import org.testng.annotations.DataProvider;

public class TestWebPageDataProvider {
	
	
	@DataProvider(name="data1")
	public  Object[][] getUserData(){
        return new Object[][] {
            {"Diego1", "password1"},
            {"Melanie2", "medicina1"},
            {"Lucky3", "bebedemomi"},
        };
                }
	
	

}
