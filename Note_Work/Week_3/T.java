public class T extends S
{
    private int y;
    public T(int x)
    {
        super(x);
        y = x;
    }
    @Override
    public void print()
    {
        System.out.printf("y = %s\n", y);
    }
}