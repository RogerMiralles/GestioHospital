/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p01.grup06.gestiohospital;

/**
 *
 * @author Joel C
 */
public class Adreca {
    private final String ciutat;
    private final int codiPostal;
    private final String carrer;
    private final int numero;
    private final String planta;
    private final String porta;

    public Adreca(String ciutat, int codiPostal, String carrer, int numero, String planta, String porta) {
        this.ciutat = ciutat;
        this.codiPostal = codiPostal;
        this.carrer = carrer;
        this.numero = numero;
        this.planta = planta;
        this.porta = porta;
    }

    @Override
    public String toString() {
        return "Carrer " + carrer + " Nº" + numero + " " + numero + " " + planta + "-" + porta + "\n" + codiPostal + " " + ciutat;
    }
}
