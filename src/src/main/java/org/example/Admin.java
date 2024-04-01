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
    public String addServiceProvider(String username,String password,String phoneNember,String email){
        ServiceProvider s=new ServiceProvider();
        s.setUsername(username);
        s.setPassword(password);
        s.setPhoneNum(phoneNember);
        s.setEmail(email);
        setLogged(false);
        Application.servicesProviders.add(s);
        return "ServiceProvider added successfully";
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
    public String printServiceProviders() {
        StringBuilder message = new StringBuilder();
        String space = "     ";
        for (ServiceProvider s : Application.servicesProviders) {
            String providerInfo = String.format("Username: %s%sPhoneNumber: %s%sEmail: %s",
                    s.getUsername(), space, s.getPhoneNum(), space, s.getEmail());
            logger.info(providerInfo);
            message.append(providerInfo).append("\n");
        }
        return "All Service Providers have been printed:\n" + message.toString();
    }

    public String printUsers() {
        StringBuilder message = new StringBuilder();
        String space = "     ";
        for (User u : Application.users) {
            String userInfo = String.format("Username: %s%sPhoneNumber: %s%sEmail: %s",
                    u.getUsername(), space, u.getPhoneNum(), space, u.getEmail());
            logger.info(userInfo);
            message.append(userInfo).append("\n");
        }
        return "All users have been printed:\n" + message.toString();
    }

    public String printEvents() {
        StringBuilder message = new StringBuilder();
        String space = "   ";
        for (Event e : Application.events) {
            String eventInfo = String.format("Event Title: %s%sLocation: %s%sDate: %s%sStart at: %s%sEnd at: %s%sNumber of Invitees: %d%sUser Name: %s%sPackege Id: %d%sService Provider: %s",
                    e.getEventTitle(), space, e.getLocation(), space, e.getDate(), space, e.getStartAt(), space, e.getEndAt(), space,
                    e.getNumOfInvitees(), space, e.getUserName(), space, e.getPackegeId(), space, e.getServiceProviderName());
            logger.info(eventInfo);
            message.append(eventInfo).append("\n");
        }
        return "All events have been printed:\n" + message.toString();
    }

}
