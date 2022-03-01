import java.util.Iterator;
public class LList<T> implements IList<T>, Iterable<T>
{
    Link<T> head;
    private int size;
    public LList()
    {
        this.head = null;
        this.size = 0;
    }
    /**
    *  appends <code>item</code> to this list
    *  @param item object to be added to this list
    *  @return true if <code>item</code> is added to this list
    */
    public boolean add(T item) // done and tested
    {
        head = new Link<T>(item, head);
        size++;
        return true;
    }
    /**
    *  appends <code>item</code> to this list
    *  @param index The object <code>item</code> is inserted at <code>index</code>.
    *  @param item object to be added to this list
    *  @return true if <code>item</code> is added to this list
    */
    public boolean add(int index, T item) // done and tested
    { 
        int index_finding = size - index;
        Link<T> nav = head;
        for (int i = 0; i < size; i++, nav = nav.getNext())
        {
            if (i == index_finding - 1)
            {
                
                //nav = new Link<T>(nav.getDatum(), new Link<T>(item, nav.getNext()));
                nav.changeNext(new Link<T>(item, nav.getNext()));
                size ++;
                return true;
            }
        }
        return false;
    }
    /**
    *  This returns a -1 if <code>quarry</code> is not found or the index of
    *  the fist instance of <code>quarry</code> otherwise.
    *  @param quarry object to be added to this list
    *  @return -1 if <code>quarry</code> is not found or the index where
    *  the first instance of <code>quarry</code> is located.
    */
    public int indexOf(T quarry) // works and tested
    {
        Link<T> nav = head;
        for (int i = 0; i < size; i++, nav = nav.getNext())
        {
            if(nav.getDatum().equals(quarry))
            {
                return size - i - 1;
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
    public boolean remove(T quarry) // works and tested
    {
        Link<T> nav = head;
        for (int i = 0; i < size; i++, nav = nav.getNext())
        {
            if(nav.getNext().getDatum().equals(quarry))
            {  
                //System.out.println(nav.getNext().toString());
                nav.changeNext(nav.getNext().getNext());
                size--;
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
    public T remove(int index) // tested and works
    {
        try
        {
            Link<T> nav = head;
            for (int i = 0; i < size; i++, nav = nav.getNext())
            {
                if(size - i == index + 2)
                {
                    T yeeted = nav.getNext().getDatum();
                    nav.changeNext(nav.getNext().getNext());
                    size--;
                    return yeeted; 
                }
            }
        }
        catch(IndexOutOfBoundsException yuh)
        {
            System.err.println("dumbass its out of the list");
        }
        return null; 
    }
    /**
    *  This removes all objects equal to <code>quarry</code> from this list.
    *  @param quarry object to be extirpated from  this list
    *  @return <code>false</code> if <code>quarry</code> is not found 
    */
    public boolean extirpate(T quarry) // works and tested
    {
        // Link<T> nav = head;
        int how_many = 0; 
        // for (int i = 0; i < size - 1; i++, nav = nav.getNext())
        // {
        //     if(nav.getNext().getDatum().equals(quarry))
        //     {  
        //         nav.changeNext(nav.getNext().getNext());
        //         size--;
        //         how_many++;
        //     }
        // }
        while(contains(quarry))
        {
            remove(quarry); 
            how_many++;
        }
        if(how_many == 0)
        {
            return false; 
        }
        return true;
    }
    /**
    *  This removes all elements from this list.
    */
    public void clear() //tested and done
    {
        head = null; 
        size = 0; 
    }
    /**
    *  This computes the size of the list
    *  @return the number of elements in this list
    */
    public int size() //Done
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
    public void set(int index, T newItem) // tested and works
    {
        try
        {
            Link<T> nav = head;
            for (int i = 0; i < size; i++, nav = nav.getNext())
            {
                if(size - i == index)
                    {
                        nav.changeDatum(newItem);
                    }
            }  
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
    public T get(int index) // tested and works
    {
        try
        {
            Link<T> nav = head;
            for (int i = 0; i < size; i++, nav = nav.getNext()) 
            {
                if(size - i == index + 1)
                { 
                    return nav.getDatum(); 
                }
            }
        }
        catch(IndexOutOfBoundsException yuh)
        {
            System.err.println("dumbass its out of the list");
        }
        return null; 
    }
    /**
    *   This checks for the presence of <code>quarry</code> in this list.
    *   @param quarry the item we are searching for in this list
    *   @return <code>true</code> if <code>quarry</code> is found in this list 
    */
    public boolean contains(T quarry) // tested and works
    {
        Link<T> nav = head;
        for (int i = 0; i < size; i++, nav = nav.getNext())
        {
            if(nav.getDatum().equals(quarry))
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
    class LListIterator implements Iterator<T>
        {
            private Link<T> loc;
            public LListIterator()
            {
                loc = head;
            }
            public boolean hasNext()
            {
                if(loc.getNext().equals(null))
                {
                    return false;
                }
                else
                {
                    return true; 
                }
            }
            @SuppressWarnings("unchecked")
            public T next()
            {
                return (T) loc.getNext();
            }
        }
    public Iterator<T> iterator()
    {
        return new LListIterator();
    }
    public String toString()
    {
        if(size == 0)
        {
            return "[]";
        }
        String out = "]";
        //StringBuffer sb = new StringBuffer();
        //sb.append("[");
        Link<T> nav = head;
        out = String.format("%s",nav.getDatum()) + out;
        nav = nav.getNext();
        for(int k = 0; k < size - 2; k++, nav = nav.getNext())
        {
            //sb.append(String.format("%s, ", nav.getDatum()));
            out = String.format("%s, ",nav.getDatum()) + out;
        }
        out = String.format("[%s, ", nav.getDatum()) + out;
        //sb.append(String.format("%s]", nav.getDatum()));
        //return sb.toString();
        return out;

    }
    public static void main(String args[])
    {
        LList<String> yuh = new LList<>(); 
        yuh.add("yuh 1");
        yuh.add("yuh 2");
        yuh.add("yuh 3");
        yuh.add("yuh 3");
        yuh.add("yuh 3");
        yuh.add("yuh 3");
        yuh.add("yuh 4");
        yuh.add("yuh 5");
        int n = Integer.parseInt(args[0]);
        for (int i = 0; i < n; i++)
        {
            String add = Integer.toString(i);
            yuh.add(add);
            
        }
        System.out.println(yuh);
        // System.out.println(yuh.add(3, "girlboss"));
        // System.out.println(yuh);
        // System.out.println(yuh.indexOf("girlboss"));
        //System.out.println(yuh.remove("yuh 3"));
        //System.out.println(yuh.remove(0));
        //System.out.println(yuh.contains("yuh 3"));
        //System.out.println(yuh.extirpate("yuh 3"));
        //yuh.clear();
        yuh.set(1, "girlboss");
        System.out.println(yuh);
        System.out.println(yuh.get(0));
        
    }
}
class Link<E>
{
    private E datum;
    private Link<E> next;
    public Link(E datum, Link<E> next)
    {
        this.datum = datum;
        this.next = next;
    }
    public Link(E datum)
    {
        this(datum, null);
    }
    public E getDatum()
    {
        return datum;
    }
    public Link<E> getNext()
    {
        return next;
    }
    public void changeNext(Link<E> new_next)
    {
        next = new_next;  
    }
    public void changeDatum(E quarry)
    {
        datum = quarry; 
    }
    public String toString()
    {
        return String.format("%s", datum);
    }
}
