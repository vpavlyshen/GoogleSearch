package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

class DriverProvider {

    protected WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public WebDriver createEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    public WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }


    public WebDriver createOperaDriver() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }
}
