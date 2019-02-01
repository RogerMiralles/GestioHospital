package m03.uf5.p01.grup06.gestiohospital.modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Hospital {

    private final Hospital hospital;
    private final Map<String, Pacient> pacients;
    private final Map<String, Metge> metges;
    private final Map<Integer, Historial> historials;
    private final Map<Integer, Malaltia> malalties;
    private final String nomHospital;
    private final Adreca adreca;
    

    public Hospital(String nom, Adreca adreca) {
        this.nomHospital = nom;
        this.adreca = adreca;
        this.pacients = new HashMap<>();
        this.metges = new HashMap<>();
        this.historials = new HashMap<>();
        this.malalties = new HashMap<>();
        this.hospital = this;
    }

    public Hospital(String nom, String ciutat, int codiPostal, String carrer, int numero, String planta, String porta) {
        this.nomHospital = nom;
        this.adreca = new Adreca(ciutat, codiPostal, carrer, numero, planta, porta);
        this.pacients = new HashMap<>();
        this.metges = new HashMap<>();
        this.historials = new HashMap<>();
        this.malalties = new HashMap<>();
        this.hospital = this;
    }

    public Hospital getInstance() {
        return this.hospital;
    }
    
    public void addMetge(Metge... m) {
        for (Metge metge : m) {
            if (metges.containsKey(metge.getNif())) {
                throw (new IllegalArgumentException("Medico duplicado. (Ya hay un medico con este DNI)."));
            } else if (getMetge(Long.parseLong(metge.getNumSegSocial())) != null) {
                throw (new IllegalArgumentException("Medico duplicado. (Ya hay un medico con este numero de SS)."));
            } else {
                metges.put(metge.getNif(), metge);
            }
        }
    }

    public void addPacient(Pacient... p) {
        for (Pacient pacient : p) {
            if (pacients.containsKey(pacient.getNif())) {
                throw (new IllegalArgumentException("Paciente duplicado. (Ya hay un paciente con este DNI)."));
            } else if (this.getPacient(Long.parseLong(pacient.getNumSegSocial())) != null) {
                throw (new IllegalArgumentException("Paciente duplicado. (Ya hay un paciente con este numero de SS)."));
            } else {
                this.addHistorial(pacient.getHistorial());
                pacients.put(pacient.getNif(), pacient);
            }
        }
    }

    public void addHistorial(Historial... h) {
        for (Historial historial : h) {
            if (!historials.containsKey(historial.getCodi())) {
                historials.put(historial.getCodi(), historial);
            } else {
                throw (new IllegalArgumentException("Historial duplicado."));
            }
        }
    }

    public void addMalaltia(Malaltia... m) {
        for (Malaltia malaltia : m) {
            if (!malalties.containsKey(malaltia.getCodi())) {
                malalties.put(malaltia.getCodi(), malaltia);
            } else {
                throw (new IllegalArgumentException("Enfermedad duplicada."));
            }
        }
    }

    public Metge getMetge(String dni) {
        if (metges.containsKey(dni)) {
            return metges.get(dni);
        } else {
            return null;
        }
    }

    public Metge getMetge(long SS) {
        for (Entry<String, Metge> entrada : metges.entrySet()) {
            Metge m = entrada.getValue();
            if (Long.parseLong(m.getNumSegSocial()) == SS) {
                return m;
            }
        }
        return null;
    }

    public Pacient getPacient(String dni) {
        if (pacients.containsKey(dni)) {
            return pacients.get(dni);
        } else {
            return null;
        }
    }

    public Pacient getPacient(double SS) {
        for (Entry<String, Pacient> entrada : pacients.entrySet()) {
            Pacient p = entrada.getValue();
            if (Long.parseLong(p.getNumSegSocial()) == SS) {
                return p;
            }
        }
        return null;
    }

    public Pacient getPacient(int numHistorial) {
        for (Entry<String, Pacient> entrada : pacients.entrySet()) {
            Pacient p = entrada.getValue();
            if (p.getHistorial().getCodi() == numHistorial) {
                return p;
            }
        }
        return null;
    }

    public Historial getHistorial(int codi) {
        if (historials.containsKey(codi)) {
            return historials.get(codi);
        } else {
            return null;
        }
    }

    public Historial getHistorial(String dniPacient) {
        int codi = this.getPacient(dniPacient).getHistorial().getCodi();
        return getHistorial(codi);
    }

    public Malaltia getMalaltia(int codi) {
        if (malalties.containsKey(codi)) {
            return malalties.get(codi);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Hospital " + this.nomHospital + "\n" + this.adreca
                + "\n Medicos: " + this.metges.size() + "\n Pacientes: " + this.pacients.size()
                + "\n Historiales: " + this.historials.size() + "\n Enfermedades: " + this.malalties.size();
    }
}
