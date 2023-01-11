package code.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    public static void staticWait(int second){
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setWaitTime(){
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    public static void selectFromDropdown(WebElement element, String text ){
        Select select= new Select(element);
        select.selectByVisibleText(text);

        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
