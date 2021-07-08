package frontend.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GoogleSearchResultsPage extends BaseWebPage {

    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div[1]/div/div[1]/div/div[*]/div/div/div[1]/a/h3")
    private WebElement firstLink;
    @FindBy(xpath = "//*[@id=\"pnnext\"]/span[2]")
    private WebElement nextPageButton;

    protected GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public FIrstResultPage goToFirstResult() {
        firstLink.click();
        return new FIrstResultPage(driver);
    }

    public GoogleSearchResultsPage goToNextResultPage() {
        nextPageButton.click();
        return this;
    }


    public boolean isElementPresent(String identifierString) {
        try {
            driver.findElement(By.xpath(String.format("//a[text()=\"%s\"]",identifierString)));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
