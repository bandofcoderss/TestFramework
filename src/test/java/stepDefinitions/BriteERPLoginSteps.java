package stepDefinitions;

import cucumber.api.java.en.*;
import org.junit.Assert;
import pages.BriteLoginPage;
import utils.BrowserUtils;
import utils.Settings;
import utils.drivers.Driver;

public class BriteERPLoginSteps extends BaseSteps{

    @Given("Employee on Login Page of the application")
    public void employee_on_Login_Page_of_the_application() {
        Driver.getDriver().get(Settings.BASEURL);
    }

    @When("Employee logs in with valid credentials")
    public void employee_logs_in_with_valid_credentials() {
        GetInstance(BriteLoginPage.class)
                .enterEmail(Settings.EMPLOYEE_EMAIL)
                .enterPassword(Settings.EMPLOYEEPASSWORD)
                .clickLoginButton();


    }

    @Then("Employee navigates to Inbox page of the application")
    public void employee_navigates_to_Inbox_page_of_the_application() {
        String expectedTitle = "#Inbox - Odoo";
        BrowserUtils.waitForTitleUpdate(expectedTitle);
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Inbox page title validation failed", expectedTitle, actualTitle);
    }

    @Given("Manager on Login Page of the application")
    public void manager_on_Login_Page_of_the_application() {
        this.employee_on_Login_Page_of_the_application();
    }

    @When("Manager logs in with valid credentials")
    public void manager_logs_in_with_valid_credentials() {
        GetInstance(BriteLoginPage.class)
                .enterEmail(Settings.MANAGER_EMAIL)
                .enterPassword(Settings.MANAGERPASSWORD)
                .clickLoginButton();
    }

    @Then("Manager navigates to Inbox page of the application")
    public void manager_navigates_to_Inbox_page_of_the_application() {
        String expectedTitle = "#Inbox - Odoo";
        BrowserUtils.waitForTitleUpdate(expectedTitle);
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Inbox page title validation failed", expectedTitle, actualTitle);
    }

    @Then("fail")
    public void fail() {
        Assert.fail("Test Failure");
    }


}
