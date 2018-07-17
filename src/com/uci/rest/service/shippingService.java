package com.uci.rest.service;

import com.uci.rest.db.DatabaseConnector;
import com.uci.rest.db.DatabaseUtils;
import com.uci.rest.model.Shipping;
import com.uci.rest.model.Todo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class shippingService {


    private final static String ALL_SHIPPING_QUERY = "SELECT * FROM shipping";

    public static Shipping getShippingByName(String name) {
        //Get a new connection object before going forward with the JDBC invocation.
        Connection connection = DatabaseConnector.getConnection();
        ResultSet resultSet = DatabaseUtils.retrieveQueryResults(connection, ALL_SHIPPING_QUERY + " WHERE shipping_type = '" + name + "'");

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                	Shipping shipping = new Shipping();
            
                	shipping.setId(resultSet.getInt("id"));
                	shipping.setShipping_type((resultSet.getString("shipping_type")));
                	shipping.setStart_range((resultSet.getInt("start_range")));
                	shipping.setEnd_range((resultSet.getInt("end_range")));
                	shipping.setPrice((resultSet.getDouble("price")));               

                    return shipping;

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

    
}
