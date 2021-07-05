package frontend.pages.google;

import org.openqa.selenium.WebDriver;

public abstract class BaseWebPage {
    protected WebDriver driver;

    protected BaseWebPage(WebDriver driver) {
        this.driver = driver;
    }

}
