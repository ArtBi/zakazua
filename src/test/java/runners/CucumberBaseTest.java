package runners;


import driverUtils.AbstractDriverManager;
import driverUtils.DriverManagerFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.RemoteWebDriver;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepDefinitions", "runners"},
        tags = "@SmokeTest")
public class CucumberBaseTest {
    protected static RemoteWebDriver driver;
    private static AbstractDriverManager driverManager;

    @BeforeClass()
    public static void initDriver() {
        driverManager = DriverManagerFactory.getInstance().getManager();
        driver = driverManager.getDriver();
    }

    @AfterClass()
    public static void close() {
        driverManager.quitDriver();
    }
}