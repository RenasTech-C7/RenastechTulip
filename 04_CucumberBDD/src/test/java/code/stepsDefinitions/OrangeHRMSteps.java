package code.stepsDefinitions;

import code.pages.OrangeHRMAdmin;
import code.pages.OrangeHRMHome;
import code.pages.OrangeHRMLogin;
import code.utils.BrowserUtils;
import code.utils.ConfigurationsReader;
import code.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class OrangeHRMSteps extends BrowserUtils {
    OrangeHRMLogin orangeHRMLogin=new OrangeHRMLogin();
    OrangeHRMHome orangeHRMHome=new OrangeHRMHome();
    OrangeHRMAdmin orangeHRMAdmin=new OrangeHRMAdmin();

    private static final Logger logger= Logger.getLogger(OrangeHRMSteps.class);
    @Given("The user wants to go to OrangeHRM Website")
    public void the_user_wants_to_go_to_orange_hrm_website() {
        Driver.getDriver().get(ConfigurationsReader.getProperties("OrangeHRMTest"));
        setWaitTime();
    }
    @When("The user wants to enter username and password")
    public void the_user_wants_to_enter_username_and_password() {
        orangeHRMLogin.setUserName(ConfigurationsReader.getProperties("userName"));
        orangeHRMLogin.setPassWord(ConfigurationsReader.getProperties("password"));
        logger.info("Username and password provided successfully");
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
        logger.info("All neccessary information for Login details is provided ");
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
        logger.info("AddLoginDetails button is clicked successfully");
        orangeHRMHome.setUserName(dataTable.get(1).get(0));
        logger.info("Username is provided successfully");
        orangeHRMHome.setPassword(dataTable.get(1).get(1));
        logger.info("Password is provided successfully");
        orangeHRMHome.setConfirmPassword(dataTable.get(1).get(1));
        orangeHRMHome.setStatusDropdown(dataTable.get(1).get(2));
        logger.info("Status provided successfully");
    }

    @Then("The user wants to add login information {string} {string} {string}")
    public void the_user_wants_to_add_login_information(String username, String password, String status) {
        orangeHRMHome.setAddLoginDetails();
        logger.info("AddLogin Details button is clicked successfully");
        orangeHRMHome.setUserName(username);
        logger.info(username+" is provided as username");
        orangeHRMHome.setPassword(password);
        logger.info(password+" is provided as Password");
        orangeHRMHome.setConfirmPassword(password);
        logger.info(password+" is provided as Confirm Password");
        orangeHRMHome.setStatusDropdown(status);
        logger.info("Status is provided successfully");


    }

    @Then("the user wants to add employee's first name as {string} and last name as {string}")
    public void the_user_wants_to_add_employee_s_first_name_as_and_last_name_as(String firstname, String lastname) {
        orangeHRMHome.setFirstName(firstname);
        orangeHRMHome.setLastName(lastname);
        logger.info(firstname+" is provided as firstname and "+lastname+" is provided as lastname");
    }
    @Then("The user wants to go to Admin Module")
    public void the_user_wants_to_go_to_admin_module() {
        orangeHRMAdmin.setAdminButton();
    }
    @Then("The user wants to go to Nationalities Page")
    public void the_user_wants_to_go_to_nationalities_page() {
        orangeHRMAdmin.setNationalitiesButton();
    }
    @Then("The user wants to click on add new nationality")
    public void the_user_wants_to_click_on_add_new_nationality() {
        orangeHRMAdmin.setAddButton();
    }
    @Then("The user wants to add new nationalities as {string}")
    public void the_user_wants_to_add_new_nationalities_as(String nationality) {
        orangeHRMAdmin.setNameofNationalityBox(nationality);
        orangeHRMAdmin.setSaveButton();
        orangeHRMAdmin.setNationalitiesList(nationality);
    }
    @Given("The user wants to login to OrangeHRM using Excel file\\(External File)")
    public void the_user_wants_to_login_to_orange_hrm_using_excel_file_external_file() throws IOException {
        Driver.getDriver().get(ConfigurationsReader.getProperties("OrangeHRMTest"));
        //File path is absolute path
        String filePath="C:\\Users\\oralr\\IdeaProjects\\RenastechTulip\\04_CucumberBDD\\src\\test\\resources\\externalFile.xlsx";
        FileInputStream fileInputStream=new FileInputStream(filePath); //We are uploading file here
        XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream); // We are opening the excel file here
        XSSFSheet sheet= workbook.getSheet("Sheet1"); //We are opening Sheet1 here

        System.out.println(sheet.getRow(0).getCell(0).toString());
        System.out.println(sheet.getRow(0).getCell(1).toString());
        System.out.println(sheet.getRow(1).getCell(0).toString());
        System.out.println(sheet.getRow(1).getCell(1).toString());

        int rows=sheet.getLastRowNum();
        int columns=sheet.getRow(0).getLastCellNum();

        System.out.println("Total rows:"+ rows+", Total Columns:"+columns);
        String username=sheet.getRow(1).getCell(0).toString();
        String password=sheet.getRow(1).getCell(1).toString();

      orangeHRMLogin.setDataFromExcel(username,password);

        for(int i=0; i<rows; i++ ){
            for (int j=0; j<columns; j++){
                System.out.println(sheet.getRow(i).getCell(j).toString());
            }
        }


    }



}
