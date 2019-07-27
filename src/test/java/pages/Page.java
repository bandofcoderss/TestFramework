package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.drivers.Driver;

/**
 * https://www.swtestacademy.com/page-factory-selenium-webdriver/
 * @author Ibraiym Denizov
 */
public class Page {

    public WebDriver driver;

    //Constructor
    public Page(){
        this.driver = Driver.getDriver();
    }

    //JAVA Generics to Create and return a New Page
    public  <TPage extends BasePage> TPage GetInstance (Class<TPage> pageClass) {
        try {
            //Initialize the Page with its elements and return it.
            return PageFactory.initElements(driver,  pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
