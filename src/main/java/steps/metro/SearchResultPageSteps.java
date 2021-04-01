package steps.metro;

import org.openqa.selenium.WebDriver;
import steps.BaseSteps;

public class SearchResultPageSteps extends BaseSteps {

    public SearchResultPageSteps(WebDriver driver) {
        super.initSearchResultPage(driver);
    }

    public int getCountOfProductsOnTheSearchPage() {
        return searchResultPage.getProductsElements().size();
    }
}
