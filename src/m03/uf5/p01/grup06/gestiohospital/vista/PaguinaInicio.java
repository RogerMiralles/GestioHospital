/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p01.grup06.gestiohospital.vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import m03.uf5.p01.grup06.gestiohospital.modelo.Adreca;
import m03.uf5.p01.grup06.gestiohospital.modelo.Metge;

/**
 *
 * @author Joel C
 */
public class PaguinaInicio extends JFrame {
    private JPanel pPrincipal, pNorte, pCentro, pSur, pBusqueda;
    private JComboBox cbTipoDato, cbTipoId;
    private JLabel lblTitulo;
    private JTextField tfBuscar;
    private JTextArea taMostrar;
    private JButton btnBuscar, btnCancelar;
    String[] objetos = {"Enfermedades","Historiales","Medicos","Pacientes" };
    String[] idsEnfermedad = {"Codigo"};
    String[] idsHistorial = {"Codigo","NºSegSocial","DNI"};
    String[] idsMedico = {"NºSegSocial","DNI"};
    String[] idsPaciente = {"Codigo","NºSegSocial","DNI"};
 
    Adreca a2 = new Adreca("Barcelona", 8001, "Plaça Catalunya", 78, "Quarta", "Segona");
    Metge medico = new Metge("Gregory", "House", "Smith", "396120465841", "48181321R", "937564023", a2, 11, 3000, "ES35");
    
    public PaguinaInicio(){
        CreaGUI();
        crearEventos();
    }
    
    public void CreaGUI(){
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 600);
        
        pPrincipal = new JPanel();
        pNorte = new JPanel();
        pCentro = new JPanel();
        pSur = new JPanel();
        pBusqueda = new JPanel();
        pBusqueda.setBorder(BorderFactory.createTitledBorder("Opciones de Búsqueda: "));
        pPrincipal.setLayout(new BorderLayout());
        pNorte.setLayout(new GridLayout(0,1));
        lblTitulo = new JLabel("<html><h1>Pantalla de Visualización<h1>");
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        cbTipoDato = new JComboBox(objetos);
        cbTipoId = new JComboBox(idsEnfermedad);
        tfBuscar = new JTextField();
        tfBuscar.setPreferredSize(new Dimension(200,30));
        taMostrar = new JTextArea(medico.toString());
        taMostrar.setEditable(false);
        btnBuscar = new JButton("BUSCAR");
        btnCancelar = new JButton("CANCELAR");        
        
        pBusqueda.add(tfBuscar);
        pBusqueda.add(cbTipoDato);
        pBusqueda.add(cbTipoId);
        pNorte.add(lblTitulo);
        pNorte.add(pBusqueda);
        pCentro.add(taMostrar);
        pSur.add(btnBuscar);
        pSur.add(btnCancelar);
        
        pPrincipal.add(pNorte,BorderLayout.NORTH);
        pPrincipal.add(pCentro,BorderLayout.CENTER);
        pPrincipal.add(pSur,BorderLayout.SOUTH);
        
        ventana.add(pPrincipal);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
    
    public void crearEventos(){
        cbTipoDato.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiaIds();
            }
            
        });
    }
    
    public void cambiaIds(){
        int indice = cbTipoDato.getSelectedIndex();
        switch(indice){
            case 0:
                cbTipoId.removeAllItems();
                for(int i = 0; i < idsEnfermedad.length; i++){
                    cbTipoId.addItem(idsEnfermedad[i]);
                }
            case 1:
                cbTipoId.removeAllItems();
                for(int i = 0; i < idsHistorial.length; i++){
                    cbTipoId.addItem(idsHistorial[i]);
                }   
                break;
            case 2:
                cbTipoId.removeAllItems();
                for(int i = 0; i < idsMedico.length; i++){
                    cbTipoId.addItem(idsMedico[i]);
                }
                break;
            case 3:
                cbTipoId.removeAllItems();
                for(int i = 0; i < idsPaciente.length; i++){
                    cbTipoId.addItem(idsPaciente[i]);
                }
                break;
            default:
                cbTipoId.removeAllItems();
        }
    }
    
    public static void main(String[] args) {
        new PaguinaInicio();
    }
}
