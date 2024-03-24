package org.example;

public class Packege {
    private int id;
    private int price;
    private int capacity;
    private String location;
    private String placeName;
    private String servicesDes;
    private String  serviceProviderName;

    public Packege(){
        id=0;
        price=0;
        capacity=0;
        location=null;
        servicesDes=null;
        serviceProviderName=null;
         placeName = null;
    }
    public Packege(int id, int price, int capacity, String location, String placeName, String servicesDes, String serviceProviderName){
        this.id=id;
        this.placeName=placeName;
        this.location=location;
        this.capacity=capacity;
        this.price=price;
        this.serviceProviderName=serviceProviderName;
        this.servicesDes=servicesDes;
    }
public int getId(){
        return this.id;
}
public int getPrice(){
        return this.price;
}
public int getCapacity(){
        return this.capacity;
}
public String getLocation(){
        return this.location;
}
public String getPlace_name(){
        return this.placeName;
}
public String getServicesProvider_name(){
        return this.serviceProviderName;
}
public String getServices_des(){
        return this.servicesDes;
}
public void setId(int id){
        this.id=id;
}
public void setPrice(int price){
        this.price=price;
}
public void setCapacity(int capacity){
        this.capacity=capacity;
}
public void setLocation(String location){
        this.location=location;
}
public void setPlace_name(String placeName){
        this.placeName=placeName;
}
public void setServices_des(String servicesDes){
        this.servicesDes=servicesDes;
}
public void setServiceProvider_name(String serviceProviderName){
        this.serviceProviderName=serviceProviderName;
}
}
