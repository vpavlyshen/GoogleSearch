package frontend.pages.google;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends BaseWebPage {

    private static final String URL = "https://www.google.com/";

    @FindBy(xpath = "//INPUT[@class='gLFyf gsfi']")
    private WebElement searchInputField;


    public GoogleHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleSearchResultsPage searchSomething(String searchQuery) {
        searchInputField.sendKeys(searchQuery);
        searchInputField.sendKeys(Keys.ENTER);
        return new GoogleSearchResultsPage(driver);
    }


    public GoogleHomePage navigate() {
        driver.navigate().to(URL);

        return this;
    }

}
