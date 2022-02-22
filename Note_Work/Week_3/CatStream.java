import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Optional;

public class CatStream 
{
    private Optional<Object> fileContainer; 
    public CatStream(String fileName)
    {
        this.fileContainer = Optional.of(fileName);
        
    }
    public CatStream() 
    {
        this.fileContainer = Optional.empty(); 
    }
    public void showFile()
    {
        Path path = Path.of((fileContainer.ifPresentOrElse(), () -> //this shit doesnt work copy from morrison 
        
        {
            System.err.println("No file is specified. Bailing.....");
            System.exit(1); 
        });
        try(BufferedReader br = Files.newBufferedReader(path);)
        {
            br.lines()
                .forEach(System.out::println);
        }
        catch(NoSuchFileException ex)
        {
            System.err.printf("File %s not found.\n", fileContainer.get());
        }
        catch(IOException ex)
        { 
            ex.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        System.out.println("yuh");
        CatStream csFilled = new CatStream(args[0]);
        CatStream csEmpty = new CatStream();
        csFilled.showFile();  

    }
}