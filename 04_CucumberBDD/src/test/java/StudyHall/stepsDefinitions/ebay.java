package StudyHall.stepsDefinitions;

import StudyHall.pages.ebayPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;
import code.utils.BrowserUtils;
import code.utils.Driver;


public class ebay extends BrowserUtils {

    ebayPage ebay = new ebayPage();
    @Given("User navigates to website as {string}")
    public void user_navigates_to_website_as(String url) {
        Driver.getDriver().navigate().to(url);
    }
    @Then("User verify all the dashboards on header")
    public void user_verify_all_the_dashboards_on_header(DataTable dataTable) {
        //this list is for expected values
        List<String> expectedTabs = dataTable.asList(String.class);

        //this list is for actual values
        List<String> actualTabs = new ArrayList<>();

        for (WebElement ele: ebay.dashboardTabs) {
            //storing the string value of a webelement from application
            actualTabs.add(ele.getText());
        }
        System.out.println(actualTabs);
        System.out.println(expectedTabs);
        //to verify both the list
        Assert.assertEquals(expectedTabs,actualTabs);
    }
}
