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

    public Malaltia(int codi, String nom, boolean baixa, String tractament, Duration duracion) {
        this.codi = codi;
        this.nom = nom;
        this.causaBaixa = baixa;
        this.tractament = tractament;
        this.duradaTractament = duracion;
    }

    @Override
    public String toString() {
        return "<html><h2>Datos Enfermedad</h2>"
                + "<ul>"
                + "<li>Codigo: " + this.getCodi()+"</li>"
                + "<li>Nombre: " + this.getNom()+"</li>"
                + "<li>Causa Baja: " + this.isCausaBaixastr()+"</li>"
                + "<li>Tratamiento: " + this.getTractament()+"</li>"
                + "<li>Duración tratamiento: " + this.getDuradaTractament().toDays()+" dias.</li>"
                + "</ul>";
    }

    public int getCodi() {
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

    public String isCausaBaixastr() {
        if(this.isCausaBaixa()){
            return "Si";
        }
        else{
            return "No";
        }
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

    public String FormatCSVMalaltia() {
        return codi + "," + nom + "," + causaBaixa + "," + tractament + "," + duradaTractament.toDays();
    }

}
