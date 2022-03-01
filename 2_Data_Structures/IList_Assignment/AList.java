import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional; 
public class AList<T> implements IList<T>, Iterable<T>
{
    private Object[] entries;
    private int size; 
    private int capacity_list;
    // I guess when you initialize a list itll make one thats 10 objects big
    
    public AList() //Tested
    {
        this.entries = new Object[10]; 
        this.size = 0;
        this.capacity_list = 10; 
    }
    public AList(int capacity) // Tested
    {
        this.entries = new Object[capacity]; 
        this.size = 0;
        this.capacity_list = capacity;
    }
    /**
    *  appends <code>item</code> to this list
    *  @param item object to be added to this list
    *  @return true if <code>item</code> is added to this list
    */
    public boolean add(T item) // Done and tested
    {
        for (int i = 0; i < capacity_list; i++)
        {
            if(entries[i] == null)
            {
                entries[i] = item;
                size ++; 
                return true;
            }
        }
        superSizeMe();
        if (entries[size] == null)
        {
            entries[size] = item;
            size ++; 
            return true;
        }
        return false; 
    }
    private static int newLength(int n) 
    {
        return n < 1000? 2*n : 3*n/2;
    }
    public void superSizeMe()
    {
        capacity_list = newLength(capacity_list);
        entries = Arrays.copyOf(entries, capacity_list);
    }
    /**
    *  appends <code>item</code> to this list
    *  @param index The object <code>item</code> is inserted at <code>index</code>.
    *  @param item object to be added to this list
    *  @return true if <code>item</code> is added to this list
    */
    public boolean add(int index, T item) // Tested and done
    {
        entries[index] = item; 
        return true;
    }
    /**
    *  This returns a -1 if <code>quarry</code> is not found or the index of
    *  the fist instance of <code>quarry</code> otherwise.
    *  @return -1 if <code>quarry</code> is not found or the index where
    *  the first instance of <code>quarry</code> is located.
    */
    public int indexOf(T quarry) //Done works
    {
        for (int index = 0; index < size; index++) // does not work
        {
            if(entries[index].equals(quarry))
            {
                return index; 
            }
        }
        return -1;
    }
    /**
    *  This removes the first instance of <code>quarry</code> from this
    *  list; if no instance is found, it returns <code>false</code>.
    *  @param quarry object to be removed to this list
    *  @return <code>false</code> if <code>quarry</code> is not found 
    *  or the index where
    *  the first instance of <code>quarry</code> is located.
    */
    public boolean remove(T quarry) // works
    {
        for (int i = 0; i < capacity_list; i++)
        {
            if(entries[i].equals(quarry))
            {
                shifter(i);
                size --;
                return true;
            }
        }
        return false;
    }
    public void shifter(int index)
    {
        for(int j = index; j < capacity_list - 1; j++)
                {
                    entries[j] = entries[j+1];
                } 
    }
    /**
    *  This removes the object found at index <code>index</code>
    *  @param quarry object to be removed to this list
    *  @return <code>false</code> if <code>quarry</code> is not found 
    *  or the index where
    *  the first instance of <code>quarry</code> is located.
    *  @throws IndexOutOfBoundsException if an out-of-bounds index is passed
    */
    @SuppressWarnings("unchecked")
    public T remove(int index) //works
    {  
        Object output = entries[index];
        try
        {
            if(!entries[index].equals(null))
                    {
                        shifter(index);
                        size --; 
                    }
        }
        catch(IndexOutOfBoundsException yuh)
        {
            System.err.println("dumbass its out of the list");
        }
        return (T) output;
    }
    /**
    *  This removes all objects equal to <code>quarry</code> from this list.
    *  @param quarry object to be extirpated from  this list
    *  @return <code>false</code> if <code>quarry</code> is not found 
    */
    public boolean extirpate(T quarry) //doesn't worked
    {
        int j = 0;
        for(int i = 0; i < capacity_list; i++)
        {
            if(entries[i].equals(quarry))
            {
                shifter(i);
                size --; 
                j++;
            }
        }
        if(j == 0)
        {
            return false;
        }
        return true;
        
    }
    /**
    *  This removes all elements from this list.
    */
    public void clear() // works 
    {
        for(int index = 0; index < capacity_list; index++)
        {
            entries[index] = null;
        }
        size = 0; 
    }
    /**
    *  This computes the size of the list
    *  @return the number of elements in this list
    */
    public int size() //Done + tested 
    {
        return size;
    }
    /**
    *   This replaces the object at index <code>index</code> with <code>newItem</code>.
    *   @param index the index at which we are performing the replacement
    *   @param newItem the new item we are placing into the list
    *   @return the item being replaced [the evictee]
    *   @throws IndexOutOfBOundException if the <code>index</code> is out of bounds.
    */
    public void set(int index, T newItem) // works
    {
        try
        {
            entries[index] = newItem;
        }
        catch(IndexOutOfBoundsException yuh)
        {
            System.err.println("dumbass its out of the list");
        }

    }
    /**
    *   This fetches the object at index <code>index</code>.
    *   @param index the index from which we wish to retrieve an element.
    *   @return the element at <code>index</code> in this list.
    *   @throws IndexOutOfBOundException if the <code>index</code> is out of bounds.
    */
    @SuppressWarnings("unchecked")
    public T get(int index) //Done: tested and works
    {
        try
        {
            return (T) entries[index];
        }
        catch(IndexOutOfBoundsException yuh)
        {
            System.err.println("dumbass its out of the list");
        }
        return (T) entries[index];
    }
    /**
    *   This checks for the presence of <code>quarry</code> in this list.
    *   @param quarry the item we are searching for in this list
    *   @return <code>true</code> if <code>quarry</code> is found in this list 
    */
    public boolean contains(T quarry) // workin
    {
        
        for (int index = 0; index < entries.length; index++)
        {
            if(entries[index].equals(quarry))
            {
                return true; 
            }
        }
        return false;
    }
    /**
     * This creates an iterator that walks through this list in index order.
     * @return iterator for this list.
     */
    class ListIterator implements Iterator<T>
        {
            private int loc;
            public ListIterator()
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
                T out = (T)entries[loc];
                loc++;
                return out;
            }
        }
    public Iterator<T> iterator() // I don't know
    {
        return new ListIterator();
    }
    
    public String toString() // Done and tested
    {
        StringBuffer sb = new StringBuffer();
        if (size == 0)
        {
            return "[]";
        }
        sb.append("[");
        for(int k = 0; k < size - 1; k++)
        {
            if (entries[k] != null)
            {
              sb.append(String.format("%s, ", entries[k]));  
            }
        }
        sb.append(String.format("%s]", entries[size - 1]));
        return sb.toString();
    }
    public static void main(String[] args)
    {
        AList<String> uhm = new AList<>();
        uhm.add("yuh");
        int n = Integer.parseInt(args[0]);
        for (int i = 0; i < n; i++)
        {
            String add = Integer.toString(i);
            uhm.add(add);
            
        }
        System.out.println(uhm);

        uhm.add(0, "el o el");
        System.out.println(uhm);

        uhm.set(1, "girlboss");
        System.out.println(uhm);

        uhm.clear();
        System.out.println(uhm);

        // System.out.println(uhm.get(1));
        // System.out.println(uhm.indexOf("yuh"));

        // System.out.println(uhm.remove("yuh"));        
        // System.out.println(uhm.remove(5));
        // System.out.println(uhm);

        // System.out.println(uhm.contains("yuh"));


        
    }
}