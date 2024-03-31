package Softwear_Project_Acceptance_Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Admin;
import static org.junit.Assert.*;
import org.junit.Test;

public class AdminTest {
    private Admin admin = new Admin();
    private   String response;
@Test
    @Given("the admin is logged in")
    public void the_admin_is_logged_in() {
        admin.setLogged(true);
        assertTrue("Admin should be logged in", admin.getLogged());
    }

    @When("the admin adds the service provider with username {string}, password {string}, phone number {string}, and email {string}")
    public void the_admin_adds_the_service_provider_with_username_password_phone_number_and_email(String username, String password, String phoneNumber, String email) {
        response= admin.addServiceProvider(username, password, phoneNumber, email);
    }

@Test
    @Then("the service provider with username {string} should be added to the system")
    public void the_service_provider_with_username_should_be_added_to_the_system() {
        response= admin.addServiceProvider( "ahmad",  "123",  "05123123",   "ahmad@example.com");
        assertEquals("ServiceProvider added successfully",response);

    }

    @When("the admin deletes the service provider with username {string} and phone number {string}")
    public void the_admin_deletes_the_service_provider_with_username_and_phone_number(String username, String phonenumber) {
        response= admin.deleteServiceProvider(username,phonenumber);
}
    @Test
    @Then("the service provider with username {string} should be removed from the system")
    public void the_service_provider_with_username_should_be_removed_from_the_system() {
         response= admin.deleteServiceProvider("ahmad",  "05123123");
        assertEquals("The ServiceProvider is removed",response);
    }

    @When("the admin requests to print all service providers")
    public void the_admin_requests_to_print_all_service_providers() {
        response= admin.printServiceProviders();
    }
    @Test
    @Then("the system should display all service providers with their username, phone number, and email")
    public void the_system_should_display_all_service_providers_with_their_username_phone_number_and_email() {
        response= admin.printServiceProviders();
        assertEquals("All ServiceProvider has been printed",response);
    }

    @When("the admin requests to print all users")
    public void the_admin_requests_to_print_all_users() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Test
    @Then("the system should display all users with their username, phone number, and email")
    public void the_system_should_display_all_users_with_their_username_phone_number_and_email() {
        response= admin.printUsers();
        assertEquals("All users has been printed",response);
    }

    @When("the admin requests to print all events")
    public void the_admin_requests_to_print_all_events() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

@Test
    @Then("the system should display all events with their title, location, date, start and end times, number of invitees, user name, package id, and service provider name")
    public void the_system_should_display_all_events_with_their_title_location_date_start_and_end_times_number_of_invitees_user_name_package_id_and_service_provider_name() {
        response= admin.printEvents();
        assertEquals("All events has been printed",response);
    }
}