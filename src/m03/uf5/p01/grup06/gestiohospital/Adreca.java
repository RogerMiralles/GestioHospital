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
    private String ciutat;
    private int codiPostal;
    private String carrer;
    private int numero;
    private String planta;
    private String porta;
    
    Adreca(String ciutat, int codiPostal, String carrer, int numero, String planta, String porta){
        this.ciutat = ciutat;
        this.codiPostal = codiPostal;
        this.carrer = carrer;
        this.numero = numero;
        this.planta = planta;
        this.porta = porta;
    }
}
