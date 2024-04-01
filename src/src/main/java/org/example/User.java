package org.example;

import java.text.MessageFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class User{
    private String username;
    private String password;
    private String email;
    private String phoneNum;
    private boolean isLogged;
    private static final Logger LOGGER = Logger.getLogger(User.class.getName());
    private static final List<Packege> packegesAfterFilter = new ArrayList<>();
    private static final List<Event> currentEvent= new ArrayList<>();



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
    public String creatEvent(String eventT,int b,String loc,int numInvite,String d,String startTime,String endTime){
        String eventTitle=eventT;
        int budget = b;
        List<Packege> packAfterBud= filterByBudget(budget);
        if(packAfterBud.isEmpty()){
            return "We do not have a package with the same or lower budget than you entered";
        }
        String location=loc;
        List<Packege> packAfterLoc=filterByLocation(packAfterBud,location);
        if(packAfterLoc.isEmpty()){
            return "We do not have a package with the same location";
        }
        int numInvitees=numInvite;
        List<Packege> packAfterCapacity=filterByCapacity(packAfterLoc,numInvitees);
        if(packAfterCapacity.isEmpty()){
            return "We do not have a package with the same Capacity";
        }
        String date=d;
        String startAt=startTime;
        String endAt=endTime;
        List<Packege> packAfterTime= filterByStartTime(packAfterCapacity,date,startAt);
        if(packAfterTime.isEmpty()){
            return "This day at this time is unavailable";
        }

        for (Packege p: packAfterTime){
            packegesAfterFilter.add(p);
            String logMessage = MessageFormat.format(
                    "Package Id: {0}    Place Name: {1}    Location: {2}    Capacity: {3}    Package Price: {4}    Services: {5}    Service Provider: {6}",
                    p.getId(), p.getPlaceName(), p.getLocation(), p.getCapacity(), p.getPrice(), p.getServicesDes(), p.getServicesProviderName());
            LOGGER.info(logMessage);
        }
        String space="   ";
        Event e=new Event();
        e.setEventTitle(eventTitle);
        e.setUserName(this.getUsername());
        e.setLocation(location);
        e.setDate(date);
        e.setNumOfInvitees(numInvitees);
        e.setStartAt(startAt);
        e.setEndAt(endAt);
        currentEvent.add(e);

        return "Please enter the Packege Id that you want to approve: ";
    }
    public String choosePackage(int packId) {
        String serviceProviderName = null;

        for (Packege p : packegesAfterFilter) {
            if (p.getId() == packId) {
                serviceProviderName = p.getServicesProviderName();
                break;
            }
        }
        if (serviceProviderName == null) {
            return "Invalid Package Id";
        }
        if (currentEvent.isEmpty()) {
            return "No event found to assign the package.";
        }

        Event e = currentEvent.get(0);
        LOGGER.info(e.getEventTitle()+e.getLocation()+e.getDate());
        e.setPackegeId(packId);
        e.setServiceProviderName(serviceProviderName);
        Application.events.add(e);
        Calender c=new Calender();
        c.setEventTitle(e.getEventTitle());
        c.setPackegeId(e.getPackegeId());
        c.setServiceProviderName(e.getServiceProviderName());
        c.setDate(e.getDate());
        c.setStartAt(e.getStartAt());
        c.setEndAt(e.getEndAt());
        Application.calenders.add(c);
        return "The event is created Successfully";
    }

    private List<Packege> filterByStartTime(List<Packege> packAfterCapacity, String date,String startAt) {
        List<Packege> pack = new ArrayList<>(packAfterCapacity);
        Iterator<Packege> iterator = pack.iterator();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime userTime;

        try {
            userTime = LocalTime.parse(startAt, formatter);
        } catch (DateTimeParseException e) {
            LOGGER.info("Could not parse the time: " + e.getMessage());

            return new ArrayList<>();
        }

        while (iterator.hasNext()) {
            Packege p = iterator.next();
            for (Calender c : Application.calenders) {
                try {
                    LocalTime startTime = LocalTime.parse(c.getStartAt(), formatter);
                    LocalTime endTime = LocalTime.parse(c.getEndAt(), formatter);
                    if (p.getId() == c.getPackegeId()  && c.getDate().equals(date)) {
                        boolean isBetween = !userTime.isBefore(startTime) && !userTime.isAfter(endTime);
                        if (isBetween) {
                            iterator.remove();
                            break;
                        }
                    }
                } catch (DateTimeParseException e) {
                    LOGGER.info("Error parsing calendar time: ");
                }
            }
        }
        return pack;
    }


    private  List<Packege> filterByCapacity(List<Packege> packAfterLoc, int numInvitees) {
        List<Packege> pack=new ArrayList<>();
        for(Packege p :packAfterLoc){
            if(p.getCapacity() >= numInvitees){
                pack.add(p);
            }
        }
        return pack;
    }

    private List<Packege> filterByLocation(List<Packege> packAfterBud, String location) {
    List<Packege> pack=new ArrayList<>();
    for(Packege p:packAfterBud){
        if(p.getLocation().equals(location)){
             pack.add(p);
        }
    }
        return pack;
    }

    public List<Packege> filterByBudget(int budget) {
        List<Packege> pack=new ArrayList<>();
        for(Packege p:Application.packeges){
            if(p.getPrice() <= budget){
                pack.add(p);
            }

        }
        return pack;
    }

    public void showMyEvents(String userName){
    String space="    ";
    for(Event e: Application.events){
        if(e.getUserName().equals(userName)){
            LOGGER.info("Event Title: "+e.getEventTitle()+space+"Location: "+e.getLocation()+space+"Number of Invitees: "+e.getNumOfInvitees()+space+"Date: "+e.getDate()+space+"Start At: "+e.getStartAt()+space+"End At: "+e.getEndAt());
        }
    }
    }
public void deleteEvent(String eventTitle){

    for(Event e:Application.events){
        if(e.getEventTitle().equals(eventTitle)){
            Application.events.remove(e);
        }
    }
    for(Calender c:Application.calenders){
        if(c.getEventTitle().equals(eventTitle)){
            Application.events.remove(c);
            Application.sendMessage("The event with title: "+eventTitle+" is deleted",c.getServiceProviderName());
        }
    }

    LOGGER.info("The event is deleted succesfully");
}



}