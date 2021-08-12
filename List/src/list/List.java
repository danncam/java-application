package list;

/**
 *
 * @author Dan
 */
interface List<E> {
    
    /**
     * Add a given element so that new element has a specified index. 
     */
    public void add(E elem, int index);
    
    /**
     * Removes element with a given index and returns it.
     */
    public E remove(int index);

    /**
     * Returns true if the List is empty, false other wise.
     */
    public boolean isEmpty();
    
    /**
     * Give the number of element in the list.
     */
    public int size();
    
    /**
     * Give the element with the given index.
     */
    public E get(int index);
    
    /**
     * Set the element.
     */
    public void set(E elem, int index);
    
    /**
     * Determines the index of the given element.
     */
    public int indexOf(E elem);

    /**
     * Returns a string of all valid elements.
     */

    @Override
    public String toString();
}
