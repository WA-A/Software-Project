package org.example;



public class venue {
    private int v_id;
    private boolean is_av;
    private int cap;
    private String amen;
    private String loca;
    private int fees;
    private int user_fkc;

    public venue(){


    }
    public venue(boolean f,int c,String am,String l,int fee,int us){
        is_av=f;
        cap=c;
        amen=am;
        loca=l;
        fees=fee;
        user_fkc=us;
    }


    public void set_id(int x){
        v_id = x;
    }

    public void set_av(boolean x){
        is_av = x;
    }
    public void set_cap(int x){
        cap= x;
    }
    public void set_amen(String x){
        amen = x;
    }
    public void set_location(String x){

        loca = x;
    }
    public void set_fees(int x){
        fees = x;
    }

    public void set_user(int x){
        user_fkc = x;
    }
    /////////////////////////
    public int get_id(){
        return v_id;
    }

    public boolean get_av(){
        return is_av ;
    }
    public int get_cap(){
        return cap;
    }
    public String get_amen(){
        return amen ;
    }

    public String get_loca(){

        return loca;
    }

    public int get_fees(){
        return fees;
    }
    public int get_user(){
        return user_fkc ;
    }





}

