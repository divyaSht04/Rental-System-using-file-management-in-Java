import java.util.ArrayList;
import java.util.Scanner;

public class ReturnItem {
    Scanner sc = new Scanner(System.in);
    ArrayList<String[]> readingItem;
    ItemsDisplay displayItem;
    ArrayList<String[]> Item_return_List = new ArrayList<>();
    int quantity_number_aInt;
    int product_number_aInt;
    
    public ReturnItem(ArrayList<String[]> readingItem, int product_number_aInt,int quantity_number_aInt){
        this.readingItem = readingItem;
        this.product_number_aInt = product_number_aInt;
        this.quantity_number_aInt = quantity_number_aInt;
    }
    
    
    public ArrayList<String[]> ReturningProcess(){ 
        
        String Item_name = "", Item_price = "", Item_brand="" , Item_index = "";
        for(String[] rows:readingItem){
            if(product_number_aInt == Integer.parseInt(rows[0])){
                if(Integer.parseInt(rows[4]) > 0){
                    Item_index = rows[0];
                    Item_name = rows[1];
                    Item_brand = rows[2];
                    Item_price = rows[3];
                    break;
                }
                else{
                    return null;
                }
            }
        }    
        String rented_Item[] = {Item_index,Item_name,Item_brand,Item_price,String.valueOf(quantity_number_aInt)};
        Item_return_List.add(rented_Item);
        return Item_return_List;
    }
    
    public ArrayList<String[]> changingList_txt(){
        ArrayList<String[]> changingList = readingItem;

        for(String[] rows:changingList){
            if(product_number_aInt == Integer.parseInt(rows[0])){
                int existing_quantity = Integer.parseInt(rows[4]);
                int new_quantity = existing_quantity +  quantity_number_aInt;
                rows[4] = String.valueOf(new_quantity);
            }
        }  
        return changingList;
    }
}
