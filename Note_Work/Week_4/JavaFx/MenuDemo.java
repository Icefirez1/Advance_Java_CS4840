//package Note_Work.Week_4.JavaFx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class MenuDemo extends Application
{
    public MenuDemo()
    {
    }
    @Override
    public void init()
    {
        System.out.println("init called");
    }
    @Override
    public void start(Stage primary)
    {
        BorderPane bp = new BorderPane();
        Scene s = new Scene(bp, 500, 500);
        TextArea ta = new TextArea();
        MenuBar mbar = new MenuBar(); 
        Menu apps = new Menu("Appetizers");
        MenuItem foiGrassItem = new MenuItem("Foie Gras");

        foiGrassItem.setOnAction( e -> {
            ta.setText(ta.getText() + "foie gras \n");

        });

        apps.getItems().add(new MenuItem("Foie Gras"));
        apps.getItems().add(new MenuItem("rice"));
        apps.getItems().add(new MenuItem("ur mom"));

        Menu entrees = new Menu("Entrees");
        Menu desserts = new Menu("Desserts");
        Menu cakes = new Menu("cake");
        MenuItem chocolateCake = new MenuItem("Chocolate");
        MenuItem angelsFoodCakeItem = new MenuItem("Angel's Food");
        desserts.getItems().add(cakes);
        cakes.getItems().addAll( chocolateCake,angelsFoodCakeItem);

        mbar.getMenus().addAll(apps, entrees, desserts);
        bp.setTop(mbar);
        bp.setCenter(ta); 
        primary.setScene(s);
        primary.show();
    }
    @Override 
    public void stop()
    {
        System.out.println("stopped");
    }

}
