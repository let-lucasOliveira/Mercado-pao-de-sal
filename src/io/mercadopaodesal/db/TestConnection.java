/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.mercadopaodesal.db;


import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        Connection conn = ConnectionFactory.getConnection();
        
        if (conn != null) {
            System.out.println("✅ Database connected successfully!");
        } else {
            System.out.println("❌ Failed to connect.");
        }
    }
}