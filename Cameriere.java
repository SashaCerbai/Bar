/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar;

/**
 *
 * @author cerba
 */
public class Cameriere extends Thread{
    
    protected static int numOrdinazioni = 0;
    
    private static int numClienti = 0;

    public Cameriere(String name, int numClienti) {
        
        super(name);
        this.numClienti=numClienti;
    
    }

    @Override
    public void run() {
        
        while (numClienti > 0) {            
            try{
                System.out.println("Cameriere sta aspettando l'ordinazione");
                Tavolo.semaphorePieno.acquire();

                int ordinazione = Tavolo.prelevaOrdinazioni();
                numOrdinazioni += ordinazione;
                System.out.println("Cameriere ha preso " + ordinazione + " ordinazioni");
                System.out.println("Cameriere ha ottenuto " + numOrdinazioni + " ordinazioni totali");

                Tavolo.semaphoreVuoto.release();
            
            }catch(InterruptedException e){}
            
            numClienti--;
        }
        
    }
    
    
    
}
