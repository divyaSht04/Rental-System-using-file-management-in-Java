import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ItemsReading reading = new ItemsReading("rental_items.txt");
        ArrayList<String[]> Items_in_List = reading.readingFile();
        
        UpdateRentalList update;
        
        ItemsDisplay displayItem = new ItemsDisplay(Items_in_List);

        while (true) {
            System.out.println("\t***********************************************************************************************");
            System.out.println("\t╔════════════════════════════════════════════════════════════════════╗");
            System.out.println("\t║                                                                    ║");
            System.out.println("\t║                  WELCOME TO DIVYA SHRESTHA RENTAL                  ║");
            System.out.println("\t║                                                                    ║");
            System.out.println("\t║                       SAMAKHUSHI,KATHMANDU                         ║");
            System.out.println("\t║                                                                    ║");
            System.out.println("\t║====================================================================║");
            System.out.println("\t║ PLEASE SELECT A CATEGORY AS ( 1/2/3/4 ), ACCODING TO YOUR CHOICE:  ║");
            System.out.println("\t║                                                                    ║");
            System.out.println("\t║                                                                    ║");
            System.out.println("\t║                        1 = SHOW ITEMS                              ║");
            System.out.println("\t║                        2 = RENT ITEMS                              ║");
            System.out.println("\t║                        3 = RETURN ITEMS                            ║");
            System.out.println("\t║                        4 = EXIT SHOP                               ║");
            System.out.println("\t║                                                                    ║");
            System.out.println("\t╚════════════════════════════════════════════════════════════════════╝");
            System.out.print("\t");

            try{
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the option: ");
                int option = sc.nextInt();
                sc.nextLine();
                if (option == 1) {
                    displayItem.Display();
                } else if (option == 2) {
                    
                    ArrayList<String[]> rentItemList = new ArrayList<>();
                    System.out.print("Enter Your name: ");
                    String user_name = sc.nextLine(); // Read the name
                    while (true) {
                        displayItem.Display();
                        System.out.print("Enter the product number you want to rent: ");
                        int product_number_aInt = sc.nextInt();
                        sc.nextLine(); // Consume the newline character
                        
    
                        System.out.print("Enter the quantity you want to rent: ");
                        int quantity_number_aInt = sc.nextInt();
                        sc.nextLine(); // Consume the newline character
    
                        RentingItem rentItem = new RentingItem(Items_in_List, product_number_aInt, quantity_number_aInt);
    
                        ArrayList<String[]> check_ArrayList = rentItem.RentingProcess();
                        if (check_ArrayList == null) {
                            continue;
                        } else {
                            rentItemList.addAll(check_ArrayList);
                        }
    
                        System.out.print("Do you want to rent more items (yes/no): ");
                        String ask = sc.nextLine();
    
                        // updating bill
                        ArrayList<String[]> to_update_List = rentItem.changingList_txt();
                        update = new UpdateRentalList(to_update_List);
                        update.updateBill();
    
                        if (ask.equalsIgnoreCase("no")) {
                            break;
                        }
                    }
    
                    Generate_Bill bill = new Generate_Bill(rentItemList, user_name);
                    bill.generateRentBill();
                }else if(option == 3){
                    ArrayList<String[]> returnItem_List = new ArrayList<>();
                    System.out.print("Enter Your name: ");
                    String user_name = sc.nextLine(); // Read the name
                    while (true) {
                        displayItem.Display();
                        System.out.print("Enter the product number you want to return: ");
                        int product_number_aInt = sc.nextInt();
                        sc.nextLine(); // Consume the newline character
    
                        System.out.print("Enter the quantity you want to return: ");
                        int quantity_number_aInt = sc.nextInt();
                        sc.nextLine(); // Consume the newline character
    
                        ReturnItem return_Item_ = new ReturnItem(Items_in_List, product_number_aInt, quantity_number_aInt);
    
                        ArrayList<String[]> check_ArrayList = return_Item_.ReturningProcess();
                        if (check_ArrayList == null) {
                            System.out.println("Please enter the right quantity ");
                            continue;
                        } else {
                            returnItem_List.addAll(check_ArrayList);
                        }
                        System.out.print("Do you want to rent more items (yes/no): ");
                        String ask = sc.nextLine();
                        // updating bill
                        ArrayList<String[]> to_update_List = return_Item_.changingList_txt();
                        update = new UpdateRentalList(to_update_List);
                        update.updateBill();
    
                        if (ask.equalsIgnoreCase("no")) {
                            break;
                        }
                    }
                    Generate_Bill bill = new Generate_Bill(returnItem_List, user_name);
                    bill.generateRetrnbill();
                } 
                else if (option == 4) {
                    System.out.println();
                    System.out.println("Thank you for visiting :)");
                    System.out.println();
                    sc.close();
                    break;
                }
            }catch (InputMismatchException ex){
                System.out.println("Please enter the right number");
                continue;
            }
        }
    }
}