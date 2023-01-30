/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package miniproject;

/**
 *
 * @author nusaibaalriyami
 */
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.*; 

public class MiniProject {

    
    public class customer{
        private String cusName;
        private String cusPhoneNum;

    //default Constructor
        public customer(){
            this.cusName = "";
            this.cusPhoneNum = "";
        }

    //parameter Constructor
        public customer(String cusName,String cusPhoneNum){
            this.cusName = cusName;
            this.cusPhoneNum = cusPhoneNum;
        }

    //method to print the bill
        public void printBill() {
            System.out.println("Customer Name: " + cusName);
            System.out.println("Customer Phone Number: " + cusPhoneNum);
        }
    }

    //super class
    public class store{

        private String branchNum;

       //default Constructor
        public store(){
            this.branchNum = "";
        } 

       //parameter Constructor
        public store(String branchNum,String casherName){
            this.branchNum = branchNum;
        } 

        public void printBill() {
            System.out.println("Branch Number: " + branchNum );
        }
    }

    class device extends store {

        private int itemsNum;
        private String itemsName;
        private String itemsID;
        private String Version;
        private int price;

        //default constructor
        public device(){
            this.itemsNum = 0;
            this.itemsName = "";
            this.itemsID = "";
            this.Version = "";
            this.price = 0;
        }

        //parameter constructor
        public device(String branchNum,String casherName, int itemsNum, String itemsName, String itemsID, String Version, int price){
            this.itemsNum = itemsNum;
            this.itemsName = itemsName;
            this.itemsID = itemsID;
            this.Version = Version;
            this.price = price;
        }


        @Override
        public void printBill(){
            System.out.println("The number of items: " + itemsNum);
            System.out.println("Price: " + price);
        }

        public void printItemsInfo(){
            System.out.println("The device name: " + itemsName);
            System.out.println("The device ID: " + itemsID);
            System.out.println("The device version: " + Version);
        }
    }

    /*class Payment extends device {

        private String payMethod;
        private float tax;
        private double netPrice;

        public Payment(){
            this.payMethod = "";
            this.tax = 0;
            this.netPrice = 0;
        }

        public Payment(String branchNum,String casherName, int itemsNum, String itemsName, String itemsID, String Version, int price, String payMethod, float tax, double netPrice){
            this.payMethod = payMethod;
            this.tax = tax;
            this.netPrice = netPrice;
        }

        @Override
        public void printBill(){
            System.out.println("Payment Method: " + payMethod);
            System.out.println("Tax: " + tax);
            System.out.println("NetPrice: " + netPrice);
        }

    }*/


        public static void main(String[] args) {
        String branchNum,casherName,cusName, cusPhoneNum, payMethod, itemsName = null, itemsID = null, Version = null;
        String[] days;
        float tax, sum = 0;
        double netPrice;
        int i, itemsNum, z;
        int price = 0;


        Scanner scanner = new Scanner(System.in);

            System.out.println("Enter branch Number: ");
            branchNum = scanner.next();

            System.out.println("Enter Casher Name: ");
            casherName = scanner.next();

            System.out.println("Enter Customer Name: ");
            cusName = scanner.next();

            System.out.println("Enter Customer phone number: ");
            cusPhoneNum = scanner.next();

            System.out.println("Enter The number of items: ");  
            itemsNum = scanner.nextInt(); 

            System.out.println("This is Comment done by 30th Jan 2022");
            int n =itemsNum;

            for(i=0;i<n;i++)   //loop executes n times  
            {
            System.out.println("Enter the name of device No " + (i+1) + " :");
            itemsName = scanner.next();

            System.out.println("Enter the ID of device No " + (i+1) + " :");
            itemsID = scanner.next();

            System.out.println("Enter the version of device No " + (i+1) + " :");
            Version = scanner.next();

            System.out.println("Enter the Price for device No " + (i+1) + " :");  
            z = scanner.nextInt(); //reads integer from the user   
            sum = price + z;       //calculates sum  
            } 

        customer c;
        //c = new customer(cusName, cusPhoneNum);
        c = new customer();
        store s;
        s = new store(branchNum,casherName);
        device d;
        d = new device(branchNum,casherName,itemsNum,itemsName,itemsID,Version,price);


        System.out.println("----------------Billing System----------------");

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
        Date date = new Date();    
        Calendar calendar = Calendar.getInstance();  

        days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

        System.out.println("Date: "+formatter.format(date)+"  "+days[calendar.get(Calendar.DAY_OF_WEEK) - 1]);  


        c.printBill();
        s.printBill();
        d.printBill();
        d.printItemsInfo();


        System.out.println("The total price is: "+ sum );  

        tax = sum * 5/100;
        System.out.println("Value Added Tax 5%: "+ tax);

        netPrice = sum + tax;
        System.out.println("Your net price is: "+ netPrice);

        if(netPrice <= 100)
        {
            payMethod = "cash";
            System.out.println("Your payment method is: " + payMethod);
        }
        else if(netPrice > 100)
        {
            payMethod ="Credit card";
            System.out.println("Your payment method is: " + payMethod);
        }

        System.out.println("----------------Thank You for Shopping!!-----------------");  
        System.out.println(" ****************Visit Again*******");

     }
 }
