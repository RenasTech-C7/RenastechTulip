package code.pages;

import code.utils.BrowserUtils;
import code.utils.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLogin extends BrowserUtils {
    public OrangeHRMLogin(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    private static final Logger logger= Logger.getLogger(OrangeHRMLogin.class);
    @FindBy(id = "txtUsername")
    private WebElement userName;
    @FindBy(id = "txtPassword")
    private WebElement passWord;
    @FindBy(id = "btnLogin")
    private WebElement loginButton;

    public void setUserName(String username) {
        if(username.isEmpty()){
            logger.error("Username is empty. Please check the value you provided ");
            logger.warn("Username is neccessary to login");
            logger.fatal("Not able to Log in due to empty username");
            logger.info("Please provide a valid username");
        }
      staticWait(1);
      userName.sendKeys(username);
    }

    public void setPassWord(String password) {
        passWord.sendKeys(password);
    }

    public void setLoginButton() {
        loginButton.click();
    }

    public void setDataFromExcel(String username, String password){
        userName.sendKeys(username);
        passWord.sendKeys(password);
        clickWithWait(loginButton);

    }
}
