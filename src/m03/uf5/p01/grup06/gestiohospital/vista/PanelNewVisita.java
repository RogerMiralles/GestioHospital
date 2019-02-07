package m03.uf5.p01.grup06.gestiohospital.vista;

import java.awt.*;
import javax.swing.*;

public class PanelNewVisita  extends JPanel {
    private final String[] metodoIdentPacient = {"NIF" , "Numero SS", "Codi historial"};
    private final String[] metodoIdentMetge = {"NIF" , "Numero SS"};
    
    private JPanel pacient, metge, enfermetat;
    private JComboBox cbPacient, cbMetge;
    private JTextField tfPacient, tfMetge, tfEnfermetat;
    
    public PanelNewVisita () {
        creaPanel();
    } 

    private void creaPanel() {        
        JPanel pContenido = new JPanel(new GridLayout(4, 1, 5, 5));
        pContenido.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
               
        pacient = new JPanel(new FlowLayout(0));
        tfPacient = new JTextField();
        tfPacient.setPreferredSize(new Dimension(200,30));
        cbPacient = new JComboBox(metodoIdentPacient);
        cbPacient.setPreferredSize(new Dimension(100, 30));
        JLabel lblPacient = new JLabel("Pacient:");
        lblPacient.setPreferredSize(new Dimension(120, 30));
        pacient.add(lblPacient);
        pacient.add(tfPacient);
        pacient.add(cbPacient);
        
        metge = new JPanel(new FlowLayout(0));        
        tfMetge = new JTextField();
        tfMetge.setPreferredSize(new Dimension(200,30));
        cbMetge = new JComboBox(metodoIdentMetge);
        cbMetge.setPreferredSize(new Dimension(100, 30));
        JLabel lblMetge = new JLabel("Metge:");
        lblMetge.setPreferredSize(new Dimension(120, 30));
        metge.add(lblMetge);
        metge.add(tfMetge);
        metge.add(cbMetge);
        
        enfermetat = new JPanel(new FlowLayout(0));
        tfEnfermetat = new JTextField();
        tfEnfermetat.setPreferredSize(new Dimension(200,30));
        JLabel lblEnfermetat = new JLabel("Codi enfermetat:");
        lblEnfermetat.setPreferredSize(new Dimension(120, 30));
        enfermetat.add(lblEnfermetat);
        enfermetat.add(tfEnfermetat);
        
        JLabel lblDesc = new JLabel ("Introdueix les dades de la visita. ");
        
        pContenido.add(lblDesc);
        pContenido.add(pacient);
        pContenido.add(metge);
        pContenido.add(enfermetat);
        this.add(pContenido);
    }

    public JComboBox getCbPacient() {
        return cbPacient;
    }

    public JComboBox getCbMetge() {
        return cbMetge;
    }

    public JTextField getTfPacient() {
        return tfPacient;
    }

    public JTextField getTfMetge() {
        return tfMetge;
    }

    public JTextField getTfEnfermetat() {
        return tfEnfermetat;
    }
}
