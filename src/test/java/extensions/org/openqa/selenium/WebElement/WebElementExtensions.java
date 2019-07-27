package extensions.org.openqa.selenium.WebElement;

import manifold.ext.api.*;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Settings;
import utils.drivers.Driver;
/**
 * @author Ibraiym Denizov
 */
@Extension
public class WebElementExtensions {

    static int defaultWaitTime = Settings.DEFAULTWAITTIME;

    @Extension
    public static void eHighLightElement(@This WebElement element)
    {
        JavascriptExecutor js= (JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].style.border = '4px solid grey'", element);
    }

    @Extension
    public static void eClick(@This WebElement e){
        e.eElementToBeClickable(defaultWaitTime).click();
    }
    @Extension
    public static void eClick(@This WebElement e, int sec){
        e.eElementToBeClickable(sec).click();
    }

    public static void eSendKeys(@This WebElement e, String keys){
        e.eElementIsDisplayed();
        e.sendKeys(keys);
    }

    @Extension
    public static WebElement eElementToBeClickable(@This WebElement element, int sec)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), sec);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    @Extension
    public static boolean eElementIsEnabled(@This WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), defaultWaitTime);
        return wait.until(d ->
        {
            try
            {
                return element.isEnabled();
            }
            catch(StaleElementReferenceException e) // why stale element reference exception???
            {
                return false;
            }
        });
    }

    @Extension
    public static boolean eElementIsDisplayed(@This WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), defaultWaitTime);
        return wait.until(d ->
        {
            try
            {
                return element.isDisplayed();
            }
            catch(ElementNotVisibleException e)
            {
                return false;
            }
        });
    }

    @Extension
    public static WebElement eMoveToWebElement(@This WebElement element){
        element.eElementToBeClickable(defaultWaitTime);
        Actions action = new Actions(Driver.getDriver());
        action
                .moveToElement(element)
                .perform();
        return element;
    }

    @Extension
    public static WebElement eMoveToWebElementAndSendKeys(@This WebElement element, String text){
        element.eElementToBeClickable(defaultWaitTime);
        Actions action = new Actions(Driver.getDriver());
        action
                .moveToElement(element)
                .click();
        action
                .sendKeys(text)
                .build()
                .perform();
        return element;
    }


}
