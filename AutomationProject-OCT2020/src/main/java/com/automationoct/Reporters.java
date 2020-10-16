package com.automationoct;


import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "classpath:${rep}.properties" }) // mention the property file name

public interface Reporters extends Config{
	
	String reporterName();

	
	}



