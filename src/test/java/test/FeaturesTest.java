package test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
//This is the glue file. It makes the connection between the features and the steps
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber/","json:target/jsonReports/TestResults.json","junit:target/junitReports/TestResults.xml"},
        glue = { "steps" },
        features = "src/test/resources/features/"
)
public class FeaturesTest {

    /**
     *
     *   For running the tests from the command line, use the command:
     *   mvn clean test -q -Dcucumber.options="--tags @ready" -Dbrowser=chrome -Denv=stage
     *   use space and --PARAM after @TAGS to introduce new parameters
     *   To print out all the available configuration options, simply pass the --help option.
     *   Example:
     *   mvn test -Dcucumber.options="--help"
     *
     * **/
}
