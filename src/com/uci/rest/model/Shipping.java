package com.uci.rest.model;


import javax.xml.bind.annotation.XmlRootElement;

//You will need to create a Java Object. Jersey uses these to contruct requests and responses.

public class Shipping {
    private int id;
    private String shipping_type;
    private int start_range;
    private int end_range;
    private double price;

    
    /*------------getters-----------*/
    public int getId() {
        return id;
    }
    
    public String getShipping_type() {
        return shipping_type;
    }
    
    public int getStart_range() {
        return start_range;
    }
    
    public int getEnd_range() {
        return end_range;
    }
    
    public double getPrice() {
        return price;
    }
    
   
    /*------------setters-----------*/
    public void setId(int id) {
    	this.id = id;
    }
    
    public void setShipping_type(String shipping_type) {
    	this.shipping_type = shipping_type;
    }
    
    public void setStart_range(int start_range) {
    	this.start_range = start_range;
    }
    
    public void setEnd_range(int end_range) {
    	this.end_range = end_range;
    }
    
    public void setPrice(double price) {
    	this.price = price;
    }
    
}