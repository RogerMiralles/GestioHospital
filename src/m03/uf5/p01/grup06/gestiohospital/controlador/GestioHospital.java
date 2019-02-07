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

    private boolean reiniciaHospitalValoresDefecto() {
        try {
            /*FicheroCSV.escribeCSV("pacients.csv", new Pacient("Juan", "Martín", "Pascual", "281234567840", "45990250W", "666555444", a1));
            FicheroCSV.escribeCSV("pacients.csv", new Pacient("Maria", "Garcia", "Luque", "012345678939", "45872365S", "961247845", a2));

            FicheroCSV.escribeCSV("metges.csv", new Metge("Gregory", "House", "Smith", "396120465841", "48181321R", "937564023", a2, 11, 3000, "ES35"));
            FicheroCSV.escribeCSV("metges.csv", new Metge("Margarita", "Robles", "Rojas", "257896321461", "78941245R", "654789123", a1, 12, 2500, "ES97"));
            FicheroCSV.escribeCSV("metges.csv", new Metge("Jose", "Segura", "Iglesias", "157894523691", "78523458D", "678521478", a3, 13, 2000, "ES52"));

            FicheroCSV.escribeCSV("malalties.csv", new Malaltia("Resfriado", false, "Jarabe para la tos", Duration.ofDays(5)));
            FicheroCSV.escribeCSV("malalties.csv", new Malaltia("Conjuntivitis", true, "Colirio", Duration.ofDays(7)));
            FicheroCSV.escribeCSV("malalties.csv", new Malaltia("Laringitis", false, "Antibiotico", Duration.ofDays(10)));

            FicheroCSV.escribeCSV("visites.csv", new Visita(LocalDateTime.parse("2007-12-03T10:15:30"), h.getMalaltia(1), h.getMetge("48181321R"), "45990250W", "281234567840"));
            FicheroCSV.escribeCSV("visites.csv", new Visita(LocalDateTime.parse("2015-05-15T10:15:30"), h.getMalaltia(3), h.getMetge("78523458D"), "45990250W", "281234567840"));
            FicheroCSV.escribeCSV("visites.csv", new Visita(LocalDateTime.parse("2018-02-23T10:15:30"), h.getMalaltia(2), h.getMetge("78941245R"), "45872365S", "012345678939"));
            FicheroCSV.escribeCSV("visites.csv", new Visita(LocalDateTime.parse("2012-10-02T10:15:30"), h.getMalaltia(1), h.getMetge("48181321R"), "45872365S", "012345678939"));
              */    
            return true;
        } catch (Exception e) {
            System.out.println("ERROR DE RESETEO : " + e.getMessage());
            return false;
        }
    }
}
