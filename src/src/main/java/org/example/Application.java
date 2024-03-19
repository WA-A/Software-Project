package org.example;
import java.util.ArrayList;
import java.util.List;


public class Application {


    private String whoLogIn;
    private boolean isVenueAv;
    private boolean isVenueCap;
    private boolean isVenueTime =true;
    private List<Event> events = new ArrayList<>();

    private List<Venue> venues = new ArrayList<>();


    public Application() {



        venues.add(new Venue(1,true,120));
        venues.add(new Venue(2, true, 200));

        events.add(new Event(1, 1, "2024-03-19", 10, 14));
    }


    public boolean getIsVenueAv(){
        return isVenueAv;
    }

    public boolean getIsVenueCap() {
        return isVenueCap;
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

    public boolean bookVenue(int venueId, boolean av, boolean t, boolean cap) {
        for (Venue venue : venues) {
            if (venue.id == venueId && venue.available == av && cap && t)  {

                return true;
            }
        }
        return false;

    }
    public boolean doesVenueAv(int venueId) {
        for (Venue venue : venues) {
            // Check if the venue's ID matches the provided ID
            if (venue.id == venueId) {
                // Return the availability of the found venue
                return venue.available;
            }
        }
        // If no venue with the given ID is found, assume it is not available
        return false;
    }



    public boolean doesVenueTime(int venueId, String date, int startAt, int endAt) {
        for (Event event : events) {
            // Check if the event is at the same venue and on the same date
            // Overlap found, so the venue is not available at the proposed time
            if (event.venueId == venueId && event.date.equals(date) &&startAt < event.endAt && endAt > event.startAt) {


                    return false;
                }

        }
        // No overlapping events found, so the venue is available
        return true;
    }

    public boolean doesVenueHaveCapacity(int venueId, int guestNumber) {
        for (Venue venue : venues) {
            if (venue.id == venueId && venue.capacity >= guestNumber) {
                return true;
            }
        }
        return false;
    }

}


