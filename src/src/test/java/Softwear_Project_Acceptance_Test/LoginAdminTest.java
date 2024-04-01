package Softwear_Project_Acceptance_Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Admin;
import org.example.Application;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginAdminTest {
    private Admin user=new Admin() ; // Creating an instance of the User class
    private Application application =new Application(); // Creating an instance of the Application class
    private String username;
    private String password;
    @Given("The admin is on the login page")
    public void the_admin_is_on_the_login_page() {

    }

    @Given("a list of admin <Admin>")
    public void a_list_of_admin_admin() {

    }

    @When("The admin enters a valid username wasan and password {int} are checked")
    public void the_admin_enters_a_valid_username_wasan_and_password_are_checked(Integer int1) {

    }
    @Test
    @Then("the admin is found and logged in")
    public void the_admin_is_found_and_logged_in() {
        username="wasan";
        password="123456";
        user=  application.checkAdmin(username, password);
        assertNotNull(user);
    }
    @Test
    @Then("The admin should be logged in successfully in The admin is found    Successfully Login")
    public void the_admin_should_be_logged_in_successfully_in_the_admin_is_found_successfully_login() {
        username="wasan";
        password="123456";
        user=  application.checkAdmin(username, password);
        System.out.println("The Admin is  found" + " Successful Login");
        assertTrue(user.getLogged());
    }

    @When("The user enters a valid username wasan and incorrect password {string} in wrongPassword are checked")
    public void the_user_enters_a_valid_username_wasan_and_incorrect_password_in_wrong_password_are_checked(String string) {

    }
    @Test
    @Then("The admin should see an error message indicating incorrect password in The admin is not found    incorrect password")
    public void the_admin_should_see_an_error_message_indicating_incorrect_password_in_the_admin_is_not_found_incorrect_password() {
        username="wasan";
        password="123123";
        user= application.checkAdmin(username,password);
        System.out.println("The Admin is not found, Invallid password");
        assertNull(user);
    }

    @When("The admin enters a nonexistent username nonexistent Admin-User and password {string} in {int} are checked")
    public void the_admin_enters_a_nonexistent_username_nonexistent_admin_user_and_password_in_are_checked(String string, Integer int1) {

    }
    @Test
    @Then("The admin should see an error message indicating invalid username in The admin is not found    invalid username")
    public void the_admin_should_see_an_error_message_indicating_invalid_username_in_the_admin_is_not_found_invalid_username() {
        username="batool";
        password="123456";
        user= application.checkAdmin(username,password);
        assertNull(user);
        System.out.println("Admin is not found  Invalid username");
    }

    @When("the admin enters a valid username wasan and leaves the password field blank in  are checked")
    public void the_admin_enters_a_valid_username_wasan_and_leaves_the_password_field_blank_in_are_checked() {

    }
    @Test
    @Then("The admin should see an error message indicating the password is required in The admin is not found    password is required")
    public void the_admin_should_see_an_error_message_indicating_the_password_is_required_in_the_admin_is_not_found_password_is_required() {
        username= "wasan";
        password="";
        user= application.checkAdmin(username,password);
        assertNull(user);
        System.out.println("The Admin is not found " + "password is required");
    }

    @Given("a admin of admin <Admin>")
    public void a_admin_of_admin_admin() {

    }

    @When("the user leaves the username field blank in   and enters a valid password {int} are checked")
    public void the_user_leaves_the_username_field_blank_in_and_enters_a_valid_password_are_checked(Integer int1) {

    }
@Test
    @Then("The admin should see an error message indicating the username is required in The admin is not found    username is required")
    public void the_admin_should_see_an_error_message_indicating_the_username_is_required_in_the_admin_is_not_found_username_is_required() {
        username= "";
        password="123456";
        user= application.checkAdmin(username,password);
        assertNull(user);
        System.out.println("The Admin is not found " + "username is required");
    }
}
