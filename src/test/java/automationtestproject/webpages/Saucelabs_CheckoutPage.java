package automationtestproject.webpages;

import automationtestproject.TestBase;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class Saucelabs_CheckoutPage extends TestBase {
    @FindBy(xpath = "//*[@id='header_container']/div[2]/span")
    public WebElementFacade PageTitle;

    @FindBy(css = "#first-name.input_error.form_input")
    public WebElementFacade FirstNameTextInput;

    @FindBy(css = "#last-name.input_error.form_input")
    public WebElementFacade LastNameTextInput;

    @FindBy(css = "#postal-code.input_error.form_input")
    public WebElementFacade PostalCodeTextInput;

    @FindBy(css = "#continue.submit-button.btn.btn_primary.cart_button.btn_action")
    public WebElementFacade ContinueButton;


    @Step
    public void validateCheckoutPageLoaded() {
        String expectedTitle = PageTitle.getText();
        Assert.assertEquals("CHECKOUT: YOUR INFORMATION", expectedTitle);
    }

    @Step
    public void enterFirstName(String firstName) {
        FirstNameTextInput.sendKeys(firstName);
    }

    @Step
    public void enterLastName(String lastName) {
        LastNameTextInput.sendKeys(lastName);
    }

    @Step
    public void enterPostalCode(String postalCode) {
        PostalCodeTextInput.sendKeys(postalCode);
    }

    @Step
    public void clickCountinueButton() {
        ContinueButton.click();
    }


}
