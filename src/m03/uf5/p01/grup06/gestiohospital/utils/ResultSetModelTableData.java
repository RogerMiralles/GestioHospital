package m03.uf5.p01.grup06.gestiohospital.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ResultSetModelTableData extends AbstractTableModel {

    private final ArrayList<String> nomsColumnes;
    private final ArrayList<ArrayList> dadesFiles;

    public ResultSetModelTableData(ResultSet rs) throws SQLException {
        super();
        nomsColumnes = new ArrayList<>();
        dadesFiles = new ArrayList<>();

        ResultSetMetaData rsmd = rs.getMetaData();
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            nomsColumnes.add(rsmd.getColumnLabel(i));
        }

        while (rs.next()) {
            ArrayList<String> datosFila = new ArrayList<>();

            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                datosFila.add(rs.getString(i));
            }

            dadesFiles.add(datosFila);
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        dadesFiles.get(row).set(col, value);
        fireTableCellUpdated(row, col);
    }

    @Override
    public String getColumnName(int i) {
        return nomsColumnes.get(i);
    }

    @Override
    public int getRowCount() {
        return dadesFiles.size();
    }

    @Override
    public int getColumnCount() {
        return nomsColumnes.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return dadesFiles.get(rowIndex).get(columnIndex);
    }
}
