package com.uci.rest.service;

import com.uci.rest.db.DatabaseConnector;
import com.uci.rest.db.DatabaseUtils;
import com.uci.rest.model.Todo;
import com.uci.rest.model.keyboard;
import com.uci.rest.model.purchase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class purchaseService {
	
    private final static String LATEST_PURCHASE_QUERY = "select * FROM purchase ORDER BY purchase_id DESC LIMIT 1";

    public static purchase getLatestPurchase() {
        //Get a new connection object before going forward with the JDBC invocation.
        Connection connection = DatabaseConnector.getConnection();
        ResultSet resultSet = DatabaseUtils.retrieveQueryResults(connection, LATEST_PURCHASE_QUERY);

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                	purchase purchase = new purchase();

                    purchase.setProduct_id(resultSet.getInt("product_id"));
                    purchase.setFull_name(resultSet.getString("full_name"));
                    purchase.setEmail(resultSet.getString("email"));
            		purchase.setPhone_number(resultSet.getString("phone_number"));
            		purchase.setStreet_address(resultSet.getString("street_address"));
            		purchase.setCity(resultSet.getString("city"));
            		purchase.setState(resultSet.getString("state"));
            		purchase.setZip(resultSet.getString("zip"));
            		purchase.setCardholder_name(resultSet.getString("cardholder_name"));
            		purchase.setCard_number(resultSet.getString("card_number"));
            		purchase.setCard_exp_month(resultSet.getString("card_exp_month"));
            		purchase.setCard_exp_year(resultSet.getString("card_exp_year")); 
            		purchase.setCvv(resultSet.getString("cvv"));
            		purchase.setQuantity(resultSet.getInt("quantity"));
            		purchase.setShipping(resultSet.getString("shipping"));
            		purchase.setShipping_name(resultSet.getString("shipping_name"));
            		purchase.setShipping_street(resultSet.getString("shipping_street"));
            		purchase.setShipping_city(resultSet.getString("shipping_city"));
            		purchase.setShipping_state(resultSet.getString("shipping_state"));
            		purchase.setShipping_zip(resultSet.getString("shipping_zip"));
            		purchase.setTotal_price(resultSet.getString("total_price"));

                    return purchase;

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
	
    public static boolean AddPurchase(purchase purchase) {

        String sql = "INSERT INTO purchase  (product_id, full_name, email, phone_number, street_address, city, state, zip, cardholder_name, card_number, card_exp_month, card_exp_year, cvv, quantity, shipping, shipping_name, shipping_street, shipping_city, shipping_state, shipping_zip, total_price)" +
    		"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//    	String sql = "INSERT INTO purchase  (full_name, email)" +
//                "VALUES (?, ?)";
        Connection connection = DatabaseConnector.getConnection();
        return DatabaseUtils.performDBUpdate(connection, sql, Integer.toString(purchase.getProduct_id()),
        													purchase.getFull_name(),
        													purchase.getEmail(),
        													purchase.getPhone_number(),
        													purchase.getStreet_address(),
        													purchase.getCity(),
        													purchase.getState(),
        													purchase.getZip(),
        													purchase.getCardholder_name(),
        													purchase.getCard_number(),
        													purchase.getCard_exp_month(),
        													purchase.getCard_exp_year(), 
        													purchase.getCvv(),
        													Integer.toString(purchase.getQuantity()),
        													purchase.getShipping(),
        													purchase.getShipping_name(),
        													purchase.getShipping_street(),
        													purchase.getShipping_city(),
        													purchase.getShipping_state(),
        													purchase.getShipping_zip(),
        													purchase.getTotal_price());
//        return DatabaseUtils.performDBUpdate(connection, sql, purchase.getFull_name(), purchase.getEmail());

    }
    
    public static boolean deletePurchase() {

        String sql = "delete from purchase order by purchase_id desc limit 1";

        Connection connection = DatabaseConnector.getConnection();

        boolean updateStatus = DatabaseUtils.performDBUpdate(connection, sql);

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateStatus;
    }
}
