package m03.uf5.p01.grup06.gestiohospital.controlador;

import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
        
        
        ventana1.getTfBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
              buscaContenido();
                
            }
        });
        
        

        ventana1.getBtnNuevo().setActionCommand("btnNuevo");
        ventana1.getBtnNuevo().addActionListener(this);

        ventana1.getCbTipoDato().setActionCommand("cbTipoDato");
        ventana1.getCbTipoDato().addActionListener(this);

        ventana1.getCbTipoId().setActionCommand("cbTipoId");
        ventana1.getCbTipoId().addActionListener(this);

        onlyAllowNumbers(ventana1.getTfBuscar());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("btnBuscar")) {
            buscaContenido();
        }

        if (e.getActionCommand().equals("btnNuevo")) {
            ventanaNuevo();
        }

        if (e.getActionCommand().equals("cbTipoDato")) {
            int indice = ventana1.getCbTipoDato().getSelectedIndex();
            cambiaIds(indice);
        }

        if (e.getActionCommand().equals("cbTipoId")) {
            int index = ventana1.getCbTipoId().getSelectedIndex();
            ventana1.getTfBuscar().setText("");
            ventana1.getTfBuscar().removeKeyListener(numbersListener);
            ventana1.getTfBuscar().removeKeyListener(dniListener);
            if (index == 1) {
                allowDni(ventana1.getTfBuscar());
            } else {
                onlyAllowNumbers(ventana1.getTfBuscar());
            }
        }
    }

    public void cambiaIds(int indice) {
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
        String dato, cadena;
        tipoDato = ventana1.getCbTipoDato().getSelectedIndex();
        tipoId = ventana1.getCbTipoId().getSelectedIndex();
        dato = ventana1.getTfBuscar().getText();
        //ventana1.getTaMostrar().setText(cadena);
        try {
            switch (tipoDato) {
                case 0:
                    ventana1.getTaMostrar().setText(h1.getMalaltia(Integer.parseInt(dato)).toString());
                    break;
                case 1:
                    switch (tipoId) {
                        case 0:
                            ventana1.getTaMostrar().setText(h1.getHistorial(Integer.parseInt(dato)).toString());
                            break;
                        case 1:
                            ventana1.getTaMostrar().setText(h1.getHistorial(dato).toString());
                            break;
                    }
                    break;
                case 2:
                    switch (tipoId) {
                        case 0:
                            ventana1.getTaMostrar().setText(h1.getMetge(Long.parseLong(dato)).toString());
                            break;
                        case 1:
                            ventana1.getTaMostrar().setText(h1.getMetge(dato).toString());
                            break;
                    }
                    break;
                case 3:
                    switch (tipoId) {
                        case 0:
                            ventana1.getTaMostrar().setText(h1.getPacient(Integer.parseInt(dato)).toString());
                            break;
                        case 1:
                            ventana1.getTaMostrar().setText(h1.getPacient(dato).toString());
                            break;
                        case 2:
                            ventana1.getTaMostrar().setText(h1.getPacient(Long.parseLong(dato)).toString());
                            break;
                    }
                    break;
                default:
                    ventana1.getTaMostrar().setText("No se ha encontrado información a partir de estos datos.");
            }
        } catch (NumberFormatException e) {
            showErrorMessage("Campos vacios", "No deje el formulario en blanco");
            ventana1.getTaMostrar().setText(" ");
        } catch (NullPointerException e) {
            showErrorMessage("Error de Busqueda", "Información no existente.");
            ventana1.getTaMostrar().setText(" ");
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

    KeyListener numbersListener;

    private void onlyAllowNumbers(JTextField txt) {
        numbersListener = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        };
        txt.addKeyListener(numbersListener);
    }

    KeyListener dniListener;

    private void allowDni(JTextField txt) {
        dniListener = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || ((c >= 'A') && (c <= 'Z')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        };
        txt.addKeyListener(dniListener);
    }

    private void showErrorMessage(String titulo, String msg) {
        JOptionPane.showMessageDialog(ventana1, msg, titulo, JOptionPane.ERROR_MESSAGE);
    }

    
}
