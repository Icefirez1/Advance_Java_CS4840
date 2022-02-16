package Note_Work.Week_1;

import java.util.ArrayList;
import java.util.Collections;

public class Sordid 
{
    public Sordid()
    {

    }
    public static <T extends Comparable<T>> void swap(ArrayList<T> x, int j, int k)
    {
        T tmp = x.get(j);
        x.set(j, x.get(k));
        x.set(k, tmp);
    } 
    public static <T extends Comparable<T>> void trickle(ArrayList<T> x)
    {
        /* can you figure out whether or not where u swap it*/
        for (int pointer = 1; pointer < x.size(); pointer++ )
        {
            for (int i = pointer; i >= 1; i--)
            {
                if (x.get(i).compareTo(x.get(i -1)) < 0)
                {
                    swap(x, i, i-1);
                } 
            }
        }
    }

    //x and y are Sotrted lists. combine them into a singe sorted list and return it
    // This is O(n)
    public static <T extends Comparable<T>> ArrayList zipper(ArrayList<T> x, ArrayList<T> y)
    {
        ArrayList<T> out = new ArrayList<>(); 
        int px = 0; 
        int py = 0; 
        while (px < x.size() && py < y.size())
        {
            if (x.get(px).compareTo(y.get(py)) < 0)
            {
                out.add(x.get(px));
                px++;
            }
            else
            {
                out.add(y.get(py));
                px++; 
            }
        }
        out.addAll(x.subList(px, x.size()));
        out.addAll(y.subList(py, y.size()));
        return out; 
    }

    public static void main(String[] args)
    {
        ArrayList<String> al = new ArrayList<>();
        ArrayList<String> al2 = new ArrayList<>();

        int n = Integer.parseInt(args[0]);
        for (int i = 0; i < n; i++)
        {
            al .add("" + i);
            al2.add("" +i);
        }
        Collections.shuffle(al);
        trickle(al);
        System.out.println(al);
        System.out.println(al2);
        


    }
}