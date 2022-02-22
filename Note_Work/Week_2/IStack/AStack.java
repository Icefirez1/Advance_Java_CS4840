import java.util.EmptyStackException;
import java.util.Arrays;
import java.util.Iterator;
//package Note_Work.Week_2.IStack;
// stacks made up of arrays
public class AStack<T> implements IStack<T>, Iterable<T>
{
    private Object[] items;
    private int size;
    private int capacity;

    public AStack(int capacity)
    {
        this.capacity = capacity;
        items = new Object[capacity];
        size = 0;
    } 
    public AStack()
    {
        this(10);
    }
    public void push(T newItem)
    {
        if(size >= capacity)
        {
            superSizeMe();
        }
        items[size] = newItem;
        size++;
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
    @SuppressWarnings("unchecked")
    public T pop()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        T out = (T) items[size - 1];
        size--;
        return out;
    }
    @SuppressWarnings("unchecked")
    public T peek()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        T out = (T) items[size - 1];
        return out;
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
        for(int k = 0; k < size - 1; k++)
        {
            sb.append(String.format("%s, ", items[k]));
        }
        sb.append(String.format("%s]", items[size - 1]));
        return sb.toString();
    }
    public Iterator<T> iterator()
    {
        return new StackIterator();
    }
    class StackIterator implements Iterator<T>
    {
        private int loc;
        public StackIterator()
        {
            loc = 0;
        }
        public boolean hasNext()
        {
            return loc < size;
        }
        @SuppressWarnings("unchecked")
        public T next()
        {
            T out = (T)items[loc];
            loc++;
            return out;
        }

    }
    //poopsmith
    private static int newLength(int n)
    {
        return n < 1000? 2*n : 3*n/2;
    }
    private void superSizeMe()
    {
        capacity = newLength(items.length);
        items = Arrays.copyOf(items, capacity);
    }
    public static void main(String[] args)
    {
        AStack<String> s = new AStack<>();
        s.push("cows");
        s.push("sheep");
        for(int k = 0; k < 10; k++)
        {
            s.push("" + k);
        }
        /*while(!s.isEmpty())
        {
            s.pop();
        }*/
        for(String k : s)
        {
            System.out.println(k);
        }
        System.out.println(s);
    }
}