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
public class Metge extends Persona {

    private final int numEmpleat;
    private final int salariMensual;
    private final String codiCompteCorrent;

    public Metge(String nom, String cognom1, String cognom2, String numSegSocial,
            String nif, String telefon, Adreca Adreca, int numEmpleat, int salariMensual, String codiCompteCorrent) {
        super(nom, cognom1, cognom2, numSegSocial, nif, telefon, Adreca);
        this.numEmpleat = numEmpleat;
        this.salariMensual = salariMensual;
        this.codiCompteCorrent = codiCompteCorrent;

    }

    @Override
    public String toString() {
        return "Dades Metge \n___________________ \nNIF: " + this.getNif() + "\nNom: "
                + this.getNom() + "\nCognoms: " + this.getCognom1() + " "
                + this.getCognom2() + "\nTelefon: " + this.getTelefon()
                + "\nNumero Seguretat Social: " + this.getNumSegSocial()
                + "\n Adreca: " + this.getAdreca().toString()
                + "\nNumero empleat: " + this.numEmpleat + "\nSalari mensual: " + this.salariMensual
                + "\nCodi compte corrent: " + this.codiCompteCorrent;
    }
}
