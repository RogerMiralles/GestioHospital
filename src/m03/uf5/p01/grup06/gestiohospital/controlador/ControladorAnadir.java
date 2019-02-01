package m03.uf5.p01.grup06.gestiohospital.controlador;

import java.awt.CardLayout;
import java.awt.event.*;
import java.time.Duration;
import java.time.LocalDateTime;
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
            }
        }

        if (ae.getActionCommand().equals("btnAceptar")) {
            System.out.println("[INFO]: Boton aceptar pulsado");

            int tipoSeleccionado = pagina.getCbTipo().getSelectedIndex();
            boolean creacionCorrecta = false;

            switch (tipoSeleccionado) {
                case 0:
                    creacionCorrecta = createVisita();
                    break;
                case 1:
                    creacionCorrecta = createPacient();
                    break;
                case 2:
                    creacionCorrecta = createMetge();
                    break;
                case 3:
                    creacionCorrecta = createMalaltia();
                    break;
            }
            if (creacionCorrecta) {
                showConfirmationMessage("Añadido correctamente", "La entidad ha sido creada con exito!");
                pagina.dispose();
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

    private boolean createVisita() {
        try {
            PanelNewVisita p = (PanelNewVisita) pagina.getpVisita();

            int codigoMalaltia = Integer.parseInt(p.getTfEnfermetat().getText());
            Malaltia m = hospital.getMalaltia(codigoMalaltia);

            Pacient pcnt = null;
            String pcntData = p.getTfPacient().getText();
            switch (p.getCbPacient().getSelectedIndex()) {
                case 0:
                    pcnt = hospital.getPacient(pcntData);
                    break;
                case 1:
                    pcnt = hospital.getPacient(Long.parseLong(pcntData));
                    break;
                case 2:
                    pcnt = hospital.getPacient(Integer.parseInt(pcntData));
                    break;
            }

            Metge mtg = null;
            String mtgData = p.getTfPacient().getText();
            switch (p.getCbPacient().getSelectedIndex()) {
                case 0:
                    mtg = hospital.getMetge(mtgData);
                    break;
                case 1:
                    mtg = hospital.getMetge(Long.parseLong(mtgData));
                    break;
            }
            
            if (pcnt == null) {
                showErrorMessage(" PACIENT NO TROBAT", "No existeix ningun pacient amb les dades inserides.");
                return false;
            } else if (mtg == null) {
                showErrorMessage(" METGE NO TROBAT", "No existeix ningun metge amb les dades inserides.");
                return false;
            } else if (m == null) {
                showErrorMessage(" MALALTIA NO TROBADA", "No existeix ninguna malaltia amb el codi inserit.");
                return false;
            } 
            
            LocalDateTime t = LocalDateTime.now();
            Visita v = new Visita(t, m, mtg, pcnt.getNif(), pcnt.getNumSegSocial());
            System.out.println("[INFO]: Visita creada: " + v);

            hospital.getHistorial(pcnt.getHistorial().getCodi()).addVisita(v);
            FicheroCSV.escribeCSV("visites.csv", v);
            return true;
        } catch (NumberFormatException e) {
            showErrorMessage(" ERROR", "Omple tots els camps.");
            return false;
        } catch (Exception e) {
            showErrorMessage(" ERROR", e.toString());
            return false;
        }
    }

    private boolean createPacient() {
        try {
            PanelNewPacient p = (PanelNewPacient) pagina.getpPaciente();
            String nom = p.getTfNom().getText();
            String cognom1 = p.getTfApellido1().getText();
            String cognom2 = p.getTfApellido2().getText();
            String numSegSocial = p.getTfNumSS().getText();
            String nif = p.getTfDNI().getText();
            String telefon = p.getTfTelf().getText();

            String ciutat = p.getTfCiutat().getText();
            Long codiPostal = Long.parseLong(p.getTfCP().getText());
            String carrer = p.getTfCalle().getText();
            int numero = Integer.parseInt(p.getTfNum().getText());
            String planta = p.getTfPlanta().getText();
            String porta = p.getTfPuerta().getText();

            Adreca adreca = new Adreca(ciutat, codiPostal, carrer, numero, planta, porta);

            Pacient pcnt = new Pacient(nom, cognom1, cognom2, numSegSocial, nif, telefon, adreca);
            System.out.println("[INFO]: Pacient creat: " + pcnt);

            hospital.addPacient(pcnt);
            FicheroCSV.escribeCSV("pacients.csv", pcnt);
            return true;
        } catch (NumberFormatException e) {
            showErrorMessage(" ERROR", "Omple tots els camps.");
            return false;
        } catch (Exception e) {
            showErrorMessage(" ERROR", e.toString());
            return false;
        }
    }

    private boolean createMetge() {
        try {
            PanelNewMetge p = (PanelNewMetge) pagina.getpMedico();
            String nom = p.getTfNom().getText();
            String cognom1 = p.getTfApellido1().getText();
            String cognom2 = p.getTfApellido2().getText();
            String numSegSocial = p.getTfNumSS().getText();
            String nif = p.getTfDNI().getText();
            String telefon = p.getTfTelf().getText();
            int numEmpleat = Integer.parseInt(p.getTfNumEmpleat().getText());
            int salari = Integer.parseInt(p.getTfSalari().getText());
            String compteCorrent = p.getTfCompteCorrent().getText();

            String ciutat = p.getTfCiutat().getText();
            Long codiPostal = Long.parseLong(p.getTfCP().getText());
            String carrer = p.getTfCalle().getText();
            int numero = Integer.parseInt(p.getTfNum().getText());
            String planta = p.getTfPlanta().getText();
            String porta = p.getTfPuerta().getText();

            Adreca adreca = new Adreca(ciutat, codiPostal, carrer, numero, planta, porta);

            Metge mtg = new Metge(nom, cognom1, cognom2, numSegSocial, nif, telefon, adreca, numEmpleat, salari, compteCorrent);
            System.out.println("[INFO]: Metge creat: " + mtg);

            hospital.addMetge(mtg);
            FicheroCSV.escribeCSV("metges.csv", mtg);
            return true;
        } catch (NumberFormatException e) {
            showErrorMessage(" ERROR", "Omple tots els camps.");
            return false;
        } catch (Exception e) {
            showErrorMessage(" ERROR", e.toString());
            return false;
        }
    }

    private boolean createMalaltia() {
        try {
            PanelNewMalaltia p = (PanelNewMalaltia) pagina.getpMalaltia();
            String name = p.getTfNom().getText();
            String tractament = p.getTfTractament().getText();
            Duration duracion = Duration.ofDays(Integer.parseInt(p.getTfDurada().getText()));
            Boolean causaBaixa = p.getCbBaixa().isSelected();

            Malaltia m = new Malaltia(name, causaBaixa, tractament, duracion);
            System.out.println("[INFO]: Malaltia creada: " + m);

            hospital.addMalaltia(m);
            FicheroCSV.escribeCSV("malalties.csv", m);
            return true;
        } catch (NumberFormatException e) {
            showErrorMessage(" ERROR", "Omple tots els camps.");
            return false;
        } catch (Exception e) {
            showErrorMessage(" ERROR", e.toString());
            return false;
        }
    }

    private boolean showWaringCloseMessage() {
        Object[] options = {"Continuar aqui", "Sortir sense guardar"};
        int n = JOptionPane.showOptionDialog(pagina,
                "Si cancela l'operacio les dades del formulari es perdran.\nVols sortir sense guardar?",
                "Sortir sense guardar?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[1]);
        return n == JOptionPane.YES_NO_CANCEL_OPTION;
    }

    private void showErrorMessage(String titulo, String msg) {
        JOptionPane.showMessageDialog(pagina, msg, titulo, JOptionPane.ERROR_MESSAGE);
    }

    private void showConfirmationMessage(String titulo, String msg) {
        JOptionPane.showMessageDialog(pagina, msg, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
