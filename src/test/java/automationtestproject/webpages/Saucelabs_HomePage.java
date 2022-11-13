package automationtestproject.webpages;

import automationtestproject.TestBase;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;
import org.junit.Assert;

public class Saucelabs_HomePage extends TestBase {

    @FindBy(xpath = "//*[@id='header_container']/div[2]/span")
    public WebElementFacade PageTitle;

    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
    public WebElementFacade AddToCartButton;

    @FindBy(css = ".shopping_cart_link")
    public WebElementFacade ShoppingCartLink;

    @FindBy(xpath = "//input[@placeholder='Search apps and items...']")
    public WebElementFacade AppSearchText;

    @FindBy(xpath = "//*[@id='input-194']")
    public WebElementFacade AppSearchField;

    @FindBy(xpath = "//*[@id='Lead']/div/lightning-formatted-rich-text/span/p/b")
    public WebElementFacade LeadElement;

    @FindBy(xpath = "//*[@id='Unit__c']")
    public WebElementFacade UnitElement;

    @Step
    public void validateHomePageLoaded() {
        String expectedTitle = PageTitle.getText();
        Assert.assertEquals("PRODUCTS", expectedTitle);
    }

    @Step
    public void clickAddToCartButton() {
        AddToCartButton.click();
    }

    @Step
    public void clickAddCartLink() {
        ShoppingCartLink.click();

    }

    @Step
    public void clickLeadObject() {
        JavascriptExecutorFacade js = new JavascriptExecutorFacade(getDriver());
        js.executeScript("arguments[0].click();", LeadElement);
    }

    @Step
    public void clickUnitsObject() {
        JavascriptExecutorFacade js = new JavascriptExecutorFacade(getDriver());
        js.executeScript("arguments[0].click();", UnitElement);
    }

}
