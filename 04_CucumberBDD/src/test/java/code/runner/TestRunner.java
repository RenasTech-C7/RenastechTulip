package code.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) //We are connecting JUnit here //Important interview question
//Answer: We use Runwith to integrate JUnit with Runner class so that we can run scenarios and have assertions
@CucumberOptions(
        features = "src/test/resources", //This is to connect feature files with runner class
        //We need to copy path Resources folder as following : path from content root
        glue = "code/stepsDefinitions", //This is to connect stepsDefinitions with runner class
        //We need to copy path of stepsDefinitions Folder as following : path from source root
        tags = "@Regression", //This is the field that we will use to run tags
        dryRun = false,  //This is to get Undefined steps without running scenarios
        plugin = {
         "pretty", //This will help us to have a more understandable console output
         "html:target/default-cucumber-reports.html",
         "json:target/cucumber.json",

        }
)






public class TestRunner {
}
