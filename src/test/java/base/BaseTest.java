package base;


import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public abstract class BaseTest {

    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void initWebDriver() {
        this.driver = this.createDriver();
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

    protected WebDriver createDriver() {
        return DriverProvider.getDriver();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

}
