package m03.uf5.p01.grup06.gestiohospital;

import java.time.Duration;

public class Malaltia {

    private static int inc = 0;
    private final int codi;
    private final String nom;
    private final boolean causaBaixa;
    private final String tractament;
    private final Duration duradaTractament;

    public Malaltia(String nom, boolean baixa, String tractament, Duration duracion) {
        this.codi = ++inc;
        this.nom = nom;
        this.causaBaixa = baixa;
        this.tractament = tractament;
        this.duradaTractament = duracion;
    }

    @Override
    public String toString() {
        if (causaBaixa) {
            return "Tiene la enfermedad " + nom + " que causa baja, el tratamiento es " + tractament + " y durará " + duradaTractament.toDays();
        } else {
            return "Tiene la enfermedad " + nom + " que no causa baja, el tratamiento es " + tractament + " y durará " + duradaTractament.toDays();
        }
    }
    
    public int getCodi () {
        return this.codi;
    }
}
