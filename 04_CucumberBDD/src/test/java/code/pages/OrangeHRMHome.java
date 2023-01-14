package code.pages;

import code.utils.BrowserUtils;
import code.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMHome extends BrowserUtils {
    public OrangeHRMHome(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h1[.='Dashboard']")
    private WebElement dashBoard;
    @FindBy(id = "menu_pim_viewPimModule")
    private WebElement PIM;
    @FindBy(id = "menu_pim_addEmployee")
    private WebElement addEmployee;
    @FindBy(id = "firstName")
    private WebElement firstName;
    @FindBy(id = "lastName")
    private WebElement lastName;
    @FindBy(id = "btnSave")
    private WebElement saveButton;
    @FindBy(xpath = "//h1[.='Personal Details']")
    private WebElement personalDetailsHeader;
    @FindBy(id = "chkLogin")
    private WebElement addLoginDetails;
    @FindBy(id = "user_name")
    private WebElement userName;
    @FindBy(id = "user_password")
    private WebElement password;
    @FindBy(id = "re_password")
    private WebElement confirmPassword;
    @FindBy(id = "status")
    private WebElement statusDropdown;

    public void setDashBoard() {
        Assert.assertEquals("Dashboard",dashBoard.getText());
    }
    public void setDashBoard(String str) {
        Assert.assertEquals(str,dashBoard.getText());
    }

    public void setPIM() {
      // PIM.click();
       clickWithWait(PIM);
    }

    public void setAddEmployee() {
        clickWithWait(addEmployee);
    }

    public void setFirstName(String firstname) {
      firstName.sendKeys(firstname);
    }

    public void setLastName(String lastname) {
        lastName.sendKeys(lastname);
    }

    public void setSaveButton() {
        clickWithWait(saveButton);
    }

    public void setPersonalDetailsHeader(String expectedHeader) {
        staticWait(2);
        Assert.assertEquals(expectedHeader,personalDetailsHeader.getText());
    }

    public void setAddLoginDetails() {
       clickWithWait(addLoginDetails);
    }

    public void setUserName(String username) {
       userName.sendKeys(username);
    }

    public void setPassword(String passWord) {
        password.sendKeys(passWord);
    }

    public void setConfirmPassword(String confirmpassword) {
       confirmPassword.sendKeys(confirmpassword);
    }

    public void setStatusDropdown(String statusdropdown) {
        selectFromDropdown(statusDropdown,statusdropdown);
    }
}
