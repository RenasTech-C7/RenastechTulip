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
        tags = "@Scenario_Outline_TC3", //This is the field that we will use to run tags
        dryRun = false,  //This is to get Undefined steps without running scenarios
        plugin = {
         "pretty", //This will help us to have a more understandable console output
         "rerun:target/rerun.txt", //This will help us to store failed scenarios from different feature files at each run so
         //that we can run only failed scenarios. We will be reading failed scenarios from rerun.txt file located under target folder
         "html:target/default-cucumber-reports.html", // We use this to generate HTML reports after each run
         "json:target/cucumber.json", //We use this to generate JSON reports after each run

        }
)






public class TestRunner {
}
