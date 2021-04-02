package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.sql.Timestamp;

public class ScreenshotUtils {

    public static byte[] takeScreenshot(WebDriver driver) {
        if (driver == null) return null;
        try {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File targetFile =
                    new File("target\\json-report\\screenshots\\ " + getTimeStamp() + ".png");
            if (targetFile.exists()) {
                targetFile.delete();
            }
            Files.copy(targetFile.toPath(), new FileOutputStream(file));
            return Files.readAllBytes(file.toPath());
        } catch (Exception e) {
            return null;
        }
    }

    private static String getTimeStamp() {
        return new Timestamp(System.currentTimeMillis()).toString();
    }
}
