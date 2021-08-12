package ArrayList;

/**
 *
 * @author dan
 */
public class ArrayList implements List{

    protected Object[] arr;
    protected int start, end;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        arr = new Object[DEFAULT_CAPACITY];
        start = end = DEFAULT_CAPACITY/2;
    }
    
    @Override
    public void insertAtFront(Object insertItem) {
        if(start == 0)
            resize(arr.length * 2);
        arr[start] = insertItem;
        start--;
    }

    @Override
    public void insertAtBack(Object insertItem) {
        if(end == arr.length - 1)
            resize(arr.length * 2);
        arr[end] = insertItem;
        end++;
    }

    @Override
    public Object removeFromFront() {
        if(isEmpty())
            return null;
        else
        {
        
        return arr[start++];
        }
    }

    @Override
    public Object removeFromBack() {
        if(isEmpty())
            return null;
        else
        {
        return arr[end--];
        }
    }

    public void CompleteCleaning()
    {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;
            
        }
    }

    @Override
    public void makeEmpty() {
        start = end = arr.length/2;
    }

    @Override
    public boolean isEmpty() {
        return (start == end) && (start == DEFAULT_CAPACITY/2);
    }
    
    @Override
    public int size()
    {
        return end - start;
    }
    private void resize(int pos) throws ArrayIndexOutOfBoundsException
    {
        if(pos < 0 || pos >= arr.length)
        {
            Object[] temp = new Object[arr.length * 2];
            for (int i = start/2; i < end/2; i++) {
                temp[i] = arr[i];

            }
            arr = temp;
        }
        
    }
    @Override
    public Object get(int index)
    {
        return arr[index];
    }
    @Override
    public void set(int index, Object obj)
    {
        index = start + index;
        arr[index] = obj;
    }
    public void print()
    {
        for (int i = start; i < end; i++) {
            System.out.println(arr[i].toString() + "\t");
            
        }
    }
    
}
