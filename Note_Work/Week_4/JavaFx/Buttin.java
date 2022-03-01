//package Note_Work.Week_4.JavaFx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField; 

public class Buttin extends Application
{
    private int num = 0; 
    @Override
    public void start(Stage primary)
    {

        Button butt = new Button("Click me daddy");
        Button teuton = new Button("Click me to pls mommy");
        Button quitButton = new Button("Agh i can't go anymore");
        TextField tf = new TextField();
        VBox vbox = new VBox();

        butt.setOnAction(  e ->{
            // Platform.exit(); this is the polite way to exit a program
            butt.setText("press harder!!");
            tf.setText("yuh");
        });

        quitButton.setOnAction( die ->{
            Platform.exit();
        });

        // Group root = new Group(); 
        // root.getChildren().addAll(butt, teuton);
        vbox.getChildren().addAll(butt, teuton, quitButton, tf);

        primary.setScene(new Scene(vbox, 500, 500));
        primary.show();

    }
    public void stop()
    {
        System.out.println("stopped");
    }
}
