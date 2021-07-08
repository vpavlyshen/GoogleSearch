package test.parallel;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"classpath:parallel/scenarios.feature"},
        glue = {"steps"},plugin = {"pretty", "html:target/cucumber"})
public class RunCucumberTestsParalele extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}