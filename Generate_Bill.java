import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Generate_Bill {
    ArrayList<String[]> rent_bill;
    ArrayList<String[]> return_bill;
    String user_name;

    public Generate_Bill(ArrayList<String[]> bill, String user_name) {
        this.rent_bill = bill;
        this.user_name = user_name;
        this.return_bill = bill;
    }

    public int randomNumber() {
        double random_num_double = Math.random() * 100;
        int random_num_aInt = (int) Math.floor(random_num_double);
        return random_num_aInt;
    }


    public int generate_randomNum_2(){
        double random_num_double = (Math.random() * 901) + 100;
        int random_num_aInt = (int) Math.floor(random_num_double);
        System.out.println(random_num_aInt);
        return random_num_aInt;
    }

    public static void main(String[] args) {
        Generate_Bill b1 = new Generate_Bill(null, null);
        b1.randomNumber();
        b1.generate_randomNum_2();
    }

    public void generateRentBill() throws IOException {

        int random_num_aInt = randomNumber();
        LocalDateTime localdate = LocalDateTime.now();

        String rentedDate = localdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));// formatting accordind to our
                                                                                        // need

        double total_amount = 0;
        FileWriter rentfile = new FileWriter(random_num_aInt + "_" + user_name + "rented_item.txt");
        rentfile.write("\n");
        rentfile.write("\n");
        rentfile.write("\n");
        rentfile.write(
                "----------------------------------------------------------------------------------------------------");
        rentfile.write("\n");
        rentfile.write("\t\t\t\t\t  Rental Store LMT. ");
        rentfile.write("\n");
        rentfile.write("\n");
        rentfile.write(
                "----------------------------------------------------------------------------------------------------");
        rentfile.write("\n");
        rentfile.write("\t\t\tSamakhushi,Kathmandu | Contact number: 9841930222 ");
        rentfile.write("\n");
        rentfile.write(
                "----------------------------------------------------------------------------------------------------");
        rentfile.write("\n");
        rentfile.write("\t \t \tBill");
        rentfile.write("\n");
        rentfile.write(
                "----------------------------------------------------------------------------------------------------");
        rentfile.write("\n");
        rentfile.write("");
        rentfile.write("Rented Date:" + rentedDate + " \n");
        rentfile.write("\n");
        rentfile.write("Customer name :" + user_name + "\n");
        rentfile.write("\n");
        rentfile.write(
                "--------------------------------------------------------------------------------------------------------------");
        rentfile.write("\n");
        rentfile.write(String.format("%-30s | %-30s | %-30s | %-30s\n", "Name", "Brand", "Unit Price",
                "Quantity"));
        rentfile.write("\n");
        rentfile.write("\n");
        rentfile.write(
                "--------------------------------------------------------------------------------------------------------------");
        rentfile.write("\n");
        rentfile.write("\n");
        for (String[] items : rent_bill) {
            rentfile.write(String.format("%-30s | %-30s | %-30s | %-30s\n", items[1], items[2], items[3], items[4]));
            double price = Double.parseDouble(items[3].replace("$", ""));
            int quantity = Integer.parseInt(items[4]);
            total_amount = price * quantity;
            rentfile.write("\n");
        }
        rentfile.write("\n");
        rentfile.write(
                "--------------------------------------------------------------------------------------------------------------");
        rentfile.write("\n");
        rentfile.write("\n");
        rentfile.write("Total Amount: " + total_amount);

        rentfile.close();
        System.out.println();
        System.out.println("The bill has been generated!, The name is :" + random_num_aInt + "_" + user_name + "rented_item.txt");
    }

    public void generateRetrnbill() throws IOException {
        LocalDateTime localdate = LocalDateTime.now();

        String returndate = localdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));// formatting accordind to our
                                                                // need
        double total_amount = 0;
        FileWriter returnFile = new FileWriter(generate_randomNum_2() + "_" + user_name + "rented_item.txt");
        returnFile.write("\n");
        returnFile.write("\n");
        returnFile.write("\n");
        returnFile.write(
                "----------------------------------------------------------------------------------------------------");
        returnFile.write("\n");
        returnFile.write("\t\t\t\t\t  Return Store LMT. ");
        returnFile.write("\n");
        returnFile.write("\n");
        returnFile.write(
                "----------------------------------------------------------------------------------------------------");
        returnFile.write("\n");
        returnFile.write("\t\t\tSamakhushi,Kathmandu | Contact number: 9841930222 ");
        returnFile.write("\n");
        returnFile.write(
                "----------------------------------------------------------------------------------------------------");
        returnFile.write("\n");
        returnFile.write("\t \t \tBill");
        returnFile.write("\n");
        returnFile.write(
                "----------------------------------------------------------------------------------------------------");
        returnFile.write("\n");
        returnFile.write("");
        returnFile.write("Rented Date:" +  returndate+ " \n");
        returnFile.write("\n");
        returnFile.write("Customer name :" + user_name + "\n");
        returnFile.write("\n");
        returnFile.write(
                "--------------------------------------------------------------------------------------------------------------");
        returnFile.write("\n");
        returnFile.write(String.format("%-30s | %-30s | %-30s | %-30s\n", "Name", "Brand", "Unit Price",
                "Quantity"));
        returnFile.write("\n");
        returnFile.write("\n");
        returnFile.write(
                "--------------------------------------------------------------------------------------------------------------");
        returnFile.write("\n");
        returnFile.write("\n");
        for (String[] items : rent_bill) {
            returnFile.write(String.format("%-30s | %-30s | %-30s | %-30s\n", items[1], items[2], items[3], items[4]));
            double price = Double.parseDouble(items[3].replace("$", ""));
            int quantity = Integer.parseInt(items[4]);
            total_amount = price * quantity;
            returnFile.write("\n");
        }
        returnFile.write("\n");
        returnFile.write(
                "--------------------------------------------------------------------------------------------------------------");
        returnFile.write("\n");
        returnFile.write("\n");
        returnFile.write("Total Amount: " + total_amount);

        returnFile.close();
    }
}
