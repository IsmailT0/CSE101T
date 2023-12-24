// @author İsmail Temüroğlu @18.10.2022
import java.util.Scanner;
public class BreadStore_20220808049 {
    public static void main(String[]args){
        Scanner input1= new Scanner(System.in);
        System.out.println("******Bread Store Inventory ******");
        System.out.println("Enter the number of bread store have ");
        int bread= input1.nextInt();
        if(bread>=0) {
            System.out.println("Enter the cost of bread:");
            double cost = input1.nextDouble();
            if (cost >= 0) {
                System.out.println("******Costumer User Interface ******");
                System.out.print("Welcome to our bread store. WE have " + bread + " loaves bread available.");
                System.out.println(" How many would you like?");
                int userbread = input1.nextInt();
                if (userbread > 0) {
                    int remaining = (bread - userbread);
                    double payment = (cost * userbread);
                    if (remaining >= 0) {
                        System.out.println("Your cost is " + payment);
                        System.out.println("Thank you for shopping with us today.");
                        System.out.println("Now we have  " + remaining + " loaves of bread remaining.");
                    }
                    else {
                        System.out.println("Error:We don't have that many remaining.");
                    }
                }
                else if (userbread==0) {
                    System.out.println("Error:You enter a 0. Exiting.");
                    System.out.println("Now we have " + bread + " loaves of bread remaining.");
                }
                else {
                    System.out.println("Error:You enter a negative number. Exiting.");
                    System.out.println("Now we have " + bread + " loaves of bread remaining.");
                }
            }
            else {
                System.out.println("Error:You enter a negative number. Exiting.");
            }
        }
        else {
            System.out.println("Error:You enter a negative number. Exiting.");
        }
    }
}
