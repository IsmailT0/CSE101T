import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * @author İsmail Temüroğlu
 * @since 20.12.2022
 * */

public class StoreUsingFile_20220808049 {
    public static void main(String []  args)throws Exception{
        String fileName = args[0];
        int length = countProducts(fileName +"_ProductInfo.txt");

        String [] itemID = new String[length];
        String [] itemName= new String[length];
        int [] quantity = new int[length];
        double [] price = new double[length];
        getProductInfo(itemID,itemName,quantity,price,fileName+"_ProductInfo.txt");

        int length2 = countProducts(fileName +"_Order.txt");

        //for taking order
        Scanner input1 = new Scanner(new File(fileName +"_Order.txt"));
        String[] itemID2= new String[length2];
        int[] quantity2 = new int[length2];
        int index=0;
        while (input1.hasNextLine()){
            itemID2[index] = input1.next();
            quantity2[index] = input1.nextInt();
            index++;
        }
        PrintWriter printWriter = new PrintWriter(fileName +"_log.txt");
        double[] payment =new double[length];//use index products
        int[] requested = new int[length];//same thing
        boolean a = true;


        for (int i=0;i<length2;i++){
            for (int j=0;j<length;j++){
                if (itemID2[i].equals(itemID[j])){
                    if (quantity2[i]>=0){
                        if(quantity2[i]<=quantity[j] ){
                            quantity[j] -= quantity2[i];
                            payment[j] = quantity2[i] * price[j];
                            requested[j] += quantity2[i];
                        }
                        else {
                            printWriter.printf("ERROR: %s - %d requested but only" +
                                            " %d remaining.\n",itemName[j],quantity2[i]
                                    ,quantity[j]);
                        }

                    }else {
                        printWriter.printf("ERROR: Invalid amount requested(%d)\n",quantity2[i]);
                    }
                    a = true;
                    break;

                }else {
                    a= false;
                }

            }

            if (!a){
                printWriter.print("ERROR: " + itemID2[i] + " not found.\n");
            }
        }
        printWriter.close();

        writeProductInfo(itemID,itemName,quantity,price,fileName +"_ProductAfterOrder.txt");
        PrintWriter printWriter1 = new PrintWriter(fileName +"_Receipt.txt");
        printWriter1.println("***********CUSTOMER RECEIPT**********");
        double totalDue = 0;
        for(int i = 0; i < payment.length; i++){
            if(payment[i] != 0){
                printWriter1.printf("%s (%s) - %d * %8f.2 = %8f.2\n",itemName[i],
                        itemID[i] ,requested[i],price[i] ,payment[i]);

                totalDue += payment[i];
            }
        }
        printWriter1.println("-------------------------------------\n");
        printWriter1.println("total due - " + totalDue);
        printWriter1.close();

    }




    public static int countProducts(String fileName) throws Exception {

        Scanner inputFromFile = new Scanner(new File(fileName));
        int count =0;
        while (inputFromFile.hasNextLine()) {
            count++;
            inputFromFile.nextLine();
        }
        return count;
    }
    public static void getProductInfo(String[] itemID,String [] itemName,
                                      int [] quantity,double [] price,String fileName)throws Exception{
        Scanner inputFromFile = new Scanner(new File(fileName));
        int counter =0;
        while (inputFromFile.hasNextLine()){

            itemID[counter] = inputFromFile.next();
            itemName[counter] = inputFromFile.next();
            quantity[counter] = inputFromFile.nextInt();
            price[counter] = inputFromFile.nextDouble();
            counter++;
        }
    }
    public static void writeProductInfo(String[] itemID,String [] itemName,
                                        int [] quantity,double [] price, String fileName) throws Exception{
        PrintWriter printWriter = new PrintWriter(fileName );
        for(int i = 0; i < itemID.length; i++){
            printWriter.println(itemID[i]+" " +  itemName[i]+" " + quantity[i]+" "+ price[i]);
        }
        printWriter.close();
    }

}


