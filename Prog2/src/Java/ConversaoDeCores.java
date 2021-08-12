package Java;

/**
 *
 * March 13
 * Diferentes sistemas são utilizados para representar cores.
 * Por exemplo, o sistema mais comum para representação de cores em
 * display LCD, câmeras digitais e páginas web conhecido como sistema
 * RGB, especifica os níveis de vermelho(R), verde(G) e azul(B) em uma
 * escala de 0 a 255.
 * O sistema utilizado na publicação de livros e revistas, conhecido como
 * CMYK, especifica os níveis de ciano, magenta, amarelo e preto em um
 * escala de 0.0 a 1.0.
 * Escreva um programa Java que receba três inteiros r, g e b
 * representando um cor no sistema RGB e imprima os valores das
 * componentes c, m, y, k correspondentes no sistema CMYK.
 * Se r=g=b=0 então c=m=y=0 e k = 1, caso contrário utilize a fórmula abaixo:
 * 
 * w  max(r / 255, g / 255, b / 255);
 * c  (w  (r / 255)) / w
 * m (w  (g / 255)) / w
 * y  (w (b / 255)) / w
 * k  1 w
 * 
 */
public class ConversaoDeCores {
    public static void main(String[] args) {
    	int r, g, b;

    	double c, m, y, k;


    	r = 12;
    	g = 35;
    	b = 122;


    	float w1 = Math.max(r / 255.0f, g/ 255.0f);
    	float w  = Math.max(w1, b / 255.0f);
        System.out.println(w);
    	if ((r == 0) && (g == 0) && (b == 0)) 
        {
        	c = 0f;
        	m = 0f;
        	y = 0f;
        	k = 1f;
    	} else 
        {
        	c = (w - (r / 255.0f)) / w;
        	m = (w - (g / 255.0f)) / w;
        	y = (w - (b / 255.0f)) / w;
        	k = 1f - w;
    	}
    	System.out.println(""
            	+ "C: " + c +"\n"
            	+ "M: " + m +"\n"
            	+ "Y: " + y +"\n"
            	+ "K: " + k);
    }
}
