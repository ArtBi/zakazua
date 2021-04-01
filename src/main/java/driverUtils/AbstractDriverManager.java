package driverUtils;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public abstract class AbstractDriverManager {

    protected static ThreadLocal<RemoteWebDriver> drivers = new ThreadLocal<>();

    protected abstract RemoteWebDriver createDriver();

    protected abstract void startService();

    public void quitDriver() {
        if (null != drivers.get()) {
            try {
                System.out.println("Finish session: " + drivers.get().getSessionId());
                drivers.get().quit(); // First quit WebDriver session gracefully
                drivers.remove(); // Remove WebDriver reference from the ThreadLocal variable.
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException("Unable to gracefully quit WebDriver.", e); // We'll replace this with actual Loggers later - don't worry !
            }
        }
    }

    public RemoteWebDriver getDriver() {
        if (null == drivers.get()) {
            startService();
            drivers.set(this.createDriver());
            setOptionsToDriver();
        }
        return drivers.get();
    }

    private void setOptionsToDriver() {
        drivers.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        drivers.get().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        drivers.get().manage().window().maximize();
    }

    public boolean isRunning() {
        return drivers.get() != null;
    }
}
