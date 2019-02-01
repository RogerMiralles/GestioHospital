package m03.uf5.p01.grup06.gestiohospital.vista;

import java.awt.*;
import javax.swing.*;
import m03.uf5.p01.grup06.gestiohospital.controlador.*;
import m03.uf5.p01.grup06.gestiohospital.modelo.*;

public class PaginaAnadir extends JFrame {
    
    private final String[] tipoObjetos = {"Visita", "Paciente", "Medico", "Enfermedad"};
    private JPanel pNorte, pSur, pCentro, pVisita, pMedico, pPaciente, pMalaltia;
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
        pVisita = new PanelNewVisita();
        pPaciente = new PanelNewPacient();
        pMedico = new PanelNewMetge();
        pMalaltia = new PanelNewMalaltia();
                
        pCentro.add("Visita", pVisita);
        pCentro.add("Paciente", pPaciente);
        pCentro.add("Medico", pMedico);
        pCentro.add("Enfermedad", pMalaltia);
        
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
                Adreca a3 = new Adreca("Terrassa", 8221, "Plaça Doctor Robert", 5, "S/N", "S/N");
                Hospital h = new Hospital("Mutua Terrassa", a3);
                new PaginaAnadir(h).setVisible(true);
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
    
    public JPanel getpCentro() {
        return pCentro;
    }
    public JPanel getpVisita() {
        return pVisita;
    }

    public JPanel getpMedico() {
        return pMedico;
    }

    public JPanel getpPaciente() {
        return pPaciente;
    }

    public JPanel getpMalaltia() {
        return pMalaltia;
    }
}
