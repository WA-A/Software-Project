package org.example;
import java.util.ArrayList;
import java.util.List;



public class Application {


    private String whoLogIn;
    private boolean isVenueTime =true;
    private List<Event> events = new ArrayList<>();

    private List<Venue> venues = new ArrayList<>();


    public Application() {

    }

    public void setWhoLogIn(String who){
        whoLogIn =who;
    }

    public boolean getWhoLogIn(){
        return whoLogIn.equals("users");
    }

    public boolean getIsVenueTime(){
        return isVenueTime;
    }


}


