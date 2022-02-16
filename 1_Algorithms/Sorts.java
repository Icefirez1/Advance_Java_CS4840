import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Sorts
{
    public static <T extends Comparable<T>> void swap(List<T> x, int j, int k)
    {
        T tmp = x.get(j);
        x.set(j, x.get(k));
        x.set(k, tmp);
    } 
    @SuppressWarnings("unchecked")
    public static <T extends Comparable> void gnome(List<T> x)
    {
        for (int index = 1; index < x.size();)
        {
            if(index == 0)
            {
                index++;
            }
            if(x.get(index).compareTo(x.get(index-1)) >= 0)
            {
                index++; 
            }
            else
            {
                swap(x, index, index-1);
                index --;
            }            
        }
    }
    @SuppressWarnings("unchecked")
    private static <T extends Comparable> List<T> zipper(List<T> list, List<T> list2)
    {
        List<T> out = new ArrayList<>(); 
        int px = 0; 
        int py = 0; 
        while (px < list.size() && py < list2.size())
        {
            if (list.get(px).compareTo(list2.get(py)) < 0)
            {
                out.add(list.get(px));
                px++;
            }
            else
            {
                out.add(list2.get(py));
                py++; 
            }
        }
        out.addAll(list.subList(px, list.size()));
        out.addAll(list2.subList(py, list2.size()));
        return out; 
    }
    
    public static <T extends Comparable> List<T> merge(List<T> x)
    {
        /* so i can do this recusively 
        So I gotta split the list into two then keep going until the 
        list size is one then zipper it until all the way back up*/
        // Ask Dr. Morrison what thing he wants returned
        if (x.size() == 1)
        {
            return x;
        }
        return zipper(merge(x.subList(0, x.size()/2)), merge(x.subList(x.size()/2, x.size())));
        //I DID THIS SHIT RECUSRIVELY LETS GOOOOOOOOOOOOOOO
    }
    public static void main(String[] args)
    {
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>(); 
        int n = Integer.parseInt(args[0]);
        for (int i = 0; i < n; i++)
        {
            Integer add = Integer.parseInt("" + i);
            al.add(add);
            al2.add(add);
        }
        System.out.println("Testing of zipper");
        System.out.println(al);
        System.out.println(al2);
        ArrayList<Integer> combined = (ArrayList<Integer>) zipper(al,al2);
        System.out.println(combined);

        System.out.println("Testing of merge");
        Collections.shuffle(al);
        System.out.println(al);
        ArrayList<Integer> out = (ArrayList<Integer>) merge(al);
        System.out.println(out);

        System.out.println("Testing of gnome");
        Collections.shuffle(al);
        System.out.println(al);
        gnome(al);
        System.out.println(al);



    }
}