package org.example;
import java.util.Iterator;
import java.util.logging.Logger;

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
    public void addServiceProvider(String username,String password,String phoneNember,String email){
        ServiceProvider s=new ServiceProvider();
        s.setUsername(username);
        s.setPassword(password);
        s.setPhoneNum(phoneNember);
        s.setEmail(email);
        setLogged(false);
        Application.servicesProviders.add(s);
    }


    public String deleteServiceProvider(String username, String phoneNumber) {
        Iterator<ServiceProvider> iterator = Application.servicesProviders.iterator();
        while (iterator.hasNext()) {
            ServiceProvider s = iterator.next();
            if (s.getPhoneNum().equals(phoneNumber) && s.getUsername().equals(username)) {
                iterator.remove();
                return "The ServiceProvider is removed";
            }
        }
        return null;
    }
    public void printServiceProviders(){
        String space="     ";
        for(ServiceProvider s: Application.servicesProviders){
            logger.info("Username: "+s.getUsername()+space+"PhoneNumber: "+s.getPhoneNum()+space+"Email: "+s.getEmail());
        }
    }
    public void printUsers(){
        for (User u:Application.users){
            String space="     ";
            logger.info("Username: "+u.getUsername()+space+"PhoneNumber: "+u.getPhoneNum()+space+"Email: "+u.getEmail());
        }
    }
    public void printEvents(){
        String space="   ";
        for(Event e:Application.events) {
            logger.info("Event Title: " + e.getEventTitle()+space +"Location: "+e.getLocation()+space+"Date: "+e.getDate()+space+"Start at: "+e.getStartAt()+space+"End at: "+e.getEndAt()+space+"Number of Invitees: "+e.getNumOfInvitees()+space+"User Name: "+e.getUserName()+space+"Packege Id: "+e.getPackegeId()+space+"Service Provider: "+e.getServiceProviderName());
        }
    }
    }
