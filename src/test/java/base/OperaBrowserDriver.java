package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

 class OperaBrowserDriver extends BrowserDriver{

    @Override
    public WebDriver createDriver() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }
}
