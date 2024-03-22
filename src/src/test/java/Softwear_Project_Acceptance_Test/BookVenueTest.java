package Softwear_Project_Acceptance_Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.example.Application;
import org.example.Venue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Test;

 class BookVenueTest {
    private final Application application;
    private final Venue venue = new Venue(2, true, 200);

    public BookVenueTest(Application app){
        this.application = app;
    }

    @Given("i am user")
    public void iAmUser() {
        application.setWhoLogIn("users");
        assertEquals("Ensure the user is logged in", true, application.getWhoLogIn());
    }

    @When("i booking a venue that reserved")
    public void iBookingAVenueThatReserved() {
        application.doesVenueAv(2);
        assertFalse("Check if the venue is not available", application.getIsVenueAv());
    }

    @When("The venue is booked at this time")
    public void theVenueIsBookedAtThisTime() {
        application.doesVenueTime(1,"2026-10-02",7,8);
        assertTrue("Verify if the booking time is not available", application.getIsVenueTime());

    }
    @Test
    @Then("Booking venue failed")
     void bookingVenueFailed() {
        application.doesVenueTime(1,"2026-10-02",2,3);
        application.doesVenueAv(2);
        application.doesVenueHaveCapacity(1, 1000);

        assertFalse("Ensure booking fails due to one or more conditions",
                application.getIsVenueTime() && application.getIsVenueAv() && application.getIsVenueCap());

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
        assertTrue("Verify the venue's capacity is insufficient", application.getIsVenueCap());
    }
    @When("i am user and venue is perfectly available")
    public void iAmUserAndVenueIsPerfectlyAvailable() {

        application.doesVenueTime(1,"2026-10-02",7,8);
        application.doesVenueAv(1);
        application.doesVenueHaveCapacity(1, 25);

        assertTrue(application.getIsVenueTime()&&application.getIsVenueAv()&&application.getIsVenueCap());
    }
    @Test
    @Then("booking Succesfully Done")
     void bookingSuccesfullyDone() {

        application.doesVenueTime(1,"2026-10-02",7,8);
        assertTrue(application.bookVenue(1,application.doesVenueAv(1),application.getIsVenueTime(),application.doesVenueHaveCapacity(1,25)));
    }


}

