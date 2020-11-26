/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Scanner;


public class View {

    int choice;
    public static Scanner sc = new Scanner(System.in);

    public int firstPage() {
      
        System.out.println("Welcome JGPS");
        System.out.println(" Select anyone from below:");
        System.out.println(" 1. Login\n"
                + " 2. Sign Up\n"
                + "3. Exit");
        System.out.println(" Enter your choice: ");
        choice = sc.nextInt();

        return choice;

    }

    public int viewOptions() {
       
        System.out.println("\t Select anyone from below:\n");
        System.out.println("\t 1. Go to categories and select products\n"
                + "\t 2. Order selected products\n"
                + "\t 3. LOG OUT");
        System.out.println("Enter your choice: ");
        choice = sc.nextInt();

        return choice;

    }
    
    public int orderSelectedProduct(){

        System.out.println("\t Select Option from below: \n");
        System.out.println("\t 1. See Order\n"
                + "\t 2. Delete A product from cart\n"
                + "\t 3. Delete All Product From Cart\n"
                + "\t 4. Confirm Your Order\n"
                + "\t 5. Back");
        System.out.println("Enter your choice: ");
        choice = sc.nextInt();

        return choice;
        
    }

    public int showCategories() {

        System.out.println("\t Select any category \n");
        System.out.println("\t 1. Grocery Items\n"
                + "\t 2. Electronics Items\n"
                + "\t 3. Sports Items\n"
                + "\t 4. Cosmetics\n"
                + "\t 5. Miscellaneous\n"
                + "\t 6. Return to previous menu\n");

        System.out.println("Enter your choice: ");
        choice = sc.nextInt();

        return choice;
    }
    
    
    
    public int showGroceryItems(){

        System.out.println("\t Select any Grocery item: \n");
        System.out.println("\t 1. Soybean Oil\n"
                + "\t 2. Fish\n"
                + "\t 3. Meat\n"
                + "\t 4. Bakery\n"
                + "\t 5. Return to previous menu\n");
        System.out.println("Enter your choice: ");
        choice = sc.nextInt();

        return choice;
    }
    
    public int showElectronicsItems(){

        
        System.out.println("\t Select any Electronics item: \n");
        System.out.println("\t 1. Phone\n"
                + "\t 2. Laptop\n"
                + "\t 3. TV\n"
                + "\t 4. Light\n"
                + "\t 5. Return to previous menu\n");

        System.out.println("Enter your choice: ");
        choice = sc.nextInt();

        return choice;
    }
    
      public int showSportsItems(){

        System.out.println("\t Select any Sports item: \n");
        System.out.println("\t 1. Hocky\n"
                + "\t 2. Cricket\n"
                + "\t 3. Football\n"
                + "\t 4. Badminton\n"
                + "\t 5. Return to previous menu\n");
        System.out.println("Enter your choice: ");
        choice = sc.nextInt();

        return choice;
    }
    
      public int showCosmeticsItems(){

        System.out.println("\t Select any Cosmetics item: \n");
        System.out.println("\t 1. Male\n"
                + "\t 2. Female\n"
                + "\t 3. Return to previous menu\n");
        System.out.println("Enter your choice: ");
        choice = sc.nextInt();

        return choice;
    }
    
        public int showMiscellaneousItems(){

        System.out.println("\t Select any Miscellaneous item: \n");
        System.out.println("\t 1. licenses\n"
                + "\t 2. Books\n"
                + "\t 3. Return to previous menu\n");
        System.out.println("Enter your choice: ");
        choice = sc.nextInt();

        return choice;
    }

    public void loginSuccessMsg() {
        System.out.println("\t <<<Login Successful!!!>>> \n");
    }

    public void loginUnsuccessfulMsg() {
        System.out.println("\t >>>Login Failed.!!!"
                + "You need to sign up first!!!<<< \n");
    }

    public void signUpSuccessMsg() {
        System.out.println("\t <<<Sign up successfull, you can login now!!>>> \n");
    }
    
    public void orderMsg(){
        System.out.println("\t Select product: ");
    }
    public void orderQuantity(){
        System.out.println("\t Enter Quantity: ");
    }
    
      public void orderAdd(){
        System.out.println("\t##### Product Add In your Cart#####");
    }
        public void cartWasEmpty(){
        System.out.println("\t##### Cart Is Empty Now####");
    }
        public void productWasDeleted(){
            System.out.println("\t##### Selected Product Was Deleted####");
        }
    public void nameInputMsg(){
        System.out.println("\t Enter your name: ");
    }
    public void selectPaaymentProcessMsg(){
        System.out.println("\t SelectAny Payment Process");
        System.out.println("\t 1.bKash (01234102030, Ref: 234)\n"
                           +"\t 2.Rocket (012341020301)");
        
    }
    public void transactionIdMsg(){
       System.out.println("\t Enter Transaction Id:");
    }
    public void paymentConfirmedMsg(){
        System.out.println("\t <<<Your payment is confirmed>>>");
    }
    public void adressInputMsg(){
        System.out.println("\t Enter Your Address:");
        
    }
    
    public void phoneNoInputMsg(){
        System.out.println("\t Enter Your Phone NO: ");
    }
    public void orderConfirmMsg(String name, String tranId, String phone, String address){
       
        System.out.println("\t      ORDER DETAIL");
        System.out.println("\t Name: "+name);
        System.out.println("\t Transaction Id: "+tranId);
        System.out.println("\t Phone: "+phone);
        System.out.println("\t Address: "+address+"\n");
        System.out.println("Contact this number(01944896737) for delivery updates.");
    }

}
