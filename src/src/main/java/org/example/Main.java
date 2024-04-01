package org.example;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    private static final Logger LOGGER =  Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

/*
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
            System.out.println("Wasan awwade wasaan batool" );

            Application x=new Application();
ServiceProvider ap= new ServiceProvider();
ap = x.checkServiceProvider("abdullah","112233");
System.out.println(ap.showMyPackeges("abdullah"));*/


        Application x = new Application();

        Admin w = new Admin();
        w = x.checkAdmin("wasan", "123456");
        w.printEvents();
        for (Calender c : Application.calenders) {
            LOGGER.info("Event Title: " + c.getEventTitle() + "Date: " + c.getDate() + "Start At: " + c.getStartAt() + "End At: " + c.getEndAt());
        }
        User u = new User();
        u = x.checkUser("ghazi", "345345");
        String Title = "Meeting 1";
        int budget = 6000;
        String location = "Nablus";
        int invitees = 180;
        String date = "10/12/2022";
        String start = "08:00";
        String end = "10:00";
        String m = u.creatEvent(Title, budget, location, invitees, date, start, end);
        LOGGER.info("Enter the Packege Id");
        Scanner s=new Scanner(System.in);
        int packegeId=s.nextInt();
        u.choosePackege(packegeId);
        u.showMyEvents(u.getUsername());


    }

   }
