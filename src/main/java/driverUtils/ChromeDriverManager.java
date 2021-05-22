package driverUtils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class ChromeDriverManager extends AbstractDriverManager {
    private ChromeDriverService chService;

    @Override
    public void startService() {
        if (null == chService) {
            try {
                chService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File("src\\main\\resources\\drivers\\chromedriver.exe"))
                        .usingAnyFreePort()
                        .build();
                chService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public RemoteWebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        return new ChromeDriver(chService, options);
    }

}
