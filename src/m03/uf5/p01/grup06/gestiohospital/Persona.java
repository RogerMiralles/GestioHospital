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
    
    public Persona (String nom, String cognom1, String cognom2, String numSegSocial, String nif, String telefon, Adreca adreca) {
        String error = "";
        
        if (!nifCorrecto(nif)) {
            error += "- NIF incorrecto ";
        } else if (!cumplePatron("^[A-zçñàáéèíóòúÇÑÁÀÉÈÍÒÓÚ]*", nom, cognom1, cognom2)){
            error += "- Nombre o apellido incorrecto ";
        } else if (!segSocialCorrecto(numSegSocial)) {
            error += "- Numero de la seguridad social incorrecto ";
        } else if (!cumplePatron("^[967][1-9]{8}$", telefon)) {
            error += "- Numero de telefono incorrecto ";
        }
        
        if (!error.equals("")){
            throw(new IllegalArgumentException(error));
        } else {
            this.nom = nom;
            this.cognom1 = cognom1;
            this.cognom2 = cognom2;
            this.numSegSocial = numSegSocial;
            this.nif = nif;
            this.telefon = telefon;
            this.adreca = adreca;
        }        
    }
    
    private boolean nifCorrecto (String nif) {
        String TABLA_LETRA ="TRWAGMYFPDXBNJZSQVHLCKE";        
        Pattern reglas = Pattern.compile("^[0-9]{8}[A-Z]$");
        Matcher textAnalitzar;
        
        textAnalitzar = reglas.matcher(nif);
        if(!textAnalitzar.matches()) {
            return false;
        } else {
            return TABLA_LETRA.charAt(Integer.parseInt(nif.substring(0,8)) % 23) == nif.charAt(9);
        }
    }
    
    private boolean segSocialCorrecto (String numSegSc) {
        
        if (cumplePatron("^[\\d]{12}$", numSegSc)) {
            
            int idProvincia = Integer.parseInt(numSegSc.substring(0,2));
            
            if ((idProvincia > 0 && idProvincia <= 50) || idProvincia == 53 || idProvincia == 66) {
                
                long n = Long.parseLong(numSegSc.substring(0,10));
                int n2 = Integer.parseInt(numSegSc.substring(10,12));
                
                if (n % 97 == n2) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean cumplePatron (String patron, String... datos) {
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
