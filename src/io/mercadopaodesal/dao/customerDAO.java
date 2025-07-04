/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package io.mercadopaodesal.dao;

import io.mercadopaodesal.db.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

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
    
        public Customer get (int id){
            String sql = "SELECT * FROM cliente WHERE cli_id = ?";
                
           try{ 
                PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                Customer c = new Customer();
                rs.first();
                c.setId(id);
                c.setEmail(rs.getString("cli_email"));
                c.setNome(rs.getString("cli_nome"));
                c.setCpf(rs.getString("cli_cpf"));
                return c;
           }
           catch(SQLException ex){
               System.out.println("Error consulting!");
               return null;
           }
        }
    
        public void add (Customer customer) {
        String sql = "INSERT INTO cliente (cli_nome, cli_email, cli_cpf) VALUES (?,?,?);";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, customer.getNome());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getCpf());
            
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir cliente: "+ex.getMessage());
        }
    }
        
    public void update(Customer customer){
        try{   
            String sql = "UPDATE cliente SET cli_nome=?, cli_email=?, cli_cpf=? WHERE cli_id=?";

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
            String sql = "DELETE FROM cliente WHERE cli_id=?";
            
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setInt(1, id);
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao excluir pessoa: "+ex.getMessage());
        }
    }
}
