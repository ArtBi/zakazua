package stepDefinitions;

import driverUtils.DriverManagerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import steps.StepFactory;
import steps.metro.MainPageSteps;
import steps.metro.SearchResultPageSteps;


public class MetroSearchTests {

    MainPageSteps mainPageSteps;// = StepFactory.getMainPageSteps(DriverManagerFactory.getInstance().getDriver());
    SearchResultPageSteps searchResultPageSteps;// = StepFactory.getSearchResultPageSteps(DriverManagerFactory.getInstance().getDriver());


    @Given("Metro portal is opened without login")
    public void openMetroPortalWithoutLogin() {
        StepFactory stepFactory = new StepFactory(DriverManagerFactory.getInstance().getDriver());
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
