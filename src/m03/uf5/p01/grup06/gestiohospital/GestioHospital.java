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
public class GestioHospital {

    private static Hospital h;
    
    public static void main(String[] args) {
        iniciaHospital();
        
    }
    
    private static void iniciaHospital() {
        h = new Hospital();
        
    }
}
