package m03.uf5.p01.grup06.gestiohospital;

import java.util.HashMap;
import java.util.Map;

public class Hospital {
    private final Map<String, Pacient> pacients;
    private final Map<String, Metge> metges;
    private final Map<Integer, Historial> historials;
    private final Map<Integer, Malaltia> malalties;
    private final String nomHospital;
    private final Adreca adreca;
    
    
    public Hospital(String nom, Adreca adreca){
        this.nomHospital = nom;
        this.adreca = adreca;
        this.pacients = new HashMap<>();
        this.metges = new HashMap<>();
        this.historials = new HashMap<>();
        this.malalties = new HashMap<>();
    }
    
    public Hospital(String nom, String ciutat, int codiPostal, String carrer, int numero, String planta, String porta) {
        this.nomHospital = nom;
        this.adreca = new Adreca(ciutat, codiPostal, carrer, numero, planta, porta);
        this.pacients = new HashMap<>();
        this.metges = new HashMap<>();
        this.historials = new HashMap<>();
        this.malalties = new HashMap<>();
    }
    
    public void addMetge (Metge... m)  {
        for (Metge metge : m) {
            if (metges.containsKey(metge.getNif()) || metges.containsValue(metge)) {
                metges.put(metge.getNif(), metge);
            } else {
                throw (new IllegalArgumentException("Metge duplicat."));
            }
        }
    }
    
    public void addPacient (Pacient... p)  {
        for (Pacient pacient : p) {
            if (pacients.containsKey(pacient.getNif()) || pacients.containsValue(pacient)) {
                if (!historials.containsKey(pacient.getHistorial().getCodi())) {
                    this.addHistorial(pacient.getHistorial());
                }
                pacients.put(pacient.getNif(), pacient);
            } else {
                throw (new IllegalArgumentException("Pacient duplicat."));
            }
        }
    }
    
    public void addHistorial (Historial... h)  {
        for (Historial historial : h) {
            if (historials.containsKey(historial.getCodi())) {
                historials.put(historial.getCodi(), historial);
            } else {
                throw (new IllegalArgumentException("Historial duplicat."));
            }
        }
    }
    
    public void addMalaltia (Malaltia... m)  {
        for (Malaltia malaltia : m) {
            if (malalties.containsKey(malaltia.getCodi())) {
                malalties.put(malaltia.getCodi(), malaltia);
            } else {
                throw (new IllegalArgumentException("Malaltia duplicada."));
            }
        }
    }
    
    public Metge getMetge (String dni) {
        if (metges.containsKey(dni)) {
            return metges.get(dni);
        } else {
            return null;
        }
    }
    
    public Pacient getPacient (String dni) {
        if (pacients.containsKey(dni)) {
            return pacients.get(dni);
        } else {
            return null;
        }
    }
    
    public Historial getHistorial (int codi) {
        if (historials.containsKey(codi)) {
            return historials.get(codi);
        } else {
            return null;
        }
    }
    
    public Historial getHistorial (String dniPacient) {
        int codi = this.getPacient(dniPacient).getHistorial().getCodi();
        return getHistorial(codi);
    }
         
    public Malaltia getMalaltia (int codi) {
        if (malalties.containsKey(codi)) {
            return malalties.get(codi);
        } else {
            return null;
        }
    }
    
    @Override
    public String toString () {
        return "Hospital " + this.nomHospital + "\n Adreça: " + this.adreca + 
                "\n Metges: " + this.metges.size() + "\n Pacients: " + this.pacients.size();     
    }
}
