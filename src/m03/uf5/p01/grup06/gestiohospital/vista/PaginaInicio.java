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
    private JLabel lblTitulo, taMostrar;
    private JTextField tfBuscar;
    private JButton btnBuscar, btnNuevo;
    private final String[] objetos = {"Enfermedades", "Historiales", "Medicos", "Pacientes"};
    private final String[] idsEnfermedad = {"Codigo"};
    private final String[] idsHistorial = {"Codigo", "DNI"};
    private final String[] idsMedico = {"NºSegSocial", "DNI"};
    private final String[] idsPaciente = {"Codigo", "DNI", "NºSegSocial"};
    private final Hospital hospital;

    public PaginaInicio(Hospital hospital) {
        this.hospital = hospital;
        this.setTitle("Gestor hospital");
        ImageIcon i = new ImageIcon("drawables/ic_hospitalLauncher.png");
        this.setIconImage(i.getImage());
        CreaGUI();
        crearEventos();
    }

    private void CreaGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setMinimumSize(new Dimension(800, 600));

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
        taMostrar = new JLabel();
        taMostrar.setFont(new Font("Dialog", Font.PLAIN, 12));
        taMostrar.setOpaque(false);
        pCentro.setBorder(BorderFactory.createTitledBorder("Información Buscada: "));
        btnBuscar = new JButton("Buscar");
        btnNuevo = new JButton("Nuevo");

        pBusqueda.add(tfBuscar);
        pBusqueda.add(cbTipoDato);
        pBusqueda.add(cbTipoId);
        pNorte.add(lblTitulo);
        pNorte.add(pBusqueda);
        pCentro.add(taMostrar);
        pSur.add(btnBuscar);
        pSur.add(btnNuevo);

        pPrincipal.add(pNorte, BorderLayout.NORTH);
        pPrincipal.add(pCentro, BorderLayout.CENTER);
        pPrincipal.add(pSur, BorderLayout.SOUTH);

        this.add(pPrincipal);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void crearEventos() {
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

    public JLabel getTaMostrar() {
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

    public JButton getBtnNuevo() {
        return btnNuevo;
    }
}
