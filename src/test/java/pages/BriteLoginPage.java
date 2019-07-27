package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
        emailInputField.eSendKeys(userEmail);
        return this;
    }

    public BriteLoginPage enterPassword(String password){
        passwordInputField.eSendKeys(password);
        return this;
    }

    public BriteLoginPage clickLoginButton(){
        loginButton.eClick();
        return this;
    }
}
