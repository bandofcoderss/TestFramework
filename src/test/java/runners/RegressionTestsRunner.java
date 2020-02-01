package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="resources/features"
        ,glue=""
        ,dryRun = false
        ,tags = "@regression"
        ,plugin =  {"pretty","html:target/html", "json:target/cucumber.json"})
public class RegressionTestsRunner {
}
