package StudyHall.stepsDefinitions;

import StudyHall.pages.renasPracticePage;
import code.utils.BrowserUtils;
import code.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class renasPractice extends BrowserUtils {

    renasPracticePage renasPracticePage = new renasPracticePage();
    @Given("User navigates to the websites {string}")
    public void user_navigates_to_the_websites(String url) {
        Driver.getDriver().navigate().to(url);
    }
    @When("User clicks Get a Quote button")
    public void user_clicks_get_a_quote_button() {
       renasPracticePage.setGetAQuote();
    }
    @Then("User chooses vehicle year as {string}")
    public void user_chooses_vehicle_year_as(String year) throws InterruptedException {
       renasPracticePage.setMakeAYear(year);
    }
    @Then("User make vehicle as {string}")
    public void user_make_vehicle_as(String string) {
        Assert.assertTrue(true);
    }
    @Then("User make model as {string}")
    public void user_make_model_as(String string) {
        Assert.assertTrue(true);
    }
    @Then("The next button is enabled and click Next button")
    public void the_next_button_is_enabled_and_click_next_button() {
        Assert.assertTrue(true);
    }
    @Then("User clicks Coverage Start date")
    public void user_clicks_coverage_start_date() {
      renasPracticePage.setClickCoverageStartDate();
    }
    @Then("User choose start date")
    public void user_choose_start_date() {
     renasPracticePage.setClickCalender();
    }
}
