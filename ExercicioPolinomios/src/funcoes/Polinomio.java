package funcoes;

public class Polinomio {

    private double coeficientes[];

    /**
     * Este é o construtor que eu quero para esta classe!
     */
    public Polinomio(final double c[]){
        this.coeficientes = new double[c.length];
        System.arraycopy(c, 0, this.coeficientes, 0, c.length);
    }
    
    /**
     * Método que avalia o polinomio.
     */
    public double avaliar(double x) {
        // Versão naive.
        /*
        double r = 0.0;
        for (int i=0; i<this.coeficientes.length; i++) {
            r += this.coeficientes[i] * Math.pow(x, i);
        }
        return r;
        */
        
        // Versão um pouco mais eficiente.
        if (this.coeficientes.length > 0) {
            double r = this.coeficientes[0];
            double xPowIndex = 1.0;
            for (int i=1; i<this.coeficientes.length; i++) {
                xPowIndex *= x;
                r += this.coeficientes[i] * xPowIndex;
            }
            return r;
        }
        else {
            return 0.0;
        }
    }
    
    @Override
    public String toString() {
        String r = "";
        for (int i=0; i<this.coeficientes.length; i++) {
            r += " + " + this.coeficientes[i] + " * x^" + i;
        }
        return r;
    }
    
    
    /**
     * Operação de soma do polinomio atual com outro polinomio informado.
     */
    public Polinomio somar(final Polinomio other) throws Exception {
            if (other == null) {
                throw new Exception("Uma instância de polinômio é requerida");
            }
            
            // Uma possibilidade de implementação.
            /*
            int minLength = Math.min(this.coeficientes.length, other.coeficientes.length);
            int maxLength = Math.max(this.coeficientes.length, other.coeficientes.length);

            double aux[] = new double[maxLength];
            for (int i=0; i<minLength; i++) {
                aux[i] = this.coeficientes[i] + other.coeficientes[i];
            }
            
            if (this.coeficientes.length == maxLength) {
                System.arraycopy(this.coeficientes, minLength, aux, minLength, maxLength - minLength);
            }
            else {
                System.arraycopy(other.coeficientes, minLength, aux, minLength, maxLength - minLength);
            }
            
            return new Polinomio(aux);
            */
            
            // Outra possibilidade de implementação.
            int minLength = Math.min(this.coeficientes.length, other.coeficientes.length);
            int maxLength = Math.max(this.coeficientes.length, other.coeficientes.length);

            double min[], max[];
            double aux[] = new double[maxLength];
            
            if (this.coeficientes.length == maxLength) {
                max = this.coeficientes;
                min = other.coeficientes;
            }
            else {
                max = other.coeficientes;
                min = this.coeficientes;
            }
            
            System.arraycopy(max, 0, aux, 0, maxLength);
            for (int i=0; i<minLength; i++) {
                aux[i] += min[i];
            }

            return new Polinomio(aux);
    }
}
