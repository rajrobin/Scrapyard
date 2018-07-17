package com.uci.rest.model;


import javax.xml.bind.annotation.XmlRootElement;

//You will need to create a Java Object. Jersey uses these to contruct requests and responses.

public class purchase {
    private int purchase_id;
    private int product_id;
    private String full_name;
    private String email;
    private String phone_number;
    private String street_address;
    private String city;
    private String state;
    private String zip;
    private String cardholder_name;
    private String card_number;
    private String card_exp_month;
    private String card_exp_year;
    private String cvv;
    private int quantity;
    private String shipping;
    private String shipping_name;
    private String shipping_street;
    private String shipping_city;
    private String shipping_state;
    private String shipping_zip;
    private String total_price;
    
    /*------------getters-----------*/
    public int getPurchase_id() {
        return purchase_id;
    }
    
    public int getProduct_id() {
        return product_id;
    }
    
    public String getFull_name() {
        return full_name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPhone_number() {
        return phone_number;
    }
    
    public String getStreet_address() {
        return street_address;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getState() {
        return state;
    }
    
    public String getZip() {
        return zip;
    }
    
    public String getCardholder_name() {
        return cardholder_name;
    }
    
    public String getCard_number() {
        return card_number;
    }
    
    public String getCard_exp_month() {
        return card_exp_month;
    }
    
    public String getCard_exp_year() {
        return card_exp_year;
    }
    
    public String getCvv() {
        return cvv;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public String getShipping() {
        return shipping;
    }
    
    public String getShipping_name() {
        return shipping_name;
    }
    
    public String getShipping_street() {
        return shipping_street;
    }
    
    public String getShipping_city() {
        return shipping_city;
    }
    
    public String getShipping_state() {
        return shipping_state;
    }
    
    public String getShipping_zip() {
        return shipping_zip;
    }
    
    public String getTotal_price() {
        return total_price;
    }
    
    
    
    /*------------setters-----------*/    
    public void setPurchase_id(int purchase_id) {
    	this.purchase_id = purchase_id;
    }
    
    public void setProduct_id(int product_id) {
    	this.product_id = product_id;
    }
    
    public void setFull_name(String full_name) {
    	this.full_name = full_name;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public void setPhone_number(String phone_number) {
    	this.phone_number = phone_number;
    }
    
    public void setStreet_address(String street_address) {
    	this.street_address = street_address;
    }
    
    public void setCity(String city) {
    	this.city = city;
    }
    
    public void setState(String state) {
    	this.state = state;
    }
    
    public void setZip(String zip) {
    	this.zip = zip;
    }
    
    public void setCardholder_name(String cardholder_name) {
    	this.cardholder_name = cardholder_name;
    }
    
    public void setCard_number(String card_number) {
    	this.card_number = card_number;
    }
    
    public void setCard_exp_month(String card_exp_month) {
    	this.card_exp_month = card_exp_month;
    }
    
    public void setCard_exp_year(String card_exp_year) {
    	this.card_exp_year = card_exp_year;
    }
    
    public void setCvv(String cvv) {
    	this.cvv = cvv;
    }
    
    public void setQuantity(int quantity) {
    	this.quantity = quantity;
    }
    
    public void setShipping(String shipping) {
    	this.shipping = shipping;
    }
    
    public void setShipping_name(String shipping_name) {
    	this.shipping_name = shipping_name;
    }
    
    public void setShipping_street(String shipping_street) {
    	this.shipping_street = shipping_street;
    }
    
    public void setShipping_city(String shipping_city) {
    	this.shipping_city = shipping_city;
    }
    
    public void setShipping_state(String shipping_state) {
    	this.shipping_state = shipping_state;
    }
    
    public void setShipping_zip(String shipping_zip) {
    	this.shipping_zip = shipping_zip;
    }
    
    public void setTotal_price(String total_price) {
    	this.total_price = total_price;
    }

}