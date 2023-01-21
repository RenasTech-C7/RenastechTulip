package StudyHall.pages;

import code.utils.BrowserUtils;
import code.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class renasPracticePage extends BrowserUtils {

    public renasPracticePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[contains(text(),'Get a Quote')]")
    private WebElement getAQuote;
    @FindBy(id = "mat-select-0")
    private WebElement year;
    @FindBy(css = "[id*='mat-option-']")
    private List<WebElement> makeAYear;
    @FindBy(xpath = "//button[@id='next-step']")
    private WebElement nextButton;
    @FindBy(id = "cdk-step-label-0-3")
    private WebElement clickCoverageStartDate;
     @FindBy(css = ".mat-datepicker-toggle.ng-tns-c47-6")
     private WebElement clickCalender;





    public void setGetAQuote(){
        getAQuote.click();
    }
    public void setMakeAYear(String makeYear) throws InterruptedException {
        Assert.assertFalse(nextButton.isEnabled());
        clickWithWait(year);
        int yearSize= makeAYear.size();
        System.out.println(yearSize);
        for (int i = 0; i < yearSize; i++) {
            if (makeAYear.get(i).getText().equals(makeYear)){
                makeAYear.get(i).click();
                break;
            }
        }
    }
    public void setClickCoverageStartDate(){
        clickWithWait(clickCoverageStartDate);
    }
    public void setClickCalender(){
        clickWithWait(clickCalender);
    }
}
