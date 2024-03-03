package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = "@target/failedTests.txt",
                glue = "stepdefinitions",
                plugin = {"pretty", "html:target/report.html"}
        )
public class FailedTestRunner {
}
