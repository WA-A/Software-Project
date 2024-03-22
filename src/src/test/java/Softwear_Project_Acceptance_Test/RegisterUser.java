package Softwear_Project_Acceptance_Test;

import io.cucumber.java.en.Given;
import org.example.UserManagement;

import java.util.Scanner;

public class RegisterUser {

    UserManagement usermanagement;
    public RegisterUser(){
        usermanagement = new UserManagement();
    }

    private String UserEmail;
    private int UserPassword;
    private String UserName;

    private int UserPhone;
    @Given("The user is on the registration page")
    public void the_user_is_on_the_registration_page(String email, Integer password, Integer phone, String name) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Admin Email: ");
        UserEmail = email;
        scanner.nextLine();

        System.out.print("Enter Admin Password: ");
        UserPassword = password ;
        scanner.nextInt();

        System.out.print("Enter Admin Name: ");
        scanner.nextLine();
        UserName = name ;
        scanner.nextLine();

        System.out.print("Enter Admin Phone: ");
        scanner.nextLine();
        UserPhone = phone ;
        scanner.nextLine();


        System.out.println("User registered successfully!");
    }
}
