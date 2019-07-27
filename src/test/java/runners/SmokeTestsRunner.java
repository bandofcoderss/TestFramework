package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="resources/features"
        ,glue=""
        ,dryRun = false
        ,tags = "@smoke")

public class SmokeTestsRunner {
}
