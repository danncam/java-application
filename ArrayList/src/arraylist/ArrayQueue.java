package arraylist;

public class ArrayQueue {
    
private Object[] arrayqueue;
private int front;
private int back;
private static final int DEFAULT_CAPACITY = 10;

    public ArrayQueue() {
        arrayqueue = new Object[DEFAULT_CAPACITY];
        front = 0;
        back = front + 1;
    }
    public boolean isEmpty()
    {
        return front == back;
    }
    public void makeEmpty()
    {
        for (int i = 0; i < arrayqueue.length; i++) {
            arrayqueue[i] = null;
            
        }
        back = 0;
    }
    public void enqueue(Object ob)
    {
        resize();
        arrayqueue[back] = ob;
        back++;
        
    }
    public Object dequeue()
    {
        Object ob = arrayqueue[front];
        front++;
        return ob;
    }
    public Object getFront()
    {
        return arrayqueue[front];
    }
    public void resize()
    {
        if(back == DEFAULT_CAPACITY)
        {
            Object[] newarray = new Object[arrayqueue.length * 2];
            for (int i = front; i <= back; i++) {
                newarray[i] = arrayqueue[front++];
                
            }
            front = 0;
            arrayqueue = newarray;
        }
        
    }
}
