package steps.metro;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import steps.BaseSteps;


public class MainPageSteps extends BaseSteps {

    private static final String PATH_TO_MAIN_PAGE = "https://metro.zakaz.ua/";
    private WebDriver driver;

    public MainPageSteps(WebDriver driver) {
        super.initMainPage(driver);
        super.initSearchResultPage(driver);
        this.driver = driver;
    }

    public void openShop() {
        driver.get(PATH_TO_MAIN_PAGE);
    }

    public void searchGivenItem(String itemToSearch) {
        mainPage.getSearchField().sendKeys(itemToSearch);
        mainPage.getSearchField().sendKeys(Keys.ENTER);
        searchResultPage.waitUntilPageOpened();
    }
}
