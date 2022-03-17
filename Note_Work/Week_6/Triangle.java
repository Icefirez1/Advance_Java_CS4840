import java.lang.reflect.Array;
import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle implements Shape
{
    private double x; 
    private double y; 
    private double size; 
    private Color color; 
    public Triangle(double x, double y, double size, Color color)
    {
        this.x = x; 
        this.y = y; 
        this.size = size; 
        this.color = color; 
    }
    public void draw(GraphicsContext pen)
    {
        // figure out how to draw a triangle
        pen.setFill(color);

        double height = size*Math.sqrt(3)/4;
        double [] xArr = {x, x + size/2, x - size/2, x};
        double [] yArr = {y - height, y + height, y + height, y - height};
        pen.fillPolygon(xArr, yArr, 4);
    }
    
}
