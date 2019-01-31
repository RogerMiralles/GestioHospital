package m03.uf5.p01.grup06.gestiohospital.controlador;

import java.awt.CardLayout;
import java.awt.event.*;
import javax.swing.*;
import m03.uf5.p01.grup06.gestiohospital.modelo.*;
import m03.uf5.p01.grup06.gestiohospital.vista.*;

public class ControladorAnadir implements ActionListener {

    private final PaginaAnadir pagina;
    private final Hospital hospital;

    public ControladorAnadir(PaginaAnadir pagina, Hospital hospital) {
        this.pagina = pagina;
        this.hospital = hospital;
        asignaComponentes();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getActionCommand().equals("ComboBoxTipo")) {
            String tipoSeleccionado = pagina.getCbTipo().getSelectedItem().toString();

            CardLayout cl = (CardLayout) (pagina.getpCentro().getLayout());
            cl.show(pagina.getpCentro(), tipoSeleccionado);

            System.out.println("[INFO]: Frame cambiado a " + tipoSeleccionado);
        }

        if (ae.getActionCommand().equals("btnCancelar")) {
            System.out.println("[INFO]: Boton cancelar pulsado");
            if (showWaringCloseMessage()) {
                pagina.dispose();
                System.exit(0);
            }
        }

        if (ae.getActionCommand().equals("btnAceptar")) {
            System.out.println("[INFO]: Boton aceptar pulsado");
            int tipoSeleccionado = pagina.getCbTipo().getSelectedIndex();

            switch (tipoSeleccionado) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }
    }

    private void asignaComponentes() {
        pagina.getCbTipo().setActionCommand("ComboBoxTipo");
        pagina.getCbTipo().addActionListener(this);

        pagina.getBtnAceptar().setActionCommand("btnAceptar");
        pagina.getBtnAceptar().addActionListener(this);

        pagina.getBtnCancelar().setActionCommand("btnCancelar");
        pagina.getBtnCancelar().addActionListener(this);
    }

    private boolean showWaringCloseMessage() {
        Object[] options = {"Continuar aqui", "Sortir sense guardar"};
        int n = JOptionPane.showOptionDialog(pagina,
                "Si cancela l'operacio les dades del formulari es perdran.\nVols sortir sense guardar?",
                "Sortir sense guardar?",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

        return n == JOptionPane.YES_NO_CANCEL_OPTION;
    }
    
    private boolean createVisita() {
        
        return true;
    } 
}
