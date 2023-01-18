package code.stepsDefinitions;

import code.pages.OrangeHRMHome;
import code.pages.OrangeHRMLogin;
import code.utils.BrowserUtils;
import code.utils.ConfigurationsReader;
import code.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class OrangeHRMSteps extends BrowserUtils {
    OrangeHRMLogin orangeHRMLogin=new OrangeHRMLogin();
    OrangeHRMHome orangeHRMHome=new OrangeHRMHome();
    @Given("The user wants to go to OrangeHRM Website")
    public void the_user_wants_to_go_to_orange_hrm_website() {
        Driver.getDriver().get(ConfigurationsReader.getProperties("OrangeHRMTest"));
        setWaitTime();
    }
    @When("The user wants to enter username and password")
    public void the_user_wants_to_enter_username_and_password() {
        orangeHRMLogin.setUserName(ConfigurationsReader.getProperties("userName"));
        orangeHRMLogin.setPassWord(ConfigurationsReader.getProperties("password"));
    }
    @Then("The user wants to click on Login button")
    public void the_user_wants_to_click_on_login_button() {
        orangeHRMLogin.setLoginButton();
    }
    @Then("The user wants to verify that browser landed on Dashboard")
    public void the_user_wants_to_verify_that_browser_landed_on_dashboard() {
        orangeHRMHome.setDashBoard();
    }
    @Then("The user wants to verify that browser landed on {string}")
    public void the_user_wants_to_verify_that_browser_landed_on(String string) {
        orangeHRMHome.setDashBoard(string);
    }

    @Then("The user wants to click on PIM Module")
    public void the_user_wants_to_click_on_pim_module() {
        orangeHRMHome.setPIM();
    }
    @Then("The user wants to go to Add Employee Page")
    public void the_user_wants_to_go_to_add_employee_page() {
        orangeHRMHome.setAddEmployee();
    }
    @Then("The user wants to add first name as {string}")
    public void the_user_wants_to_add_first_name_as(String string) {
        orangeHRMHome.setFirstName(string);
    }
    @Then("The user wants to add last name as {string}")
    public void the_user_wants_to_add_last_name_as(String string) {
        orangeHRMHome.setLastName(string);
    }
    @Then("The user wants to save personal information")
    public void the_user_wants_to_save_personal_information() {
        orangeHRMHome.setSaveButton();
    }
    @Then("The user should be able to see {string}")
    public void the_user_should_be_able_to_see(String string) {
       orangeHRMHome.setPersonalDetailsHeader(string);
    }

    @Then("The user wants to add employee's first and last name")
    public void the_user_wants_to_add_employee_s_first_and_last_name(Map<String,String> dataTable) {
        orangeHRMHome.setFirstName(dataTable.get("FirstName"));
        orangeHRMHome.setLastName(dataTable.get("LastName"));
    }
    @Then("The user wants to add login details as following")
    public void the_user_wants_to_add_login_details_as_following(Map<String,String> dataTable) {
        orangeHRMHome.setAddLoginDetails();
        orangeHRMHome.setUserName(dataTable.get("UserName"));
        orangeHRMHome.setPassword(dataTable.get("Password"));
        orangeHRMHome.setConfirmPassword(dataTable.get("Password"));
        orangeHRMHome.setStatusDropdown(dataTable.get("Status"));
    }

    @Then("The user wants to add employee's first and last name using a List Method")
    public void the_user_wants_to_add_employee_s_first_and_last_name_using_a_list_method(List<List<String>> dataTable) {
     //We need to use Nested list in order to use dataTable in feature file(OrangeHRM.feature)
                                            //Row  Column
        orangeHRMHome.setFirstName(dataTable.get(2).get(0));  //Row 3 Column 1
        orangeHRMHome.setLastName(dataTable.get(2).get(1));
    }
    @Then("The user wants to add Login details in a List way")
    public void the_user_wants_to_add_login_details_in_a_list_way(List<List<String>> dataTable) {
        //We need to use Nested list in order to use dataTable in feature file(OrangeHRM.feature)

        orangeHRMHome.setAddLoginDetails();
        orangeHRMHome.setUserName(dataTable.get(1).get(0));
        orangeHRMHome.setPassword(dataTable.get(1).get(1));
        orangeHRMHome.setConfirmPassword(dataTable.get(1).get(1));
        orangeHRMHome.setStatusDropdown(dataTable.get(1).get(2));
    }



}
