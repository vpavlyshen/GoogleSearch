package base;

import org.openqa.selenium.WebDriver;

abstract class BrowserDriver {

    protected abstract WebDriver createDriver();

}
