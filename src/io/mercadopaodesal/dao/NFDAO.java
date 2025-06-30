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

public class NFDAO {
    private ConnectionFactory cnct;
    private Connection conn;
    
    public NFDAO () {
        this.cnct = new ConnectionFactory ();
        this.conn = this.cnct.getConnection ();
    }
    
        public NF get (int id){
            String sql = "SELECT * FROM fornecedor WHERE for_id = ?";
                
           try{ 
                PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                NF nf = new NF();
                rs.first();
                nf.setId(id);
                nf.setDate(rs.getString("nf_date"));
                nf.settValue(rs.getDouble("nf_vlr_Total"));
                nf.setCustomerID(rs.getInt("cli_id"));
                nf.setSuplierID(rs.getInt("for_id"));
                return nf;
           }
           catch(SQLException ex){
               System.out.println("Error consulting!");
               return null;
           }
        }
    
        public void add (NF nf) {
        String sql = "INSERT INTO notafiscal (nf_data, nf_vlr_total, for_id, cli_id) VALUES (?,?,?,?);";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nf.getDate());
            stmt.setDouble(2, nf.gettValue());
            if (nf.getCustomerID() != null) {
                stmt.setInt(3, nf.getCustomerID());
            } else {
                stmt.setNull(3, java.sql.Types.INTEGER);
            }

            if (nf.getSuplierID() != null) {
                stmt.setInt(4, nf.getSuplierID());
            } else {
                stmt.setNull(4, java.sql.Types.INTEGER);
            }

            stmt.execute();           
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir Nota fiscal: "+ex.getMessage());
        }
    }
        
    public void update(NF nf){
        try{   
            String sql = "UPDATE notafiscal SET nf_data=?, nf_vlr_total=?, for_id=?, cli_id=? WHERE for_id=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nf.getDate());
            stmt.setDouble(2, nf.gettValue());
            if (nf.getCustomerID() != null) {
                stmt.setInt(3, nf.getCustomerID());
            } else {
                stmt.setNull(3, java.sql.Types.INTEGER);
            }

            if (nf.getSuplierID() != null) {
                stmt.setInt(4, nf.getSuplierID());
            } else {
                stmt.setNull(4, java.sql.Types.INTEGER);
            }
            stmt.setInt(5,nf.getId());
            stmt.execute();
        } catch(SQLException ex){
            System.out.println("Error to update the NF data: "+ex.getMessage());
       }
    }
    
    public void delete (int id) {
        try{
            String sql = "DELETE FROM notafiscal WHERE nf_id=?";
            
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setInt(1, id);
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Error deleting suplier: "+ex.getMessage());
        }
    }
}