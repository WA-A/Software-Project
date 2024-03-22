package org.example;



import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

class Venue {
    int id;
    boolean available;
    int capacity;

    public Venue(int id, boolean available, int capacity) {
        this.id = id;
        this.available = available;
        this.capacity = capacity;
    }
}

class Event {
    int id;
    int venueId;
    String date;
    int startAt;
    int endAt;
    public Event(int id, int venueId, String date, int startAt, int endAt) {
        this.id = id;
        this.venueId = venueId;
        this.date = date;
        this.startAt = startAt;
        this.endAt = endAt;
    }
}

public class Application {

    private List<Venue> venues = new ArrayList<>();
    private List<Event> events = new ArrayList<>();


    private users u;

    /////////////////////////////////////
    private boolean flag;

    private String WhoLogIn;
    private boolean is_venue_av;
    private boolean is_venue_cap;
    private boolean is_venue_time=true;
    private boolean is_overlap;


    public Application() {
        venues.add(new Venue(1, true, 100));
        venues.add(new Venue(2, true, 200));

        events.add(new Event(1, 1, "2024-03-19", 10, 14));
    }


    public boolean get_is_venue_av(){
        return is_venue_av;
    }

    public boolean get_is_venue_cap() {
        return is_venue_cap;
    }

    public void SetWhoLogIn(String who){
        WhoLogIn=who;
    }

    public boolean getWhoLogIn(){
        return WhoLogIn.equals("users");
    }

    public boolean get_is_venue_time(){
        return is_venue_time;
    }

    public boolean bookVenue(int venueId, boolean av, boolean t, boolean cap) {
        for (Venue venue : venues) {
            if (venue.id == venueId && venue.available == av && cap && t)  {

                return true;
            }
        }
        return false;

    }
    public boolean Does_venue_av(int venueId) {
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



    public boolean Does_venue_time(int venueId, String date, int startAt, int endAt) {
        for (Event event : events) {
            // Check if the event is at the same venue and on the same date
            if (event.venueId == venueId && event.date.equals(date)) {
                // Check for time overlap
                // Assuming startAt and endAt are based on a 24-hour clock (0-23)
                if ((startAt < event.endAt && endAt > event.startAt)) {
                    // Overlap found, so the venue is not available at the proposed time
                    return false;
                }
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


