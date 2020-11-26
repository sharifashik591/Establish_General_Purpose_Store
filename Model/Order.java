
package Model;

import View.View;
import java.util.Scanner;


public class Order {
    View view = new View();
    Scanner sc = new Scanner(System.in);
     private Database database = new Database();
    
    
    public void orderProduct(String tableName){
        
        view.orderMsg();
        int selected = sc.nextInt();
        view.orderQuantity();
        int quantity = sc.nextInt();
       
        database.orderAddTOCart(tableName, selected, quantity);
         view.orderAdd();
        
    }
    
    public void showOrder(){
        database.showOrderDb("CART");
    }
    public void deleteAllFromCart(){
        database.refreshCart();
    }
    
    public void cancellProduct(){
        int id;
        //database.showOrderDb("CART");
        database.showCartDb();
        view.orderMsg();
        id = sc.nextInt();
        database.deleteProductFromCartDb(id);
        
    }
    
  public void confirmOrder(){
      int slectPaymentProcess;
      String tranId;
      String name;
      String phone;
      String address;
      
      view.selectPaaymentProcessMsg();
      slectPaymentProcess = sc.nextInt();
      sc.nextLine();
      view.transactionIdMsg();
      tranId = sc.nextLine();
      view.paymentConfirmedMsg();
      view.nameInputMsg();
      name = sc.nextLine();
      view.phoneNoInputMsg();
      phone = sc.nextLine();
      view.adressInputMsg();
      address = sc.nextLine();
      
      view.orderConfirmMsg(name, tranId, phone, address);
  }

}
