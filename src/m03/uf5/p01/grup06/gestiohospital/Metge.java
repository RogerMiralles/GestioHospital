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
    

    public String toString(){
            
        return "Dades Metge \n___________________ \nNIF: "+this.getNif()+"\nNom: "
                +this.getNom()+"\nCognoms: "+this.getCognom1()+" "
                +this.getCognom2()+"\nTelefon: "+this.getTelefon()
                +"\nNumero Seguretat Social: "+this.getNumSegSocial()
                +"\n Adreca: "
                +"\nNumero empleat: "+numEmpleat+"\nSalari mensual: "+salariMensual+
                "\nCodi compte corrent: "+ codiCompteCorrent;
        
    }
    
}
