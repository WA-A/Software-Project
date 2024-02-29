package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
     System.out.println("Please Choose :- \n" +
             "1- Admin \n" +
             "2- User \n" +
             "3- Service Provider \n");

        Scanner s = new Scanner(System.in);
        int choose = s.nextInt();

        if(choose == 1){
            System.out.println("Hello Admin \n " +
                    "Please Choose " +
                    "Register/SignUp" +
                    "Login/SignIn" );

            Scanner sp = new Scanner(System.in);
            String choosePage = sp.nextLine();

            if(choosePage == "Register/SignUp"){

                // RegisterAdmin
            }
            else if (choosePage == "Login/SignIn") {
                // LoginAdmin
            }

            else{
                System.out.println(" Page Not Found \n" );
            }

        }

        if(choose == 2){
            System.out.println("Hello User \n " +
                    "Please Choose " +
                    "Register/SignUp" +
                    "Login/SignIn" );

            Scanner sp = new Scanner(System.in);
            String choosePage = sp.nextLine();

            if(choosePage =="Register/SignUp"){

                // RegisterUser
            }
            else if (choosePage =="Login/SignIn") {
                // LoginUser
            }

            else{
                System.out.println(" Page Not Found \n" );
            }

        }

        if(choose == 3){
            System.out.println("Hello Service Provider \n " +
                    "Please Choose " +
                    "Register/SignUp" +
                    "Login/SignIn" );

            Scanner sp = new Scanner(System.in);
            String choosePage = sp.nextLine();

            if(choosePage =="Register/SignUp"){

                // RegisterService Provider
            }
            else if (choosePage =="Login/SignIn") {
                // LoginService Provider
            }

            else{
                System.out.println(" Page Not Found \n" );
            }

        }

    }
}