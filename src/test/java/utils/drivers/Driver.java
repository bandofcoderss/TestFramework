package utils.drivers;

import org.openqa.selenium.WebDriver;
/**
 * @author Ibraiym Denizov
 */
public class Driver {

    private Driver(){}

    public static Driver Instance = new Driver();
    protected WebDriver webDriver;

    public static WebDriver getDriver(){return Instance.webDriver;}

    public void startChrome()
    {
        if(webDriver != null)return;
        webDriver = ChromeWebDriver.LoadChromeDriver();
    }

    public void startIE()
    {
        if(webDriver != null)return;
        webDriver = IEWebDriver.LoadIEDriver();
    }

    public void startHeadless()
    {
        if(webDriver != null)return;
        webDriver = HeadlessChromeWebDriver.LoadHeadlessChromeDriver();
    }

    public void stopWebDriver()
    {
        try
        {
            webDriver.quit();
            webDriver.close();
        }catch (Exception e)
        {
            //log error message
        }
        webDriver = null;
    }




}
