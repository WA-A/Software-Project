package org.example;

public class Venue {
    int id;
    int w;
    boolean available;
    int capacity;

    public Venue(int id, boolean available, int capacity) {
        this.id = id;
        this.available = available;
        this.capacity = capacity;
    }
}
