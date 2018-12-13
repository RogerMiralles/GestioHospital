/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p01.grup06.gestiohospital;

/**
 *
 * @author david
 */
public class Pacient extends Persona {

    private final Historial historial;

    public Pacient(String nom, String cognom1, String cognom2, String numSegSocial, String nif, String telefon, Adreca adreca) {
        super(nom, cognom1, cognom2, numSegSocial, nif, telefon, adreca);
        historial = new Historial();
    }

    @Override
    public String toString() {
        return "Dades Pacient: " + this.getNom() + " " + this.getCognom1() + " " + this.getCognom2() + "\n"
                + "Nnumero de SS: " + this.getNumSegSocial() + "\n"
                + "DNI: " + this.getNif() + "\n"
                + "Telefon: " + this.getTelefon() + "\n"
                + "Adreça: " + this.getAdreca().toString() + "\n"
                + historial.toString();
    }
    
    public Historial getHistorial() {
        return this.historial;
    }
}
