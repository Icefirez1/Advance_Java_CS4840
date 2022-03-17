

// Making stacks with a linked list 
// This is my first time working with stuff like this so thats interesting

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Iterator;
public class LStack<T> implements IStack<T>, Iterable<T>
{
    private Node<T> top;
    private int size;
    public LStack()
    {
        top = null;
        size = 0;
    }
    public boolean isEmpty()
    {
        return top == null;
    }
    public void push(T newItem)
    {
        top = new Node<T>(newItem, top);
        size++;
    }
    public T pop()
    {
        if(isEmpty())
        {   
            throw new EmptyStackException();
        }
        T out = top.getDatum();
        top = top.getNext();
        size--;
        return out;
    }
    public T peek()
    {
        return top.getDatum();
    }
    public int size()
    {
        return size;
    }
    @Override
    public String toString()
    {
        if(isEmpty())
        {
            return "[]";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        Node<T> nav = top;
        for(int k = 0; k < size - 1; k++, nav = nav.getNext())
        {
            sb.append(String.format("%s, ", nav.getDatum()));
        }
        sb.append(String.format("%s]", nav.getDatum()));
        return sb.toString();

    }
    public Iterator<T> iterator()
    {
        return new StackIterator();
    }
    class StackIterator implements Iterator<T>
    {
        public Node<T> nav;
        public StackIterator()
        {
            nav = top;
        }
        public boolean hasNext()
        {
            return nav != null;
        }
        public T next()
        {
            T out = nav.getDatum();
            nav = nav.getNext();
            return out;
        }
    }
    public static void main(String[] args)
    {
        LStack<String> s = new LStack<>();
        s.push("cows");
        s.push("sheep");
        for(int k = 0; k < 10; k++)
        {
            s.push("" + k);
        }
        for(String k:s)
        {
            System.out.println(k);
        }
        /*while(!s.isEmpty())
        {
            s.pop();
        }*/
        System.out.println(s);
    }
}
class Node<T>
{
    private final T datum;
    private Node<T> next;
    public Node(T datum, Node<T> next)
    {
        this.datum = datum;
        this.next = next;
    }
    public T getDatum()
    {
        return datum;
    }
    public Node<T> getNext()
    {
        return next;
    }
}