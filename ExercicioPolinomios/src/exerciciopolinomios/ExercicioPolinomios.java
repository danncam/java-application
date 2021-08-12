package exerciciopolinomios;

import funcoes.Polinomio;

public class ExercicioPolinomios {

    public static void main(String[] args) throws Exception {
        
        double coeffP[] = {30.0, 2.0, 4.0};
        double coeffQ[] = {5.0, -8.0};
        
        Polinomio p = new Polinomio(coeffP);
        Polinomio q = new Polinomio(coeffQ);
        
        System.out.println("Polinomio P = " + p);
        System.out.println("Polinomio Q = " + q);
        
        Polinomio s1 = p.somar(q);
        Polinomio s2 = q.somar(p);

        System.out.println("Polinomio S1 = " + s1);
        System.out.println("Polinomio S2 = " + s2);
        
        double r1 = p.avaliar(3.0);
        double r2 = p.avaliar(5.5);
        double r3 = p.avaliar(-16.8);        
    }
}
