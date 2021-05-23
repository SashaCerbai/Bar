/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author cerba
 */
public class Tavolo {
    
    protected static int ordinazioni = 0;
    
    protected static Semaphore semaphorePieno  = new Semaphore(0);
    protected static Semaphore semaphoreVuoto  = new Semaphore(1);
    
    public synchronized static void generaOrdinazioni(){
        
        ordinazioni = new Random().nextInt(4) + 1;
        
    }
    
    public synchronized static int prelevaOrdinazioni(){
        
        return ordinazioni;
        
    }
    
}
