package frontend.pages.google.components;

import frontend.pages.google.BaseWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchResult extends BaseWebPage {

    private WebElement parentContainer;

    private WebElement url;
    private WebElement title;
    private WebElement description;


    public GoogleSearchResult(WebDriver driver, WebElement parentContainer) {
        super(driver);
        this.parentContainer = parentContainer;
        url=parentContainer.findElement(By.cssSelector(""));
        title=parentContainer.findElement(By.cssSelector(""));
        description=parentContainer.findElement(By.cssSelector(""));
    }

    public String getSearchResultUrl(){
        return url.toString();
    }

    public String getSearchResultTitle(){
        return title.toString();
    }

    public String getSearchResultDecription(){
        return description.toString();
    }

    public void goToFoundedPage(){
        title.click();
    }
}
