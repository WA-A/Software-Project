package org.example;



import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Application {

    private venue v;
    private users u;
    private event e;
    /////////////////////////////////////
    private boolean flag;

    private String WhoLogIn;
    private boolean is_venue_av;
    private boolean is_venue_cap;
    private boolean is_venue_time=true;
    private boolean is_overlap;

////////////////////////////////////



    public boolean get_is_venue_av(){
        return is_venue_av;
    }

    public boolean get_is_venue_cap() {
        return is_venue_cap;
    }

    public void SetWhoLogIn(String t){
        WhoLogIn=t;
    }

    public boolean getWhoLogIn(){
        return WhoLogIn.equals("users");
    }

    public boolean get_is_venue_time(){
        return is_venue_time;
    }

    public boolean book_venue(int event_id,boolean av1,boolean t1,boolean cap1){
        if(av1&&t1&&cap1){
            return true;
            //booking venue by id of event_id
        }
        return false;
    }
    public boolean Does_venue_av(int v_number){

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String userDB ="postgres";
        String passwordDB="12345";

        String st_venue = "select * from venue";
        try {
            Connection con_venue=DriverManager.getConnection(url,userDB,passwordDB);;
            Statement statement_venue=con_venue.createStatement();
            ResultSet rs_venue = statement_venue.executeQuery(st_venue);

            while(rs_venue.next()){
                if(rs_venue.getString(1).equals(Integer.toString(v_number)))
                {

                    if(is_venue_av=rs_venue.getBoolean(2)){
                        return true;
                    }

                }

            }
            return false;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }


    }


    public boolean Does_venue_time(int v_number,String d,int start_at,int end_at){


        String url = "jdbc:postgresql://localhost:5432/postgres";
        String userDB ="postgres";
        String passwordDB="12345";
        String st_event = "select * from event";

        String st_calender = "select * from calender";




        try {
            Connection con_event=DriverManager.getConnection(url,userDB,passwordDB);;
            Statement statement_event=con_event.createStatement();
            ResultSet rs_event = statement_event.executeQuery(st_event);

            Connection con_calender=DriverManager.getConnection(url,userDB,passwordDB);;
            Statement statement_calender=con_calender.createStatement();
            ResultSet rs_calender = statement_calender.executeQuery(st_calender);



            while(rs_event.next()) {

                int x1=rs_event.getInt(8);
                int x2=rs_event.getInt(1);

                if(x1 == v_number) {
                    while(rs_calender.next()){
                        JOptionPane.showMessageDialog(null,"this is start while rs_cal");

                        if(rs_calender.getInt(5)==x2){
                            String sDateCalender=rs_calender.getString(2);


                            if((start_at<end_at)&&(sDateCalender.equals(d))){


                                String sStartCalender=rs_calender.getString(3);
                                String sEndCalender=rs_calender.getString(4);

                                String s31=sStartCalender.substring(0,2);
                                int cStart = Integer.parseInt(s31);
                                String s41=sEndCalender.substring(0,2);
                                int cEnd=Integer.parseInt(s41);


                                //IntRang interval = new IntRang(cStart,cEnd);

                                if(((end_at<cEnd)&&(cStart<end_at))||((cStart<start_at)&&(cEnd>start_at)||(cEnd<=end_at)&&(cStart>=start_at))){
                                    is_venue_time=false;
                                    return false;
                                }

                            }
                        }
                    }
                }
            }

            return false;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }


    }

    public boolean Does_venue_capasity(int v_number,int guist_number){

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String userDB ="postgres";
        String passwordDB="12345";
        String st_venue = "select * from venue";


        try {

            Connection con_venue=DriverManager.getConnection(url,userDB,passwordDB);;
            Statement statement_venue=con_venue.createStatement();
            ResultSet rs_venue = statement_venue.executeQuery(st_venue);


            while(rs_venue.next()){

                if(rs_venue.getInt(1) == v_number){
                    JOptionPane.showMessageDialog(null,rs_venue.getInt(3)+"   "+guist_number);
                    if(rs_venue.getInt(3)>guist_number){

                        is_venue_cap = true;
                        return true;
                    }
                }
            }
            return false;


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;

        }










    }

}
