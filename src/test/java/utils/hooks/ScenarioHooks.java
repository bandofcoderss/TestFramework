package utils.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Settings;
import utils.drivers.Driver;

import java.util.concurrent.TimeUnit;

public class ScenarioHooks {

    @Before("not @api")
    public void startWebDriver()
    {
        String browser = Settings.BROWSER;
        switch (browser.trim().toUpperCase())
        {
            case "CHROME":
            case "DEBUG":
                Driver.Instance.startChrome(); break;
            case "IE" : Driver.Instance.startIE(); break;
            case "HEADLESS": Driver.Instance.startHeadless(); break;
            default: // log some error message or start chrome by default
        }
        Driver.getDriver().manage().timeouts().implicitlyWait(Settings.IMPLICITWAITTIME, TimeUnit.SECONDS);
    }

    @After("not @api")
    public void ScenarioTearDown(Scenario scenario){
        if (scenario.isFailed()) {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.embed(screenshot, "image/png");
        }
        //will close browser after scenario unless the value of browser in configuration.properties file is 'DEBUG"
        if(!Settings.BROWSER.trim().toUpperCase().equalsIgnoreCase("DEBUG"))
            Driver.Instance.stopWebDriver();
    }

}
