package org.example;

public class Admin {
    private String username;
    private String password;
    private boolean isLogged;
    public Admin(){
        username=null;
        password=null;
        isLogged=false;
    }
   public Admin(String username,String password,boolean isLogged){
        this.username=username;
        this.password=password;
        this.isLogged=isLogged;
    }
public void setUsername(String username){
        this.username=username;
}

    public void setPassword(String password) {
        this.password = password;
    }
    public void setLogged(boolean isLogged){
        this.isLogged=isLogged;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public boolean getLogged(){
        return this.isLogged;
    }
}
