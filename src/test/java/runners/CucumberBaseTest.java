package runners;


import driverUtils.AbstractDriverManager;
import driverUtils.DriverManagerFactory;
import driverUtils.DriverType;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.text.MessageFormat;


@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepDefinitions"})
public class CucumberBaseTest {
    protected RemoteWebDriver driver;
    private AbstractDriverManager driverManager;

    @Before(order = 1)
    public void beforeScenario(Scenario scenario) {
        System.out.println("------------------------------");
        System.out.println(MessageFormat.format("Starting - {0}", scenario.getName()));
        System.out.println("------------------------------");
    }

    @Before()
    public void initDriver() {
        driverManager = DriverManagerFactory.getInstance();
        driver = driverManager.getDriver();
    }

    @After()
    public void close() {
        driverManager.quitDriver();
    }
}