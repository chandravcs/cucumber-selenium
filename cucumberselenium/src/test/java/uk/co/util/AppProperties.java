package uk.co.util;

import java.io.FileInputStream;
import java.util.Properties;

public class AppProperties {

	private static Properties properties = null;

	public static String testclasspath = "target/test-classes/";

	public static Properties getProperties() {

		if (properties == null) {
			String propertyFile = System.getProperty("user.dir") + "/src/test/resources/Config.properties";
			try {
				System.out.println("Loading properties from file " + propertyFile);
				properties = new Properties();
				properties.load(new FileInputStream(propertyFile));
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return properties;
	}

	public static String get(String propertyKey) {
		return getProperties().getProperty(propertyKey);
	}
}
