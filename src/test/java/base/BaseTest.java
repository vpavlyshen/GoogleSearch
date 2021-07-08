package base;


import io.cucumber.core.options.CucumberProperties;
import org.openqa.selenium.WebDriver;


public abstract class BaseTest {

    private WebDriver driver;

    public void initWebDriver() {
        this.driver = BuildDriver();
        driver.manage().window().maximize();
    }


    public void quitDriver() {
        if (!(this.driver == null)) {
            this.driver.quit();
            this.driver = null;
        }
    }

    protected static WebDriver BuildDriver() {
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
