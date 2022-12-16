package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConfigReader {

	public Properties properties = null;
	static String fileName;

	private Logger logger;

    /**
     * This method is used to load the properties from config.properties file
     *
     * @return it returns Properties prop object
     */
    public Properties init_prop() {

      String propertiesFileName = "config.properties";

        // To initiate the prop
        try (InputStream in = ConfigReader.class.getClassLoader().getResourceAsStream("com/config/" + propertiesFileName)) {
            logger = LogManager.getLogger();
            properties = new Properties();
            properties.load(in);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
    
	public Properties getProperties() {
		return this.properties;
	}
}
