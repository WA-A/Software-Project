package Softwear_Project_Acceptance_Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Application;
import org.example.ServiceProvider;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginServiceProviderTest {
    private ServiceProvider user=new ServiceProvider() ; // Creating an instance of the User class
    private Application application =new Application(); // Creating an instance of the Application class
    private String username;
    private String password;
    @Given("The Server Provider is on the login page")
    public void the_server_provider_is_on_the_login_page() {

    }

    @Given("a list of service Providers <servicesProviders>")
    public void a_list_of_service_providers_services_providers() {

    }

    @When("The serviceProvider enters a valid username mohammad and password {int} are checked")
    public void the_service_provider_enters_a_valid_username_mohammad_and_password_are_checked(Integer int1) {

    }
    @Test
    @Then("the serviceProvider is found and logged in")
    public void the_service_provider_is_found_and_logged_in() {
        username="abdullah";
        password="112233";
        user=  application.checkServiceProvider(username, password);
        assertNotNull(user);
    }
    @Test
    @Then("The serviceProvider should be logged in successfully in The Service Provider is found    Successfully Login")
    public void the_service_provider_should_be_logged_in_successfully_in_the_service_provider_is_found_successfully_login() {
        username="abdullah";
        password="112233";
        user=  application.checkServiceProvider(username, password);
        System.out.println("The Service Provider is  found" + " Successful Login");
        assertTrue(user.getLogged());
    }

    @When("The service Provider enters a valid username mohammad and incorrect password {string} in wrongPassword are checked")
    public void the_service_provider_enters_a_valid_username_mohammad_and_incorrect_password_in_wrong_password_are_checked(String string) {

    }
    @Test
    @Then("the service Provider is notfound and logged in")
    public void the_service_provider_is_notfound_and_logged_in() {
        username="abdullah";
        password="123123";
        user= application.checkServiceProvider(username,password);
        assertNull(user);
    }
    @Test
    @Then("The service Provider should see an error message indicating incorrect password in The Service Provider is not found    incorrect password")
    public void the_service_provider_should_see_an_error_message_indicating_incorrect_password_in_the_service_provider_is_not_found_incorrect_password() {
        username="abdullah";
        password="123123";
        user= application.checkServiceProvider(username,password);
        System.out.println("The Service Provider is not found, Invallid password");
        assertNull(user);
    }

    @When("The service Provider enters a nonexistent username nonexistent Admin-User and password {string} in {int} are checked When The admin enters a valid username nonexistent Admin-User and password {int} are checked")
    public void the_service_provider_enters_a_nonexistent_username_nonexistent_admin_user_and_password_in_are_checked_when_the_admin_enters_a_valid_username_nonexistent_admin_user_and_password_are_checked(String string, Integer int1, Integer int2) {

    }
    @Test
    @Then("The service Provider should see an error message indicating invalid username in The Service Provider is not found    invalid username")
    public void the_service_provider_should_see_an_error_message_indicating_invalid_username_in_the_service_provider_is_not_found_invalid_username() {
        username="batool";
        password="112233";
        user= application.checkServiceProvider(username,password);
        assertNull(user);
        System.out.println("Service Provider is not found  Invalid username");
    }

    @When("the service Provider enters a valid username mohammad and leaves the password field blank in  are checked")
    public void the_service_provider_enters_a_valid_username_mohammad_and_leaves_the_password_field_blank_in_are_checked() {

    }
    @Test
    @Then("The service Provider should see an error message indicating incorrect password in The Service Provider is not found    password is required")
    public void the_service_provider_should_see_an_error_message_indicating_incorrect_password_in_the_service_provider_is_not_found_password_is_required() {
        username= "abdullah";
        password="";
        user= application.checkServiceProvider(username,password);
        assertNull(user);
        System.out.println("The Service Provider is not found " + "password is required");
    }

    @When("the Server Provider leaves the username field blank in   and enters a valid password {int} are checked")
    public void the_server_provider_leaves_the_username_field_blank_in_and_enters_a_valid_password_are_checked(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Test
    @Then("The service Provider should see an error message indicating incorrect password in The Service Provider is not found    username is required")
    public void the_service_provider_should_see_an_error_message_indicating_incorrect_password_in_the_service_provider_is_not_found_username_is_required() {
        username= "";
        password="112233";
        user= application.checkServiceProvider(username,password);
        assertNull(user);
        System.out.println("The Service Provider is not found " + "username is required");
    }
}