package Softwear_Project_Acceptance_Test;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Cases",
        plugin = {"summary","html:target/cucumber/report.html"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"Softwear_Project_Acceptance_Test"}

)


public class Acceptance {

}
