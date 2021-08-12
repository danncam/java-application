/**
 *
 * @author marcoslage
 */
package back.oitorainhas;

import back.Backtracking;
import back.ICandidato;
import back.Posicao;

public class OitoRainhas extends Backtracking {

    int nRainhas = 8;
    
    public OitoRainhas(int j) {
        
        a = new TabuleiroRainhas(7,j);
        terminou = false;
    }

    @Override
    public boolean ehSolucao(int k) {
        if(k+2 == nRainhas) return true;
        return false;
    }

    @Override
    public ICandidato[] constroiCandidatos(int k) {
                
        Posicao[] aux = new Posicao[8];        
        TabuleiroRainhas tab = (TabuleiroRainhas)a;
        
        int nCandidatos = 0;
        for (int col = 0; col < 8; col++) {
            Posicao currPos = new Posicao( k,col );
            
            if( tab.testaCandidato( currPos ) ) {
                aux[col] = currPos;
                nCandidatos++;
            }
        }
        
        Posicao[] candidatos = new Posicao[nCandidatos];
        nCandidatos = 0;
        for (int col = 0; col < 8 ; col++) {
            if(aux[col]!= null) {
                candidatos[nCandidatos++] = aux[col];
                //System.out.print(aux[col].toString() +" ");
            }
        }
        //System.out.println("");
        
        return candidatos;
    }

    @Override
    public void processaSolucao(int k) {
        a.imprimeProblema();
    }
    
}
