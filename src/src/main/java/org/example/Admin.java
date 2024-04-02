package org.example;
import java.util.Iterator;
import java.util.logging.Logger;

import static org.example.Application.servicesProviders;

public class Admin {
    private String username;
    private String password;
    private boolean isLogged;
    private static final Logger logger = Logger.getLogger(Admin.class.getName());
    public Admin(){
        username=null;
        password=null;
        isLogged=false;
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
    public String addServiceProvider(String username,String password,String phoneNember,String email){


        for(ServiceProvider aa:servicesProviders){
            if(aa.getEmail().equals(email)||aa.getUsername().equals(username)) {
                return "Invalid information, The register failed";
            }
        }
        ServiceProvider s=new ServiceProvider();
        s.setUsername(username);
        s.setPassword(password);
        s.setPhoneNum(phoneNember);
        s.setEmail(email);
        setLogged(false);
        servicesProviders.add(s);
        return "ServiceProvider added successfully";
    }


    public String deleteServiceProvider(String username, String phoneNumber) {
        Iterator<ServiceProvider> iterator = servicesProviders.iterator();
        while (iterator.hasNext()) {
            ServiceProvider s = iterator.next();
            if (s.getPhoneNum().equals(phoneNumber) && s.getUsername().equals(username)) {
                iterator.remove();
                return "The ServiceProvider is removed";
            }
        }
        return null;
    }
    public String printServiceProviders(){
        String space="     ";
        for(ServiceProvider s: servicesProviders){

            logger.info("Username: "+s.getUsername()+space+"PhoneNumber: "+s.getPhoneNum()+space+"Email: "+s.getEmail());
        }
        return "All ServiceProvider has been printed";
    }
    public String printUsers(){
        String space="     ";
        for (User u:Application.users){
            logger.info("Username: "+u.getUsername()+space+"PhoneNumber: "+u.getPhoneNum()+space+"Email: "+u.getEmail());
        }
        return "All users has been printed";
    }
    public String printEvents(){
        String space="   ";
        for(Event e:Application.events) {
            logger.info("Event Title: " + e.getEventTitle()+space +"Location: "+e.getLocation()+space+"Date: "+e.getDate()+space+"Start at: "+e.getStartAt()+space+"End at: "+e.getEndAt()+space+"Number of Invitees: "+e.getNumOfInvitees()+space+"User Name: "+e.getUserName()+space+"Packege Id: "+e.getPackegeId()+space+"Service Provider: "+e.getServiceProviderName());
        }
        return "All events has been printed";
    }

    public String updateServiceProvider(String username, int updateType, String newValue) {
        for (ServiceProvider serviceProvider : servicesProviders) {
            if (serviceProvider.getUsername().equals(username)) {
                if (updateType == 1) {
                    serviceProvider.setPassword(newValue);
                    return "Password updated successfully for " + username;
                } else if (updateType == 2) {
                    serviceProvider.setPhoneNum(newValue);
                    return "Phone number updated successfully for " + username;
                }
            }

        }
        return "Service provider not found";
    }




    }
