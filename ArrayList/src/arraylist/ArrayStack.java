package arraylist;

public class ArrayStack { 

    private Object[] arrs;
    private int last; //index to enter
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayStack() {
        arrs = new Object[DEFAULT_CAPACITY];
        last = 0;
    }
    
    public void push (Object ob) {
        try {
            arrs[last] = ob;
        } catch (ArrayIndexOutOfBoundsException e) {
            resize();
            arrs[last] = ob;
        } finally {
            if(!isOutOfBounds())
                last++;
        }
    }

    public Object pop() {
        Object ob = null;
        try {
            ob = arrs[last];
            arrs[last] = null;
        } catch ( ArrayIndexOutOfBoundsException e ) {
            last = 0;
            return null;
        } finally {
            if( !isOutOfBounds() )
                last--;
            else last = 0;
        }
        return ob;
    }

    public boolean isEmpty(){
        return last == 0;
    }

    public void resize(){
        if(isOutOfBounds()) {
            Object[] narrs = new Object[arrs.length * 2];
            System.arraycopy(arrs, 0, narrs, 0, arrs.length);
            arrs = narrs;
            last = 0;
        }
    }

    public void print(){

    }

    private boolean isOutOfBounds() {
        return last >= arrs.length || last < 0;
    }

    public void printDebugger() {
        System.out.println("Printing debugger");
        for (int i = 0; i < arrs.length; i++) {
            System.out.print(arrs[i] + " ");
        }
        System.out.println("\nLast-> " + (isOutOfBounds()?last +" OutOfBounds":last) + "\nTotal-> " + arrs.length);
    }
}
