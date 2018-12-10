/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p01.grup06.gestiohospital;

import java.time.Duration;

/**
 *
 * @author david
 */
public class Malaltia {
    private static int inc = 0;
    private int codi;
    private String nom;
    private boolean causaBaixa;
    String tractament;
    Duration duradaTractament;
    
    public Malaltia(String nom, boolean baixa, String tractament, Duration duracion){
        this.codi = inc++;
        this.nom = nom;
        this.causaBaixa = baixa;
        this.tractament = tractament;
        this.duradaTractament = duracion;
    }
}
