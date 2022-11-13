package automationtestproject.webpages;

import automationtestproject.TestBase;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class Saucelabs_CheckoutCompleted extends TestBase {
    @FindBy(xpath = "//*[@id='header_container']/div[2]/span")
    public WebElementFacade PageTitle;

    @FindBy(xpath = "//*[@id='checkout_complete_container']/h2")
    public WebElementFacade CheckoutCompleteMessage;


    @Step
    public void validateCheckoutCompletePageLoaded() {
        String expectedTitle = PageTitle.getText();
        Assert.assertEquals("CHECKOUT: COMPLETE!", expectedTitle);
    }

    @Step
    public void validateCheckoutCompleteMessage() {
        String expectedMessage = CheckoutCompleteMessage.getText();
        Assert.assertEquals("THANK YOU FOR YOUR ORDER", expectedMessage);
    }

}

