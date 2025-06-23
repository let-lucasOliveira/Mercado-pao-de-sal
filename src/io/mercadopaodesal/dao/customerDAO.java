/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package io.mercadopaodesal.dao;

import io.mercadopaodesal.db.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class CustomerDAO {
    private ConnectionFactory cnct;
    private Connection conn;
    
    public CustomerDAO () {
        this.cnct = new ConnectionFactory ();
        this.conn = this.cnct.getConnection ();
    }
        public void add (Customer customer) {
        String sql = "INSERT INTO pessoa (nome, sexo, idioma) VALUES (?,?,?);";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, customer.getNome());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getCpf());
            
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir pessoa: "+ex.getMessage());
        }
    }
        
    public void update(Customer customer){
        try{   
            String sql = "UPDATE pessoa SET nome=?, email=?, cpf=? WHERE id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, customer.getNome());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getCpf());
            stmt.setInt(4,customer.getId());
            stmt.execute();
        } catch(SQLException ex){
            System.out.println("Error to update the customer data: "+ex.getMessage());
       }
    }
    
    public void delete (int id) {
        try{
            String sql = "DELETE FROM pessoa WHERE id=?";
            
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setInt(1, id);
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao excluir pessoa: "+ex.getMessage());
        }
    }
}
