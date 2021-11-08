package arraylist;

public class ArrayList implements List {

    protected Object[] arr;
    protected int start, end;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        arr = new Object[DEFAULT_CAPACITY];
        start = end = DEFAULT_CAPACITY / 2;
    }

    @Override
    public void insertAtFront(Object ob) {
        resize(start - 1);
        start = (start - 1);
        arr[start] = ob;
    }

    @Override
    public void insertAtBack(Object ob) {
        resize(end + 1);
        arr[end] = ob;
        end = (end + 1);
    }

    @Override
    public Object removeFromFront() {
        Object ob = null;
        try {
            ob = arr[start];
            arr[start] = null;
            start = (start + 1);
            return ob;
        } catch ( Exception emptyListException ) {
           emptyListException.printStackTrace();
           if (isEmpty()) 
            return null;
        }
        return ob;
    }

    @Override
    public Object removeFromBack() {
        end = (end - 1);
        Object ob = null;
        try {
            ob = arr[end];
            arr[end] = null;
        } catch ( Exception emptyListException ) {
            emptyListException.printStackTrace();
            if (isEmpty()) 
             return null;
         }
         return ob;
    }

    @Override
    public boolean isEmpty() {
        return start == end;
    }

    @Override
    public void makeEmpty() {
        start = end = arr.length / 2;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;
        }
        System.out.println("List empty successfully");
    }

    //--------- Fora da interface.
    
    public int size() {
        return (end - start);
    }

    private void resize(int pos) {

        if (pos < 0 || pos >= arr.length) {
            int oldlen = end - start;    //> old list size
            int oldsize = arr.length;  //> old array size

            // New array
            Object[] narr = new Object[2 * oldsize];

            // Copy the old vector starting from oldsize/2
            System.arraycopy(arr, start, narr, oldsize / 2, oldlen);

            // New start and end
            start = oldsize / 2;
            end = start + oldlen;
            arr = narr;
        }
    }

    public Object get(int n) {
        int siz = size();
        if (n >= siz) {
            return null;
        }
        if (n >= 0) {
            return arr[(start + n)];
        }
        return null;
    }

    public void set(int n, Object ob) {
        if (n >= start && n < end) {
            int idx = (start + n);
            arr[idx] = ob;
        }
    }

    public void print() {
        if(isEmpty())
            System.out.println("List is Empty");
        for (int i = start; i < end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
