package com.automationoct;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "classpath:${env}.properties" }) // mention the property file name

//@Sources({ "${env}.properties" })


public interface Environment extends Config {

	String url();
	
	String urlTestPage();
	

	String username();

	String password();
	

	@Key("db.hostname")
	String getDBHostname();

	@Key("db.port")
	int getDBPort();

	@Key("db.username")
	String getDBUsername();

	@Key("db.password")
	String getDBPassword();

}
