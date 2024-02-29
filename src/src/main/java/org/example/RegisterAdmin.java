package org.example;
import io.cucumber.java.en.When;

import java.util.Scanner;

public class RegisterAdmin {

    AdminManagement adminmanagement;
    public RegisterAdmin(){
        adminmanagement = new AdminManagement();
    }

    private String AdminEmail;
    private int AdminPassword;
    private String AdminName;

    private int AdminPhone;

    @When("The admin enters wasan2020@gmail.com , {int} , {int} , <Admin-Name>")
    public void the_admin_enters_wasan2020_gmail_com_admin_name(String email, Integer password, Integer phone, String name) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Admin Email: ");
        AdminEmail = email;
        scanner.nextLine();

        System.out.print("Enter Admin Password: ");
        AdminPassword = password ;
        scanner.nextInt();

        System.out.print("Enter Admin Name: ");
        scanner.nextLine();
        AdminName = name ;
        scanner.nextLine();

        System.out.print("Enter Admin Phone: ");
        scanner.nextLine();
        AdminPhone = phone ;
        scanner.nextLine();


        System.out.println("Admin registered successfully!");
    }

    @When("The admin enters an existing wasan2020@gmail.com ,a valid  password {int} and  phone {int} and user name <Admin-Name>")
    public void the_admin_enters_an_existing_wasan2020_gmail_com_a_valid_password_and_phone_and_user_name_admin_name(String email, Integer password, Integer phone, String name) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Admin Email: ");
        AdminEmail = email;
        scanner.nextLine();

        System.out.print("Enter Admin Password: ");
        AdminPassword = password ;
        scanner.nextInt();

        System.out.print("Enter Admin Name: ");
        scanner.nextLine();
        AdminName = name ;
        scanner.nextLine();

        System.out.print("Enter Admin Phone: ");
        scanner.nextLine();
        AdminPhone = phone ;
        scanner.nextLine();

        if(email == "<E-mail>"){
            System.out.println("the Email is already taken!");
        }


    }
}
