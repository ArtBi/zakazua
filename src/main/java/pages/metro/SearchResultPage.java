package pages.metro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.BasePage;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//span[text() = 'Результаты поиска по запросу']")
    WebElement searchResultText;

    @FindBy(xpath = "//div[@data-marker='Products Box']//a[@data-marker='Product Tile']")
    List<WebElement> productsElements;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getProductsElements() {
        return productsElements;
    }

    @Override
    public void waitUntilPageOpened() {
        searchResultText.isDisplayed();
    }
}
