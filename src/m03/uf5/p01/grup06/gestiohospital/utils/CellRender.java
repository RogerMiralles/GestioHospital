package m03.uf5.p01.grup06.gestiohospital.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CellRender extends DefaultTableCellRenderer {

   private String tipo="text";
    private Font courier = new Font( "Arial",Font.PLAIN ,12 );
    private Font normal = new Font( "Arial",Font.PLAIN ,12 );
    private Font bold = new Font( "Arial",Font.BOLD ,12 );

    

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        this.setText((String)value);
        this.setForeground(new Color(0,0,0));
        if (selected) {
            this.setBackground(new Color(50, 153, 254));
             this.setFont(bold);
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
