package arraylist;
public class Stack {
    ArrayList stack;
    
    public void push(Object ob)
    {
        stack.insertAtBack(ob);
    }
    public Object pop()
    {
        return stack.removeFromBack();
    }
    public Object top()
    {
        return stack.get(stack.size() - 1);
    }
    public boolean isEmpty()
    {
        return stack.isEmpty();
    }
    public void makeEmpty()
    {
        stack.makeEmpty();
    }
}
