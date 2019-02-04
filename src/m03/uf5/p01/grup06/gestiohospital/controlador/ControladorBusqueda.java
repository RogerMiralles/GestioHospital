package m03.uf5.p01.grup06.gestiohospital.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import m03.uf5.p01.grup06.gestiohospital.modelo.*;
import m03.uf5.p01.grup06.gestiohospital.vista.*;

public class ControladorBusqueda implements ActionListener {

    PaginaInicio ventana1;
    Hospital h1;

    public ControladorBusqueda(PaginaInicio ventanaInicio, Hospital h1) {
        ventana1 = ventanaInicio;
        this.h1 = h1;
        asignarComponentes();
    }

    private void asignarComponentes() {
        ventana1.getBtnBuscar().setActionCommand("btnBuscar");
        ventana1.getBtnBuscar().addActionListener(this);

        ventana1.getBtnNuevo().setActionCommand("btnNuevo");
        ventana1.getBtnNuevo().addActionListener(this);
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
        int indice = ventana1.getCbTipoDato().getSelectedIndex();
        switch (indice) {
            case 0:
                ventana1.getCbTipoId().removeAllItems();
                for (int i = 0; i < ventana1.getIdsEnfermedad().length; i++) {
                    ventana1.getCbTipoId().addItem(ventana1.getIdsEnfermedad()[i]);
                }
                break;
            case 1:
                ventana1.getCbTipoId().removeAllItems();
                for (int i = 0; i < ventana1.getIdsHistorial().length; i++) {
                    ventana1.getCbTipoId().addItem(ventana1.getIdsHistorial()[i]);
                }
                break;
            case 2:
                ventana1.getCbTipoId().removeAllItems();
                for (int i = 0; i < ventana1.getIdsMedico().length; i++) {
                    ventana1.getCbTipoId().addItem(ventana1.getIdsMedico()[i]);
                }
                break;
            case 3:
                ventana1.getCbTipoId().removeAllItems();
                for (int i = 0; i < ventana1.getIdsPaciente().length; i++) {
                    ventana1.getCbTipoId().addItem(ventana1.getIdsPaciente()[i]);
                }
                break;
            default:
                ventana1.getCbTipoId().removeAllItems();
        }
    }

    public void buscaContenido() {
        int tipoDato, tipoId;
        String dato;
        tipoDato = ventana1.getCbTipoDato().getSelectedIndex();
        tipoId = ventana1.getCbTipoId().getSelectedIndex();
        dato = ventana1.getTfBuscar().getSelectedText();
        
        switch (tipoDato) {
            case 0:
                try {
                    ventana1.getTaMostrar().setText(h1.getMalaltia(Integer.parseInt(dato)).toString());
                    break;
                } catch (NumberFormatException e) {
                    ventana1.getTaMostrar().setText("Error, se debe introducir un numero entero");
                }
            case 1:
                switch (tipoId) {
                    case 0:
                        try {
                            ventana1.getTaMostrar().setText(h1.getHistorial(Integer.parseInt(dato)).toString());
                            break;
                        } catch (NumberFormatException e) {
                            ventana1.getTaMostrar().setText("Error, se debe introducir un numero entero");
                        }
                    case 1:
                        ventana1.getTaMostrar().setText(h1.getHistorial(dato).toString());
                        break;
                    default:
                }
                break;
            case 2:
                switch (tipoId) {
                    case 0:
                        try {
                            ventana1.getTaMostrar().setText(h1.getMetge(Long.parseLong(dato)).toString());
                            break;
                        } catch (NumberFormatException e) {
                            ventana1.getTaMostrar().setText("Error, se debe introducir un numero entero");
                        }
                    case 1:
                        ventana1.getTaMostrar().setText(h1.getMetge(dato).toString());
                        break;
                    default:
                }
                break;
            case 3:
                switch (tipoId) {
                    case 0:
                        try {
                            ventana1.getTaMostrar().setText(h1.getPacient(Integer.parseInt(dato)).toString());
                            break;
                        } catch (NumberFormatException e) {
                            ventana1.getTaMostrar().setText("Error, se debe introducir un numero entero");
                        }
                    case 1:
                        try{
                            ventana1.getTaMostrar().setText(h1.getPacient(Long.parseLong(dato)).toString());
                        break;
                        }catch(NumberFormatException e){
                            ventana1.getTaMostrar().setText("Error, se debe introducir un numero entero");
                        }                        
                    case 2:
                        ventana1.getTaMostrar().setText(h1.getPacient(dato).toString());
                        break;
                    default:
                }
                break;
            default:
                ventana1.getTaMostrar().setText("No se ha encontrado información a partir de estos datos.");
        }
    }

    public void ventanaNuevo() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PaginaAnadir(h1).setVisible(true);
            }
        });
    }
}
