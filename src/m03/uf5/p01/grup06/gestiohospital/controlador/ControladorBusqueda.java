package m03.uf5.p01.grup06.gestiohospital.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import m03.uf5.p01.grup06.gestiohospital.modelo.*;
import m03.uf5.p01.grup06.gestiohospital.vista.*;

public class ControladorBusqueda implements ActionListener {

    private final PaginaInicio ventana;
    private final Hospital hospital;

    public ControladorBusqueda(PaginaInicio ventanaInicio, Hospital h1) {
        this.ventana = ventanaInicio;
        this.hospital = h1;
        asignarComponentes();
        System.out.println("[INFO]: Controlador busca creado (" + hospital.getName() + ").");
    }

    private void asignarComponentes() {
        ventana.getBtnBuscar().setActionCommand("btnBuscar");
        ventana.getBtnBuscar().addActionListener(this);

        ventana.getBtnNuevo().setActionCommand("btnNuevo");
        ventana.getBtnNuevo().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cambiaIds();

        if (e.getActionCommand().equals("btnBuscar")) {
            buscaContenido();
        }

        if (e.getActionCommand().equals("btnNuevo")) {
            ventanaNuevo();
        }
    }

    public void cambiaIds() {
        int indice = ventana.getCbTipoDato().getSelectedIndex();
        switch (indice) {
            case 0:
                ventana.getCbTipoId().removeAllItems();
                for (int i = 0; i < ventana.getIdsEnfermedad().length; i++) {
                    ventana.getCbTipoId().addItem(ventana.getIdsEnfermedad()[i]);
                }
                break;
            case 1:
                ventana.getCbTipoId().removeAllItems();
                for (int i = 0; i < ventana.getIdsHistorial().length; i++) {
                    ventana.getCbTipoId().addItem(ventana.getIdsHistorial()[i]);
                }
                break;
            case 2:
                ventana.getCbTipoId().removeAllItems();
                for (int i = 0; i < ventana.getIdsMedico().length; i++) {
                    ventana.getCbTipoId().addItem(ventana.getIdsMedico()[i]);
                }
                break;
            case 3:
                ventana.getCbTipoId().removeAllItems();
                for (int i = 0; i < ventana.getIdsPaciente().length; i++) {
                    ventana.getCbTipoId().addItem(ventana.getIdsPaciente()[i]);
                }
                break;
            default:
                ventana.getCbTipoId().removeAllItems();
        }
    }

    public void buscaContenido() {
        int tipoDato, tipoId;
        String dato;
        tipoDato = ventana.getCbTipoDato().getSelectedIndex();
        tipoId = ventana.getCbTipoId().getSelectedIndex();
        dato = ventana.getTfBuscar().getSelectedText();
        
        switch (tipoDato) {
            case 0:
                try {
                    ventana.getTaMostrar().setText(hospital.getMalaltia(Integer.parseInt(dato)).toString());
                    break;
                } catch (NumberFormatException e) {
                    ventana.getTaMostrar().setText("Error, se debe introducir un numero entero");
                }
            case 1:
                switch (tipoId) {
                    case 0:
                        try {
                            ventana.getTaMostrar().setText(hospital.getHistorial(Integer.parseInt(dato)).toString());
                            break;
                        } catch (NumberFormatException e) {
                            ventana.getTaMostrar().setText("Error, se debe introducir un numero entero");
                        }
                    case 1:
                        ventana.getTaMostrar().setText(hospital.getHistorial(dato).toString());
                        break;
                    default:
                }
                break;
            case 2:
                switch (tipoId) {
                    case 0:
                        try {
                            ventana.getTaMostrar().setText(hospital.getMetge(Long.parseLong(dato)).toString());
                            break;
                        } catch (NumberFormatException e) {
                            ventana.getTaMostrar().setText("Error, se debe introducir un numero entero");
                        }
                    case 1:
                        ventana.getTaMostrar().setText(hospital.getMetge(dato).toString());
                        break;
                    default:
                }
                break;
            case 3:
                switch (tipoId) {
                    case 0:
                        try {
                            ventana.getTaMostrar().setText(hospital.getPacient(Integer.parseInt(dato)).toString());
                            break;
                        } catch (NumberFormatException e) {
                            ventana.getTaMostrar().setText("Error, se debe introducir un numero entero");
                        }
                    case 1:
                        try{
                            ventana.getTaMostrar().setText(hospital.getPacient(Long.parseLong(dato)).toString());
                        break;
                        }catch(NumberFormatException e){
                            ventana.getTaMostrar().setText("Error, se debe introducir un numero entero");
                        }                        
                    case 2:
                        ventana.getTaMostrar().setText(hospital.getPacient(dato).toString());
                        break;
                    default:
                }
                break;
            default:
                ventana.getTaMostrar().setText("No se ha encontrado información a partir de estos datos.");
        }
    }

    public void ventanaNuevo() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PaginaAnadir(hospital).setVisible(true);
            }
        });
    }
}
