/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package io.mercadopaodesal.dao;

/**
 *
 * @author lucas
 */
public class NF {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double gettValue() {
        return tValue;
    }

    public void settValue(double tValue) {
        this.tValue = tValue;
    }

    public Integer getSuplierID() {
        return suplierID;
    }

    public void setSuplierID(Integer suplierID) {
        this.suplierID = suplierID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }


    private int id;
    private String date;
    private double tValue;
    private Integer suplierID;
    private Integer customerID;
}
