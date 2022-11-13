package automationtestproject.webpages;

import automationtestproject.TestBase;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

@DefaultUrl("page:saucelab.page")
public class Saucelabs_LoginPage extends TestBase {
    @FindBy(css = "input#user-name.input_error.form_input")
    public WebElementFacade UserNameTextInput;

    @FindBy(css = "input#password.input_error.form_input")
    public WebElementFacade PasswordTextInput;

    @FindBy(css = "input#login-button.submit-button.btn_action")
    public WebElementFacade LoginButton;

    @FindBy(xpath = "//*[@id='login_button_container']/div/form/div[3]/h3")
    public WebElementFacade LockedOutUserMessage;

    @Step
    public void enterUserName(String userName) {
        UserNameTextInput.sendKeys(userName);
    }

    @Step
    public void enterPassword(String password) {
        PasswordTextInput.sendKeys(password);
    }

    @Step
    public void clickLoginButton() {
        safeClickOn(LoginButton);
    }

    @Step
    public void validateLockedOutMessage() {
        String expectedMessage = LockedOutUserMessage.getText();
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", expectedMessage);
    }

    @Step
    public void validateInvalidUserMessage() {
        String expectedMessage = LockedOutUserMessage.getText();
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", expectedMessage);
    }

}

