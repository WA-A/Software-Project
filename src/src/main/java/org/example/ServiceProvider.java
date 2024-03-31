package org.example;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class ServiceProvider {
    private String username;
    private String password;
    private String email;
    private String phoneNum;
    private boolean isLogged;
    private static final Logger LOGGER = Logger.getLogger(ServiceProvider.class.getName());

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
    public String addPackage(int packegeId,int price,int capacity,String location ,String placeName,String description,String serProNme) {
        Packege p=new Packege();
        p.setId(packegeId);
        p.setPrice(price);
        p.setPlaceName(placeName);
        p.setCapacity(capacity);
        p.setServicesDes(description);
        p.setServiceProviderName(serProNme);
        p.setLocation(location);
        Application.packeges.add(p);
        return "package added successfully";
    }

    public String removePackage(int packegeId) {
        Iterator<Packege> iterator = Application.packeges.iterator();
        while (iterator.hasNext()) {
            Packege p = iterator.next();
            if (p.getId()== packegeId) {
                iterator.remove();
                return "The Packege is removed";
            }
        }
        return "package not found" ;
    }

    public String updatePackage(int id, int updateType, String newValue) {
        boolean updated = false;

        for (Packege pkg : Application.packeges) {
            if (pkg.getId() == id) {
                switch (updateType) {
                    case 1:
                        updatePrice(pkg, newValue);
                        updated = true;
                        break;
                    case 2:
                        updateCapacity(pkg, newValue);
                        updated = true;
                        break;
                    case 3:
                        updateLocation(pkg, newValue);
                        updated = true;
                        break;
                    case 4:
                        updatePlaceName(pkg, newValue);
                        updated = true;
                        break;
                    case 5:
                        updateServicesDes(pkg, newValue);
                        updated = true;
                        break;
                    case 6:
                        updateServiceProviderName(pkg, newValue);
                        updated = true;
                        break;
                    default:
                        LOGGER.warning("Invalid option. Please try again.");
                        return "Invalid update option provided.";
                }
                return updated ? "Package updated successfully." : "No updates made.";
            }
        }
        return "Package not found.";
    }

    private void updatePrice(Packege pkg, String newValue) {
        pkg.setPrice(Integer.parseInt(newValue));

    }

    private void updateCapacity(Packege pkg, String newValue) {
        pkg.setCapacity(Integer.parseInt(newValue));

    }

    private void updateLocation(Packege pkg, String newValue) {
        pkg.setLocation(newValue);

    }

    private String updatePlaceName(Packege pkg, String newValue) {
        pkg.setPlaceName(newValue);
        return "Place name updated successfully";
    }

    private void updateServicesDes(Packege pkg, String newValue) {
        pkg.setServicesDes(newValue);

    }

    private void updateServiceProviderName(Packege pkg, String newValue) {
        pkg.setServiceProviderName(newValue);

    }


public String showMyPackeges(String username){
    List<Packege> pack=new ArrayList<>();
    boolean flage= false;
    String space="    ";
    for(Packege p:Application.packeges){
        if(p.getServicesProviderName().equals(username)){
            flage=true;
            pack.add(p);
        }
    }
    for(Packege p: pack){
        LOGGER.info("Packege Id: "+p.getId()+space+"Place Name: "+p.getPlaceName()+space+"Location: "+p.getLocation()+space+"Capacity: "+p.getCapacity()+space+"Packege Price: "+p.getPrice()+space+"Services: "+p.getServicesDes()+space+"Service Provider: "+p.getServicesProviderName());
    }
    return flage?"There are packages":"No packages found";
}
public String showMyTasks(String username){
    boolean flage= false;
    List<Calender> cal=new ArrayList<>();
    String space="    ";
    for(Calender c:Application.calenders){
        if(c.getServiceProviderName().equals(username)){
            flage=true;
            cal.add(c);
        }
    }
    for(Calender c: cal){
        LOGGER.info("Event Title: "+c.getEventTitle()+space+"Date: "+c.getDate()+space+"Start At: "+c.getStartAt()+space+"End At: "+c.getEndAt()+space+"Packege Id: "+c.getPackegeId());
    }
    return flage?"There are tasks":"No tasks found";
}
public String showMessages(String servceProviderName){
    boolean flage= false;
    for(Message m:Application.messages){
        if(m.getServiceProviderName().equals(servceProviderName)) {
            flage=true;
            LOGGER.info(m.getMessage());
        }
    }
    return flage?"There are massages":"No massages found";
}

}
