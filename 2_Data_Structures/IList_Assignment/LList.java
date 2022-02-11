import java.util.Iterator;
public class LList<T> implements IList<T>, Iterable<T>
{
    Link<T> head;
    public LList()
    {
        head = null;
    }
    /**
    *  appends <code>item</code> to this list
    *  @param item object to be added to this list
    *  @return true if <code>item</code> is added to this list
    */
    public boolean add(T item)
    {
        return false;
    }
    /**
    *  appends <code>item</code> to this list
    *  @param index The object <code>item</code> is inserted at <code>index</code>.
    *  @param item object to be added to this list
    *  @return true if <code>item</code> is added to this list
    */
    public boolean add(int index, T item)
    {
        return false;
    }
    /**
    *  This returns a -1 if <code>quarry</code> is not found or the index of
    *  the fist instance of <code>quarry</code> otherwise.
    *  @param quarry object to be added to this list
    *  @return -1 if <code>quarry</code> is not found or the index where
    *  the first instance of <code>quarry</code> is located.
    */
    public int indexOf(T quarry)
    {
        return 0;
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
        return null;
    }
    /**
    *  This removes all objects equal to <code>quarry</code> from this list.
    *  @param quarry object to be extirpated from  this list
    *  @return <code>false</code> if <code>quarry</code> is not found 
    */
    public boolean extirpate(T quarry)
    {
        return false;
    }
    /**
    *  This removes all elements from this list.
    */
    public void clear()
    {
    }
    /**
    *  This computes the size of the list
    *  @return the number of elements in this list
    */
    public int size()
    {
        return 0;
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
 
    }
    /**
    *   This fetches the object at index <code>index</code>.
    *   @param index the index from which we wish to retrieve an element.
    *   @return the element at <code>index</code> in this list.
    *   @throws IndexOutOfBOundException if the <code>index</code> is out of bounds.
    */
    public T get(int index)
    {
        return null;
    }
    /**
    *   This checks for the presence of <code>quarry</code> in this list.
    *   @param quarry the item we are searching for in this list
    *   @return <code>true</code> if <code>quarry</code> is found in this list 
    */
    public boolean contains(T quarry)
    {
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
}
