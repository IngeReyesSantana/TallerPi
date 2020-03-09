package Hilos;

import java.math.BigDecimal;

/**
 * @author Reyes Hernando Santana Perez
 * @serial ID: 170035
 */

public class Hilo2 extends Thread{
    
    private int numi, numf;
    private BigDecimal res;
    BigDecimal Resta;
            
    public void Valores(int numei, int numef) {
        this.numi = numei;
        this.numf = numef;
    }        

    @Override
    public void run() {
        Resta = Restar(numi ,numf);
        try {
            Hilo2.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Error en la clase Hilo2 " + e);
        }
    }
    
    public BigDecimal Restar (int numi, int numf){
        res = new BigDecimal(0);
        for (int i = numi; i <= numf; i = i + 4) {
            BigDecimal resta = new BigDecimal(1.0 / i);
            res = res.add(resta);
        }
        return res;
    }  
}