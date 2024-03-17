package org.example;



import java.sql.Date;

public class event {
    private int e_id;
    private String periodofevent;
    private Date dateofevent;
    private int numofguist;
    private String location;
    private String descreption;
    private int user_fk;
    private int venue_fk;
    private int sp_fk;


    public int get_eid() {return e_id;}
    public String get_period() {return periodofevent;}
    public Date get_date() {return dateofevent;}
    public String get_loca() {return location;}
    public int get_num() {return numofguist;}
    public String get_desc() {return descreption;}
    public int get_user_fk() {return user_fk;}
    public int get_venue_fk() {return venue_fk;}
    public int get_sp_fk() {return sp_fk;}

    public void set_eid() {}
    public void set_period() {}
    public void set_date() {}
    public void set_loca() {}
    public void set_num() {}
    public void set_desc() {}
    public void set_user_fk() {}
    public void set_venue_fk() {}
    public void set_sp_fk() {}






}

