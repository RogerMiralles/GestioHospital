package m03.uf5.p01.grup06.gestiohospital.controlador;

import java.time.Duration;
import java.time.LocalDateTime;
import m03.uf5.p01.grup06.gestiohospital.modelo.*;
import m03.uf5.p01.grup06.gestiohospital.vista.*;

public class GestioHospital {

    private static Hospital h;

    public static void main(String[] args) {
        iniciaHospital();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaInicio(h);//.setVisible(true);
            }
        });
    }

    private static void iniciaHospital() {
        try {
            
            System.out.println("INCIO");
            
            
            Adreca a1 = new Adreca("Terrassa", 8226, "Pablo Picaso", 45, "Segona", "Primera");
            Adreca a2 = new Adreca("Barcelona", 8001, "Plaça Catalunya", 78, "Quarta", "Segona");
            Adreca a3 = new Adreca("Terrassa", 8221, "Plaça Doctor Robert", 5, "S/N", "S/N");

            FicheroCSV.escribeCSV("pacients.csv", new Pacient("Juan", "Martín", "Pascual", "281234567840", "45990250W", "666555444", a1));
            FicheroCSV.escribeCSV("pacients.csv",new Pacient("Maria", "Garcia", "Luque", "012345678939", "45872365S", "961247845", a2));
            
            FicheroCSV.escribeCSV("metges.csv", new Metge("Gregory", "House", "Smith", "396120465841", "48181321R", "937564023", a2, 11, 3000, "ES35"));
            FicheroCSV.escribeCSV("metges.csv", new Metge("Margarita", "Robles", "Rojas", "257896321461", "78941245R", "654789123", a1, 12, 2500, "ES97"));
            FicheroCSV.escribeCSV("metges.csv",new Metge("Jose", "Segura", "Iglesias", "157894523691", "78523458D", "678521478", a3, 13, 2000, "ES52") );
            
            FicheroCSV.escribeCSV("malalties.csv", new Malaltia("Resfriado", false, "Jarabe para la tos", Duration.ofDays(5)));
            FicheroCSV.escribeCSV("malalties.csv", new Malaltia("Conjuntivitis", true, "Colirio", Duration.ofDays(7)));
            FicheroCSV.escribeCSV("malalties.csv", new Malaltia("Laringitis", false, "Antibiotico", Duration.ofDays(10)));
            
            
            
            h = new Hospital("Mutua Terrassa", a3);
           
            for (int i = 0; i <FicheroCSV.leeCsvPacients("pacients.csv").size() ; i++) {
                h.addPacient(FicheroCSV.leeCsvPacients("pacients.csv").get(i));
                
            }
            
            System.out.println("Bucle 1");
            for (int i = 0; i < FicheroCSV.leeCsvMetge("metges.csv").size(); i++) {
                h.addMetge(FicheroCSV.leeCsvMetge("metges.csv").get(i));
                
            }
            
            
            System.out.println("EJECUTA");
            for (int i = 0; i < FicheroCSV.leeCsvMalalties("malalties.csv").size(); i++) {
                h.addMalaltia(FicheroCSV.leeCsvMalalties("malalties.csv").get(i));
                
            }
            System.out.println("sadaskjdhakjsdh");
            FicheroCSV.escribeCSV("visites.csv",new Visita(LocalDateTime.parse("2007-12-03T10:15:30"), h.getMalaltia(1), h.getMetge("48181321R"),"45990250W", "281234567840") );
            FicheroCSV.escribeCSV("visites.csv",new Visita(LocalDateTime.parse("2015-05-15T10:15:30"), h.getMalaltia(3), h.getMetge("78523458D"),"45990250W", "281234567840") );
            FicheroCSV.escribeCSV("visites.csv",new Visita(LocalDateTime.parse("2018-02-23T10:15:30"), h.getMalaltia(2), h.getMetge("78941245R"),"45872365S", "012345678939") );
            FicheroCSV.escribeCSV("visites.csv",new Visita(LocalDateTime.parse("2012-10-02T10:15:30"), h.getMalaltia(1), h.getMetge("48181321R"),"45872365S", "012345678939") );
            
            
            for (int i = 0; i < FicheroCSV.leeCsvVisita("visites.csv").size(); i++) {
                if(FicheroCSV.leeCsvVisita("visites.csv").get(i).getDni().equals(h.getPacient("45990250W").getNif())){
                    h.getPacient("45990250W").getHistorial().addVisita(FicheroCSV.leeCsvVisita("visites.csv").get(i));
                }
                if(FicheroCSV.leeCsvVisita("visites.csv").get(i).getDni().equals(h.getPacient("45872365S").getNif())){
                    h.getPacient("45872365S").getHistorial().addVisita(FicheroCSV.leeCsvVisita("visites.csv").get(i));
                }
                
                
            }
            

            /*h.addMetge(new Metge("Gregory", "House", "Smith", "396120465841", "48181321R", "937564023", a2, 11, 3000, "ES35"));
            h.addMetge(new Metge("Margarita", "Robles", "Rojas", "257896321461", "78941245R", "654789123", a1, 12, 2500, "ES97"));
            h.addMetge(new Metge("Jose", "Segura", "Iglesias", "157894523691", "78523458D", "678521478", a3, 13, 2000, "ES52"));
            
            
            h.addMalaltia(new Malaltia("Resfriado", false, "Jarabe para la tos", Duration.ofDays(5)));
            h.addMalaltia(new Malaltia("Conjuntivitis", true, "Colirio", Duration.ofDays(7)));
            h.addMalaltia(new Malaltia("Laringitis", false, "Antibiotico", Duration.ofDays(10)));

            h.getPacient("45990250W").getHistorial().addVisita(new Visita(LocalDateTime.parse("2007-12-03T10:15:30"), h.getMalaltia(1), h.getMetge("48181321R")));
            h.getPacient("45990250W").getHistorial().addVisita(new Visita(LocalDateTime.parse("2015-05-15T10:15:30"), h.getMalaltia(3), h.getMetge("78523458D")));
            h.getPacient("45872365S").getHistorial().addVisita(new Visita(LocalDateTime.parse("2018-02-23T10:15:30"), h.getMalaltia(2), h.getMetge("78941245R")));
            h.getPacient("45872365S").getHistorial().addVisita(new Visita(LocalDateTime.parse("2012-10-02T10:15:30"), h.getMalaltia(1), h.getMetge("48181321R")));
*/
            
            System.out.println("Hospital iniciado con exito.\n\n" + h + "\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("HA FALLADO EL PRGRAMA");
        }
    }
}
