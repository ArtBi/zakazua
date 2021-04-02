package runners;


import driverUtils.DriverManagerFactory;
import io.cucumber.java.Scenario;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.ScreenshotUtils;

import java.text.MessageFormat;

import static java.util.Optional.ofNullable;

public class Hook {

    @Before()
    public void beforeScenario(Scenario scenario) {
        System.out.println("------------------------------");
        System.out.println(MessageFormat.format("Starting - {0}", scenario.getName()));
        System.out.println("------------------------------");
    }

    @Before()
    public void ifScenarioFailed(Scenario scenario) {
        if (scenario.isFailed()) {
            WebDriver driver = DriverManagerFactory.getInstance().getManager().getDriver();
            ofNullable(driver).ifPresent(ScreenshotUtils::takeScreenshot);
        }
    }
}
