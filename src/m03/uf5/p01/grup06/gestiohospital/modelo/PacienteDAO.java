/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p01.grup06.gestiohospital.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import m03.uf5.p01.grup06.gestiohospital.utils.GestorConnexioJDBC;

/**
 *
 * @author david
 */
public class PacienteDAO {
    
    public static void printSQLException(SQLException e){
        e.printStackTrace(System.err);
        System.err.println("SQLState: " + e.getSQLState());
        System.err.println("Error code: " + e.getErrorCode());
        System.err.println("Message: " + e.getMessage());
        Throwable t = e.getCause();
        while(t != null){
            System.out.println("Cause: " + t);
            t = t.getCause();
        }
    }
    
    public ResultSet pacienteByNif(String nif){
        try {
            Connection con = GestorConnexioJDBC.getConnection();
            PreparedStatement sentencia = null;
            String consulta = "SELECT * FROM PACIENTS WHERE nifPacient = ?";
            sentencia = con.prepareStatement(consulta);
            sentencia.setString(1, nif);
            ResultSet rs = sentencia.getResultSet();
            return rs;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return null;
    }
    
    public ResultSet pacienteByNSS(String nss){
        try {
            Connection con = GestorConnexioJDBC.getConnection();
            PreparedStatement sentencia = null;
            String consulta = "SELECT * FROM PACIENTS WHERE numSegSoc = ?";
            sentencia = con.prepareStatement(consulta);
            sentencia.setString(1, nss);
            ResultSet rs = sentencia.getResultSet();
            return rs;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return null;
    }
    
    public ResultSet pacienteByCodiHistorial(int codiHist){
        try {
            Connection con = GestorConnexioJDBC.getConnection();
            PreparedStatement sentencia = null;
            String consulta = "SELECT * FROM PACIENTS WHERE codiHistorial = ?";
            sentencia = con.prepareStatement(consulta);
            sentencia.setInt(codiHist, codiHist);
            ResultSet rs = sentencia.getResultSet();
            return rs;            
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return null;
    }
    
    public void modificaByNif(Pacient pacient){
        try {
            Connection con = GestorConnexioJDBC.getConnection();
            PreparedStatement sentencia = null;
            String consulta = "(call actualizaPacient(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
        } catch (SQLException ex) {
            printSQLException(ex);
        }
    }
}
