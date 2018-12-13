package m03.uf5.p01.grup06.gestiohospital;

import java.time.Duration;

public class GestioHospital {

    private static Hospital h;
    
    public static void main(String[] args) {
        iniciaHospital();
        
        switch (opcionMenu()) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
        
    }
    
    private static void iniciaHospital() {
        Adreca a1 = new Adreca("Terrassa",8226,"C/Pablo Picaso",45,"Segona","Primera");
        Adreca a2 = new Adreca("Barcelona",8001,"Plaça Catalunya",78,"Quarta","Segona");
        Adreca a3 = new Adreca("Terrassa",8221,"Plaça Doctor Robert",5,"S/N","S/N");
        
        h = new Hospital("Mutua Terrassa",a3);      
        Pacient p1 = new Pacient("Juan","Martín","Pascual","281234567840","45990250W","666555444",a1);
        Metge m1 = new Metge("Gregory","House","Smith","396120465841","12345678Z","937564023",a2,11,3000,"ES35");
        Malaltia ma1 = new Malaltia("Resfriado",false,"Xarop per la tos", Duration.ofDays(5));        
    }
    
    private static int opcionMenu() {
        
    }
}
