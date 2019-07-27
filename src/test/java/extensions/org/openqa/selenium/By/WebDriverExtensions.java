package extensions.org.openqa.selenium.By;

import manifold.ext.api.Extension;
import manifold.ext.api.This;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.drivers.Driver;
/**
 * @author Ibraiym Denizov
 */

@Extension
public class WebDriverExtensions {

    @Extension
    public static WebElement eFindElement(@This By locator)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        return wait.until(drv -> drv.findElement(locator));
    }

    @Extension
    public static void eClick(@This By locator){
        locator.eFindElement().eClick();
    }

    @Extension
    public static void eSendKeys(@This By locator, String text)
    {
        locator.eFindElement().sendKeys(text);
    }


}
