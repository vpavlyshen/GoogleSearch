package base.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class OperaBrowserDriver extends BrowserDriver{

    @Override
    public WebDriver createDriver() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }
}
