package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinitions"},
        monochrome = true, dryRun = false,
        plugin = {"pretty", "html:target/cucumber"})
/*
 * tags selects which tests to run (must have @word in feature file) [ex: tags = "@login" ]
 * monochrome makes terminal logs more readable;
 * dryRun true = identifies undefined steps;
 * plugin pretty prints tests steps, HTML creates an html report
 */

public class CucumberTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false) // allows parallel testing
    public Object[][] scenarios() {
        return super.scenarios();
    }
}