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
        
        
    }
    
    private boolean nifCorrecto (String nif) {
        String TABLA_LETRA ="TRWAGMYFPDXBNJZSQVHLCKE";        
        Pattern reglas = Pattern.compile("[0-9]{8}[A-Z]");
        Matcher textAnalitzar;
        boolean valido = false;
        
        for (int i = 0; i < 5 && !valido; i++) {
            textAnalitzar = reglas.matcher(nif);
            if(!textAnalitzar.matches())
                return false;
            else{
                Pattern reglaDni = Pattern.compile("[0-9]{8}");
                Matcher textDni = reglaDni.matcher(nif);
                textDni.find();
                int dni = Integer.parseInt(textDni.group());
                char lletra = TABLA_LETRA.charAt(dni % 23);
                if(nif.charAt(nif.length()-1) == lletra)
                    valido = true;
                else 
                    return false;
            }
        }
        return true;
    }       
}
