//package Note_Work.Week_4.JavaFx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class LifeCycle extends Application
{
    public LifeCycle()
    {
        System.out.println("Constructor called");
    }
    @Override
    public void init()
    {
        System.out.println("init called");
    }
    @Override
    public void start(Stage primary)
    {

        primary.show();
    }
    @Override 
    public void stop()
    {
        System.out.println("stopped");
    }

}
