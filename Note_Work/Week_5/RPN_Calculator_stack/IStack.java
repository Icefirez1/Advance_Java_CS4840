
//package Note_Work.Week_2.IStack;

public interface IStack<T>
{
    public void push(T newItem);
    public T pop();
    public T peek();
    public boolean isEmpty();
    public int size();

}