package ecosystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Util {
    /***
     * return alternative resources for tasks Read resource info from file
     * @param path
     * @return data
     */
    public static List<String> MatchResource(String path){
    
        List<String> data = new ArrayList<String>();
        try {
            /**
             * read file content from file
             */           
            FileReader reader = new FileReader(path);
            BufferedReader br = new BufferedReader(reader);
           
            String line = null;
            br.readLine();
            while((line = br.readLine()) != null) {
                data.add(line);
            }
           
            br.close();
            reader.close();
            
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
            }
            catch(IOException e) {
                  e.printStackTrace();
            }
        return data;
        }

}

