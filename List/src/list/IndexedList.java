package list;

/**
 *
 * Indexed Lists are type of array lists that index acts directly on element
 */
public class IndexedList<E> implements List<E> {
    private 
    Object[] array;
    int size; /* number of valid elements */
    boolean sorted;
    public IndexedList() {
        array = new Object[2];
        size = 0;
        
    }
    public IndexedList(String[] array){
        try {
            this.array = new Object[array.length + 1];
                for (int i = 0; i < array.length; i++) {
                    sorted = i > 0 && array[i - 1].compareTo(array[i]) <= 1 ? true : false;
                    this.array[i] = (Object) array[i];
                }
        } catch (ArrayStoreException ex) {
            System.out.println("Can`t store the wrong type of object into an array of objects.");
        }
    }
    
    /**
     * This method add an element to list, a positive integer position is needed to index.
     * If you add an element on an occupied index, it realocates all elements to the right from the position given
     * Alocate an element in a index position that is out of physic array creating a new array
     * 
     */
    @Override
    public void add(E elem, int index) {
        try{
            /* Can add just if the index is less or equal to the capacity of array, and that position is not occupied */
            if(index < array.length - 1 && array[index] == null)
            {
                array[index] = elem;
                size++;
                sorted = false;
                System.out.println(elem.toString() + " added successfully");
            } else {
                if(index >= array.length - 1) {
                /* But if necessary, resize the array */
                    array = resize(index + 2 - array.length);
                    array[index] = elem;
                    size++;
                    sorted = false;
                    System.out.println(elem.toString() + " added successfully, but the array has been increased to " + array.length);
                    return;
                }
//              /* And if is occupied, realocate all elements from it to right */
                if(array[index] != null)
                {
                    array = realocate(index, 1);
                    array[index] = elem;
                    size++;
                    sorted = false;
                    System.out.println(elem.toString() + " added successfully and all elements after " + elem + " have been realocated to the right");
                }
            }
            
        } catch (ArrayIndexOutOfBoundsException ex)    {
            System.out.println("Can`t insert " + elem.toString() + " in this index");
        } catch (NullPointerException ex) {
            
        }
    }

    @Override
    public E remove(int index) {
        try{
            /* Can remove just if there's elements on it and the index is valid */
            if(!isEmpty() && array[index] != null)
            {
                Object removed = array[index];
                
                /* After remove, all elements walk one index to front */
                array = realocate(index, -1);
                size--;
                sorted = false;
                System.out.print(index + " removed successfully");
                /* And if necessary, resize the array */
                if(index == array.length - 1)
                {
                    int nullindexes = 0;
                    for (int i = array.length - 2; i > 0; i--)
                    {
                        if(array[i] == null)
                        {
                            nullindexes++;
                        } else {
                            break;
                        }
                    }
                    
                    array = resize(-nullindexes);
                    System.out.println(", but the array has been reduced to " + array.length);
                }
                System.out.println("");
                return (E) removed;
                
            }
        } catch (ArrayIndexOutOfBoundsException ex)    {
            System.out.println("Can`t remove element from index " + index);
        }
        System.out.println(index + " is null");
        return null;
    }

    @Override
    public E get(int index) {
        try {
            /* Can just get an element if there's elements on it or the index is valid */
            if(!isEmpty() && array[index] != null)
            {
                return (E) array[index];
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Can`t get element of the index " + index);
        }
        return null;
    }
    
    @Override
    public void set(E elem, int index){
        try {
            /* Can just set an element if there's elements on it or the index is valid */
            if(!isEmpty() && array[index] != null)
            {
                array[index] = elem;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Can`t set element of the index " + index);
        }
    }

    @Override
    public int indexOf(E elem) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public IndexedList<E> combine(IndexedList<E> l)
    {
        try {
            IndexedList<E> newlist = new IndexedList();
            int j = 0;
            for (int i = 0; i < this.array.length + l.array.length; i++) {
                
            }
            Object[] newarray = new Object[this.array.length + l.array.length + 1];
            
            System.arraycopy(array, 0, newarray, 0, array.length - 1);
            System.arraycopy(l.array, 0, newarray, array.length, l.array.length);
            newlist.array = newarray;
            for (int i = 0; i < newarray.length; i++) {
                if(newarray[i] != null) {
                    newlist.size++;
                }
                
            }
            return newlist;
            
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Array index not found");
        }
        return null;
    }
    
    public IndexedList<E> sublist(int firstindex, int lastindex)
    {
        IndexedList<E> newlist = new IndexedList();
        try {
            for (int i = firstindex; i < lastindex; i++) {
                newlist.add(this.get(i), i);

            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("");
        }
        return newlist;
        
    }
    
    public void sort()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public int search(E e)
    {
        try {
            
            for (int i = 0; i < array.length; i++)
            {
                if(array[i].equals(e))
                {
                    System.out.println("This element is on index " + i);
                    return i;
                }
            }
        } catch (NullPointerException ex) {
            System.out.println("Can`t find any element equals " + e + " in this list");
        }
        System.out.println("Not found");
        return -1;
        
    }

    /* Check if the list is empty is check if there's valid elements on array */       
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private Object[] resize(int offset)
    {
        
        try {
            Object[] newarray = new Object[array.length + offset];
            int length = offset > 0 ? array.length : newarray.length;
            System.arraycopy(array, 0, newarray, 0, length);
            return newarray;
        } catch (ArrayIndexOutOfBoundsException | ArrayStoreException | NullPointerException ex){
            System.out.println("\n" +
            "IndexOutOfBoundsException - if copying would cause access of data outside array bounds.\n" +
            "ArrayStoreException - if an element in the src array could not be stored into the dest array because of a type mismatch.\n" +
            "NullPointerException - if either src or dest is null.");
        }
        return null;
    }
    
    private Object[] realocate(int index, int offset)
    {
        if(offset > 0)
        {
            
            Object[] newarray = new Object[array.length + offset];
            System.arraycopy(array, 0, newarray, 0, index);
            System.arraycopy(array, index, newarray, index + offset, array.length - index);
            return newarray;
        } else {
            Object[] newarray = new Object[array.length + offset];
            System.arraycopy(array, 0, newarray, 0, index);
            System.arraycopy(array, index - offset, newarray, index - offset - 1, array.length - index - 1);
            return newarray;
        }
    }

    @Override
    public String toString() {
        String elements = " ";
        for (int i = 0; i < array.length; i++) {
            if(array[i] != null){
                elements += array[i].toString() + " ";
            }
            else {
                elements += "";
            }
        }
        return "LinearList{" + elements + "}\nCapacity: " + (array.length - size) + "\nSize: " + size;
    }
    public void printAll(){
        System.out.print("PrintAll{ ");
        for (Object object : array) {
            if(object != null){
                System.out.print(object.toString() + " ");
            } else {
                System.out.print("N ");
            }
            
        }
    }
    

    
}
