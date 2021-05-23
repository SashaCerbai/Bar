/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar;

import java.util.ArrayList;

/**
 *
 * @author cerba
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Il Bar è aperto");
        
        ArrayList<Cliente> listaClienti=new ArrayList<>();
        
        listaClienti.add(new Cliente("Sasha"));
        listaClienti.add(new Cliente("Nirushan"));
        listaClienti.add(new Cliente("Dardan"));
        listaClienti.add(new Cliente("Daniele"));
        listaClienti.add(new Cliente("Joshua"));
        listaClienti.add(new Cliente("Francesco"));
        listaClienti.add(new Cliente("Sun jin woo"));
        
        Cameriere cam=new Cameriere("Filippo", listaClienti.size());
        cam.start();
        
        for (Cliente c : listaClienti) {
            
            c.start();
            
        }
        
        try {
            for (Cliente c : listaClienti) {
                
                c.join();
                
            }
            
            cam.join();
            
        } catch (InterruptedException e) {}
        
        System.out.println("Il Bar è chiuso");
        
        System.out.println("Gli incassi totali della gionrnata sono: " + Cameriere.numOrdinazioni + " euro");
        
    }
    
}
