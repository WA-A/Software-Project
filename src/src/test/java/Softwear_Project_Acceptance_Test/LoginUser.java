package Softwear_Project_Acceptance_Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginUser {

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("The user enters a valid username Ghina and password {int}")
    public void the_user_enters_a_valid_username_ghina_and_password(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should be logged in successfully and show Successful   Login")
    public void the_user_should_be_logged_in_successfully_and_show_successful_login() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("The user enters a valid username Ghina and incorrect password {string} in WorngPassword")
    public void the_user_enters_a_valid_username_ghina_and_incorrect_password_in_worng_password(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The user should see an error message indicating incorrect password in incorrect password")
    public void the_user_should_see_an_error_message_indicating_incorrect_password_in_incorrect_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("The user enters a nonexistent username nonexistent User Name and password {string} in {int}")
    public void the_user_enters_a_nonexistent_username_nonexistent_user_name_and_password_in(String string, Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The user should see an error message indicating invalid username in invalid username")
    public void the_user_should_see_an_error_message_indicating_invalid_username_in_invalid_username() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @When("the user enters a valid username Ghina and leaves the password field blank in ")
    public void the_user_enters_a_valid_username_ghina_and_leaves_the_password_field_blank_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should see an error message indicating the password is required in password is required")
    public void the_user_should_see_an_error_message_indicating_the_password_is_required_in_password_is_required() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user leaves the username field blank in   and enters a valid password {int}")
    public void the_user_leaves_the_username_field_blank_in_and_enters_a_valid_password(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should see an error message indicating the username is required in username is required")
    public void the_user_should_see_an_error_message_indicating_the_username_is_required_in_username_is_required() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
