package m03.uf5.p01.grup06.gestiohospital;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class GestioHospital {

    private static Hospital h;
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        iniciaHospital();
        boolean seguir = true;

        while (seguir) {
            switch (opcionMenu()) {
                case 1:
                    addVisita();
                    break;
                case 2:
                    addPacient();
                    break;
                case 3:
                    mostrarPacient();
                    break;
                case 4:
                    mostrarMetge();
                    break;
                case 5:
                    mostraHistorial();
                    break;
                case 6:
                    seguir = false;
                    System.out.println(" --- FIN DEL PROGRAMA --- ");
                    break;
            }
        }
    }

    private static void iniciaHospital() {
        try {
            Adreca a1 = new Adreca("Terrassa", 8226, "Pablo Picaso", 45, "Segona", "Primera");
            Adreca a2 = new Adreca("Barcelona", 8001, "Plaça Catalunya", 78, "Quarta", "Segona");
            Adreca a3 = new Adreca("Terrassa", 8221, "Plaça Doctor Robert", 5, "S/N", "S/N");

            h = new Hospital("Mutua Terrassa", a3);

            h.addPacient(new Pacient("Juan", "Martín", "Pascual", "281234567840", "45990250W", "666555444", a1));
            h.addPacient(new Pacient("Maria", "Garcia", "Luque", "012345678939", "45872365S", "961247845", a2));

            h.addMetge(new Metge("Gregory", "House", "Smith", "396120465841", "48181321R", "937564023", a2, 11, 3000, "ES35"));
            h.addMetge(new Metge("Margarita", "Robles", "Rojas", "257896321461", "78941245R", "654789123", a1, 12, 2500, "ES97"));
            h.addMetge(new Metge("Jose", "Segura", "Iglesias", "157894523691", "78523458D", "678521478", a3, 13, 2000, "ES52"));

            h.addMalaltia(new Malaltia("Resfriado", false, "Xarop per la tos", Duration.ofDays(5)));
            h.addMalaltia(new Malaltia("Conjuntivitis", true, "Clorido", Duration.ofDays(7)));
            h.addMalaltia(new Malaltia("Laringitis", false, "Antibiotico", Duration.ofDays(10)));

            h.getPacient("45990250W").getHistorial().addVisita(new Visita(LocalDateTime.parse("2007-12-03T10:15:30"), h.getMalaltia(1), h.getMetge("48181321R")));
            h.getPacient("45990250W").getHistorial().addVisita(new Visita(LocalDateTime.parse("2015-05-15T10:15:30"), h.getMalaltia(3), h.getMetge("78523458D")));
            h.getPacient("45872365S").getHistorial().addVisita(new Visita(LocalDateTime.parse("2018-02-23T10:15:30"), h.getMalaltia(2), h.getMetge("78941245R")));
            h.getPacient("45872365S").getHistorial().addVisita(new Visita(LocalDateTime.parse("2012-10-02T10:15:30"), h.getMalaltia(1), h.getMetge("48181321R")));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
        System.out.print("Inserte aqui su opcion: ");
        return SC.nextInt();
    }

    private static void addVisita() {

        int codi = identificaPacient().getHistorial().getCodi();
        Metge metg = identificaMetge();

        Malaltia mal = null;
        while (mal == null) {
            System.out.print("Inserta el codi de la malaltia: ");
            mal = h.getMalaltia(SC.nextInt());
            System.out.println("Malaltia no encontrada. Intentlo otra vez.");
        }

        h.getHistorial(codi).addVisita(new Visita(LocalDateTime.now(), mal, metg));
        System.out.println("Visita añadida con exito.");
    }

    private static void addPacient() {
        System.out.print("Inserte el nombre: ");
        String nom = SC.next();
        System.out.print("Inserte el primer apellido: ");
        String ap1 = SC.next();
        System.out.print("Inserte el segundo apellido: ");
        String ap2 = SC.next();
        System.out.print("Inserte el numero de la seguridad social: ");
        String nSs = SC.next();
        System.out.print("Inserte el DNI o NIF: ");
        String nif = SC.next();
        System.out.print("Inserte el telefono: ");
        String tel = SC.next();
        System.out.print("Inserte la Calle:");
        String calle = SC.next();
        System.out.print("Inserte el Numero:");
        int num = SC.nextInt();
        System.out.print("Inserte la Planta (con letras):");
        String planta = SC.next();
        System.out.print("Inserte la Puerta (con letras):");
        String puerta = SC.next();
        System.out.print("Inserte el Codigo Postal (omitir 0 a la izquierda):");
        int postal = SC.nextInt();
        System.out.print("Insertar la Ciudad:");
        String ciudad = SC.next();

        Pacient p = new Pacient(nom, ap1, ap2, nSs, nif, tel, new Adreca(ciudad, postal, calle, num, planta, puerta));
        h.addPacient(p);
        System.out.println("Paciente añadido con exito.");
    }

    private static void mostrarPacient() {
        System.out.println("\n" + identificaPacient() + "\n");
    }

    private static void mostrarMetge() {
        System.out.println("\n" + identificaMetge() + "\n");
    }

    private static void mostraHistorial() {
        System.out.println("\n" + identificaPacient().getHistorial() + "\n");
    }

    private static Pacient identificaPacient() {
        Pacient p = null;
        while (p == null) {
            System.out.print("\nInserte el metodo de identificacion del paciente:\n"
                    + "\t1. NIF \n\t2. Numero de la Seguridad Social\n\t3. Codigo de historial\n\nInserte aqui su opcion: ");
            try {
                switch (Integer.parseInt(SC.next())) {
                    case 1:
                        System.out.print("Inserte el DNI del paciente: ");
                        p = h.getPacient(SC.next());
                        if (p == null) {
                            System.out.println("No se ha encontrado nadie con ese DNI. Intentelo otra vez.");
                        }
                        break;
                    case 2:
                        System.out.print("Inserte el Numero de la Seguridad Social del paciente: ");
                        try {
                            p = h.getPacient(Integer.parseInt(SC.next()));
                            if (p == null) {
                                System.out.println("No se ha encontrado nadie con ese numero de la SS. Intentlo otra vez.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Numero de la SS invalido, intentelo de nuevo insertando los 12 digitos sin espacios.");
                        }
                        break;
                    case 3:
                        System.out.print("Inserte el codigo del historal del paciente: ");
                        try {
                            p = h.getPacientPerHistorial(Integer.parseInt(SC.next()));
                            if (p == null) {
                                System.out.println("No se ha encontrado nadie con ese numero de historial. Intentlo otra vez.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Numero de historial invalido, intentelo de nuevo insertando unicamente con digitos y sin espacios.");
                        }
                        break;
                    default:
                        System.out.println("Opcion insertada incorrecta. Intentlo otra vez.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Opcion insertada incorrecta. Inserte un numero con la opcion deseada.");
            }
        }
        return p;
    }

    private static Metge identificaMetge() {
        Metge metg = null;
        while (metg == null) {
            System.out.print("Inserte el metodo de identificacion del medico:\n"
                    + "\t1. NIF \n\t2. Numero de la Seguridad Social\n\nInserte aqui su opcion: ");

            try {
                switch (Integer.parseInt(SC.next())) {
                    case 1:
                        System.out.print("Inserte el DNI del medico: ");
                        metg = h.getMetge(SC.next());
                        break;
                    case 2:
                        System.out.print("Inserte el Numero de la Seguridad Social del medico: ");
                        try {
                            metg = h.getMetge(Integer.parseInt(SC.next()));
                        } catch (NumberFormatException e) {
                            System.out.println("Numero de la SS invalido, intentelo de nuevo insertando los 12 digitos sin espacios.");
                        }
                        break;
                    default:
                        System.out.println("Opcion insertada incorrecta. Intentlo otra vez.");
                }
                if (metg == null) {
                    System.out.println("Medico no encontrado, intentelo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opcion insertada incorrecta. Inserte un numero con la opcion deseada.");
            }
        }
        return metg;
    }
}
