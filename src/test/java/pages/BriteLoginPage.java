package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;
import utils.Settings;

public class BriteLoginPage extends BasePage {

    public BriteLoginPage(){super();}

    @FindBy(id = "login")
    private WebElement emailInputField;
    @FindBy(id = "password")
    private WebElement passwordInputField;
    @FindBy(xpath = "//button[.='Log in']")
    private WebElement loginButton;

    public BriteLoginPage enterEmail(String userEmail){
        BrowserUtils.waitForVisibility(emailInputField, Settings.DEFAULTWAITTIME).sendKeys(userEmail);
        return this;
    }

    public BriteLoginPage enterPassword(String password){
        BrowserUtils.waitForVisibility(passwordInputField, Settings.DEFAULTWAITTIME).sendKeys(password);
        return this;
    }

    public BriteLoginPage clickLoginButton(){
        BrowserUtils.waitForClickablility(loginButton, Settings.DEFAULTWAITTIME).click();
        return this;
    }
}
