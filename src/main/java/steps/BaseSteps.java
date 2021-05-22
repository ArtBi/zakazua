package steps;

import org.openqa.selenium.WebDriver;
import pages.metro.MainPage;
import pages.metro.SearchResultPage;

public class BaseSteps {

    protected MainPage mainPage;
    protected SearchResultPage searchResultPage;


    protected void initMainPage(WebDriver driver) {
        if (mainPage == null) {
            mainPage = new MainPage(driver);
        }
    }

    protected void initSearchResultPage(WebDriver driver) {
        if (searchResultPage == null) {
            searchResultPage = new SearchResultPage(driver);
        }
    }

}
