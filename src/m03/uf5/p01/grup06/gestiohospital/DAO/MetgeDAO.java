package m03.uf5.p01.grup06.gestiohospital.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import m03.uf5.p01.grup06.gestiohospital.modelo.Metge;
import m03.uf5.p01.grup06.gestiohospital.utils.GestorConnexioJDBC;

public class MetgeDAO {
    public static ResultSet getAllMetgesRS() {
        try {
            Connection conn = GestorConnexioJDBC.getConnection();
            PreparedStatement sentencia = conn.prepareStatement("SELECT * FROM METGES;");
            sentencia.executeQuery();
            return sentencia.getResultSet();
        } catch (SQLException ex) {
            System.out.println("ERROR CONSULTA SQL: " + ex.getMessage());
            return null;
        }
    }
    
    public static ResultSet getMetgeByDNIRS(String dni) {
        try {
            Connection conn = GestorConnexioJDBC.getConnection();
            PreparedStatement sentencia = conn.prepareStatement("SELECT * FROM METGES WHERE nifMetge = ?;");
            sentencia.setString(1, dni);
            sentencia.executeQuery();
            return sentencia.getResultSet();
        } catch (SQLException ex) {
            System.out.println("ERROR CONSULTA SQL: " + ex.getMessage());
            return null;
        }
    }
    
    public static ResultSet getMetgeBySSRS(String numSS) {
        try {
            Connection conn = GestorConnexioJDBC.getConnection();
            PreparedStatement sentencia = conn.prepareStatement("SELECT * FROM METGES WHERE numSegSoc = ?;");
            sentencia.setString(1, numSS);
            sentencia.executeQuery();
            return sentencia.getResultSet();
        } catch (SQLException ex) {
            System.out.println("ERROR CONSULTA SQL: " + ex.getMessage());
            return null;
        }
    }
    
    public static boolean updateMetge(Metge metge) {
        try {
            Connection conn = GestorConnexioJDBC.getConnection();
            CallableStatement cStmt = conn.prepareCall("{call actualizaMetge(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cStmt.setInt(1, metge.getNumEmpleat());
            cStmt.setString(2, metge.getNom());
            cStmt.setString(3, metge.getCognom1());
            cStmt.setString(4, metge.getCognom2());
            cStmt.setString(5, metge.getNumSegSocial());
            cStmt.setString(6, metge.getTelefon());
            cStmt.setInt(7, metge.getSalariMensual());
            cStmt.setString(8, metge.getCodiCompteCorrent());
            cStmt.setString(9, metge.getAdreca().getCiutat());
            cStmt.setLong(10, metge.getAdreca().getCodiPostal());
            cStmt.setInt(11, metge.getAdreca().getNumero());
            cStmt.setString(12, metge.getAdreca().getPlanta());
            cStmt.setString(13, metge.getAdreca().getPorta());
            cStmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR CONSULTA SQL: " + ex.getMessage());
            return false;
        }
    }
}
