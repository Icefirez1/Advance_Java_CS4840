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
    
    public AList() //Tested and done
    {
        entries = new Object[10]; 
        size = 0;
        capacity_list = 10; 
    }
    public AList(int capacity)
    {
        entries = new Object[capacity]; 
        size = 0;
        capacity_list = capacity;
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
    public boolean add(int index, T item)
    {
        entries[index] = item; 
        return true;
    }
    /**
    *  This returns a -1 if <code>quarry</code> is not found or the index of
    *  the fist instance of <code>quarry</code> otherwise.
    *  @param quarry object to be added to this list
    *  @return -1 if <code>quarry</code> is not found or the index where
    *  the first instance of <code>quarry</code> is located.
    */
    public int indexOf(T quarry) //Done:not_tested
    {
        for (int index = 0; index < entries.length; index++)
        {
            if(entries[index] == quarry)
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
    public boolean remove(T quarry)
    {
        for (int i = 0; i < capacity_list; i++)
        {
            if(entries[i] == quarry)
            {
                entries[i] = null; 
                return true;
            }
        }
        return false;
    }
    /**
    *  This removes the object found at index <code>index</code>
    *  @param quarry object to be removed to this list
    *  @return <code>false</code> if <code>quarry</code> is not found 
    *  or the index where
    *  the first instance of <code>quarry</code> is located.
    *  @throws IndexOutOfBoundsException if an out-of-bounds index is passed
    */
    public T remove(int index)
    {
        entries[index] = null;
        return (T) entries[index];
    }
    /**
    *  This removes all objects equal to <code>quarry</code> from this list.
    *  @param quarry object to be extirpated from  this list
    *  @return <code>false</code> if <code>quarry</code> is not found 
    */
    public boolean extirpate(T quarry)
    {
        int j = 0;
        for(int i = 0; i < capacity_list; i++)
        {
            if(entries[i] == quarry)
            {
                entries[i] = null;
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
    public void clear()
    {
        for(int index = 0; index < capacity_list; index++)
        {
            entries[index] = null;
        }
    }
    /**
    *  This computes the size of the list
    *  @return the number of elements in this list
    */
    public int size() //Done:Not_tested
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
    public void set(int index, T newItem)
    {
        entries[index] = newItem;
    }
    /**
    *   This fetches the object at index <code>index</code>.
    *   @param index the index from which we wish to retrieve an element.
    *   @return the element at <code>index</code> in this list.
    *   @throws IndexOutOfBOundException if the <code>index</code> is out of bounds.
    */
    public T get(int index) //Done:not_tested
    {
        return (T) entries[index];
    }
    /**
    *   This checks for the presence of <code>quarry</code> in this list.
    *   @param quarry the item we are searching for in this list
    *   @return <code>true</code> if <code>quarry</code> is found in this list 
    */
    public boolean contains(T quarry)
    {
        
        for (int index = 0; index < entries.length; index++)
        {
            if(entries[index] == quarry)
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
    public Iterator<T> iterator()
    {
        return null;
    }
    public String toString()
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
        AList<String> uhm = new AList<>(1);
        System.out.println(uhm.add("yuh"));
        System.out.println(uhm);

    }
}