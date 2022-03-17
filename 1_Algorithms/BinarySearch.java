/**
 * This class searches its list for a specified item
 * by index
 */
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Comparator;
import java.lang.Comparable;
import java.util.Collections;
public class BinarySearch<T extends Comparable<T>> 
{
    private List<T> items;
    /**
    *  This constructor accepts a List<T> of items to be searched.
    *  @param items the list of items we are searching
    *  @throws IllegalArgumentException if the list passed is not sorted
    */
    public BinarySearch(List<T> items)
    {
        //throw an IllegalArgumentException if 
        //the list is out of order.
        this.items = items;
        if (!isInOrder(items))
        {
            throw new IllegalArgumentException("List Out of order");
        }
    }
    /**
    *  This searches our list and returns the index containing
    *  <code>quarry</code>
    *  @param quarry the item we week
    *  @return the index of the first instance of <code>quarry</code>, 
    *  or -1 if <code>quarry</code> is not found.
    */
    public static <T extends Comparable<T>> boolean isInOrder(List<T> list)
    {
        //System.out.println("checked");
        for (int i = 0; i < list.size() -1; i ++)
        {
            if(list.get(i).compareTo(list.get(i+1)) > 0)
            {
                return false; 
            }
        }
        return true;
    }
    public int indexOf(T quarry)
    {
        //use bianry search to locate quarry by index
        //return -1 if it's a wild goose chase.
        int low = 0; 
        int high = items.size();
        int middle_index = (high+low)/2;
        while (low + 1 < high)
        {
            if (quarry.equals(items.get(middle_index)))
            {
                return middle_index;
            }
            if (quarry.compareTo(items.get(middle_index)) > 0)
            {
                low = middle_index;
            }
            else
            {
                high = middle_index;
            }
            middle_index = (high+low)/2;

        }
        return -1;
    }
    public static void main(String[] args)
    {
        //TEST YOUR CODE!!
        //System.out.println("yuh");
        List<String> list = new ArrayList<String>();
        int n = Integer.parseInt(args[0]);
        for (int i = 0; i < n; i++)
        {
            String add = Integer.toString(i);
            list.add(add);
            
        }
        //System.out.println(list);
        BinarySearch<String> bs = new BinarySearch<>(list);
        System.out.println(bs.indexOf("9"));

        


    }
}