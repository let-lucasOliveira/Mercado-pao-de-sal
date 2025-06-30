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
public class ProductDAO {
    private ConnectionFactory cnct;
    private Connection conn;
    
    public ProductDAO (){
     this.cnct = new ConnectionFactory();
     this.conn = this.cnct.getConnection();
    }
    public Product get (int id){
        String sql = "SELECT * FROM produto WHERE prod_id = ?"; 

        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Product p = new Product();
            rs.first();
            p.setId(id);
            p.setCatId(rs.getInt("cat_id"));
            p.setCodBarras(rs.getString("prod_codigoBarras"));
            p.setNome(rs.getString("prod_nome"));
            p.setPreco(rs.getInt("prod_preco"));
            return p;
        }
        catch(SQLException ex){
            System.out.println("Error consulting");
            return null;
        }
    }
    
    public void add(Product p) {
        try (Connection conn = new ConnectionFactory().getConnection()) {
            String sql = "INSERT INTO produto (prod_nome, prod_preco, prod_codBarras, cat_id) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setString(3, p.getCodBarras());
            stmt.setInt(4, p.getCatId());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Product added succesfuly!");
            } else {
                System.out.println("Any product was add.");
            }
        } catch (SQLException e) {
            System.out.println("Error to add product: " + e.getMessage());
        }
    }

        
    public void update(Product product){
        try{
            String sql = "UPDATE produto SET prod_nome=?, cat_id=?, prod_preco=?, prod_codigoBarras=? WHERE prod_id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getNome());
            stmt.setInt(2, product.getCatId());
            stmt.setDouble(3, product.getPreco());
            stmt.setString(4, product.getCodBarras());
            stmt.setInt(5, product.getId());
            stmt.execute();
        }
        catch(SQLException ex){
            System.out.println("Error to update the product: "+ex.getMessage());
        }
    }
    
    public void delete(int id){
        try{
            String sql = "DELETE FROM produto WHERE prod_id=?";
            
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setInt(1, id);
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Error deleting product: "+ex.getMessage());
        }
    }
}