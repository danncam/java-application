package ArrayList;

/**
 *
 * @author dan
 */
public interface List {
    /**
     * Insert an object at the first index of list
     */
    public void insertAtFront(Object insertItem);
    /**
     * Insert an object at the last index of list
     */
    public void insertAtBack(Object insertItem);
    /**
     * Remove the first object
     */
    public Object removeFromFront();
    /**
     * Remove the last object
     */
    public Object removeFromBack();
    /**
     * Return the length
     */
    public int size();
    /**
     * Return the object allocated in the index
     */
    public Object get(int index);
    /**
     * Modify the object allocated in the index
     */
    public void set(int index, Object obj);
    
    /**
     * Test if the list is logically empty
     */
    public void makeEmpty();
    /**
     *  Make the list logically empty
     */
    public boolean isEmpty();
    
    
    
}
