package com.uci.rest.service;

import com.uci.rest.db.DatabaseConnector;
import com.uci.rest.db.DatabaseUtils;
import com.uci.rest.model.Todo;
import com.uci.rest.model.keyboard;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class keyboardService {


    private final static String ALL_KEYBOARDS_QUERY = "SELECT * FROM product_info";

    public static keyboard getKeyboardById(int id) {
        //Get a new connection object before going forward with the JDBC invocation.
        Connection connection = DatabaseConnector.getConnection();
        ResultSet resultSet = DatabaseUtils.retrieveQueryResults(connection, ALL_KEYBOARDS_QUERY + " WHERE id = " + id);

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    keyboard keyboard = new keyboard();

                    keyboard.setId(resultSet.getInt("id"));
                    keyboard.setName(resultSet.getString("name"));
                    keyboard.setCategory(resultSet.getString("category"));
                    keyboard.setPrice(resultSet.getDouble("price"));
                    keyboard.setQuote(resultSet.getString("quote"));                 
                    keyboard.setColor(resultSet.getString("color"));
                    keyboard.setConnection(resultSet.getString("connection"));
                    keyboard.setDimension(resultSet.getString("dimension"));
                    keyboard.setWeight(resultSet.getDouble("weight"));
                    keyboard.setDescription(resultSet.getString("description"));


                    return keyboard;

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {

                    // We will always close the connection once we are done interacting with the Database.
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;


    }
    
    public static List<keyboard> getAllKeyboards() {
        List<keyboard> keyboards = new ArrayList<keyboard>();

        Connection connection = DatabaseConnector.getConnection();
        ResultSet resultSet = DatabaseUtils.retrieveQueryResults(connection, ALL_KEYBOARDS_QUERY);
        
        
        if (resultSet != null) {
            try {
                while (resultSet.next()) {                	
                	keyboard keyboard = new keyboard();

                    keyboard.setId(resultSet.getInt("id"));
                    keyboard.setName(resultSet.getString("name"));
                    keyboard.setCategory(resultSet.getString("category"));
                    keyboard.setPrice(resultSet.getDouble("price"));
                    keyboard.setQuote(resultSet.getString("quote"));                 
                    keyboard.setColor(resultSet.getString("color"));
                    keyboard.setConnection(resultSet.getString("connection"));
                    keyboard.setDimension(resultSet.getString("dimension"));
                    keyboard.setWeight(resultSet.getDouble("weight"));
                    keyboard.setDescription(resultSet.getString("description"));
                    
                    keyboards.add(keyboard);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        else
        {
        	System.out.println("is null");
        }
        
        return keyboards;
    }
    
    public static boolean updateKeyboard(keyboard keyboard) {

        String sql = "UPDATE product_info SET name=?, description=?, price=? WHERE id=?;";

        Connection connection = DatabaseConnector.getConnection();

        boolean updateStatus = DatabaseUtils.performDBUpdate(connection, sql, keyboard.getName(), keyboard.getDescription(), Double.toString(keyboard.getPrice()),
                String.valueOf(keyboard.getId()));

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateStatus;

    }
    
}
