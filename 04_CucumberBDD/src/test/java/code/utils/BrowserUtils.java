package code.utils;

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
}
