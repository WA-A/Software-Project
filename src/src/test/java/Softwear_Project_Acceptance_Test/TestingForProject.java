package Softwear_Project_Acceptance_Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.example.Application;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestingForProject {
    private boolean flag;
    private final Application application;


    public TestingForProject(Application app){
        this.application = app;
    }

    @Given("i am user")
    public void iAmUser() {
        application.SetWhoLogIn("users");
        assertEquals(true,application.getWhoLogIn());
    }

    @When("i booking a venue that reserved")
    public void iBookingAVenueThatReserved() {
        application.Does_venue_av(2);
        assertFalse(application.get_is_venue_av());
    }

    @When("The venue is booked at this time")
    public void theVenueIsBookedAtThisTime() {
        application.Does_venue_time(1,"2026-10-02",7,8);
        assertTrue(application.get_is_venue_time());

    }
    @Then("Booking venue failed")
    public void bookingVenueFailed() {
        application.Does_venue_time(1,"2026-10-02",2,3);
        application.Does_venue_av(2);
        application.doesVenueHaveCapacity(1, 1000);

        assertFalse(application.get_is_venue_time()&&application.get_is_venue_av()&&application.get_is_venue_cap());

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
        assertTrue(application.get_is_venue_cap());
    }
    @When("i am user and venue is perfectly available")
    public void iAmUserAndVenueIsPerfectlyAvailable() {

        application.Does_venue_time(1,"2026-10-02",7,8);
        application.Does_venue_av(1);
        application.doesVenueHaveCapacity(1, 25);

        assertTrue(application.get_is_venue_time()&&application.get_is_venue_av()&&application.get_is_venue_cap());
    }
    @Then("booking Succesfully Done")
    public void bookingSuccesfullyDone() {

        application.Does_venue_time(1,"2026-10-02",7,8);
        assertTrue(application.bookVenue(1,application.Does_venue_av(1),application.get_is_venue_time(),application.doesVenueHaveCapacity(1,25)));
    }


}
