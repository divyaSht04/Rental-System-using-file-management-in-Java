import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ItemsReading {
    private ArrayList<String[]> rentalList = new ArrayList<>();
    private String file_name;
    
    public ItemsReading(String file_name){
        this.file_name = file_name;
    }
    
    public ArrayList<String[]> readingFile() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(file_name)); // Taking values form the text file
        String line;

        while((line = reader.readLine()) != null){
            String value[] = line.split(", ");// creates and array of substring removing ", "
            rentalList.add(value);
        }
        reader.close();
        return rentalList;
    }
}
