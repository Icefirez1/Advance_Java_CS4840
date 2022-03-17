import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square implements Shape
{
    private double x; 
    private double y; 
    private double size; 
    private Color color; 
    public Square(double x, double y, double size, Color color)
    {
        this.x = x; 
        this.y = y; 
        this.size = size; 
        this.color = color; 
    }
    public void draw(GraphicsContext pen)
    {
        pen.setFill(color);
        pen.fillRect(x - size/2, y - size/2, size, size);
    }
    
}
