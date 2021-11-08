package arraylist;

public class ArrayQueue {
    
private Object[] arrq;
private int front; //index to remove
private int back; //index to insert
private static final int DEFAULT_CAPACITY = 10;

    public ArrayQueue() {
        arrq = new Object[DEFAULT_CAPACITY];
        front = back = 0;
    }
    
    public void enqueue(Object ob) {
        try {
            arrq[back] = ob;
            back++;
        } catch (ArrayIndexOutOfBoundsException e) {
            resize();
            enqueue(ob);
        }
    }

    public Object dequeue() {
        Object ob = arrq[front];
        front++;
        return ob;
    }

    public Object getFront() {
        return arrq[front];
    }

    public int length(){
        return Math.abs(back - front);
    }

    public void resize() {
        if(isOutOfBounds()) {
            Object[] narrq = new Object[arrq.length * 2];
            System.arraycopy(arrq, front, narrq, 0, length());
            arrq = narrq;
            back = length();
            front = 0;
        }
    }

    public boolean isEmpty() {
        return front == back;
    }

    private boolean isOutOfBounds() {
        return back >= arrq.length;
    }

    public void makeEmpty() {
        for (int i = 0; i < arrq.length; i++) {
            arrq[i] = null;
            
        }
        back = 0;
        System.out.println("Queue empty successfully");
    }
    
    public void print() {
        if(isEmpty())
            System.out.println("Queue is Empty");
        for (int i = front; i < back; i++) {
            System.out.print(arrq[i] + " ");
        }
        System.out.println("");
    }

    public void printDebugger() {
        System.out.println("Printing debugger");
        for (int i = 0; i < arrq.length; i++) {
            System.out.print(arrq[i] + " ");
        }
        System.out.println("\nFront-> " + front + "\nBack-> " + (isOutOfBounds()?back +" OutOfBounds":back) + "\nQuantity-> " + length() +"\nTotal-> " + arrq.length);
    }
}
