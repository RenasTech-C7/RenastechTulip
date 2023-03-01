package code.hooks;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class bookApiHooks {

    @BeforeClass
    public void setup(){
        //We are setting baseURI here once. It will be applied to all of the test cases in this class
        RestAssured.baseURI="https://simple-books-api.glitch.me";
    }
}
