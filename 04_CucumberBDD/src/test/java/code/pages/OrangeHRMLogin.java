package code.pages;

import code.utils.BrowserUtils;
import code.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLogin extends BrowserUtils {
    public OrangeHRMLogin(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "txtUsername")
    private WebElement userName;
    @FindBy(id = "txtPassword")
    private WebElement passWord;
    @FindBy(id = "btnLogin")
    private WebElement loginButton;

    public void setUserName(String username) {
      staticWait(1);
      userName.sendKeys(username);
    }

    public void setPassWord(String password) {
        passWord.sendKeys(password);
    }

    public void setLoginButton() {
        loginButton.click();
    }
}
