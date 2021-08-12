package LinearList;

/**
 *
 * @author Dan
 */
public class List {
    private int size;
    private Element[] list;
    private Element[] old;
    public List(){
        size = 0;
        list = new Element[1];
    }
    public void insert(int key, String value)
    {   
        
        size++;
    }
    public void insertAtEnd()
    public void delete(int key)
    {
        size--;
    }
    public String get(int key)
    {
        if(isInside(key))
        {
            return list[key].getValue();
        } else {
            System.out.println("Índice fora da lista");
            return null;
        }
    }
    public void set(int key, String value)
    {
        if(isInside(key))
        {
            list[key].setValue(value);
        } else {
            System.out.println("Índice fora da lista");
        }
        
    }
    public int search(String value)
    {
        
    }
    @Override
    public String toString(){
        String output = "";
        for (int i = 0; i < size; i++) {
            output += list[i].getValue() + "\t";
            
        }
        return output;
    }
    private List[] realocate(int key)
    {
        if(key >= list.length || (this.size == this.list.length))
        {
            /*backup*/
            System.arraycopy(old, 0, list, 0, size);
            list = new Element[size+1];
            System.arraycopy(old, 0, list, 0, size + 1);
        }
    }
    public void sort()
    {
        
    }
    private boolean isInside(int key)
    {
        return (key > 0 && key <= size);
    }
}
