package m03.uf5.p01.grup06.gestiohospital.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import m03.uf5.p01.grup06.gestiohospital.modelo.Malaltia;
import m03.uf5.p01.grup06.gestiohospital.utils.GestorConnexioJDBC;

public class MalaltiaDAO {

    public static ResultSet getAllMalaltiesRS() {
        try {
            Connection conn = GestorConnexioJDBC.getConnection();
            PreparedStatement sentencia = conn.prepareStatement("SELECT * FROM MALALTIES;");
            sentencia.executeQuery();
            return sentencia.getResultSet();
        } catch (SQLException ex) {
            System.out.println("ERROR CONSULTA SQL: " + ex.getMessage());
            return null;
        }
    }

    public static ResultSet getMalaltiesByCodiRS(int codi) {
        try {
            Connection conn = GestorConnexioJDBC.getConnection();
            PreparedStatement sentencia = conn.prepareStatement("SELECT * FROM MALALTIES WHERE codiMalaltia = ?;");
            sentencia.setInt(1, codi);
            sentencia.executeQuery();
            return sentencia.getResultSet();
        } catch (SQLException ex) {
            System.out.println("ERROR CONSULTA SQL: " + ex.getMessage());
            return null;
        }
    }

    public static boolean updateMalaltia(Malaltia malaltia) {
        try {
            Connection conn = GestorConnexioJDBC.getConnection();
            CallableStatement cStmt = conn.prepareCall("{call actualizaMalaltia(?, ?, ?, ?, ?)}");
            cStmt.setInt(1, malaltia.getCodi());
            cStmt.setString(2, malaltia.getNom());
            cStmt.setString(3, malaltia.isCausaBaixastr());
            cStmt.setString(4, malaltia.getTractament());
            cStmt.setInt(5, (int) malaltia.getDuradaTractament().toDays());
            cStmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR CONSULTA SQL: " + ex.getMessage());
            return false;
        }
    }

    public static boolean createMalaltia(Malaltia malaltia) {
        try {
            Connection con = GestorConnexioJDBC.getConnection();
            PreparedStatement sentencia = null;
            String consulta = "INSERT INTO MALALTIES VALUES(?,?,?,?,?)";
            sentencia = con.prepareStatement(consulta);
            sentencia.setInt(1, malaltia.getCodi());
            sentencia.setString(2, malaltia.getNom());
            sentencia.setString(3, malaltia.isCausaBaixastr());
            sentencia.setString(4, malaltia.getTractament());
            sentencia.setInt(5, (int) malaltia.getDuradaTractament().toDays());
            sentencia.executeQuery();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR CONSULTA SQL: " + ex.getMessage());
            return false;
        }
    }
}
