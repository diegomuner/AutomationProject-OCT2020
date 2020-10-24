package com.automationoct.dataproviders;

import org.testng.annotations.DataProvider;

public class TestWebPageDataProvider {

	@DataProvider(name = "data1")
	public Object[][] getUserData() {
		return new Object[][] { { "Diego1", "password1" }, { "Melanie2", "asdasd1" }, { "Lucky3", "bebedemomi" }, };
		
		
		
	}
	
	@DataProvider(name = "data2")
	public Object[][] getUserData2() {
		return new Object[][] { { "Diego2", "password2" }, { "Melanie3", "asdasd" }, { "Lucky3", "bebeasdi" }, };
	}

}
