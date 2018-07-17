package com.uci.rest.model;


import javax.xml.bind.annotation.XmlRootElement;

//You will need to create a Java Object. Jersey uses these to contruct requests and responses.

public class keyboard {
    private int id;
    private String name;
    private String category;
    private double price;
    private String quote;
    private String color;
    private String connection;
    private String dimension;
    private double weight;
    private String description;
    
    /*------------getters-----------*/
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getCategory() {
        return category;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getQuote() {
        return quote;
    }
    
    public String getColor() {
        return color;
    }
    
    public String getConnection() {
        return connection;
    }
    
    public String getDimension() {
        return dimension;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public String getDescription() {
        return description;
    }
    
    
    
    /*------------setters-----------*/
    public void setId(int id) {
    	this.id = id;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setCategory(String category) {
    	this.category = category;
    }
    
    public void setPrice(double price) {
    	this.price = price;
    }
    
    public void setQuote(String quote) {
    	this.quote = quote;
    }
    
    public void setColor(String color) {
    	this.color = color;
    }
    
    public void setConnection(String connection) {
    	this.connection = connection;
    }
    
    public void setDimension(String dimension) {
    	this.dimension = dimension;
    }
    
    public void setWeight(double weight) {
    	this.weight = weight;
    }
    
    public void setDescription(String description) {
    	this.description = description;
    }
}