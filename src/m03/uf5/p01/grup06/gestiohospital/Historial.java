/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p01.grup06.gestiohospital;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Joel C
 */
public class Historial {
    
    private final int codi;
    private static int ultCodigo = 0;
    private final ArrayList<Visita> visitas = new ArrayList<>();
    
    public Historial() {
        this.codi = ++ultCodigo;
    }
    
    @Override
    public String toString() {
        String s = "HISTORIAL " + this.codi + "\n----------------------------------------------";
        
        Iterator<Visita> lit = visitas.iterator();
        
        while (lit.hasNext()) {
            Visita v = lit.next();
            s += "\n Visita " + v.getData().toString();
            s += "\n Metge: " + v.getMetge().getNom() + " " + v.getMetge().getCognom1();
            s += "\n Malaltia: + " + v.getMalaltia().toString();
            s += "\n----------------------------------------------";
        }
        return s;
    }
    
    public void addVisita (Visita v) {
        visitas.add(v);
    }
}
