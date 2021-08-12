package list;

/**
 *
 * @author Dan
 */
public class SimpleLinkedList {
    private Node first;
    private Node actual;
    private int length;
    
    public SimpleLinkedList()
    {
        actual = new Node();
        first = actual;
        length = 0;
    }
    
    public void insertAtBegin(float value)
    {
        Node newfirst = new Node();
        newfirst.value = value;
        newfirst.next = actual;
        first = newfirst;
        length = length + 1;
    }
    public void removeAtBegin()
    {
        if(length > 0)
        {
            
        }
    }
    public boolean search(float value)
    {
        actual = first;
        while(actual != null)
        {
            if(actual.value == value)
            {
                return true;
            } 
            actual = actual.next;
        }
        return false;
    }
}
