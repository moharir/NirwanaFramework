package cigniti.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class CignitiProperties {

	String path = System.getProperty("user.dir");
	private String cignitiPropertyFile = path + "/src/test/resources/commoninputfiles/cigniti.properties";
	Properties properties;

	public CignitiProperties() {
		fileProcessor();
	}

	public CignitiProperties(String serviceName) {
		if (serviceName.equalsIgnoreCase("weather"))
			cignitiPropertyFile = path + "/src/test/resources/restinputfiles/weather.properties";
		else if (serviceName.equalsIgnoreCase("aon"))
			cignitiPropertyFile = path + "/src/test/resources/soapinputfiles/aon.properties";
		else if (serviceName.equalsIgnoreCase("reqres"))
			cignitiPropertyFile = path + "/src/test/resources/commoninputfiles/reqres.properties";
		else if (serviceName.equalsIgnoreCase("reqres1"))
			cignitiPropertyFile = path + "/src/test/resources/commoninputfiles/reqres.properties";
		else
			cignitiPropertyFile = path + "/src/test/resources/commoninputfiles/cigniti.properties";
		fileProcessor();
	}

	public void fileProcessor() {
		properties = new Properties();
		try {
			File propertyFile = new File(cignitiPropertyFile);
			FileInputStream fileInput = new FileInputStream(propertyFile);
			properties = new Properties();
			InputStream inputStream = CignitiProperties.class.getClassLoader().getResourceAsStream(cignitiPropertyFile);
			properties.load(fileInput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		String value = "";
		try {
			value = properties.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}
