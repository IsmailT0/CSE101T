import java.util.Scanner;

public class StoreUsingArrays_20220808049 {
    public static void main(String[] args){
        //System.out.println(returnedAmounts(399.8));
        String [] arr= {"bread", "cola","Snickers", "Ayran"};
        int [] quantity={10,15,12,30};
        double [] price={0.75,2.5,2.25,1};
        storeRun(arr,quantity,price);

    }

    //String capitalize method
    public static String capitalizeString(String text){
        text =text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
        return text;
    }

    // capitalize all the Strings in an array
    public static void capitalizeArray(String []  name){

        for (int i =0 ; i< name.length;i++){
            name [i] = capitalizeString(name[i]);
        }
    }

    public static void storeRun(String [] itemName , int [] itemNumbers, double [] price ){
        Scanner input1 = new Scanner(System.in);
        double totalPayment =0 ;
        double amount;
        int remainItem;//for remaining that we have
        int[] requestedItem =new int [itemName.length+1];//number of ıtem that user requested
        double [] payment = new double[itemName.length+1];//payment for each item
        System.out.println("Welcome to our store. We have the following. Please enter what would you like.");
        int choice = menu(itemName,price,input1);

        while(choice !=0){


            if (choice>0 && choice<=(itemName.length+1)) {



                System.out.printf("How many %s would you like? ", itemName[choice-1]);
                int request= input1.nextInt();



                if (request<0){
                    System.out.println("Invalid entry");
                }
                else{
                    remainItem = itemNumbers[choice-1];



                    remainItem -=request;



                    if (remainItem<0){
                        System.out.println("Invalid entry");

                    }

                    else{
                        requestedItem[choice-1]+=request;

                        itemNumbers[choice-1]-=request;

                    }
                }

                payment[choice-1]=((requestedItem[choice-1])*(price[choice-1]));




            }
            else{
                System.out.println("Invalid entry");
            }
            choice=menu(itemName,price,input1 );
        }
        for (double j : payment) totalPayment += j;
        System.out.println("*****Costumer Total*****");
        for (int i =0; i<payment.length;i++){
            if(payment[i] != 0){
                System.out.println(itemName[i]+ " - "+requestedItem[i]+" * "+price[i]+" = "+payment[i]);
            }
        }
        System.out.println("-----------------------------------------");

        System.out.println("Total due "+totalPayment);
        System.out.println();

        double takenCash = -1;
        while (totalPayment>takenCash) {
            System.out.println("Please enter amount given");
            takenCash = input1.nextDouble();
            if (takenCash >= totalPayment) {
                amount = (takenCash - totalPayment);
                System.out.println(returnedAmounts(amount));
            } else {
                System.out.println("Invalid entry");
            }
        }

    }

    public static  int menu (String[] str , double[ ] price, Scanner input1){
        capitalizeArray(str);

        for ( int i =0; i< str.length;i++){
            System.out.printf("%d for %s ",i+1,str[i]);
            System.out.println(price[i]);
        }
        System.out.println("0 - to checkout");
        System.out.println("Please enter what you would like:");
        int n = input1.nextInt();
        System.out.printf("\nYour choice was %d\n",n);

        return n;
    }

    public static String returnedAmounts(double amount) {
        int[] counterArr = new int[12];
        double[] cashback = {200, 100, 50, 20, 10, 5, 1, 0.5, 0.25, 0.10, 0.05, 0.01};
        String output ="";
        String[] paybackName = {"200", "100", "50", "20", "10", "5", "1", "0.5", "0.25", "0.10", "0.05", "0.01"};
        while (amount != 0) {
            for (int i = 0; i < counterArr.length; i++) {

                if (amount >= cashback[i]) {
                    counterArr[i] = (int) (amount / cashback[i]);
                    if (counterArr[i] != 0) {
                        output +="";
                        output +=counterArr[i]+" - ";
                        output += paybackName[i]+"\n";
                        amount %= cashback[i];
                        amount = Math.round(amount*100);
                        amount/=100;
                    }

                }
            }
        }
        return output;
    }
}
