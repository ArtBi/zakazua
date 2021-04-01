package stepDefinitions;

import driverUtils.DriverManagerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import steps.StepFactory;
import steps.metro.MainPageSteps;
import steps.metro.SearchResultPageSteps;


public class MetroSearchTests {

    MainPageSteps mainPageSteps;
    SearchResultPageSteps searchResultPageSteps;


    @Given("Metro portal is opened")
    public void openMetroPortal() {
        StepFactory stepFactory = new StepFactory(DriverManagerFactory.getInstance().getManager().getDriver());
        mainPageSteps = stepFactory.getMainPageSteps();
        searchResultPageSteps = stepFactory.getSearchResultPageSteps();
        mainPageSteps.openShop();
    }


    @When("I search the following item {string}")
    public void someTes(String itemToSearch) {
        mainPageSteps.searchGivenItem(itemToSearch);

    }

    @Then("On the page are present more then {int} items")
    public void someTes(int expectedCount) {
        int actualCount = searchResultPageSteps.getCountOfProductsOnTheSearchPage();

        Assert.assertTrue( actualCount >= expectedCount);
    }

}
