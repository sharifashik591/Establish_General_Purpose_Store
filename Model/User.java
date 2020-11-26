
package Model;

import View.View;
import java.util.Scanner;


public class User {
    private String name;
    private String password;
    private String email;
    
    private View view = new View();
    
    private Scanner sc = new Scanner(System.in);

    private Database database = new Database();
    
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    
    public boolean userLogin(){
        boolean check = false;
        
        String email, password;
        System.out.println("Enter your email: ");
        email = sc.nextLine();
        System.out.println("Enter your password: ");
        password = sc.nextLine();
        if(database.userLoginCheckDB(email)==true)check=true;
        
        return check;
    }
    
    public void userSignUp(){
        String nm, pass, email2;
        view.nameInputMsg();
        nm = sc.nextLine();
        System.out.println("Enter your password: ");
        pass = sc.nextLine();
        System.out.println("Enter your email: ");
        email2 = sc.nextLine();
        database.userSignUpDB(nm, pass, email2);
    }
    
    
}
