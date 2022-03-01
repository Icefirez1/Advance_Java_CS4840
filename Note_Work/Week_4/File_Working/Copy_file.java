package Note_Work.Week_4.File_Working;
//package Note_Work.Week_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;
public class Copy_file 
{

    public static void main(String args[])
    {
        
        BufferedReader objReader = null;
        try {
             //This is base but like I'm trying to do it with buffered reader and stuff
            File Output_File = new File("Output.txt");
            FileInputStream fis = new FileInputStream(args[0]);
            FileOutputStream fos = new FileOutputStream(Output_File);
            int c;

            while ((c = fis.read()) != -1) {
               fos.write(c);
            }

            fis.close();
            fos.close();
            // objReader = new BufferedReader(new FileReader(args[0]));
            // String strCurrentLine = objReader.readLine();
            // System.out.println(strCurrentLine);
            // while ((strCurrentLine = objReader.readLine()) != null) {

            //     //System.out.println(strCurrentLine);
            //     fos.write(strCurrentLine);
            //    } Yea i ran out of time for this 



        } catch (FileNotFoundException e) {
            System.err.println("FileStreamsTest: " + e);
        } catch (IOException e) {
            System.err.println("FileStreamsTest: " + e);
        }
    }
}
