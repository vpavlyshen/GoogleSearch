package base;

import base.drivers.ChromeBrowserDriver;
import base.drivers.EdgeBrowserDriver;
import base.drivers.FirefoxBrowserDriver;
import base.drivers.OperaBrowserDriver;
import io.cucumber.core.options.CucumberProperties;
import org.openqa.selenium.WebDriver;


public class DriverProvider {

    public static WebDriver getDriver() {
        String browserType;
        if (System.getProperty("unningWith") == "TESTNG") {
             browserType =System.getProperty("browser");
        } else browserType =CucumberProperties.fromPropertiesFile().get("browser");
        BrowserNameEnum browser = BrowserNameEnum.valueOf(browserType.toUpperCase());
        return switch (browser) {
            case CHROME -> new ChromeBrowserDriver().createDriver();
            case FIREFOX -> new FirefoxBrowserDriver().createDriver();
            case OPERA -> new OperaBrowserDriver().createDriver();
            case EDGE -> new EdgeBrowserDriver().createDriver();
            default -> throw new IllegalArgumentException("NOT SUPPORTED BROWSER");
        };

    }
}
