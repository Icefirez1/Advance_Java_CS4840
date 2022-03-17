
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import java.util.ArrayList;

public class Draw extends Application
{
    private Stage primary;
    private Color currentColor;
    private Color bgColor; 
    private double currentSize;
    private GraphicsContext pen;
    private Canvas canvas;
    private Slider sizeSlider; 
    private Label sizeLab;
    private ShapeType currentShape;
    private ArrayList<Shape> shapez; 
    private HBox canvasBox; 
    


    public Draw()
    {
        this.currentColor = Color.BLACK;
        this.bgColor = Color.WHITE;
        this.currentShape = ShapeType.SQUARE; 
        this.currentSize = 50;
        this.shapez = new ArrayList<>();
        canvas = new Canvas(800, 500);
        pen = canvas.getGraphicsContext2D();
        sizeSlider = new Slider(1, 200, 50);

        //shits broken 
        sizeSlider.valueProperty().addListener( e -> 
        {
            currentSize = sizeSlider.getValue(); 
            sizeLab.setText("" + (int)currentSize);
        });
        sizeLab = new Label("50");


        sizeLab = new Label("50");
        canvasBox = new HBox();
        canvasBox.getChildren().add(canvas);
    }

    @Override
    public void init()
    {
    }

    @Override
    public void start(Stage primary)
    {
        this.primary = primary;
        BorderPane bp = new BorderPane();
        HBox topBox = new HBox(); 
        topBox.getChildren().add(buildMenus());



        
        topBox.getChildren().add(sizeSlider);
        topBox.getChildren().add(sizeLab);



        bp.setCenter(canvasBox);
        bp.setTop(topBox); //buildMenus());
        primary.setScene(new Scene(bp));
        // pen.setFill(Color.RED);
        // pen.fillRect(0,0,100,100);
        // pen.setStroke(Color.BLUE);
        // pen.strokeRect(200,200,50,50);
        // pen.setFill(Color.GREEN);
        // pen.fillOval(300,300, 100, 50);
        canvas.setOnMouseClicked( e ->
        {
            Shape s = null;
            switch (currentShape)
            {
            case SQUARE:
                s = new Square(e.getX(), e.getY(), currentSize, currentColor);
                break;
            case CIRCLE:
                s = new Circlez(e.getX(), e.getY(), currentSize, currentColor);
                break; 
            case TRIANGLE:
                s = new Triangle(e.getX(), e.getY(), currentSize, currentColor);
                break;  
            }
            shapez.add(s);
            s.draw(pen);
        });


        primary.show();
    }
    private MenuBar buildMenus()
    {
        MenuBar mbar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu saveAsMenu = new Menu("Save ass");
        Menu colorMenu = new Menu("Color");
        Menu sizeMenu = new Menu("Size");
        Menu shapeMenu = new Menu("Shape");
        Menu backgroundMenu = new Menu("Background");

        mbar.getMenus().addAll(fileMenu, colorMenu, sizeMenu, shapeMenu, backgroundMenu);

        colorMenu.getItems().add(new ColorMenuItem("Red", Color.RED));
        colorMenu.getItems().add(new ColorMenuItem("Blue", Color.BLUE));
        colorMenu.getItems().add(new ColorMenuItem("Green", Color.GREEN));
        colorMenu.getItems().add(new ColorMenuItem("Yellow", Color.YELLOW));
        colorMenu.getItems().add(new ColorMenuItem("Dookbloo", Color.valueOf("#001A57")));
        
        MenuItem customColorItem = new MenuItem("Custom...");
        customColorItem.setOnAction( e-> 
        {
            Stage popup = new Stage(); 
            popup.setTitle("Choose your color");
            BorderPane bp = new BorderPane(); 
            ColorPicker cp = new ColorPicker();
            cp.setOnAction( f -> 
            {
                currentColor = cp.getValue(); 
                popup.close();
            });

            bp.setCenter(cp);
            popup.setScene(new Scene (bp, 100, 100));
            popup.show(); 
        });
        colorMenu.getItems().add(customColorItem);


        sizeMenu.getItems().add(new SizeMenuItem(20));
        sizeMenu.getItems().add(new SizeMenuItem(50));
        sizeMenu.getItems().add(new SizeMenuItem(100));
        sizeMenu.getItems().add(new SizeMenuItem(200));

        shapeMenu.getItems().add(new ShapeMenuItem(ShapeType.SQUARE));
        shapeMenu.getItems().add(new ShapeMenuItem(ShapeType.CIRCLE));
        shapeMenu.getItems().add(new ShapeMenuItem(ShapeType.TRIANGLE));
        
        backgroundMenu.getItems().add(new BgMenuItem("BLACK", Color.BLACK));


        MenuItem jpgItem = new MenuItem("JPG");
        jpgItem.setOnAction( e ->
        {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpg_file", "*jpg"));
            


        });

        MenuItem pngItem = new MenuItem("PNG");
        saveAsMenu.getItems().addAll(jpgItem, pngItem);


        MenuItem quitItem = new MenuItem("Quit");
        quitItem.setOnAction(e -> Platform.exit());
        MenuItem clearItem = new MenuItem("Clear");
        clearItem.setOnAction( e ->
        {
            shapez.clear();
            pen.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); 
        });
        fileMenu.getItems().addAll(clearItem, quitItem, saveAsMenu);

        return mbar;
    }
    @Override
    public void stop()
    {
    }
    /******************* Aliens ********************/
    enum ShapeType
    {
        SQUARE, 
        CIRCLE, 
        TRIANGLE

    }
    class ColorMenuItem extends MenuItem
    {
        Color color;
        public ColorMenuItem(String name, Color color)
        {
            super(name);
            this.color = color;
            setOnAction( e ->
            {
                currentColor = color;
            });
        }

    }
    class SizeMenuItem extends MenuItem
    {
        double size;
        public SizeMenuItem(double size)
        {
            super("" + size);
            this.size = size;
            setOnAction( e ->
            {
                currentSize = size;
                sizeSlider.setValue(currentSize);
                sizeLab.setText( ""  + (int)currentSize);
            });
        }

    }
    class ShapeMenuItem extends MenuItem
    {
        ShapeType shape; 
        public ShapeMenuItem(ShapeType shape)
        {
            super("" + shape);
            this.shape = shape;
            setOnAction( e ->
            {
                currentShape = shape;
            });
        }

    }
    class BgMenuItem extends MenuItem
    {
        Color color;
        public BgMenuItem(String name, Color color)
        {
            super(name);
            this.color = color;
            setOnAction( e ->
            {
                bgColor = color;
                // pen.setFill(bgColor);
                // pen.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                canvasBox.setStyle("-fx-background-color:" + bgColor.toString().substring(0,8).replace("0x", "#"));
                // System.out.println(bgColor.toString().substring(0,8).replace("0x", "#"));
            });
        }
    }
}