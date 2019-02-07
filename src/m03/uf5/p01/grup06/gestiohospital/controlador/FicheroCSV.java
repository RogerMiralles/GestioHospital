package m03.uf5.p01.grup06.gestiohospital.controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import m03.uf5.p01.grup06.gestiohospital.modelo.*;

 public class FicheroCSV {

   
    public static ArrayList<Pacient> leeCsvPacients(String nombreFichero) throws FileNotFoundException {
        File fichero = new File(nombreFichero);
        Scanner sc = new Scanner(fichero);
        ArrayList <Pacient> pacients=new ArrayList();
        while (sc.hasNext()) {
            String[] datos = sc.nextLine().split(",");
            // [nif, numSegSocial, nom, cognom, cognom, telefon, ciutat, CodiPostal, carrer, num, planta, porta]

            Pacient p = new Pacient(datos[2], datos[3], datos[4], datos[1],
                    datos[0], datos[5], 
                    new Adreca(datos[6],Long.parseLong(datos[7]), datos[8], Integer.parseInt(datos[9]),
                        datos[10], datos[11]));
            pacients.add(p);
        }
        return pacients;
    }

    public static ArrayList <Visita>  leeCsvVisita(String nombreFichero) throws FileNotFoundException {
        File fichero = new File(nombreFichero);
        Scanner sc = new Scanner(fichero);
        ArrayList <Visita> visites = new ArrayList();
        while (sc.hasNext()) {
            String[] datos = sc.nextLine().split(",");
            //[Data, codi, nom, causaBaixa, tractament, duracio, nom, cognom, cognom, segSocial, nif, telefon,
            // ciutat, codiPostal, carrer, numero, planta, porta, numEmpleat, SalriMensual, CompteCorrent, DNI, SS]
             
            try {                
                Malaltia m = new Malaltia(Integer.parseInt(datos[1]), datos[2], Boolean.parseBoolean(datos[3]),
                            datos[4], Duration.ofDays(Long.parseLong(datos[5])));
                
                Metge mtg = new Metge(datos[6], datos[7], datos[8], datos[9], datos[10], datos[11], 
                            new Adreca(datos[12], Long.parseLong(datos[13]), datos[14], Integer.parseInt(datos[15]), datos[16], datos[17]),
                            Integer.parseInt(datos[18]), Integer.parseInt(datos[19]),datos[20]);                
                
                Visita v = new Visita(LocalDateTime.parse(datos[0]), m, mtg, datos[21],datos[22]);
                visites.add(v);
                
            } catch (Exception e) {
                System.out.println(e);
            }
            

        }
        return visites;
    }

    public static ArrayList<Metge> leeCsvMetge(String nombreFichero) throws FileNotFoundException {
        File fichero = new File(nombreFichero);
        Scanner sc = new Scanner(fichero);
        ArrayList <Metge> metges = new ArrayList();
        while (sc.hasNext()) {
            String[] datos = sc.nextLine().split(",");
            // [nom, cognom, cognom, segSocial, nif, telefon, ciutat, codiPostal, carrer, numero
            // planta porta, numEmpleat, SalriMensual, CompteCorrent]
            
            Metge m = new Metge(datos[0], datos[1], datos[2], datos[3],
                    datos[4], datos[5], new Adreca(datos[6], Long.parseLong(datos[7]),
                            datos[8], Integer.parseInt(datos[9]), datos[10], datos[11]),
                    Integer.parseInt(datos[12]), Integer.parseInt(datos[13]),
                    datos[14]);

            metges.add(m);

        }
        return metges;
    }

    public static ArrayList<Malaltia> leeCsvMalalties(String nombreFichero) throws FileNotFoundException {
        File fichero = new File(nombreFichero);
        Scanner sc = new Scanner(fichero);
        ArrayList<Malaltia> malalties = new ArrayList();
        while (sc.hasNext()) {
            String[] datos = sc.nextLine().split(",");
            // [codi, nom, causaBaixa, tractament, duracio]
            
            Malaltia mal = new Malaltia(Integer.parseInt(datos[0]), datos[1], Boolean.parseBoolean(datos[2]),
                    datos[3], Duration.ofDays(Long.parseLong(datos[4])));
            malalties.add(mal);
        }
        return malalties;
    }
    
    public static void escribeCSV(String nombreFichero, Pacient p) {
        try {
            PrintStream out = new PrintStream(new FileOutputStream(nombreFichero, true));
            out.println(p.getNif() + "," + p.getNumSegSocial() + "," + p.getNom() + ","
                    + p.getCognom1() + "," + p.getCognom2() + "," + p.getTelefon() + ","
                    + p.getAdreca().FormCSVAdreca());
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el fichero");
        }
    }

    public static void escribeCSV(String nombreFichero, Visita v) {
        try {
            
            PrintStream out = new PrintStream(new FileOutputStream(nombreFichero, true));
            out.println(v.getData() + "," + v.getMalaltia().FormatCSVMalaltia() + ","
                    + v.getMetge().FormatCSVMetge()+","+v.getSegSocial()+","+v.getDni());
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el fichero");
        }
    }

    public static void escribeCSV(String nombreFichero, Metge m) {
        try {
            PrintStream out = new PrintStream(new FileOutputStream(nombreFichero, true));
            out.println(m.FormatCSVMetge());
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el fichero");
        }
    }

    public static void escribeCSV(String nombreFichero, Malaltia m) {
        try {
            PrintStream out = new PrintStream(new FileOutputStream(nombreFichero, true));
            out.println( m.FormatCSVMalaltia());
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el fichero");
        }
    }
    
    public static boolean existe(String fichero, int tipo){
        try{
            leeCsvPacients(fichero);
            return true;
        }catch(FileNotFoundException e){
            System.out.println("No existe el fichero");
            return false;
        }
    }    
}
