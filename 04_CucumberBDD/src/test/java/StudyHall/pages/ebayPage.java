package StudyHall.pages;

import code.utils.BrowserUtils;
import code.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ebayPage extends BrowserUtils {


    public ebayPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//ul[@class='hl-cat-nav__container']/li/a")
    public List<WebElement> dashboardTabs;
}
