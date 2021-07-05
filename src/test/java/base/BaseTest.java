package base;


import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;


public abstract class BaseTest {

    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void initWebDriver() {
        this.driver = this.createDriver();
        driver.manage().window().maximize();
        System.out.println("Driver initialised");
    }

    @BeforeClass(alwaysRun = true)
    public void startup() {
        driver.navigate().to(System.getProperty("URL"));
        System.out.println(String.format("Navigate to %s", System.getProperty("URL")));
    }

    @AfterClass(alwaysRun = true)
    public void quitDriver() {
        if (!(this.driver == null)) {
            this.driver.quit();
            this.driver = null;
        }
        System.out.println("Kill driver");
    }

    protected WebDriver createDriver() {
        return DriverProvider.getDriver();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

}
