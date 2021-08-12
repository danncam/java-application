package Arrays;

/**
 *
 * @author dan
 */
public class Set {

    int nElem;
    int[] data = new int[100];

    public Set() {
        nElem = 0;
    }

    boolean empty() {
        return (nElem == 0);
    }

    boolean full() {
        return (nElem == 100);
    }

    boolean belongsTo(int e) {
        for (int i = 0; i < nElem; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    void insElem(int e) {
        for (int i = 0; i < nElem; i++) {
            if (!full() && !belongsTo(e)) {
                data[nElem] = e;
                nElem++;
            }
        }

    }
//    void insElem(int e) {
//        int i, j;
//        int newE;
//        
//        for (i = 1; i < nElem; i++) {
//            newE = data[i];
//            j = i;
//            while(j > 0 && data[j - 1] > newE){
//                data[j] = data[j - 1];
//                j--;
//            }
//            data[j] = e;
//        }

    void remElem(int e) {
        for (int i = 0; i < nElem; i++) {
            if (!empty() && belongsTo(e)) {
                data[i] = data[nElem - 1];
                nElem--;
            }
        }
    }

    Set union(Set conj1, Set conj2) {
        Set conj = new Set();
        for (int i = 0; i < nElem; i++) {
            conj.insElem(conj1.data[i]);
        }
        for (int i = 0; i < nElem; i++) {
            conj.insElem(conj2.data[i]);

        }
        return conj;
    }
}
