package org.example;

import java.time.LocalTime;
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
    private String localName;



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
    public String creatEvent(String userName){
        String serviceProviderName=null;
        int packegeId;
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Please enter the Event Title: ");
        String eventTitle = scanner.next();
        LOGGER.info("Please enter the budget: ");
        int budget = Integer.parseInt(scanner.nextLine());
        List<Packege> packAfterBud= filterByBudget(budget);
        if(packAfterBud.isEmpty()){
            return "We do not have a package with the same or lower budget than you enterd";
        }
        LOGGER.info("Please enter the location: ");
        String location= scanner.next();
        List<Packege> packAfterLoc=filterByLocation(packAfterBud,location);
        if(packAfterLoc.isEmpty()){
            return "We do not have a package with the same or lower budget than you enterd and the same location";
        }
        LOGGER.info("Please enter the Num of Invitees: ");
        int numInvitees= Integer.parseInt(scanner.next());
        List<Packege> packAfterCapacity=filterByCapacity(packAfterLoc,numInvitees);
        if(packAfterCapacity.isEmpty()){
            return "We do not have a package with the same or lower budget than you enterd and the same location,Capacity";
        }
        LOGGER.info("Please enter the Date: ");
        String date=scanner.next();
        List<Packege> packAfterDate=filterByDate(packAfterCapacity,date);
        if(packAfterDate.isEmpty()){
            return "We do not have a package with the same or lower budget than you enterd and the same location,capacity,date";
        }
        LOGGER.info("Please enter the Time when the event start: ");
        String startAt=scanner.next();
        LOGGER.info("Please enter the Time when the event end: ");
        String endAt = scanner.next();
        List<Packege> packAfterStartTime= filterByStartTime(packAfterDate,startAt);
        if(packAfterStartTime.isEmpty()){
            return "We do not have a package with the same or lower budget than you enterd and the same location,capacity,date";
        }
        if(packAfterStartTime.size()>1){
            String space="    ";
            for (Packege p:packAfterStartTime){
                LOGGER.info("Packege Id: "+p.getId()+space+"Place Name: "+p.getPlaceName()+space+"Location: "+p.getLocation()+space+"Capacity: "+p.getCapacity()+space+"Packege Price: "+p.getPrice()+space+"Services: "+p.getServicesDes()+space+"Service Provider: "+p.getServicesProviderName());
            }
            LOGGER.info("Enter the Packege Id that you choose: ");
             packegeId= Integer.parseInt(scanner.next());
            for(Packege p:Application.packeges){
                if(p.getId()==packegeId){
                     serviceProviderName = p.getServicesProviderName();
                }
            }

        }
        else{
            Packege p = packAfterStartTime.get(0);
             packegeId= p.getId();
           serviceProviderName= p.getServicesProviderName();
        }
        Event e= new Event();
        e.setEventTitle(eventTitle);
        e.setDate(date);
        e.setNumOfInvitees(numInvitees);
        e.setPackegeId(packegeId);
        e.setServiceProviderName(serviceProviderName);
        e.setLocation(location);
        e.setStartAt(startAt);
        e.setEndAt(endAt);
        e.setUserName(userName);
        Application.events.add(e);
        Calender c= new Calender();
        c.setPackegeId(e.getPackegeId());
        c.setEventTitle(e.getEventTitle());
        c.setServiceProviderName(e.getServiceProviderName());
        c.setDate(e.getDate());
        c.setStartAt(e.getStartAt());
        c.setEndAt(e.getEndAt());
        Application.calenders.add(c);
        Application.sendMessage("The event with title: "+eventTitle+" is added to your task",serviceProviderName);

        return "The event is created successfully";
    }


    public static final List<Packege> filterByStartTime(List<Packege> packAfterDate, String startAt) {
        List<Packege> pack = new ArrayList<>(packAfterDate);
        Iterator<Packege> iterator = pack.iterator();
        LocalTime userTime = LocalTime.parse(startAt);
        while (iterator.hasNext()) {
            Packege p = iterator.next();
            for (Calender c : Application.calenders) {
                LocalTime startTime = LocalTime.parse(c.getStartAt());
                LocalTime endTime = LocalTime.parse(c.getEndAt());
                if (p.getId() == c.getPackegeId()) {
                    boolean isBetween = userTime.isAfter(startTime) && userTime.isBefore(endTime);
                    if(isBetween){
                    iterator.remove();
                    break;
                    }
                }
            }
        }
        return pack;
    }

    public static final List<Packege> filterByDate(List<Packege> packAfterCapacity, String date) {
        List<Packege> pack = new ArrayList<>(packAfterCapacity);
        Iterator<Packege> iterator = pack.iterator();
        while (iterator.hasNext()) {
            Packege p = iterator.next();
            for (Calender c : Application.calenders) {
                if (p.getId() == c.getPackegeId() && c.getDate().equals(date)) {
                    iterator.remove();
                    break;
                }
            }
        }

        return pack;
    }

    public static final List<Packege> filterByCapacity(List<Packege> packAfterLoc, int numInvitees) {
        List<Packege> pack=new ArrayList<>();
        for(Packege p :packAfterLoc){
            if(p.getCapacity() >= numInvitees){
                pack.add(p);
            }
        }
        return pack;
    }

    public static final List<Packege> filterByLocation(List<Packege> packAfterBud, String location) {
    List<Packege> pack=new ArrayList<>();
    for(Packege p:packAfterBud){
        if(p.getLocation().equals(location)){
             pack.add(p);
        }
    }
        return pack;
    }

    public static final List<Packege> filterByBudget(int budget) {
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
public void deleteEvent(){
    Scanner scanner = new Scanner(System.in);
    LOGGER.info("Enter the Event Title you want to delete: ");
    String eventTitle= scanner.next();
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