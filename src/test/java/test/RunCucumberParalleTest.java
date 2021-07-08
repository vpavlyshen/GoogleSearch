package test;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"classpath:parallel/scenarios.feature"},
        glue = {"steps"},plugin = {"pretty"})
public class RunCucumberParalleTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}