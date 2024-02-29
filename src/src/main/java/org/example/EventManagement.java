package org.example;
import java.util.ArrayList;
import java.util.List;

public class EventManagement {

    private List<Event> events;

    public EventManagement() {
        this.events = new ArrayList<>();
    }

    public String createEvent(String title, String date, String location) {
        Event event = new Event(title, date, location);
        events.add(event);
        return "Event created successfully";
    }

    public String editEventLocation(String title, String newLocation) {
        for (Event event : events) {
            if (event.getTitle().equals(title)) {
                event.setLocation(newLocation);
                return "Event location updated successfully";
            }
        }
        return "Event not found";
    }

    public String deleteEvent(String title) {
        for (Event event : events) {
            if (event.getTitle().equals(title)) {
                events.remove(event);
                return "Event deleted successfully";
            }
        }
        return "Event not found";
    }

    public Event findEventByTitle(String title) {
        for (Event event : events) {
            if (event.getTitle().equals(title)) {
                return event;
            }
        }
        return null;
    }

    public static class Event {
        private String title;
        private String date;
        private String location;

        public Event(String title, String date, String location) {
            this.title = title;
            this.date = date;
            this.location = location;
        }

        public String getTitle() {
            return title;
        }

        public String getDate() {
            return date;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }
}
