package pages.metro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@data-marker='Search Input']")
    WebElement searchField;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageOpened() {
        throw new UnsupportedOperationException();
    }

    public WebElement getSearchField() {
        return searchField;
    }
}
