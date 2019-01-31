package m03.uf5.p01.grup06.gestiohospital.vista;

import java.awt.*;
import javax.swing.*;
import m03.uf5.p01.grup06.gestiohospital.controlador.*;
import m03.uf5.p01.grup06.gestiohospital.modelo.*;

public class PaginaAnadir extends JFrame {
    
    private final String[] tipoObjetos = {"Visita", "Paciente", "Medico", "Enfermedad"};
    private JPanel pNorte, pSur, pCentro;
    private JComboBox cbTipo;
    private JButton btnAceptar, btnCancelar;
    private ControladorAnadir c;
    private Hospital hospital;
    
    public PaginaAnadir (Hospital hospital) {
        creaGUI();
        asignaMetodos();
    }

    private void creaGUI() {
        
        this.setMinimumSize(new Dimension(600, 450));
        this.setTitle("Afegeix una nova entrada");
        this.setLocationRelativeTo(null);        
        
        JPanel contenido = new JPanel(new BorderLayout());
        contenido.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        pNorte = new JPanel(new GridLayout(2, 2, 5, 5));
        pCentro = new JPanel(new FlowLayout());
        pSur = new JPanel(new FlowLayout());
        
        cbTipo = new JComboBox(tipoObjetos);
        JLabel titulo = new JLabel("<html><h2>Nova entrada</h2>");
        Font fuente = titulo.getFont().deriveFont(Font.PLAIN);
        titulo.setFont(fuente);
        pNorte.add(titulo);
        
        JPanel pTipoEntrada = new JPanel(new FlowLayout());
        pTipoEntrada.add(new JLabel("Seleccioni el tipus d'entrada:"));
        pTipoEntrada.add(cbTipo);
        pNorte.add(pTipoEntrada);

        pCentro = new JPanel(new CardLayout());
        pCentro.add("Visita", new PanelNewVisita());
        pCentro.add("Paciente", new PanelNewPacient());
        pCentro.add("Medico", new PanelNewMetge());
        pCentro.add("Enfermedad", new PanelNewMalaltia());
        
        pCentro.setBorder(BorderFactory.createTitledBorder("Formulari"));
        
        btnAceptar = new JButton("Acceptar");
        btnCancelar = new JButton("Cancelar");
        pSur.add(btnAceptar);
        pSur.add(btnCancelar);
        
        contenido.add(pNorte, BorderLayout.NORTH);
        contenido.add(pCentro, BorderLayout.CENTER);
        contenido.add(pSur, BorderLayout.SOUTH);
        
        this.add(contenido);
        this.pack();
    }
    
    private void asignaMetodos() {
        c = new ControladorAnadir(this, hospital);
    }  
    
    // PROVISIONAL PARA TESTEAR
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaAnadir(new Hospital()).setVisible(true);
            }
        });
    }

    public JComboBox getCbTipo() {
        return cbTipo;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
    
    public JPanel getpNorte() {
        return pNorte;
    }
    
    public JPanel getpCentro() {
        return pCentro;
    }
}
