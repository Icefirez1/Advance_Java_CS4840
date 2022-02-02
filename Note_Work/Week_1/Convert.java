/* */

public class Convert
{

    public static String binToString(int num)
    {
        String out = "";
        while (num > 0)
        {
            out = Integer.toString(num%2) + out;
            num = num / 2;
        }
        return out;
    }
 
    public static void main(String[] args)
    {
        int test = 10;
        try
        {
            int x = Integer.parseInt(args[0]);
            System.out.println(binToString(x));
        }
        catch(NumberFormatException ex)
        {
            System.out.printf("Dumbass it's gotta be an integer\n");
        }
        System.out.println(binToString(test));
        System.out.println(binToString(8));

    }
}