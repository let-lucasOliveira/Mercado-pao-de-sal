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

/**
 *
 * @author lucas
 */

public class SuplierDAO {
    private ConnectionFactory cnct;
    private Connection conn;
    
    public SuplierDAO () {
        this.cnct = new ConnectionFactory ();
        this.conn = this.cnct.getConnection ();
    }
    
        public Suplier get (int id){
            String sql = "SELECT * FROM fornecedor WHERE cli_id = ?";
                
           try{ 
                PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                Suplier s = new Suplier();
                rs.first();
                s.setId(id);
                s.setName(rs.getString("for_nome"));
                s.setFantasyName(rs.getString("for_nomFantasia"));
                s.setCnpj(rs.getString("for_cnpj"));
                return s;
           }
           catch(SQLException ex){
               System.out.println("Error consulting!");
               return null;
           }
        }
    
        public void add (Suplier suplier) {
        String sql = "INSERT INTO fornecedor (for_nome, for_nomeFantasia, for_cnpj) VALUES (?,?,?);";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, suplier.getName());
            stmt.setString(2, suplier.getFantasyName());
            stmt.setString(3, suplier.getCnpj());
            
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir cliente: "+ex.getMessage());
        }
    }
        
    public void update(Suplier suplier){
        try{   
            String sql = "UPDATE fornecedor SET for_nome=?, for_nomFantasia=?, for_cnpj=? WHERE for_id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, suplier.getName());
            stmt.setString(2, suplier.getFantasyName());
            stmt.setString(3, suplier.getCnpj());
            stmt.setInt(4,suplier.getId());
            stmt.execute();
        } catch(SQLException ex){
            System.out.println("Error to update the suplier data: "+ex.getMessage());
       }
    }
    
    public void delete (int id) {
        try{
            String sql = "DELETE FROM fornecedor WHERE for_id=?";
            
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setInt(1, id);
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Error deleting suplier: "+ex.getMessage());
        }
    }
}
