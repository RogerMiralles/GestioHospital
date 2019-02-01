package m03.uf5.p01.grup06.gestiohospital.vista;

import java.awt.*;
import javax.swing.*;
import m03.uf5.p01.grup06.gestiohospital.controlador.ControladorBusqueda;
import m03.uf5.p01.grup06.gestiohospital.modelo.*;

/**
 *
 * @author david
 */
public class PaginaInicio extends JFrame {

    private JPanel pPrincipal, pNorte, pCentro, pSur, pBusqueda;
    private JComboBox cbTipoDato, cbTipoId;
    private JLabel lblTitulo;
    private JTextField tfBuscar;
    private JTextArea taMostrar;
    private JButton btnBuscar, btnCancelar, btnNuevo;
    private String[] objetos = {"Enfermedades", "Historiales", "Medicos", "Pacientes"};
    private String[] idsEnfermedad = {"Codigo"};
    private String[] idsHistorial = {"Codigo", "DNI"};
    private String[] idsMedico = {"NºSegSocial", "DNI"};
    private String[] idsPaciente = {"Codigo", "NºSegSocial", "DNI"};
    private Hospital hospital;

    Adreca a2 = new Adreca("Barcelona", 8001, "Plaça Catalunya", 78, "Quarta", "Segona");
    Metge medico = new Metge("Gregory", "House", "Smith", "396120465841", "48181321R", "937564023", a2, 11, 3000, "ES35");

    public PaginaInicio(Hospital hospital) {
        CreaGUI();
        crearEventos();
        this.hospital = hospital;
    }

    public void CreaGUI() {
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 600);

        pPrincipal = new JPanel();
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pNorte = new JPanel();
        pCentro = new JPanel();
        pSur = new JPanel();
        pBusqueda = new JPanel();
        pBusqueda.setBorder(BorderFactory.createTitledBorder("Opciones de Búsqueda: "));
        pPrincipal.setLayout(new BorderLayout());
        pNorte.setLayout(new GridLayout(0, 1));
        lblTitulo = new JLabel("<html><h1>Pantalla de Visualización<h1>");
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cbTipoDato = new JComboBox(objetos);
        cbTipoId = new JComboBox(idsEnfermedad);
        tfBuscar = new JTextField();
        tfBuscar.setPreferredSize(new Dimension(200, 30));
        taMostrar = new JTextArea();
        taMostrar.setEditable(false);
        btnBuscar = new JButton("Buscar");
        btnCancelar = new JButton("Cancelar");
        btnNuevo = new JButton("Nuevo");

        pBusqueda.add(tfBuscar);
        pBusqueda.add(cbTipoDato);
        pBusqueda.add(cbTipoId);
        pNorte.add(lblTitulo);
        pNorte.add(pBusqueda);
        pCentro.add(taMostrar);
        pSur.add(btnBuscar);
        pSur.add(btnCancelar);
        pSur.add(btnNuevo);

        pPrincipal.add(pNorte, BorderLayout.NORTH);
        pPrincipal.add(pCentro, BorderLayout.CENTER);
        pPrincipal.add(pSur, BorderLayout.SOUTH);

        ventana.add(pPrincipal);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    public void crearEventos() {
        cbTipoDato.addActionListener(new ControladorBusqueda(this, hospital));
    }

    public JComboBox getCbTipoDato() {
        return cbTipoDato;
    }

    public JComboBox getCbTipoId() {
        return cbTipoId;
    }

    public JTextField getTfBuscar() {
        return tfBuscar;
    }

    public JTextArea getTaMostrar() {
        return taMostrar;
    }

    public String[] getObjetos() {
        return objetos;
    }

    public String[] getIdsEnfermedad() {
        return idsEnfermedad;
    }

    public String[] getIdsHistorial() {
        return idsHistorial;
    }

    public String[] getIdsMedico() {
        return idsMedico;
    }

    public String[] getIdsPaciente() {
        return idsPaciente;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public static void main(String[] args) {
        Adreca a3 = new Adreca("Terrassa", 8221, "Plaça Doctor Robert", 5, "S/N", "S/N");
        Hospital h1 = new Hospital("Mutua Terrassa", a3);
        new PaginaInicio(h1);
    }
}
