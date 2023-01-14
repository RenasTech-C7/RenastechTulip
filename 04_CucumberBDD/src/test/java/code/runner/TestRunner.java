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
        tags = "@TC_200", //This is the field that we will use to run tags
        dryRun = true  //This is to get Undefined steps without running scenarios
)






public class TestRunner {
}
