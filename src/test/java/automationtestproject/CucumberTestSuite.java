package automationtestproject;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = { "pretty", "json:target/MyJsonReport/report.json",
        "junit:target/MyJunitReport/report.xml" }, features = "src/test/resources/", dryRun = false, monochrome = true, tags="@Saucelab")
public class CucumberTestSuite {
}
