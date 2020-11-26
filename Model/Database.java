/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {

    public static String url = "jdbc:derby://localhost:1527/GenarelShop";
    public static String user = "sharif";
    public static String password = "1234";

    Connection myconObj = null;
    Statement mystatObj = null;
    ResultSet myresObj = null;

    public boolean userLoginCheckDB(String email) {
        boolean chk = false;

        String query = "Select * from USERDATA Where " + "Email = " + "\'" + email + "\'";

        try {

            myconObj = DriverManager.getConnection(url, user, password);
            mystatObj = myconObj.createStatement();
            myresObj = mystatObj.executeQuery(query);

            if (myresObj.next()) {
                chk = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return chk;
    }

    public void userSignUpDB(String name, String pass, String email) {
        String query = "insert into USERDATA(Name, Password, Email)values(?,?,?)";

        try {
            myconObj = DriverManager.getConnection(url, user, password);
            PreparedStatement st = myconObj.prepareStatement(query);

            st.setString(1, name);
            st.setString(2, pass);
            st.setString(3, email);

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public void showProductsFromDB(String tableName){
        
         String query = "Select * from "+tableName;
         
         
         int i=1;
         try {

            myconObj = DriverManager.getConnection(url, user, password);
            mystatObj = myconObj.createStatement();
            myresObj = mystatObj.executeQuery(query);
             System.out.println("\t------------------------------------------------------");
            while(myresObj.next()){
                
               int id = myresObj.getInt(1);
               String nm = myresObj.getString(2);
               String size = myresObj.getString(3);
               int prc = myresObj.getInt(4);
               int discount = myresObj.getInt(5);
               int currentPrice = myresObj.getInt(6);
         
                System.out.println("\t"+id+". "+nm+"\t\t\t"+size+"\t"+prc+"tk"+"\t"+discount+"%"+"\t"+currentPrice+"tk");
                
                
                i++;
            }
            System.out.println("\t------------------------------------------------------");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
         
    } 
    public void orderAddTOCart(String table, int productId, int Quantity){
        
        String query = "Select * from "+table+" WHERE ID = "+productId;
        String nm = null;
        String size = null;
        int prc = 0 ;
        int discount = 0;
        int currentPrice = 0;
        int orderCount;
        int OrderId = 0;
        int SumProductPrice = 0;
        int SumProductCurrentPrice = 0;
        
        
         int i=1;
         try {

            myconObj = DriverManager.getConnection(url, user, password);
            mystatObj = myconObj.createStatement();
            myresObj = mystatObj.executeQuery(query);
            
            while(myresObj.next()){
                
               int id = myresObj.getInt(1);
               nm = myresObj.getString(2);
               size = myresObj.getString(3);
               prc = myresObj.getInt(4);
               discount = myresObj.getInt(5);
               currentPrice = myresObj.getInt(6);
               SumProductCurrentPrice= currentPrice*Quantity;
               SumProductPrice = prc*Quantity;
               
         
         
                
                
                i++;
            }
           
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
         
         int j=1;
            try {
                String query2 = "Select COUNT(Id) from cart";

            myconObj = DriverManager.getConnection(url, user, password);
            mystatObj = myconObj.createStatement();
            myresObj = mystatObj.executeQuery(query2);
             
          
            while(myresObj.next()){
                
               orderCount = myresObj.getInt(1);
               OrderId= orderCount+1;
           
               
                
                j++;
            }
          
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
            
        
        
          String query3 = "insert into CART(Id, Name, Size, Price, Discount, Currentprice, Quantity, SumProductPrice, SumProductCurrentPrice)values(?,?,?,?,?,?,?,?,?)";

        try {
            myconObj = DriverManager.getConnection(url, user, password);
            PreparedStatement st = myconObj.prepareStatement(query3);

            st.setInt(1, OrderId);
            st.setString(2, nm);
            st.setString(3, size);
            st.setInt(4, prc);
            st.setInt(5, discount);
            st.setInt(6, currentPrice);
            st.setInt(7, Quantity);
            st.setInt(8, SumProductPrice);
            st.setInt(9, SumProductCurrentPrice);

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
         
         
    }
    

    
    public void refreshCart(){
        try {
                String query = "DELETE FROM cart";

            myconObj = DriverManager.getConnection(url, user, password);
           PreparedStatement st = myconObj.prepareStatement(query);
            st.executeUpdate();
             
          
           
          
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showOrderDb(String tableName){
            
             
            int TotallBill = 0;
            int TotallPrice = 0;
            int GetDiscount;

         
               int j=1;
            try {
                String query2 = "Select SUM(SumProductCurrentPrice) from cart";

            myconObj = DriverManager.getConnection(url, user, password);
            mystatObj = myconObj.createStatement();
            myresObj = mystatObj.executeQuery(query2);
             
            while(myresObj.next()){
                
               TotallBill = myresObj.getInt(1);  
                j++;
            }
          
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

            
            

         
               int k=1;
            try {
                String query3 = "Select SUM(SumProductPrice) from cart";

            myconObj = DriverManager.getConnection(url, user, password);
            mystatObj = myconObj.createStatement();
            myresObj = mystatObj.executeQuery(query3);
             
            while(myresObj.next()){
                
               TotallPrice = myresObj.getInt(1);  
                k++;
            }
          
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
         
        
          String query = "Select * from "+tableName;    
            
         int i=1;
         try {

            myconObj = DriverManager.getConnection(url, user, password);
            mystatObj = myconObj.createStatement();
            myresObj = mystatObj.executeQuery(query);
             System.out.println("\t----------------------------------------------------------------");
             System.out.println("\t Name\t\t\tSize  Quantity \t\t    TotallPrice");
            while(myresObj.next()){
                
               int id = myresObj.getInt(1);
               String nm = myresObj.getString(2);
               String size = myresObj.getString(3);
               int prc = myresObj.getInt(4);
               int discount = myresObj.getInt(5);
               int currentPrice = myresObj.getInt(6);
               int quantity = myresObj.getInt(7);
               int SumProductPrice = myresObj.getInt(8);
         
                System.out.println("\t"+id+". "+nm+"\t\t"+size+"\t"+quantity+"\t\t\t"+SumProductPrice+"tk");
                
                
                
                i++;
            }
            System.out.println("\t----------------------------------------------------------------");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
         System.out.println("\t TotallPrice\t\t\t\t\t\t  ="+TotallPrice);
         GetDiscount= TotallBill-TotallPrice;
         System.out.println("\t Discount\t\t\t\t\t\t  ="+GetDiscount);
         System.out.println("\t----------------------------------------------------------------");
         System.out.println("\tTotallBill\t\t\t\t\t\t  ="+TotallBill);
    }
    
    
    public void showCartDb(){
        String query = "Select * from Cart";
        
         int i=1;
         try {

            myconObj = DriverManager.getConnection(url, user, password);
            mystatObj = myconObj.createStatement();
            myresObj = mystatObj.executeQuery(query);
             System.out.println("\t----------------------------------------------------------------");
            while(myresObj.next()){
                
               int id = myresObj.getInt(1);
               String nm = myresObj.getString(2);
               String size = myresObj.getString(3);
               int prc = myresObj.getInt(4);
               int discount = myresObj.getInt(5);
               int currentPrice = myresObj.getInt(6);
         
                System.out.println("\t"+id+". "+nm+"\t\t\t"+size+"\t"+prc+"tk"+"\t"+discount+"%"+"\t"+currentPrice+"tk");
                
                
                
                i++;
            }
            System.out.println("\t----------------------------------------------------------------");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void deleteProductFromCartDb(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
