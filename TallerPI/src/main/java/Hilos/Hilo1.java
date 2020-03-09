package Hilos;

import java.math.BigDecimal;

/**
 * @author Reyes Hernando Santana Perez
 * @serial ID: 170035
 */
public class Hilo1 extends Thread {

    int numi, numf;
    BigDecimal Suma;

    public void Valores(int numei, int numef) {
        this.numi = numei;
        this.numf = numef;
    }

    @Override
    public void run() {
        Suma = Sumar(numi, numf);
        try {
            Hilo1.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Error en la clase Hilo1 " + e);
        }
    }

    public BigDecimal Sumar(int numi, int numf) {
        double res = 0.0;
        for (int i = numi; i <= numf; i = i + 4) {
            double suma = (1.0 / i);
            res = res + suma;
        }
        Suma = new BigDecimal(res);
        return Suma;
    }
}
