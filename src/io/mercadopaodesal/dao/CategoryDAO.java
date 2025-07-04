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
import java.util.Vector;

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
                System.out.println("Error consulting!");
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
            System.out.println("Error to update the category: "+ex.getMessage());
       }
    }
    

    public Vector<Category> getAll() {
        Vector<Category> categories = new Vector<>();

        String sql = "SELECT * FROM categoria";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("cat_id");
                String name = rs.getString("cat_nome");
                categories.add(new Category(id, name));
            }

        } catch (SQLException e) {
            System.out.println("Error fetching categories: " + e.getMessage());
        }

        return categories;
    }
}
