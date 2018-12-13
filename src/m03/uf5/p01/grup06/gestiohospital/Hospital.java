package m03.uf5.p01.grup06.gestiohospital;

import java.util.HashMap;
import java.util.Map;

public class Hospital {
    private Map<String, Pacient> pacients;
    private Map<String, Metge> metges;
    private Map<Integer, Historial> historials;
    private Map<Integer, Malaltia> malalties;
    private final String nomHospital;
    private Adreca adreca;
    
    
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
    
    public boolean addMetge ()
    
}
