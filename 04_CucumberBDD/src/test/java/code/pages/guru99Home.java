package code.pages;

import code.utils.BrowserUtils;
import code.utils.Driver;
import io.cucumber.java.en_lol.WEN;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class guru99Home extends BrowserUtils {

    public guru99Home(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //We created pagefactory above to call driver in this class

    @FindBy(xpath = "//select[@name='quantity']")
    private WebElement quantityDropdown;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buyNowButton;

    public void getQuantityDropdown(String str) {
      Select select= new Select(quantityDropdown);
      select.selectByValue(str);

    }

    public void getBuyNowButton() {
       buyNowButton.click();
    }
}
