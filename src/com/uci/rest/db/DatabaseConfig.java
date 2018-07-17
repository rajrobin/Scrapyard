package com.uci.rest.db;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.glassfish.jersey.client.ClientConfig;

import com.uci.rest.model.keyboard;
import com.uci.rest.service.jsonToObject;

/**
 * Created by tariqibrahim on 5/28/17.
 */
public class DatabaseConfig {
    static Properties properties;

    static {

        properties = new Properties();

        String resourceName = "db.config.properties";

        InputStream inputStream = DatabaseConfig.class.getResourceAsStream(resourceName);

        try {
            properties.load(inputStream);
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public static String getDatabaseName() {
        return properties.getProperty("jdbc.db.databasename");
    }

    public static String getUser() {
        return properties.getProperty("jdbc.db.user");
    }

    public static String getPassword() {
        return properties.getProperty("jdbc.db.password");
    }

    public static String getHost() {
        return properties.getProperty("jdbc.db.host");
    }
    
    
    public static void main(String[] args)
    {
    	
    	
    	DatabaseConfig dbc = new DatabaseConfig();
    	System.out.println(DatabaseConfig.getDatabaseName());
    	System.out.println(DatabaseConfig.getUser());
    	System.out.println(DatabaseConfig.getPassword());
    	System.out.println(DatabaseConfig.getHost());
    }
}
