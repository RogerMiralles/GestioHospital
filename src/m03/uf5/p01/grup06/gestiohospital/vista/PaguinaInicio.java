/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p01.grup06.gestiohospital.vista;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Joel C
 */
public class PaguinaInicio extends JFrame {
    private JPanel pPrincipal, pNorte, pCentro, pSur;
    private JComboBox cbTipoDato, cbTipoId;
    private JTextField tfBuscar;
    private JButton btnBuscar, btnCancelar;
    String[] objetos = {"Enfermedades","Historial","Visita","Medicos","Pacientes" };
    String[] ids = {"codigo"};
    
    public PaguinaInicio(){
        CreaGUI();
    }
    
    public void CreaGUI(){
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 400);
        
        pPrincipal = new JPanel();
        pNorte = new JPanel();
        pCentro = new JPanel();
        pSur = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        cbTipoDato = new JComboBox(objetos);
        cbTipoId = new JComboBox(ids);
        tfBuscar = new JTextField();
        tfBuscar.setPreferredSize(new Dimension(100,30));
        btnBuscar = new JButton("BUSCAR");
        btnCancelar = new JButton("CANCELAR");
        
        pNorte.add(tfBuscar);
        pNorte.add(cbTipoDato);
        pNorte.add(cbTipoId);
        pSur.add(btnBuscar);
        pSur.add(btnCancelar);
        
        pPrincipal.add(pNorte,BorderLayout.NORTH);
        pPrincipal.add(pCentro,BorderLayout.CENTER);
        pPrincipal.add(pSur,BorderLayout.SOUTH);
        
        ventana.add(pPrincipal);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
    
    public static void main(String[] args) {
        new PaguinaInicio();
    }
}
