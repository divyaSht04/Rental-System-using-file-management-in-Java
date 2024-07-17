import java.util.ArrayList;

public class ItemsDisplay {
    public ArrayList<String[]> items_in_List;

    public ItemsDisplay(ArrayList<String[]> items_in_List){
        this.items_in_List = items_in_List;
    }

    public void Display(){
        System.out.println();
        System.out.println("\t***********************************************************************************************");
        System.out.println("\t| Index    | Name                                | Brand              | Price      | Stock left |");
        System.out.println("\t***********************************************************************************************");
        for (String[] item : items_in_List) {
            System.out.printf("\t| %-9s| %-35s| %-20s| %-11s| %-11s|\n", item[0], item[1], item[2], item[3], item[4]);
        }
        System.out.println("\t***********************************************************************************************");
        System.out.println();
    }
}
