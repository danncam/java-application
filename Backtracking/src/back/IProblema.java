/**
 *
 * @author marcoslage
 */
package back;

public interface IProblema {

    public void gravaCandidato(int k, ICandidato obj);

    public void apagaCandidato(int k, ICandidato obj);
    
    public boolean testaCandidato(ICandidato obj);
    
    public void imprimeProblema();
    
}
