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
public class DarfDAO {
    private ConnectionFactory cnct;
    private Connection conn;
    
    public DarfDAO (){
     this.cnct = new ConnectionFactory();
     this.conn = this.cnct.getConnection();
    }
    public Darf get(int id) {
        String sql = "SELECT * FROM notaitens WHERE ni_id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                return null; // No result found
            }

            Darf p = new Darf();
            p.setId(rs.getInt("ni_id"));
            p.setIdNf(rs.getInt("nf_id"));
            p.setIdPro(rs.getInt("prod_id"));
            p.setQuantity(rs.getInt("ni_quant"));
            p.setUnitValue(rs.getInt("ni_vlrUnitario"));
            return p;

        } catch (SQLException ex) {
            System.out.println("Error consulting: " + ex.getMessage());
            return null;
        }
    }
    
    public void add(Darf d) {
        try (Connection conn = new ConnectionFactory().getConnection()) {
            String sql = "INSERT INTO notaitens (nf_id, prod_id, ni_quant, ni_vlrUnitario) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, d.getIdNf());
            stmt.setInt(2, d.getIdPro());
            stmt.setInt(3, d.getQuantity());
            stmt.setInt(4, d.getUnitValue());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Nota item added successfully!");
            } else {
                System.out.println("Any Nota item was add.");
            }
        } catch (SQLException e) {
            System.out.println("Error to add product: " + e.getMessage());
        }
    }

        
    public void update(Darf darf){
        try{
            String sql = "UPDATE notaitens SET nf_id=?, prod_id=?, ni_quant=?, ni_vlrUnitario=? WHERE nf_id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, darf.getIdNf());
            stmt.setInt(2, darf.getIdPro());
            stmt.setInt(3, darf.getQuantity());
            stmt.setInt(4, darf.getUnitValue());
            stmt.setInt(5, darf.getId());
            stmt.execute();
        }
        catch(SQLException ex){
            System.out.println("Error to update the product: "+ex.getMessage());
        }
    }
    
    public void delete(int id){
        try{
            String sql = "DELETE FROM notaitens WHERE ni_id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Error deleting product: "+ex.getMessage());
        }
    }
}