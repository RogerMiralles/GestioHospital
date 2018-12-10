package m03.uf5.p01.grup06.gestiohospital;


import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aleix
 */
public class Hospital {
    private Map<String, Pacient> pacients;
    private Map<String, Metge> metges;
    private Map<Integer, Historial> historials;
    private Map<Integer, Malaltia> malalties;
    private String nomHospital;
    private Adreca adreca;
    
    
    public Hospital(){
        
    }
    
}
