package org.example;
import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {


        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.


        System.out.println("Welcome In Event Planner System \n   " +
                " Plases Choose Role : \n" +
                "1- Admin \n" +
                "2- User \n" +
                "3- Service Provider \n");

        System.out.println("Enter Number 1/2/3 \n");
        Scanner s = new Scanner(System.in);
        int Choose = s.findInLine(".").charAt(0);



        if(Choose == 1){
            System.out.println("Welcome In Admin Page" +
                    " Plases Choose Page : \n" +
                    "1-SignIn/Register \n" +
                    "2-SignUP/Login \n");

            System.out.println("Enter Number 1/2 \n");
            Scanner p = new Scanner(System.in);
            int ChoosePage = p.findInLine(".").charAt(0);

            if(ChoosePage==1){
                // Register Page
            }

            if(ChoosePage==2){
                // Login Page
            }

        }

        if(Choose == 2){
            System.out.println("Welcome In User Page" +
                    " Plases Choose Page : \n" +
                    "1- SignIn/Register \n" +
                    "2- SignUP/Login \n");


            System.out.println("Enter Number 1/2 \n");
            Scanner p = new Scanner(System.in);
            int ChoosePage = p.findInLine(".").charAt(0);


            if(ChoosePage==1){
                // Register Page
            }

            if(ChoosePage==2){
                // Login Page
            }

        }

        if(Choose == 3){
            System.out.println("Welcome In Service Provider Page" +
                    " Plases Choose Page : \n" +
                    "1- SignIn/Register \n" +
                    "2- SignUP/Login \n");


            System.out.println("Enter Number 1/2 \n");
            Scanner p = new Scanner(System.in);
            int ChoosePage = p.findInLine(".").charAt(0);


            if(ChoosePage==1){
                // Register Page
            }

            if(ChoosePage==2){
                // Login Page
            }

            System.out.println("Wasan awwade" );
            System.out.println("Wasan awwade" );




        }

   }
}