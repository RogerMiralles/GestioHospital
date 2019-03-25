package m03.uf5.p01.grup06.gestiohospital.utils;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CellRender extends DefaultTableCellRenderer {

    private String tipo = "default";

    public CellRender(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        
        if (selected) {
            this.setBackground(new Color(50, 153, 254));
        } else {
            if (row % 2 == 0) {
                this.setBackground(Color.WHITE);
            } else {
                this.setBackground(Color.CYAN);
            }
        }

        if (tipo.equals("nombre")) {
            this.setHorizontalAlignment(JLabel.LEFT);
            this.setText(((String) value).toUpperCase());
            return this;
        }

        if (tipo.equals("dni")) {
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setText(((String) value).toUpperCase());
            this.setForeground(Color.DARK_GRAY);
            return this;
        }

        if (tipo.equals("boolean")) {
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setText((String) value);
            return this;
        }

        return this;
    }

    
}
