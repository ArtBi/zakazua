package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import steps.metro.MainPageSteps;
import steps.metro.SearchResultPageSteps;

public class StepFactory {

    private WebDriver driver;
    private MainPageSteps mainPageSteps;
    private SearchResultPageSteps searchResultPageSteps;

    public StepFactory(RemoteWebDriver driver) {
        this.driver = driver;
    }


    public MainPageSteps getMainPageSteps() {
        if(mainPageSteps == null) {
            mainPageSteps = new MainPageSteps(driver);
        }
        return mainPageSteps;
    }


    public SearchResultPageSteps getSearchResultPageSteps() {
        if(searchResultPageSteps == null) {
            searchResultPageSteps = new SearchResultPageSteps(driver);
        }
        return searchResultPageSteps;
    }
}
