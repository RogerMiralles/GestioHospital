package m03.uf5.p01.grup06.gestiohospital;

import java.time.Duration;
import java.util.Scanner;

public class GestioHospital {

    private static Hospital h;
    private static final Scanner SC = new Scanner(System.in);
    
    public static void main(String[] args) {
        //iniciaHospital();
        boolean seguir = true;
        
        while (seguir){
            switch (opcionMenu()) {
                case 1:
                    //addVisita();
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
                    seguir = false;
                    System.out.println(" --- FIN DEL PROGRAMA --- ");
                    break;
            }
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
        System.out.println("╔══════════════════════════════════╗\n"
                         + "║                                                     ║\n"
                         + "║    Menu de selecció d'accions de l'Hospital         ║\n"
                         + "║                                                     ║\n"
                         + "║           1 - Registrar Visita                      ║\n"
                         + "║                                                     ║\n"
                         + "║           2 - Afegir Nou Pacient                    ║\n"
                         + "║                                                     ║\n"
                         + "║           3 - Mostrar Dades del Pacient             ║\n"
                         + "║                                                     ║\n"
                         + "║           4 - Mostrar Dades del Metge               ║\n"
                         + "║                                                     ║\n"
                         + "║           5 - Mostrar Historial del Pacient         ║\n"
                         + "║                                                     ║\n"
                         + "║           6 - Sortir                                ║\n"
                         + "║                                                     ║\n"
                         + "╚══════════════════════════════════╝\n");
        return SC.nextInt();
    }
    
    private static void addVisita() {
        System.out.println("Inserte el metodo de identificacion del paciente:\n"
                + "\t1. NIF \n\t2. Numero de la Seguridad Social\n\t 3. Codi historial");
        
        int codi;
        switch(SC.nextInt()) {
            case 1:
                System.out.print("Inserte el DNI del paciente: ");
                codi = h.getPacient(SC.next()).getHistorial().getCodi();
                break;
            case 2:
                System.out.print("Inserte el Numero de la Seguridad Social del paciente: ");
                codi = h.getPacient(SC.nextInt()).getHistorial().getCodi();
                break;
            case 3:
                System.out.print("Inserte el codigo del historal del paciente: ");
                codi = SC.nextInt();
                break;
            default:
                System.out.println("Opcion insertada incorrecta.");
                addVisita();
                break;
        }
        
        System.out.println("Inserte el metodo de identificacion del medico:\n"
                + "\t1. NIF \n\t2. Numero de la Seguridad Social");
        Metge m;
        switch(SC.nextInt()) {
            case 1:
                System.out.print("Inserte el DNI del medico: ");
                m = h.getMetge(SC.next());
                break;
            case 2:
                System.out.print("Inserte el Numero de la Seguridad Social del medico: ");
                m = h.getMetge(SC.nextInt());
                break; 
        }
        
        Visita v = new Visita();
        
        h.getHistorial(codi).addVisita(v);
    }
    
    private static void addPacient() {
        System.out.print("Inserte el nombre: ");
        String nom = SC.nextLine();
        System.out.print("Inserte el primer apellido: ");
        String ap1 = SC.nextLine();
        System.out.print("Inserte el segundo apellido: ");
        String aps = SC.nextLine();
        System.out.print("Inserte el numero de la seguridad social: ");
        int nSc = SC.nextInt();
        System.out.print("Inserte el DNI o NIF: ");
        String nif = SC.next();
        System.out.print("Inserte el telefon: ");
        int tel = SC.nextInt();
        
        Pacient p = new Pacient (/* .... */);
        h.addPacient(p);
    }
}
