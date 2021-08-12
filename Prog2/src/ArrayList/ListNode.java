package ArrayList;
public class ListNode {
    Object data;
    ListNode nextNode;
    /*
     * Constructor creates a ListNode that refers to object
     */
    public ListNode(Object data) {
        this.data = data;
        nextNode = null;
    }
    /*
     * Constructor creates a ListNode that refers to objects and to next ListNode
     */
    public ListNode(Object data, ListNode nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }
    /*
     * return reference to data in node
     */
    public Object getData() {
        return data;
    }
    /*
     * return reference to next node in list
     */
    public ListNode getNext() {
        return nextNode;
    }
    public void setNext(ListNode n)
    {
        n.nextNode = nextNode;
        nextNode = n;
    }
    
    
    
}
