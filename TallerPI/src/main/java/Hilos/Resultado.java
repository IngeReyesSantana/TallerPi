package Hilos;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author Reyes Hernando Santana Perez
 * @serial ID: 170035
 */
public class Resultado {

    private BigDecimal suma, resta, PI, a;
    private int ite, itesum, resul, numsum, numres, mitad;
    Scanner sc = new Scanner(System.in);

    public void Iteraciones() {
        System.out.println("Ingrese numero de Iteraciones");
        ite = sc.nextInt();
        Resultados();
    }

    public int Datos(int Valor) {
        if (Valor % 2 == 0) {
            resul = (Valor / 2);
        } else {
            resul = (Valor / 2) + 1;
        }
        return resul;    
    }

    public void Resultados() {
        itesum = Datos(ite);
        mitad = Datos(itesum);
        numsum = (2*((mitad*2)-1))-1;
        numres = numsum - 2;
        Hilo1 suma1 = new Hilo1();
        Hilo1 suma2 = new Hilo1();
        Hilo2 resta1 = new Hilo2();
        Hilo2 resta2 = new Hilo2();
        
        suma1.Valores(1,numsum);
        suma2.Valores((numsum+4), ite*2);
        resta1.Valores(3, numres);
        resta2.Valores((numres+4), ite*2);

        //Hilo1
        suma1.start();
        try {
            suma1.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Error en el suma1" + e);
        }

        //Hilo2
        suma2.start();
        try {
            suma2.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Error en el suma2" + e);
        }

        //Hilo3
        resta1.start();
        try {
            resta1.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Error en el resta1" + e);
        }

        //Hilo4
        resta2.start();
        try {
            resta2.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Error en el resta2" + e);
        }

        suma = (suma1.Suma).add(suma2.Suma);
        System.out.println("Suma: " + suma);
        resta = (resta1.Resta).add(resta2.Resta);
        System.out.println("Resta: " + resta);
        CalculoPI(suma, resta);
    }

    public void CalculoPI(BigDecimal suma, BigDecimal resta) {
        BigDecimal b = new BigDecimal("4");
        a = suma.subtract(resta);
        PI = b.multiply(a);
        System.out.println("PI: " + PI);
    }
}
