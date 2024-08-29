package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
//		strict = true,
//		features = "src\\test\\resources\\features\\CodeFiosLogin.feature", 
		features = "src\\test\\resources\\features", 
		glue = "steps", // this is referring to the package that holds all the steps
		tags = "@DBLoginScenario1",
		monochrome = true, 
		dryRun = false, 
		plugin = { 
				"pretty", 
				"html:target/reports/cucumber.html",
				"json:target/reports/cucumber.json"

		}

		
		)

public class LoginRunner {

}


