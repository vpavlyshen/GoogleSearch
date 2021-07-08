package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

 class FirefoxBrowserDriver extends BrowserDriver{

    public FirefoxBrowserDriver() {
    }

    public WebDriver createDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
