package frontend.pages.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FIrstResultPage extends BaseWebPage{


    protected FIrstResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public boolean diesTitleInclude(String qurey){
       return getTitle().toLowerCase().contains(qurey.toLowerCase());
    }
}
