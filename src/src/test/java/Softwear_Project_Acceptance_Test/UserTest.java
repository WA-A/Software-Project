package Softwear_Project_Acceptance_Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Application;
import org.example.Packege;
import org.example.Calender;
import org.example.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;
public class UserTest {
    private  Application a = new Application();
    private  User s =new User();
    private String x=null;



    @Test()
    @Given("the user wants to create an event with specific details")
    public void the_user_wants_to_create_an_event_with_specific_details() {
        s = a.checkUser("ghazi","345345");
        assertTrue(s.getLogged());

    }

    @When("the user provides event details including {string}, a budget of {int}, {string} location, {int} invitees, {string} date, {string} start time, and {string} end time")
    public void the_user_provides_event_details_including_a_budget_of_location_invitees_date_start_time_and_end_time(String string, Integer int1, String string2, Integer int2, String string3, String string4, String string5) {

    }
    @Test
    @Then("the system processes these details and the system prints a list of suitable packages based on the provided criteria")
    public void the_system_processes_these_details_and_the_system_prints_a_list_of_suitable_packages_based_on_the_provided_criteria() {

        String Title="Meeting 1";
        int budget= 6000;
        String location="Nablus";
        int invitees=180;
        String date= "2026-04-20";
        String start="08:00";
        String end= "10:00";
        String x= s.creatEvent(Title,budget,location,invitees,date,start,end);
        assertEquals( "Please enter the Packege Id that you want to approve: ",x);
        System.out.println(x);
    }

    @Given("the user has already created an event and received a list of suitable packages")
    public void the_user_has_already_created_an_event_and_received_a_list_of_suitable_packages() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user selects a package by its Id {int}")
    public void the_user_selects_a_package_by_its_id(Integer int1) {

    }
    @Test
    @Then("the system assigns the selected package to the event")
    public void the_system_assigns_the_selected_package_to_the_event() {
        String Title="Meeting 1";
        int budget= 6000;
        String location="Nablus";
        int invitees=180;
        String date= "2024-04-20";
        String start="08:00";
        String end= "10:00";
        String x= s.creatEvent(Title,budget,location,invitees,date,start,end);
        int packegeId=3;
        String m=s.choosePackege(packegeId);
        assertEquals("The event is created Successfully",m);
    }

    @Given("user is logged in")
    public void user_is_logged_in() {
        s = a.checkUser("ghazi","345345");
        assertTrue(s.getLogged());

    }

    @Given("{string} specifies a budget of {int}")
    public void specifies_a_budget_of(String string, Integer int1) {

    }

    @When("{string} attempts to create an event {string}")
    public void attempts_to_create_an_event(String string, String string2) {

    }
    @Test
    @Then("the creation should fail with a budget error")
    public void the_creation_should_fail_with_a_budget_error() {
        String Title="Meeting 1";
        int budget= 2000;
        String location="Nablus";
        int invitees=180;
        String date= "2024-04-20";
        String start="08:00";
        String end= "10:00";
        String x= s.creatEvent(Title,budget,location,invitees,date,start,end);
        assertEquals("We do not have a package with the same or lower budget than you entered",x);

    }

    @Given("user specifies the location {string}")
    public void user_specifies_the_location(String string) {

    }
    @Test
    @Then("the creation should fail with a location error")
    public void the_creation_should_fail_with_a_location_error() {
        String Title="Meeting 1";
        int budget= 3000;
        String location="Ramallah";
        int invitees=180;
        String date= "2024-04-20";
        String start="08:00";
        String end= "10:00";
        String x= s.creatEvent(Title,budget,location,invitees,date,start,end);
        assertEquals("We do not have a package with the same location",x);

    }

    @Given("user specifies a number of invitees {int}")
    public void user_specifies_a_number_of_invitees(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user attempts to create an event {string}")
    public void user_attempts_to_create_an_event(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Test
    @Then("the creation should fail with a capacity error")
    public void the_creation_should_fail_with_a_capacity_error() {
        String Title="Meeting 1";
        int budget= 6000;
        String location="Nablus";
        int invitees=500;
        String date= "2024-04-20";
        String start="08:00";
        String end= "10:00";
        String x= s.creatEvent(Title,budget,location,invitees,date,start,end);
        assertEquals("We do not have a package with the same Capacity",x);
    }

    @Given("user is logged in and has created multiple events")
    public void user_is_logged_in_and_has_created_multiple_events() {

    }

    @When("user requests to view his events")
    public void user_requests_to_view_his_events() {

    }
    @Test
    @Then("all events created by user should be listed")
    public void all_events_created_by_user_should_be_listed() {
        String Title="Meeting 1";
        int budget= 6000;
        String location="Nablus";
        int invitees=180;
        String date= "2024-04-20";
        String start="08:00";
        String end= "10:00";
        String m= s.creatEvent(Title,budget,location,invitees,date,start,end);
        String h= s.choosePackege(3);
        x = s.showMyEvents(s.getUsername());
        assertEquals("All your events have been shown.",x);
    }
    @Then("the creation should fail with a time error")
    public void the_creation_should_fail_with_a_time_error() {
        String Title="Meeting 1";
        int budget= 6000;
        String location="Nablus";
        int invitees=180;
        String date= "20/4/2024";
        String start="08:00";
        String end= "10:00";
        String x= s.creatEvent(Title,budget,location,invitees,date,start,end);
        assertEquals("This day at this time is unavailable",x);
    }
    @Given("user has created an event {string}")
    public void user_has_created_an_event(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user requests to delete the event {string}")
    public void user_requests_to_delete_the_event(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
@Test
    @Then("the event {string} should be successfully deleted")
    public void the_event_should_be_successfully_deleted() {
        String Title="Meeting 1";
        int budget= 6000;
        String location="Nablus";
        int invitees=180;
        String date= "20/4/2024";
        String start="02:00";
        String end= "4:00";
        String x= s.creatEvent(Title,budget,location,invitees,date,start,end);
        String m= s.deleteEvent(Title);
        assertEquals("The event is deleted successfully",m);
    }

    @Then("user should receive confirmation of the deletion")
    public void user_should_receive_confirmation_of_the_deletion() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}



