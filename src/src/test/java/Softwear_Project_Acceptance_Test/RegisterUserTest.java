package Softwear_Project_Acceptance_Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Application;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterUserTest {
    Application app=new Application();
   private String username;
  private  String password;
    private  String numberPhone;
    private  String gmail;
    @Given("The user is on the registration page")
    public void the_user_is_on_the_registration_page() {

    }

    @When("The user enters sameh,  {int} ,sameh@gmail.com  , {int}   ")
    public void the_user_enters_sameh_sameh_gmail_com_email_is_unique() {

    }
@Test
    @Then("I should Email and Password is valid")
    public void i_should_email_and_password_is_valid() {
username="samer";
password="876542";
gmail="samer@gmail.com";
numberPhone="0599234178";
String x= app.registerUser(username,password,gmail,numberPhone);
assertEquals("The user is registerd Successfully",x);
System.out.println(x);
    }

    @When("The user enters an existing sameh@gmail.com ,a valid  password {int}, phone {int} and user name sameh")
    public void the_user_enters_an_existing_sameh_gmail_com_a_valid_password_phone_and_user_name_sameh(Integer int1, Integer int2) {

    }
@Test
    @Then("The user should see an error message indicating the Email is already taken")
    public void the_user_should_see_an_error_message_indicating_the_email_is_already_taken() {
        username="ghazi";
        password="112233";
        gmail="ghazi@gmail.com";
        numberPhone="0599234178";
        String x= app.registerUser(username,password,gmail,numberPhone);
        assertEquals("Invalid information, The register failed",x);
        System.out.println(x);
    }
}
