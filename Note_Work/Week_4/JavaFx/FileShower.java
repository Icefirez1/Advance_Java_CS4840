    
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.util.Optional;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.MenuBar;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
public class FileShower extends Application
{
    private Optional<Path> filePath;
    private TextArea ta; 
    private Stage primary; 
    public FileShower()
    {
        filePath = Optional.of(Path.of("sampler.txt"));
        ta = new TextArea(); 
        ta.setStyle("   -fx-font-size :24pt");

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
        Scene s = new Scene(bp, 800, 500);
        primary.setScene(s);
        bp.setTop(populateMenuBar());
        bp.setCenter(ta);
        primary.show();
    }
    private MenuBar populateMenuBar()
    {
        MenuBar mbar = new MenuBar();
        Menu fileMenu = new Menu("File");
        mbar.getMenus().add(fileMenu);
        MenuItem openItem = new MenuItem("Open...");
        openItem.setOnAction(e->
        {
            FileChooser fc = new FileChooser(); 
            fc.setTitle("Open File");
            File chosen = fc.showOpenDialog(primary);
            primary.setTitle((String) chosen.getAbsolutePath());
            filePath = Optional.of(Path.of(chosen.getAbsolutePath())); 

            //get contents of file 
            String innards = aspirateFileInPath(); 
            // put contents into the textarea 
            ta.setText(innards);

        });
        MenuItem quitItem = new MenuItem("Quit");
        quitItem.setOnAction( e ->
        {
            Platform.exit();
        });
        fileMenu.getItems().addAll(openItem, quitItem);
        return mbar;
    }
    private String aspirateFileInPath()
    {
        try(BufferedReader br = Files.newBufferedReader(filePath.get());)
        {
            StringBuffer sb = new StringBuffer();
            br.lines().forEach( line -> sb.append(line + "\n"));
            return sb.toString();
        }
        catch(NoSuchFileException ex)
        {
            System.err.printf("File %s does not exist\n", filePath.get());
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        return "";
    }

    @Override
    public void stop()
    {
    }
}