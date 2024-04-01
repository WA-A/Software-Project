package Softwear_Project_Acceptance_Test;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import org.example.Application;
import org.example.Packege;
import org.example.ServiceProvider;
import org.junit.Test;


public class ServicrProviderTest {
    private Application app = new Application();
    private  String response;
    private ServiceProvider serviceProvider=new ServiceProvider();
   public int selectedPackageId,op;

   private Packege pkg= new Packege();

@Test
    @Given("the service provider is logged in")
    public void the_service_provider_is_logged_in() {
        serviceProvider = app.checkServiceProvider("abdullah", "112233");
        assertNotNull(serviceProvider); // Use JUnit assertion to ensure login is successful.
        assertTrue(serviceProvider.getLogged()); // Ensure the service provider is marked as logged in.
    }

    @When("a service provider adds a new package with ID {string}, price {string}, capacity {string}, location {string}, place name {string}, servisec {string}, and service provider name {string}")
    public void a_service_provider_adds_a_new_package_with_id_price_capacity_location_place_name_servisec_and_service_provider_name(String id, String price, String capacity, String location, String placeName, String services, String serviceProviderName){



    response = serviceProvider.addPackage(Integer.parseInt(id), Integer.parseInt(price), Integer.parseInt(capacity), location, placeName, services, serviceProviderName);


    }
@Test
    @Then("the new package added to the system")
    public void the_new_package_added_to_the_system() {

    response=serviceProvider.addPackage(123,200,100,"Nablus", "Sunny Beach Resort", "wifi", "abdullah");

        assertEquals("package added successfully", response);
    }

    @Then("display a confirmation message {string}")
    public void display_a_confirmation_message(String expectedMessage) {
        assertEquals(expectedMessage, response);
    }

    @Given("a package with ID {string} exists")
    public void a_package_with_id_exists(String id) {
        response = serviceProvider.removePackage(Integer.parseInt(id));

    }

    @When("the service provider requests to remove the package with ID {string}")
    public void the_service_provider_requests_to_remove_the_package_with_id(String id) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("The Packege is removed", response);
    }
@Test
    @Then("the system should remove the package")
    public void the_system_should_remove_the_package() {
    response = serviceProvider.removePackage(Integer.parseInt("123"));
        assertEquals("The Packege is removed", response);
    }

    @When("the service provider requests to remove a package with ID {string} that does not exist")
    public void the_service_provider_requests_to_remove_a_package_with_id_that_does_not_exist(String id) {

        response = serviceProvider.removePackage(Integer.parseInt(id));

    }
@Test
    @Then("the system should not remove any package")
    public void the_system_should_not_remove_any_package() {

        response = serviceProvider.removePackage(Integer.parseInt("987"));
        assertEquals("package not found", response);
    }

    @Then("display a message {string}")
    public void display_a_message(String msg) {

        assertEquals(msg,response);
        }

    @When("the service provider selects to update the package with ID {string}")
    public void the_service_provider_selects_to_update_the_package_with_id(String id)
    {


        selectedPackageId = Integer.parseInt(id);
    }
@Test
    @When("enters {string} for the option to update the price")
    public void enters_for_the_option_to_update_the_price() {
//        this.op = Integer.parseInt(option);
        op=1;
        assertEquals("The option should be for updating price", 1, this.op);

    }

    @When("inputs the new price {string}")
    public void inputs_the_new_price(String newPrice) {
        // Write code here that turns the phrase above into concrete actions
        response = serviceProvider.updatePackage(this.selectedPackageId, this.op, newPrice);

    }
@Test
    @Then("the system should update the package's price to {string}")
    public void the_system_should_update_the_package_s_price_to() {
    response=serviceProvider.addPackage(123,200,100,"Nablus", "Sunny Beach Resort", "wifi", "abdullah");

    // Packege updatedPackage = app.getPackageById(this.selectedPackageId); // Assuming this method exists for retrieving a package by ID
        response = serviceProvider.updatePackage(123, 1, "300");
        assertEquals("Package updated successfully.", response);
    }

    @When("the service provider attempts to update a package with ID {string} that does not exist")
    public void the_service_provider_attempts_to_update_a_package_with_id_that_does_not_exist(String id) {

        response = serviceProvider.updatePackage(Integer.parseInt(id),1,"300");
    }
    @Test
    @Then("the system should display a message {string}")
    public void the_system_should_display_a_message() {
        response = serviceProvider.updatePackage(766543,1,"300");

        assertEquals("Package not found.",response);
    }

    @Given("service provider {string} has added packages")
    public void service_provider_has_added_packages(String string) {

    }

    @When("{string} views their packages")
    public void views_their_packages(String serviceProviderName) {
        // Use the adapted method to retrieve package descriptions



    }
@Test
    @Then("the system should display all packages added by {string}")
    public void the_system_should_display_all_packages_added_by() {

        response=serviceProvider.showMyPackeges("abdullah");
        assertEquals("There are packages",response);

    }

    @Given("service provider {string} has tasks assigned")
    public void service_provider_has_tasks_assigned(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("{string} views their tasks")
    public void views_their_tasks(String serviceProviderName) {

        response=serviceProvider.showMyTasks(serviceProviderName);
    }
@Test
    @Then("the system should display all tasks assigned to {string}")
    public void the_system_should_display_all_tasks_assigned_to() {

        response=serviceProvider.showMyTasks("abdullah");
        assertEquals("There are tasks",response);
    }

    @Given("service provider {string} has messages")
    public void service_provider_has_messages(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("{string} views their messages")
    public void views_their_messages(String serviceProviderName) {

        response=serviceProvider.showMessages(serviceProviderName);
    }
@Test
    @Then("the system should display all messages for {string}")
    public void the_system_should_display_all_messages_for() {

        response=serviceProvider.showMessages("abdullah");
        assertEquals("No massages found",response);
    }


}
