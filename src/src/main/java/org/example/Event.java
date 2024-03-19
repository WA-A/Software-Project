package org.example;

public class Event {
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
