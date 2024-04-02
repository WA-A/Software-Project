package org.example;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import java.text.MessageFormat;
import java.util.Objects;


public class User{
    private String username;
    private String password;
    private String email;
    private String phoneNum;
    private boolean isLogged;
    private static final Logger LOGGER = Logger.getLogger(User.class.getName());
    protected static final List<Packege> packegesAfterFilter = new ArrayList<>();
    protected static final List<Event> currentEvent= new ArrayList<>();
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");



    public User(){
        username=null;
        password=null;
        email=null;
        phoneNum=null;
        isLogged=false;
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
    public String choosePackege(int packId) {
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



    public List<Packege> filterByStartTime(List<Packege> packAfterCapacity, String date, String startAt) {
        LocalTime userTime = parseTime(startAt);
        if (userTime == null) {
            return new ArrayList<>();
        }

        List<Packege> filteredPackages = new ArrayList<>(packAfterCapacity);
        Iterator<Packege> iterator = filteredPackages.iterator();

        while (iterator.hasNext()) {
            Packege p = iterator.next();
            if (isPackageTimeOverlap(p, date, userTime)) {
                iterator.remove();
            }
        }
        return filteredPackages;
    }

    private boolean isPackageTimeOverlap(Packege pkg, String date, LocalTime userTime) {
        for (Calender calendar : Application.calenders) {
            if (pkg.getId() == calendar.getPackegeId() && calendar.getDate().equals(date)) {
                LocalTime startTime = parseTime(calendar.getStartAt());
                LocalTime endTime = parseTime(calendar.getEndAt());
                if (startTime != null && endTime != null && isTimeBetween(userTime, startTime, endTime)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isTimeBetween(LocalTime target, LocalTime start, LocalTime end) {
        return !target.isBefore(start) && !target.isAfter(end);
    }

    private LocalTime parseTime(String timeString) {
        try {
            return LocalTime.parse(timeString, TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            LOGGER.info("Could not parse the time: " + e.getMessage());
            return null;
        }
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

    private List<Packege> filterByBudget(int budget) {
        List<Packege> pack=new ArrayList<>();
        for(Packege p:Application.packeges){
            if(p.getPrice() <= budget){
                pack.add(p);
            }

        }
        return pack;
    }




    public String showMyEvents(String userName) {
        // Initialize a space string for formatting output
        String space = "    ";

        // Flag to indicate if any events were found for the user
        boolean eventFound = false;

        // Iterate through the events
        for (Event e : Application.events) {
            // Check if the event is associated with the given user name
            if (Objects.equals(e.getUserName(), userName)) {
                // Construct the log message using built-in formatting
                String logMessage = String.format("Event Title: %s%sLocation: %s%sNumber of Invitees: %d%sDate: %s%sStart At: %s%sEnd At: %s",
                        e.getEventTitle(), space, e.getLocation(), space, e.getNumOfInvitees(), space, e.getDate(), space, e.getStartAt(), space, e.getEndAt());

                LOGGER.info(logMessage);
                eventFound = true;
            }
        }
        return eventFound ? "All your events have been shown." : "No events found for the user.";
    }


    public String deleteEvent(String title) {
        String eventTitle = title;
        Iterator<Event> iterator = Application.events.iterator();
        while (iterator.hasNext()) {
            Event e = iterator.next();
            if (e.getEventTitle().equals(eventTitle)) {
                iterator.remove();
            }
        }
        Iterator<Calender> calenderIterator = Application.calenders.iterator();
        while (calenderIterator.hasNext()) {
            Calender c = calenderIterator.next();
            if (c.getEventTitle().equals(eventTitle)) {
                Application.sendMessage("The event with title: " + eventTitle + " is deleted", c.getServiceProviderName());
                calenderIterator.remove(); // Remove calender entry
            }
        }

        LOGGER.info("The event is deleted successfully");
        return "The event is deleted successfully";
    }


}

