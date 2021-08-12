package kapman;

import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class Set extends ArrayList<Snake> {
private Snake snk;
    Set(){
        snk = new Snake(Conf.length);
        this.add(snk);
        
        
    }
    public boolean divide(){

        return false;
    }
    
}
