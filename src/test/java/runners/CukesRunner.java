package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="resources/features"
                ,glue=""
                ,dryRun = false
                ,plugin =  {"pretty","html:target/html", "json:target/cucumber.json"})

public class CukesRunner {
}
