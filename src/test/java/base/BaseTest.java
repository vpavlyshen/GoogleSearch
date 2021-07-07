package base;


import base.drivers.ChromeBrowserDriver;
import base.drivers.EdgeBrowserDriver;
import base.drivers.FirefoxBrowserDriver;
import base.drivers.OperaBrowserDriver;
import io.cucumber.core.options.CucumberProperties;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public abstract class BaseTest {

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void initWebDriver() {
        this.driver = BuildDriver();
        driver.manage().window().maximize();
        Reporter.log("Driver initialised",true);
    }

    @BeforeClass(alwaysRun = true)
    public void startup() {
        driver.navigate().to(System.getProperty("URL"));
        Reporter.log(String.format("Navigate to %s", System.getProperty("URL")),true);
    }

    @AfterClass(alwaysRun = true)
    public void quitDriver() {
        if (!(this.driver == null)) {
            this.driver.quit();
            this.driver = null;
        }
        Reporter.log("Kill driver",true);
    }

    public static WebDriver BuildDriver() {
        String browserType;
        if (System.getProperty("runningWith") == "TESTNG") {
            browserType =System.getProperty("browser");
        } else browserType = CucumberProperties.fromPropertiesFile().get("browser");
        BrowserNameEnum browser = BrowserNameEnum.valueOf(browserType.toUpperCase());

        switch (browser) {
            case CHROME: return new ChromeBrowserDriver().createDriver();
            case FIREFOX: return new FirefoxBrowserDriver().createDriver();
            case OPERA: return new OperaBrowserDriver().createDriver();
            case EDGE: return new EdgeBrowserDriver().createDriver();
            default: throw new IllegalArgumentException("NOT SUPPORTED BROWSER");
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

}
