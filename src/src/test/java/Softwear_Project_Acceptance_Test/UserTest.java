package Softwear_Project_Acceptance_Test;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import org.example.User;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public class UserTest {
    private final InputStream systemIn = System.in;
    private ByteArrayInputStream testIn;
    private Map<String, User> registeredUsers = new HashMap<>();
    private User currentUser=new User();
    private String response;
    @Given("no user is currently registered with username {string}")
    public void no_user_is_currently_registered_with_username() {
        assertFalse(registeredUsers.containsKey("yazan"));
    }


    @When("{string} registers with password {string}, email {string}, and phone number {string}")
    public void registers_with_password_email_and_phone_number(String username, String password, String email, String phoneNum) {
        User newUser = new User(username, password, email, phoneNum);
        registeredUsers.put(username, newUser);
        currentUser = newUser;
    }
@Test
    @Then("the user {string} should be successfully registered")
    public void the_user_should_be_successfully_registered() {
        currentUser=new User("yazan" ,"yazan123",  "yazan@example.com",  "123456");
        assertNotNull(currentUser);
        assertEquals("yazan", currentUser.getUsername());
    }

    @Given("{string} is a registered user")
    public void is_a_registered_user(String string) {

    }

    @When("{string} logs in with password {string}")
    public void logs_in_with_password(String string, String string2) {

    }

    @Then("{string} should be successfully logged in")
    public void should_be_successfully_logged_in(String string) {

    }

    @Given("user is logged in")
    public void user_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user has specified a budget of {int}, location {string}, number of invitees {int}, date {string}, and start time {string}")
    public void user_has_specified_a_budget_of_location_number_of_invitees_date_and_start_time(Integer budget, String location, Integer capacity, String date, String startat) {
        // Write code here that turns the phrase above into concrete actions
        response = currentUser.creatEvent("yazan");

    }

    @Test
    @When("user attempts to create an event {string}")
    public void user_attempts_to_create_an_event() {
        response = currentUser.creatEvent("yazan");
//        String Title="Spring Gala";
        assertEquals("The event is created successfully",response);
    }

    @Then("the event {string} should be successfully created")
    public void the_event_should_be_successfully_created(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user should receive a confirmation with the event details")
    public void user_should_receive_a_confirmation_with_the_event_details() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("{string} specifies a budget of {int}")
    public void specifies_a_budget_of(String string, Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("{string} attempts to create an event {string}")
    public void attempts_to_create_an_event(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the creation should fail with a budget error")
    public void the_creation_should_fail_with_a_budget_error() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user specifies the location {string}")
    public void user_specifies_the_location(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the creation should fail with a location error")
    public void the_creation_should_fail_with_a_location_error() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user specifies a number of invitees {int}")
    public void user_specifies_a_number_of_invitees(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the creation should fail with a capacity error")
    public void the_creation_should_fail_with_a_capacity_error() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("user is logged in and has created multiple events")
    public void user_is_logged_in_and_has_created_multiple_events() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user requests to view his events")
    public void user_requests_to_view_his_events() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("all events created by user should be listed")
    public void all_events_created_by_user_should_be_listed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
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

    @Then("the event {string} should be successfully deleted")
    public void the_event_should_be_successfully_deleted(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user should receive confirmation of the deletion")
    public void user_should_receive_confirmation_of_the_deletion() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
