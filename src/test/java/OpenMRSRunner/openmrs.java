package OpenMRSRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
	features = {"src/test/resources/Features"},
	tags = "@Login",
	glue = {"StepDefinitions"},
	plugin = {"pretty","html:taget/cucumber-reports",
			"json:target/cucumber-reports/cucumber-usage.json",
			"junit:target/cucumber-results.xml"},
	monochrome= true
)
public class openmrs {

}
