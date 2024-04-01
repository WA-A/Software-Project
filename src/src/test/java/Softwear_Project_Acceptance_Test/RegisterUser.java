package Softwear_Project_Acceptance_Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.User;

public class RegisterUser {

    private User user; // Creating an instance of the User class

    private String username;
    private String password;

    private String phonenum;
    private String email;
    private String exitemail;
    @Given("The user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
        user = new User();
    }

    @When("The user enters sameh,  {int} ,sameh@gmail.com  , {int}   # Email is unique")
    public void the_user_enters_sameh_sameh_gmail_com_email_is_unique(String username, String password,String phonenum,String email) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
        this.username = username;
        this.password = password;
        this.phonenum = password;
        this.email = email;
        user.setUsername(username);
        user.setPassword(password);
        user.setUsername(phonenum);
        user.setPassword(email);
    }

//    @Then("I should Email and Password is valid")
//    public void i_should_email_and_password_is_valid() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }

//    @When("The user enters an existing sameh@gmail.com ,a valid  password {int}, phone {int} and user name sameh")
//    public void the_user_enters_an_existing_sameh_gmail_com_a_valid_password_phone_and_user_name_sameh(Integer int1, Integer int2) {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//
//    }

    @Then("The user should see an error message indicating the Email is already taken")
    public void the_user_should_see_an_error_message_indicating_the_email_is_already_taken() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
      if (exitemail== email) {
          System.out.println("Error: The email is already taken." +
                  " Please choose a different email.");
      }
    }
}
