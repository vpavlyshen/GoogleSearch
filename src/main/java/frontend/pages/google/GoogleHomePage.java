package frontend.pages.google;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends BaseWebPage {

    private static final String URL = "https://www.google.com/";
    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")
    private WebElement searchInputField;
    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")
    private WebElement searchButton;
    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[2]")
    private WebElement luckySearchButton;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleSearchResultsPage searchSomething(String searchQuery) {
        searchInputField.sendKeys(searchQuery);
        searchInputField.sendKeys(Keys.ENTER);
        return new GoogleSearchResultsPage(driver);
    }

    public void luckySearch(String searchQuery) {
        searchInputField.sendKeys(searchQuery);
        luckySearchButton.click();
    }

    public GoogleHomePage navigate() {
        driver.navigate().to(URL);
        return this;
    }

}
