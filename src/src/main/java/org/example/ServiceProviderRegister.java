package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServiceProviderRegister {
    @Given("The Service Provider is on the registration page")
    public void the_service_provider_is_on_the_registration_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("The Service Provider enters wasan2020@gmail.com , {int} , {int} , <ServiceProvider-Name>")
    public void the_service_provider_enters_wasan2020_gmail_com_service_provider_name(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I should E-mail and Password is valid")
    public void i_should_e_mail_and_password_is_valid() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("The Service Provider enters an existing wasan2020@gmail.com ,a valid  password {int} and  phone {int} and user name <ServiceProvider-Name>")
    public void the_service_provider_enters_an_existing_wasan2020_gmail_com_a_valid_password_and_phone_and_user_name_service_provider_name(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The Service Provider should see an error message indicating the Email is already taken")
    public void the_service_provider_should_see_an_error_message_indicating_the_email_is_already_taken() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
