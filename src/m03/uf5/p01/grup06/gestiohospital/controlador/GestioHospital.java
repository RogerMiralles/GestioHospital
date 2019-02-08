package m03.uf5.p01.grup06.gestiohospital.controlador;

import java.util.ArrayList;
import m03.uf5.p01.grup06.gestiohospital.modelo.*;
import m03.uf5.p01.grup06.gestiohospital.vista.*;

public class GestioHospital {

    private static Hospital h;

    public static void main(String[] args) {
        iniciaHospital();

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PaginaInicio(h).setVisible(true);
            }
        });
    }

    private static void iniciaHospital() {
        try {

            System.out.println("INICIANDO HOSPITAL...");

            h = new Hospital("Mutua Terrassa", new Adreca("Terrassa", 8221, "Plaça Doctor Robert", 5, "S/N", "S/N"));

            // AÑADIR PACIENTES DEL CRV
            ArrayList<Pacient> listPacients =  FicheroCSV.leeCsvPacients("pacients.csv");
            Pacient[] allPacients = new Pacient[listPacients.size()];
            h.addPacient(listPacients.toArray(allPacients));
            System.out.println("Se han añadido " + h.getPacientSize() + " pacientes.");

            //AÑADIR MEDICOS DEL CRV
            ArrayList<Metge> listMetges =  FicheroCSV.leeCsvMetge("metges.csv");
            Metge[] allMetges = new Metge[listMetges.size()];
            h.addMetge(listMetges.toArray(allMetges));
            System.out.println("Se han añadido " + h.getMetgeSize() + " medicos.");

            //AÑADIR ENFERMEDADES DEL CRV
            ArrayList<Malaltia> listMalaltia =  FicheroCSV.leeCsvMalalties("malalties.csv");
            Malaltia[] allMalaltias = new Malaltia[listMalaltia.size()];
            h.addMalaltia(listMalaltia.toArray(allMalaltias));
            System.out.println("Se han añadido " + h.getMetgeSize() + " enfermedades.");

            //AÑADIR VISITAS DEL CRV
            ArrayList<Visita> listVisitas =  FicheroCSV.leeCsvVisita("visites.csv");
            Visita[] allVisitas = new Visita[listVisitas.size()];
            listVisitas.toArray(allVisitas);
                    
            for (Visita visita : allVisitas) {
                h.getPacient(visita.getDni()).getHistorial().addVisita(visita);
            }
            System.out.println("Se han añadido " + allVisitas.length + " visitas.");

            
            System.out.println("Hospital iniciado con exito.\n\n" + h + "\n");

        } catch (Exception e) {
            System.out.println("ERROR DE INICIALIZACION : " + e.getMessage());
        }
    }
}
