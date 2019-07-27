package utils.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
/**
 * @author Ibraiym Denizov
 */
public class IEWebDriver
{
    protected static WebDriver LoadIEDriver()
    {
        WebDriverManager.iedriver().setup();
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.enablePersistentHovering();
        options.destructivelyEnsureCleanSession();//optional
        return new InternetExplorerDriver(options);
    }
}
