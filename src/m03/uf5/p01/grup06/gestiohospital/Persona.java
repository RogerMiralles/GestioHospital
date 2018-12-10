/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p01.grup06.gestiohospital;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Joel C
 */
public abstract class Persona {
    
    private String nom;
    private String cognom1;
    private String cognom2;
    private String numSegSocial;
    private String nif;
    private String telefon;
    private Adreca adreca;
    
    public Persona (String nom, String cognom1, String cognom2, String numSegSocial, String nif, String telefon, Adreca Adreca) {
        String error = null;
        
        if (!nifCorrecto(nif)) {
            error += "NIF Incorrecto";
        } else if (!cumplePatron("")){
            
        }
        
    }
    
    private boolean nifCorrecto (String nif) {
        String TABLA_LETRA ="TRWAGMYFPDXBNJZSQVHLCKE";        
        Pattern reglas = Pattern.compile("[0-9]{8}[A-Z]");
        Matcher textAnalitzar;
        
        textAnalitzar = reglas.matcher(nif);
        if(!textAnalitzar.matches()) {
            return false;
        } else {
            return TABLA_LETRA.charAt(Integer.parseInt(nif.substring(0,8)) % 23) == nif.charAt(9);
        }
    }
    
    private static boolean cumplePatron (String patron, String... datos){
        Pattern regles = Pattern.compile(patron);
        for (String dato : datos) {
            Matcher textAnalitzar = regles.matcher(dato);
            if (!textAnalitzar.matches())
                return false;
        }
        return true;          
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the cognom1
     */
    public String getCognom1() {
        return cognom1;
    }

    /**
     * @return the cognom2
     */
    public String getCognom2() {
        return cognom2;
    }

    /**
     * @return the numSegSocial
     */
    public String getNumSegSocial() {
        return numSegSocial;
    }

    /**
     * @return the nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * @return the telefon
     */
    public String getTelefon() {
        return telefon;
    }

   
    
}
