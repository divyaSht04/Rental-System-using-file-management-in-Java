
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class UpdateRentalList {
    ArrayList<String[]> to_update_list;

    public UpdateRentalList(ArrayList<String[]> to_update_list){
        this.to_update_list = to_update_list;
    }

    public void updateBill() throws IOException{
        FileWriter file_write = new FileWriter("rental_items.txt");
        for(String rows[]:to_update_list){
            String number = rows[0];
            String name = rows[1];
            String brand = rows[2];
            String price = rows[3];
            String quantity = rows[4];
            file_write.write(String.format("%s, %s, %s, %s, %s",number,name,brand,price,quantity));
            file_write.write("\n");
        }
        file_write.close();
    }

}
