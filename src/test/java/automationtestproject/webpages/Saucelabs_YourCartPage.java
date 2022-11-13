package automationtestproject.webpages;

import automationtestproject.TestBase;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class Saucelabs_YourCartPage extends TestBase {

    @FindBy(xpath = "//*[@id='header_container']/div[2]/span")
    public WebElementFacade PageTitle;

    @FindBy(css = ".btn.btn_action.btn_medium.checkout_button")
    public WebElementFacade CheckOutButton;


    @Step
    public void validateYourCartPageLoaded() {
        String expectedTitle = PageTitle.getText();
        Assert.assertEquals("YOUR CART", expectedTitle);
    }
    
    @Step
    public void clickCheckOutButton() {
        CheckOutButton.click();
    }


}
