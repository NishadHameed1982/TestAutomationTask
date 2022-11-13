package automationtestproject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;

import java.time.Duration;

public class TestBase extends PageObject {
    
    public void safeClickOn(WebElementFacade webElementFacade) {

        try {
            webElementFacade.withTimeoutOf(Duration.ofSeconds(30))
                    .waitUntilVisible().waitUntilClickable().click();
        } catch (org.openqa.selenium.NoSuchElementException
                 | StaleElementReferenceException | NullPointerException e) {
            Assert.fail("Some issue in clicking the element " + webElementFacade);
        }
    }


}
