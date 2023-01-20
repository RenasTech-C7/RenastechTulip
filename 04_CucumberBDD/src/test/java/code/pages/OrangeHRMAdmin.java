package code.pages;

import code.utils.BrowserUtils;
import code.utils.Driver;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrangeHRMAdmin extends BrowserUtils {
    public OrangeHRMAdmin(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    private static final Logger logger= Logger.getLogger(OrangeHRMAdmin.class);

    @FindBy(id = "menu_admin_viewAdminModule")
    private WebElement adminButton;
    @FindBy(id = "menu_admin_nationality")
    private WebElement nationalitiesButton;
    @FindBy(id = "btnAdd")
    private WebElement addButton;
    @FindBy(id = "nationality_name")
    private WebElement nameofNationalityBox;
    @FindBy(xpath = "//input[@id='btnSave']")
    private WebElement saveButton;
    @FindBy(xpath = "//table//tr//td[2]//a")
    private List<WebElement> nationalitiesList;

    public void setAdminButton() {
        clickWithWait(adminButton);
    }

    public void setNationalitiesButton() {
        clickWithWait(nationalitiesButton);
    }

    public void setAddButton() {
       clickWithWait(addButton);
    }

    public void setNameofNationalityBox(String nameofnationalityBox) {
        nameofNationalityBox.sendKeys(nameofnationalityBox);
    }

    public void setSaveButton() {
       clickWithWait(saveButton);
    }

    public void setNationalitiesList(String nationality) {
       for (WebElement each : nationalitiesList){
           if(each.getText().equals(nationality)){
               Assert.assertEquals(each.getText(),nationality);
           }else if(!each.getText().equals(nationality)){

               logger.error("Nationality provided is not found");
           }else if(nationality.isEmpty()){

               logger.error("No nationality provided");
           }




       }
    }
}
