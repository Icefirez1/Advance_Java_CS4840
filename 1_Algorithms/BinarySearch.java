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
        System.out.println(isInOrder(items));
        if (!isInOrder(items))
        {
            throw new IllegalArgumentException("Doesnt work");
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
        System.out.println("checked");
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
        while (items.size() > 1)
        {
            Integer middle_index = items.size()/2;
            if (quarry.compareTo(items.get(middle_index)) == 0)
            {
                return middle_index;
            }
            else if (quarry.compareTo(items.get(middle_index)) == 1)
            {
                items = items.subList(middle_index, items.size());
            }
            else if (quarry.compareTo(items.get(middle_index)) == -1)
            {
                items = items.subList(middle_index, items.size());
            }
        }
        return -1;
    }
    public static void main(String[] args)
    {
        //TEST YOUR CODE!!
        System.out.println("yuh");
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(123);
        list.add(5);
        list.add(6);
        System.out.println(list.toString());
        BinarySearch<Integer> bs = new BinarySearch<>(list);
        /*List<Integer> tmp = new ArrayList<>(list);
        Collections.sort(tmp);
        boolean sorted = tmp.equals(list);
        if (sorted == false)
        {
            throw new IllegalArgumentException("dumb");
        }*/
        System.out.println(bs.indexOf(5));

        


    }
}