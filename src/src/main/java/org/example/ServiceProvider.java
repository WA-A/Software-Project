package org.example;



public class ServiceProvider {
    private String username;
    private String password;
    private String email;
    private String phoneNum;
    private boolean isLogged;

public ServiceProvider(){
    username=null;
    password=null;
    email=null;
    phoneNum=null;
}
    public void setLogged(boolean isLogged){
        this.isLogged=isLogged;
    }
    public boolean getLogged(){
        return this.isLogged;
    }
public String getPassword(){
    return this.password;
}
public String getUsername(){
    return this.username;
}
public String getEmail(){
    return this.email;
}
public String getPhoneNum(){
    return this.phoneNum;
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

}
