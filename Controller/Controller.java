/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Order;
import Model.Product;
import Model.User;
import View.View;

public class Controller {

    View view = new View();
    User user = new User();
    Product product = new Product();
    Order order = new Order();

    public void run() {
        int choice = view.firstPage();

        switch (choice) {
            case 1:
                if (user.userLogin() == true) {
                    view.loginSuccessMsg();
                    this.optionPage();
                } else {
                    view.loginUnsuccessfulMsg();
                }
                break;
            case 2:
                user.userSignUp();
                view.signUpSuccessMsg();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                return;
        }
        this.run();
    }

    public void optionPage() {
        int choice = view.viewOptions();

        switch (choice) {
            case 1:
                this.categoryPage();
                break;
            case 2:
                this.orderSelectedProduct();
                break;
            case 3:
                this.run();
                break;
            default:
                return;
        }
        this.optionPage();
    }

    public void categoryPage() {
        int choice = view.showCategories();

        switch (choice) {
            case 1: this.groceryPage();
                break;
            case 2:
                this.electronicsPage();
                break;
            case 3:
                this.sportsPage();
                break;
            case 4:
                this.cosmeticsPage();
                break;
            case 5:
                this.miscellaneousPage();
                break;
            case 6:
                this.optionPage();
                break;
            default:
                return;
        }
        this.categoryPage();

    }
      public void orderSelectedProduct() {
        int choice = view.orderSelectedProduct();

        switch (choice) {
            case 1: 
                order.showOrder();
                break;
            case 2:
                order.cancellProduct();
                view.productWasDeleted();
                break;
            case 3:
                order.deleteAllFromCart();
                view.cartWasEmpty();
                break;
            case 4:
                order.confirmOrder();
                break;
          
            case 5:
               this.optionPage();
                break;
            default:
                return;
        }
        this.orderSelectedProduct();

    }
    
    public void groceryPage(){
        int choice = view.showGroceryItems();
        
        switch (choice) {
            case 1: 
                product.showProducts("SoybeanOil");
                order.orderProduct("SoybeanOil");
                break;
            case 2:
                product.showProducts("Fish");
                 order.orderProduct("Fish");
                break;
            case 3:
                product.showProducts("Meat");
                   order.orderProduct("Meat");  
                break;
            case 4:
                product.showProducts("Bakery");
                  order.orderProduct("Bakery");
                break;
           
            case 5:
                this.categoryPage();
                break;
            default:
                return;
        }
        this.groceryPage();

    
    }
    
        public void electronicsPage(){
        int choice = view.showElectronicsItems();
        
        switch (choice) {
            case 1: 
                product.showProducts("Phone");
                order.orderProduct("Phone");
                break;
            case 2:
                product.showProducts("Laptop");
                 order.orderProduct("Laptop");
                break;
            case 3:
                product.showProducts("TV");
                   order.orderProduct("TV");  
                break;
            case 4:
                product.showProducts("Light");
                  order.orderProduct("Light");
                break;
           
            case 5:
                this.categoryPage();
                break;
            default:
                return;
        }
        this.electronicsPage();

    
    }
        
        
          public void sportsPage(){
        int choice = view.showSportsItems();
        
        switch (choice) {
            case 1: 
                product.showProducts("Hocky");
                order.orderProduct("Hocky");
                break;
            case 2:
                product.showProducts("Cricket");
                 order.orderProduct("Cricket");
                break;
            case 3:
                product.showProducts("Football");
                   order.orderProduct("Football");  
                break;
            case 4:
                product.showProducts("Badminton");
                  order.orderProduct("Badminton");
                break;
           
            case 5:
                this.categoryPage();
                break;
            default:
                return;
        }
        this.sportsPage();

    
    }
    
          
                    public void cosmeticsPage(){
        int choice = view.showCosmeticsItems();
        
        switch (choice) {
            case 1: 
                product.showProducts("MaleItem");
                order.orderProduct("MaleItem");
                break;
            case 2:
                product.showProducts("FemaleItem");
                 order.orderProduct("FemaleItem");
                break;
       
            case 3:
                this.categoryPage();
                break;
            default:
                return;
        }
        this.cosmeticsPage();

    
    }
    
        public void miscellaneousPage(){
        int choice = view.showMiscellaneousItems();
        
        switch (choice) {
            case 1: 
                product.showProducts("Licenses");
                order.orderProduct("Licenses");
                break;
            case 2:
                product.showProducts("Books");
                 order.orderProduct("Books");
                break;
       
            case 3:
                this.categoryPage();
                break;
            default:
                return;
        }
        this.miscellaneousPage();

    
    }
     
        
    

}
