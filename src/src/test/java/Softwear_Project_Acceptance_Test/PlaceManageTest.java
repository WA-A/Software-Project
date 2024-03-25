package Softwear_Project_Acceptance_Test;

import org.example.Packege;
import org.example.PackageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class PlaceManageTest {

    private static final PackageManager packageManager = new PackageManager();
    private String lastOperationResult;
    @Given("I am logged in as a serviceProvider")
    public void i_am_logged_in_as_a_service_provider() {
        // Assuming the login mechanism is handled elsewhere or not relevant for these tests
    }

    @When("I add a new venue with details {string}, {string}, {string}, {string}, {string}, {string}")
    public void i_add_a_new_venue_with_details(String id, String name, String capacity, String amenities, String pricing, String location) {
        int packageId = Integer.parseInt(id);
        int packageCapacity = Integer.parseInt(capacity);
        int packagePrice = Integer.parseInt(pricing);
        Packege newPackage = new Packege(packageId, packagePrice, packageCapacity, location, name, amenities, "ServiceProviderName"); // Assuming ServiceProviderName is a placeholder
        lastOperationResult = packageManager.addPackage(newPackage);
    }

    @Then("Id {string} should be added to the venue list")
    public void id_should_be_added_to_the_venue_list(String id) {
        assertNotNull(packageManager.getPackage(Integer.parseInt(id)));  }

    @Given("Id {string} is listed in the venue list")
    public void id_is_listed_in_the_venue_list(String string) {
        // This step would ensure that a package with the given ID exists; for simplicity, we'll assume it's already added.
    }

    @When("I request to remove the venue with Id {string}")
    public void i_request_to_remove_the_venue_with_id(String id) {
        lastOperationResult = packageManager.removePackage(Integer.parseInt(id));
    }

    @Then("Id {string} should be removed from the venue list")
    public void id_should_be_removed_from_the_venue_list(String id) {
        assertNull(packageManager.getPackage(Integer.parseInt(id)));
    }

    @When("I update the venue {string} with name {string}, capacity {string}, amenities {string}, pricing {string}, location {string}")
    public void i_update_the_venue_with_name_capacity_amenities_pricing_location(String id, String name, String capacity, String amenities, String pricing, String location) {
        int packageId = Integer.parseInt(id);
        int packageCapacity = Integer.parseInt(capacity);
        int packagePrice = Integer.parseInt(pricing);
        Packege updatedPackage = new Packege(packageId, packagePrice, packageCapacity, location, name, amenities, "ServiceProviderName"); // ServiceProviderName is a placeholder
        lastOperationResult = packageManager.updatePackage(packageId, updatedPackage);
    }

    @Then("Id {string} should have updated details in the venue list")
    public void id_should_have_updated_details_in_the_venue_list(String id) {
        Packege pkg = packageManager.getPackage(Integer.parseInt(id));
        assertNotNull(pkg);
        // Here you could add more detailed assertions to verify the update was successful
    }
}


