package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

 class EdgeBrowserDriver extends BrowserDriver{
    @Override
    public WebDriver createDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
