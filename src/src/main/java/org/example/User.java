package org.example;

public class User{
    private String username;
    private String password;
    private String email;
    private String phoneNum;
    private boolean isLogged;



public User(){
    username=null;
    password=null;
    email=null;
    phoneNum=null;
}
public User(String username,String password,String email,String phoneNum){
    this.username=username;
    this.password=password;
    this.email=email;
    this.phoneNum=phoneNum;
}
    public void setLogged(boolean isLogged){
        this.isLogged=isLogged;
    }
    public boolean getLogged(){
        return this.isLogged;
    }
public void setUsername(String username){
    this.username=username;
}
public void setPassword(String password){
    this.password=password;
}
public void setEmail(String email){
    this.email=email;
}
public void setPhoneNum(String phoneNum){
    this.phoneNum=phoneNum;
}
public String getUsername(){
    return this.username;
}
public String getPassword(){
    return this.password;
}
public String getEmail(){
    return this.email;
}
public String getPhoneNum(){
    return this.phoneNum;
}
}