package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterAdmin {

    @When("The admin enters wasan2020@gmail.com , {int} , {int} , <Admin-Name>")
    public void the_admin_enters_wasan2020_gmail_com_admin_name(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("The admin enters an existing wasan2020@gmail.com ,a valid  password {int} and  phone {int} and user name <Admin-Name>")
    public void the_admin_enters_an_existing_wasan2020_gmail_com_a_valid_password_and_phone_and_user_name_admin_name(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
