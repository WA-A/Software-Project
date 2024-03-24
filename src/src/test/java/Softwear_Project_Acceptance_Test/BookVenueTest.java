package Softwear_Project_Acceptance_Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.example.Application;
import org.example.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.Date;

import javax.swing.JOptionPane;

import org.junit.Test;



public class TestingForProject {
    private boolean flag;
    private final Application application;
    private Venue v1=new Venue(99,true,200);


    public TestingForProject(Application app){
        this.application = app;
    }

    @Given("i am user")
    public void iAmUser() {
        application.setWhoLogIn("users");
        assertEquals(true,application.getWhoLogIn());
    }

    @When("i booking a venue that reserved")
    public void iBookingAVenueThatReserved() {
        application.doesVenueAv(2);
        assertFalse(application.getIsVenueAv());
    }

    @When("The venue is booked at this time")
    public void theVenueIsBookedAtThisTime() {
        application.doesVenueTime(1,"2026-10-02",7,8);
        assertTrue(application.getIsVenueTime());

    }
    @Then("Booking venue failed")
    public void bookingVenueFailed() {
        application.doesVenueTime(1,"2026-10-02",2,3);
        application.doesVenueAv(2);
        application.doesVenueHaveCapacity(1,1000);

        assertFalse(application.getIsVenueTime()&&application.getIsVenueAv()&&application.getIsVenueCap());

    }


    @When("i booking an reserved venue")
    public void iBookingAnReservedVenue() {

    }
    @When("venue not available")
    public void venueNotAvailable() {


    }

    @When("i booking a venue")
    public void iBookingAVenue() {


    }


    @When("Already reserved")
    public void alreadyReserved() {



    }
    @Then("booking failed")
    public void bookingFailed() {



    }

    @When("venue  capasity not enough")
    public void venueCapasityNotEnough() {
        application.doesVenueHaveCapacity(1, 100);
        assertTrue(application.getIsVenueCap());
    }
    @When("i am user and venue is perfectly available")
    public void iAmUserAndVenueIsPerfectlyAvailable() {

        application.doesVenueTime(1,"2026-10-02",7,8);
        application.doesVenueAv(1);
        application.doesVenueHaveCapacity(1, 25);

        assertTrue(application.getIsVenueTime()&&application.getIsVenueAv()&&application.getIsVenueCap());
    }
    @Then("booking Succesfully Done")
    public void bookingSuccesfullyDone() {

        application.doesVenueTime(1,"2026-10-02",7,8);
        assertTrue(application.bookVenue(1,application.doesVenueAv(1),application.getIsVenueTime(),application.doesVenueHaveCapacity(1,25)));
    }


}
