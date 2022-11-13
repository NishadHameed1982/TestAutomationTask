package automationtestproject.stepdefinitions;

import automationtestproject.TestBase;
import automationtestproject.utilities.ExcelReader;
import automationtestproject.utilities.PropertyManager;
import automationtestproject.webpages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WebSauceLabsStepDefinition extends TestBase {
    @Steps
    Saucelabs_LoginPage loginPage;
    @Steps
    Saucelabs_HomePage homePage;
    @Steps
    Saucelabs_YourCartPage yourCartPage;
    @Steps
    Saucelabs_CheckoutPage checkoutPage;
    @Steps
    Saucelabs_CheckoutOverview checkoutOverview;

    @Steps
    Saucelabs_CheckoutCompleted checkoutComplete;


    @Given("Login to saucelabs using valid credentials from file {string} sheet {string} and row {int}")
    public void loginToSaucelabs(String filename, String sheetname, Integer row) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData = reader.getData(PropertyManager.getInstance().valueFromConfig("EXCEL_INPUT_FILE_PATH") + filename,
                sheetname);
        Map<String, String> listItem = testData.get(row);
        loginPage.open();
        loginPage.enterUserName(listItem.get("UserName"));
        loginPage.enterPassword(listItem.get("Password"));
        loginPage.clickLoginButton();
        homePage.validateHomePageLoaded();
    }

    @Given("Select three available items randomly")
    public void selectThreeAvailableItems() throws InterruptedException {
        homePage.clickAddToCartButton();
        homePage.clickAddToCartButton();
        homePage.clickAddToCartButton();
    }

    @Given("Click on Cart button")
    public void clickAddCartButton() throws InterruptedException {
        homePage.clickAddCartLink();
        yourCartPage.validateYourCartPageLoaded();
    }

    @Given("Click on Checkout button")
    public void clickCheckoutButton() {
        yourCartPage.clickCheckOutButton();
        checkoutPage.validateCheckoutPageLoaded();
    }

    @Given("Enter checkout information from file {string} sheet {string} and row {int}")
    public void enterCheckoutInformation(String filename, String sheetname, Integer row) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData = reader.getData(PropertyManager.getInstance().valueFromConfig("EXCEL_INPUT_FILE_PATH") + filename,
                sheetname);
        Map<String, String> listItem = testData.get(row);
        checkoutPage.enterFirstName(listItem.get("FirstName"));
        checkoutPage.enterLastName(listItem.get("LastName"));
        checkoutPage.enterPostalCode(listItem.get("PostalCode"));

    }

    @Given("Click Continue button")
    public void clickContinueButton() throws InterruptedException {
        checkoutPage.clickCountinueButton();
        checkoutOverview.validateCheckoutOverviewPageLoaded();

    }

    @When("Click Finish Button")
    public void clickFinishButton() throws InterruptedException {
        checkoutOverview.clickFinishButton();
        checkoutComplete.validateCheckoutCompletePageLoaded();
        checkoutComplete.validateCheckoutCompleteMessage();
    }

    @Given("Validate the confirmation message")
    public void validateOrderConfirmation() throws InterruptedException {
        checkoutComplete.validateCheckoutCompleteMessage();
    }

    @Given("Enter UserName from file {string} sheet {string} and row {int}")
    public void enterUserName(String filename, String sheetname, Integer row) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData = reader.getData(PropertyManager.getInstance().valueFromConfig("EXCEL_INPUT_FILE_PATH") + filename,
                sheetname);
        Map<String, String> listItem = testData.get(row);
        loginPage.open();
        loginPage.enterUserName(listItem.get("UserName"));

    }

    @Given("Enter Password from file {string} sheet {string} and row {int}")
    public void enterPassword(String filename, String sheetname, Integer row) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData = reader.getData(PropertyManager.getInstance().valueFromConfig("EXCEL_INPUT_FILE_PATH") + filename,
                sheetname);
        Map<String, String> listItem = testData.get(row);
        loginPage.enterPassword(listItem.get("Password"));

    }

    @When("Click on Login button")
    public void click_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("Validate the Lockedout error message")
    public void validateErrorMessage() {
        loginPage.validateLockedOutMessage();

    }

    @Then("Validate the Invalid User error message")
    public void validateInavlidUserErrorMessage() {
        loginPage.validateInvalidUserMessage();

    }

}
