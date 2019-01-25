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
import java.util.Scanner;
import m03.uf5.p01.grup06.gestiohospital.modelo.Malaltia;
import m03.uf5.p01.grup06.gestiohospital.modelo.Metge;
import m03.uf5.p01.grup06.gestiohospital.modelo.Pacient;
import m03.uf5.p01.grup06.gestiohospital.modelo.Persona;
import m03.uf5.p01.grup06.gestiohospital.modelo.Visita;

/**
 *
 * @author Aleix
 */
public class FicheroCSV {
    
   
    public static void leeCSV(String nombreFichero) throws FileNotFoundException {
        File fichero = new File(nombreFichero);
        Scanner sc = new Scanner(fichero);
        while (sc.hasNext()) {
            String[] datos = sc.nextLine().split(",");
            Persona p = new Persona(datos[0], datos[1], Integer.parseInt(datos[2]));
            System.out.println(p);
        }
    }

    public static void escribeCSV(String nombreFichero, Pacient p) {
        try {
            PrintStream out = new PrintStream(new FileOutputStream(nombreFichero, true));
            out.println(p.getNif() + "," +p.getNumSegSocial()+","+p.getNom()+","+
                    p.getCognom1()+","+p.getCognom2()+","+p.getTelefon());
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el fichero");
        }
    }
    
    public static void escribeCSV(String nombreFichero, Visita v) {
        try {
            PrintStream out = new PrintStream(new FileOutputStream(nombreFichero, true));
            out.println(v.getData()+","+v.getMalaltia()+","+v.getMetge());
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el fichero");
        }
    }
    
    public static void escribeCSV(String nombreFichero, Metge m) {
        try {
            PrintStream out = new PrintStream(new FileOutputStream(nombreFichero, true));
            out.println(m.getNif()+","+m.getNumSegSocial()+","+m.getNom()+","+
                    m.getCognom1()+","+m.getCognom2()+","+m.getTelefon());
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el fichero");
        }
    }
    
    public static void escribeCSV(String nombreFichero, Malaltia m) {
        try {
            PrintStream out = new PrintStream(new FileOutputStream(nombreFichero, true));
            out.println(m.getCodi()+","+m.getNom()+","+m.getTractament()+","+
                    m.getDuradaTractament()+","+m.isCausaBaixa());
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el fichero");
        }
    }
    
    public static boolean existe(String fichero){
        try{
            leeCSV(fichero);
            return true;
        }catch(FileNotFoundException e){
            System.out.println("No existe el fichero");
            return false;
        }
        
    }
    
    
}
