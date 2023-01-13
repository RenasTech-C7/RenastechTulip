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

    public void setDashBoard() {
        Assert.assertEquals("Dashboard",dashBoard.getText());
    }
}
