package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinitions"},
        monochrome = true, dryRun = false,
        plugin = {"pretty", "html:target/cucumber"})
// monochrome makes terminal logs more readable; dryRun true = identifies undefined steps; plugin pretty prints tests steps, HTML creates a html report
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}