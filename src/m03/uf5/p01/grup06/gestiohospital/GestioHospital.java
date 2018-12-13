/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p01.grup06.gestiohospital;

import java.time.Duration;

/**
 *
 * @author Joel C
 */
public class GestioHospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Adreca a1 = new Adreca("Terrassa",8226,"C/Pablo Picaso",45,"Segona","Primera");
        Adreca a2 = new Adreca("Barcelona",8001,"Plaça Catalunya",78,"Quarta","Segona");
        Pacient p1 = new Pacient("Juan","Martín","Pascual","281234567840","45990250W","666555444",a1);
        Metge m1 = new Metge("Gregory","House","Smith","396120465841","12345678Z","937564023",a2,11,3000,"ES35");
        Malaltia ma1 = new Malaltia("Resfriado",false,"Xarop per la tos", Duration.ofDays(5));
    }   
}