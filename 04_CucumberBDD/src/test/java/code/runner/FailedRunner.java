package code.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt", //This will help us to read Failed Scenarios from rerun.txt so that we can run them
        //We need to copy path from content root
        glue = "code/stepsDefinitions", //This is to connect stepsDefinitions folder with FailedRunner
        dryRun = false, //This is to generate undefined steps
        plugin = {
                "pretty", //This will help us to have a more understandable console output
                "rerun:target/rerun.txt", //This will help us to store failed scenarios from different feature files at each run so
                //that we can run only failed scenarios. We will be reading failed scenarios from rerun.txt file located under target folder
                "html:target/default-cucumber-reports.html", // We use this to generate HTML reports after each run
                "json:target/cucumber.json", //We use this to generate JSON reports after each run
        }
)







public class FailedRunner {
}
