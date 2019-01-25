/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Aleix
 */
 public class FicheroCSV {

   
    public static ArrayList<Pacient> leeCSV(String nombreFichero) throws FileNotFoundException {
        File fichero = new File(nombreFichero);
        Scanner sc = new Scanner(fichero);
        ArrayList <Pacient> pacients=new ArrayList();
        while (sc.hasNext()) {
            String[] datos = sc.nextLine().split(",");

            /*
                    datos[0]=nif
                    datos[1]=numSegSocial
                    datos[2]=nom
                    datos[3]=cognom
                    datos[4]=cognom
                    datos[5]=telefon
                    datos[6]=ciutat
                    datos[7]=codiPostal
                    datos[8]=carrer
                    datos[9]= numero
                    datos[10]=planta
                    datos[11]=porta     
                  
             */
            Pacient p = new Pacient(datos[2], datos[3], datos[4], datos[1],
                    datos[0], datos[5], new Adreca(datos[6],
                            Long.parseLong(datos[7]), datos[8], Integer.parseInt(datos[9]),
                            datos[10], datos[11]));
            pacients.add(p);

            
        }
        return pacients;
    }

    public static ArrayList <Visita>  leeCSV1(String nombreFichero) throws FileNotFoundException {
        File fichero = new File(nombreFichero);
        Scanner sc = new Scanner(fichero);
        ArrayList <Visita> visites=new ArrayList();
        while (sc.hasNext()) {
            String[] datos = sc.nextLine().split(",");
            /*
                    datos[0]=Data
                    datos[1]=codi
                    datos[2]=nom
                    datos[3]=causaBaixa
                    datos[4]=tractament
                    datos[5]=duracio                   
                    datos[6]=nom
                    datos[7]=cognom
                    datos[8]=cognom
                    datos[9]=segSocial           
                    datos[10]= nif
                    datos[11]=telefon
                    datos[12]=ciutat
                    datos[13]=codiPostal
                    datos[14]=carrer
                    datos[15]= numero
                    datos[16]=planta
                    datos[17]=porta
                    datos[18]=numEmpleat
                    datos[19]=SalriMensual
                    datos[20]=CompteCorrent
             */
            Visita v = new Visita(LocalDateTime.parse(datos[0]),
                    new Malaltia(Integer.parseInt(datos[1]), datos[2], Boolean.parseBoolean(datos[3]),
                            datos[4], Duration.ofDays(Long.parseLong(datos[5]))),
                    new Metge(datos[6],
                            datos[7], datos[8], datos[9],
                            datos[10], datos[11], new Adreca(datos[12], Long.parseLong(datos[13]),
                                    datos[14], Integer.parseInt(datos[15]), datos[16], datos[17]),
                            Integer.parseInt(datos[18]), Integer.parseInt(datos[19]),
                            datos[20]));
            visites.add(v);

        }
        return visites;
    }

    public static ArrayList<Metge> leeCSV2(String nombreFichero) throws FileNotFoundException {
        File fichero = new File(nombreFichero);
        Scanner sc = new Scanner(fichero);
        ArrayList <Metge> metges = new ArrayList();
        while (sc.hasNext()) {
            String[] datos = sc.nextLine().split(",");
            /*
                    datos[0]=nom
                    datos[1]=cognom
                    datos[2]=cognom
                    datos[3]=segSocial           
                    datos[4]= nif
                    datos[5]=telefon
                    datos[6]=ciutat
                    datos[7]=codiPostal
                    datos[8]=carrer
                    datos[9]= numero
                    datos[10]=planta
                    datos[11]=porta
                    datos[12]=numEmpleat
                    datos[13]=SalriMensual
                    datos[14]=CompteCorrent
                
             */
            Metge m = new Metge(datos[0], datos[1], datos[2], datos[3],
                    datos[4], datos[5], new Adreca(datos[6], Long.parseLong(datos[7]),
                            datos[8], Integer.parseInt(datos[9]), datos[10], datos[11]),
                    Integer.parseInt(datos[12]), Integer.parseInt(datos[13]),
                    datos[14]);

            metges.add(m);

        }
        return metges;
    }

    public static ArrayList<Malaltia> leeCSV3(String nombreFichero) throws FileNotFoundException {
        File fichero = new File(nombreFichero);
        Scanner sc = new Scanner(fichero);
        ArrayList<Malaltia> malalties = new ArrayList();
        while (sc.hasNext()) {
            String[] datos = sc.nextLine().split(",");
            /*
                    datos[0]=codi
                    datos[1]=nom
                    datos[2]=causaBaixa
                    datos[3]=tractament
                    datos[4]=duracio  
                    
             */
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
                    + p.getAdreca().FormCSVAdreca());//HISTORIAL???
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el fichero");
        }
    }

    public static void escribeCSV(String nombreFichero, Visita v) {
        try {
            System.out.println("Hola");
            PrintStream out = new PrintStream(new FileOutputStream(nombreFichero, true));
            out.println(v.getData() + "," + v.getMalaltia().FormatCSVMalaltia() + ","
                    + v.getMetge().FormatCSVMetge());
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
            out.println(m.FormatCSVMalaltia());
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el fichero");
        }
    }
    
    public static boolean existe(String fichero, int tipo){
        try{
            leeCSV(fichero);
            return true;
        }catch(FileNotFoundException e){
            System.out.println("No existe el fichero");
            return false;
        }
        
    }
    
    
}
