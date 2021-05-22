package driverUtils;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class SelenoidDriverManager extends AbstractDriverManager {

    private static URL getSelenoidURL() {
        try {
            return URI.create("http://192.168.50.41:4444/wd/hub").toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Cannot create Selenoid URL", e);
        }
    }

    public DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("85.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        return capabilities;
    }

    @Override
    public void startService() {

    }


    @Override
    public RemoteWebDriver createDriver() {
        return new RemoteWebDriver(getSelenoidURL(), getCapabilities());
    }
}
