/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class CategoryDAO {
        private ConnectionFactory cnct;
    private Connection conn;
    
    public CategoryDAO () {
        this.cnct = new ConnectionFactory ();
        this.conn = this.cnct.getConnection ();
    }
        public Category get (int id) {
            String sql = "SELECT * FROM categoria WHERE cat_id = ?";
            
            try{
                PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                Category c = new Category();
                rs.first();
                c.setId(id);
                c.setNome(rs.getString("cat_nome"));
                c.setDescription(rs.getString("cat_descricao"));
                return c;
            }
            catch(SQLException ex){
                System.out.println("ERROR consulting!");
                return null;
            }
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
            String sql = "UPDATE categoria SET cat_nome=?, cat_descricao=? WHERE cat_id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, category.getNome());
            stmt.setString(2, category.getDescription());
            stmt.setInt(3,category.getId());
            stmt.execute();
        } catch(SQLException ex){
            System.out.println("Error to update the category data: "+ex.getMessage());
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
