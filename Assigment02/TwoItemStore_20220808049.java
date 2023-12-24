import java.util.Scanner;

/**
 * @author İsmail Temüroğlu
 * @since 13.11.2022
 */
public class TwoItemStore_20220808049{
    public static void main(String[] args){
        Scanner input1= new Scanner(System.in);
        System.out.println("****** Store Inventory ******");
        System.out.print("Enter the name of product 1: ");
        String product1= input1.nextLine(); //first product name
        product1 =product1.substring(0,1).toUpperCase()+product1.substring(1).toLowerCase();
        //we want to make our input fist letter upper case and rest lower case
        System.out.printf("Enter the number of %s we have: ",product1);
        int product1number= input1.nextInt(); //number of first product
        int userInputValue1=0; //user's choice for first product
        int userInputValue2=0; //User's choice for the second product
        int userTemp1;
        int userTemp2;
        int choice1=3;// users choice for loop we give 3
        if (product1number<=0){
            System.out.println("ERROR: Value can not be negative. Exiting.");
            //only positive inputs will be accepted
        }


        else {
            System.out.printf("Enter the cost of %s : ", product1);
            float product1cost
                    = input1.nextFloat();//price of the first product

            if (product1cost
                    < 0) {
                System.out.println("ERROR: Value can not be negative. Exiting.");
                //only positive inputs will be accepted
            } else



            //second product
            {
                System.out.print("Enter the name of product 2: ");
                String product2 = input1.next();//second products name
                product2 = product2.substring(0, 1).toUpperCase() + product2.substring(1).toLowerCase();
                System.out.printf("Enter the number of %s we have: ", product2);
                int product2number = input1.nextInt();  //number of second product

                if (product2number < 0) {
                    System.out.println("ERROR: Value can not be negative. Exiting.");
                }
                else {
                    System.out.printf("Enter the cost of %s : ", product2);
                    float product2cost = input1.nextFloat(); //price of the second product
                    if (product2cost<0){
                        System.out.println("ERROR: Value can not be negative. Exiting.");
                    }



                    //USER INTERFACE


                    else {
                        System.out.println("******Costumer User Interface ******");
                        while(choice1!=0){
                            System.out.print("Welcome to our store. We have the following. " +
                                    "Please enter what would you like.");
                            System.out.printf("\n1- %s ", product1);
                            System.out.printf("\n2 %s ", product2);
                            System.out.println("\n0 to checkout");
                            choice1= input1.nextInt();
                            //User choice
                            if (choice1==1 || choice1==2 || choice1==0 ){//other inputs will not be accepted
                                //for first product

                                if (choice1==1)
                                {
                                    System.out.printf("How many %s would you like? ",product1);

                                    userTemp1 =input1.nextInt();
                                    userInputValue1+=userTemp1;

                                    //remaining can not be negative
                                    if ((product1number-userInputValue1)<0) {
                                        System.out.println("Error: We do not have that many remaining.");
                                        userInputValue1-=userTemp1;//to prevent it from always giving an error
                                    }

                                    //entry can not be negative
                                    if (userInputValue1<0){
                                        System.out.println("Error: Invalid requested amount.");
                                        userInputValue1=0;
                                    }
                                }

                                //second product
                                if (choice1==2){
                                    System.out.printf("How many %s would you like? ",product2);
                                    userTemp2=input1.nextInt();
                                    userInputValue2+=userTemp2;


                                    if ((product2number-userInputValue2)<0) {
                                        System.out.println("Error: We do not have that many remaining.");
                                        userInputValue2-=userTemp2;

                                    }
                                    if (userInputValue2<0){
                                        System.out.println("Error: Invalid requested amount.");
                                        userInputValue2=0;
                                    }
                                }
                            }
                            else {//to prevent different entry
                                System.out.println("ERROR: Invalid entry.");
                            }
                        }
                        System.out.println("******Costumer Total******");
                        float total1= userInputValue1*product1cost;
                        float total2= userInputValue2*product2cost;
                        System.out.println(product1+" - "+userInputValue1+" x "+product1cost
                                +" = "+total1);
                        System.out.println(product2+" - "+userInputValue2+" x "+product2cost+" = "+total2);
                        System.out.println("--------------------------------------------");
                        System.out.println("Total due - " + (total1+total2));
                        System.out.println("******Final Report******");
                        System.out.println("We now have the remaining amounts" +
                                " of our products:");
                        System.out.printf("\n%s - %d",product1,(product1number-userInputValue1));
                        System.out.printf("\n%s - %d",product2,(product2number-userInputValue2));
                    }
                }
            }
        }
    }
}
