package arraylist;
public class Queue {
    ArrayList queue;
    
    public void enqueue(Object ob)
    {
        queue.insertAtBack(ob);
    }
    public Object dequeue()
    {
        return queue.removeFromFront();
    }
    public Object getFront()
    {
        return queue.get(queue.size() - 1);
    }
    public boolean isEmpty()
    {
        return queue.isEmpty();
    }
    public void makeEmpty()
    {
        queue.makeEmpty();
    }
}
