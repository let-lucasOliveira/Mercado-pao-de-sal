/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class CategoryDAO {
        private ConnectionFactory cnct;
    private Connection conn;
    
    public CategoryDAO () {
        this.cnct = new ConnectionFactory ();
        this.conn = this.cnct.getConnection ();
    }
        public void add (Category category) {
        String sql = "INSERT INTO categoria (cat_nome, cat_descricao) VALUES (?,?);";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, category.getNome());
            stmt.setString(2, category.getDescription());
            
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Error adding categoria: "+ex.getMessage());
        }
    }
        
    public void update(Category category){
        try{   
            String sql = "UPDATE categoria SET cat_nome=?, cat_descricao=? WHERE id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category.getNome());
            stmt.setString(2, category.getDescription());
            stmt.setInt(4,category.getId());
            stmt.execute();
        } catch(SQLException ex){
            System.out.println("Error to update the customer data: "+ex.getMessage());
       }
    }
    
    public void delete (int id) {
        try{
            String sql = "DELETE FROM categoria WHERE cat_id=?";
            
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setInt(1,id);
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Error deleting categoria: "+ex.getMessage());
        }
    }
}
