/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar;

import jdk.nashorn.internal.ir.CatchNode;

/**
 *
 * @author cerba
 */
public class Cliente extends Thread{

    public Cliente(String name) {
        super(name);
        
    }

    @Override
    public void run() {
        
        try{           
            System.out.println("Cliente " + getName() + " in attesa dell'ordine");
            Tavolo.semaphoreVuoto.acquire();
            Tavolo.generaOrdinazioni();
            
            System.out.println("Cliente " + getName() + " ha fatto " + Tavolo.ordinazioni + " ordinazioni");   
            Tavolo.semaphorePieno.release();
            
        }catch(InterruptedException e){}      
        
    }
    
    
    
}
