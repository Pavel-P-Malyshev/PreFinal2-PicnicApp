
import java.io.IOException;


import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;


public class ReadFile 
{
       

        public static List<String> readFileInMap(String fileName)
        {
   
            List<String> lines = Collections.emptyList();

            try 
            {
                  lines = Files.readAllLines(Paths.get(fileName),StandardCharsets.UTF_8);

                  
            }
     
            catch (IOException e) {
     
                // do something
                e.printStackTrace();
            }
            return lines;
    
        }
}
