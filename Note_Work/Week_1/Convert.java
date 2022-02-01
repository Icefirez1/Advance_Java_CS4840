public class Convert
{


    

    public static String binToString(int num)
    {
        String out = "";
        while (num > 0)
        {
            int cur_num = num % 2;
            out = Integer.toString(cur_num) + out;
            num = num / 2;
        }
        return out;
    }
 
    public static void main(String[] args)
    {
        int test = 10;

        System.out.println(binToString(test));
        System.out.println(binToString(8));

    }
}