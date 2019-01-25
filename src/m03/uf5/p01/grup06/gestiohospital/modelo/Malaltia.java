package m03.uf5.p01.grup06.gestiohospital.modelo;

import java.time.Duration;

public class Malaltia {

    private static int inc = 1;
    private final int codi;
    private final String nom;
    private final boolean causaBaixa;
    private final String tractament;
    private final Duration duradaTractament;

    public Malaltia(String nom, boolean baixa, String tractament, Duration duracion) {
        this.codi = inc++;
        this.nom = nom;
        this.causaBaixa = baixa;
        this.tractament = tractament;
        this.duradaTractament = duracion;
    }

    @Override
    public String toString() {
        if (isCausaBaixa()) {
            return "Tiene la enfermedad " + getNom() + " que causa baja, el tratamiento es " + getTractament() + " y durará " + getDuradaTractament().toDays();
        } else {
            return "Tiene la enfermedad " + getNom() + " que no causa baja, el tratamiento es " + getTractament() + " y durará " + getDuradaTractament().toDays();
        }
    }
    
    public int getCodi () {
        return this.codi;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the causaBaixa
     */
    public boolean isCausaBaixa() {
        return causaBaixa;
    }

    /**
     * @return the tractament
     */
    public String getTractament() {
        return tractament;
    }

    /**
     * @return the duradaTractament
     */
    public Duration getDuradaTractament() {
        return duradaTractament;
    }
    
    
}
