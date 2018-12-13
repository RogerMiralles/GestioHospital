package m03.uf5.p01.grup06.gestiohospital;

public class GestioHospital {

    private static Hospital h;
    
    public static void main(String[] args) {
        iniciaHospital();
        
    }
    
    private static void iniciaHospital() {
        h = new Hospital();
        
    }
}
