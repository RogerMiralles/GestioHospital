/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p01.grup06.gestiohospital;

/**
 *
 * @author Aleix
 */
public class Metge extends Persona{
    
    private int numEmpleat;
    private int salariMensual;
    private String codiCompteCorrent;
    
    public Metge(String nom, String cognom1, String cognom2, String numSegSocial, 
            String nif, String telefon, Adreca Adreca, int numEmpleat, int salariMensual, String codiCompteCorrent) {
        super(nom, cognom1, cognom2, numSegSocial, nif, telefon, Adreca);
        this.numEmpleat=numEmpleat;
        this.salariMensual=salariMensual;
        this.codiCompteCorrent=codiCompteCorrent;
        
    }
    

    public void toString(){
        System.out.println("Dades Metge");
        System.out.println("______________________");
        System.out.println("NIF: ");
        System.out.println("Nom: ");
        System.out.println("Cognoms: ");
        System.out.println("Telefon: ");
        System.out.println("Adreca: ");
        System.out.println("Numero Seguretat Social: ");
        System.out.println("Numero empleat: ");
        System.out.println("Salari mensual: ");
        System.out.println("Codi compte corrent: ");
        
        
        
    }
    
}
