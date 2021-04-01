package Login;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class loginHandler {
    public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException {
        loginHandler instance=new loginHandler();
        Scanner input= new Scanner(System.in);
        boolean userFound=false;
        while (!userFound){

            String username;
            String password;
            System.out.println("Please enter your username and password");
            System.out.println("Enter Username: ");
            username=input.nextLine();
            System.out.println("Enter password: ");
            password=input.nextLine();
            loginProxy users = new loginProxy();
            String encodedpass = instance.encodePass(password);
            int result=users.checkUser(username,encodedpass);
            if (result==1){
                System.out.println("User Found");
                userFound=true;
            }
            if (result==2){
                System.out.println("Invalid Password!");
            }
            if (result==3){
                System.out.println("Invalid User");
                System.out.println("Create a new User");
                System.out.println("Enter Username: ");
                username=input.nextLine();
                System.out.println("Enter password: ");
                password=input.nextLine();
                String pass = instance.encodePass(password);
                user newUser = new user(username,pass);
                users.insertUser(newUser);
            }
        }
    }

    public String encodePass(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        return new String(digest);
    }

}

