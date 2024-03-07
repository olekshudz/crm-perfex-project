package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = "src/test/resources/features",
                glue = "stepdefinitions",
                dryRun = false,
                tags = "@regression",
                plugin = {"pretty", "html:target/report.html", "rerun:target/failedTests.txt"}
        )
public class TestRunner {
}
