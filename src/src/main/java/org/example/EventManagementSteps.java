package org.example;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EventManagementSteps {

    @When("The organizer creates an event with title {string}, date {string}, and location {string}")
    public void the_organizer_creates_an_event_with_title_date_and_location(String title, String date, String location) {
        // Write code here to create the event
        throw new io.cucumber.java.PendingException();
    }

    @Then("The event should be created successfully {string}")
    public void the_event_should_be_created_successfully(String message) {
        // Write code here to verify event creation
        throw new io.cucumber.java.PendingException();
    }

    @When("The participant searches for events")
    public void the_participant_searches_for_events() {
        // Write code here for participant to search events
        throw new io.cucumber.java.PendingException();
    }

    @When("Registers for an event with title {string}")
    public void registers_for_an_event_with_title(String eventTitle) {
        // Write code here for participant to register for event
        throw new io.cucumber.java.PendingException();
    }

    @Then("The participant should be registered successfully {string}")
    public void the_participant_should_be_registered_successfully(String message) {
        // Write code here to verify participant registration
        throw new io.cucumber.java.PendingException();
    }
}
