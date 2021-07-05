package steps;

import base.BaseTest;
import frontend.pages.google.GoogleHomePage;
import frontend.pages.google.GoogleSearchResultsPage;
import io.cucumber.core.options.CucumberProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class SecondStepsDeft extends BaseTest {

    private GoogleHomePage homePage;
    private GoogleSearchResultsPage googleSearchResultsPage;
    private static final String SEARCH_QUERY_STRING = "automation";
    private static final String SEARCH_DOMAIN = "testautomationday.com";
    private static int numberOfPagesToCheck = 5;

    @Before
    public void initPages() {
        initWebDriver();
        homePage = PageFactory.initElements(getDriver(), GoogleHomePage.class);
    }

    @After
    public void finishIt() {
        quitDriver();
    }


    @Given("I go to home page")
    public void iGoToHomePage() {
        homePage.navigate(CucumberProperties.fromPropertiesFile().get("url"));
    }


    @And("I search some query")
    public void iSearchSomeQuery() {
        googleSearchResultsPage = homePage.searchSomething(SEARCH_QUERY_STRING);
    }

    @Then("I am looking for query at five first pages")
    public void iAmLookingForQueryAtFiveFirstPages() {
        while (numberOfPagesToCheck >= 1) {
            if (googleSearchResultsPage.isElementPresent(By.xpath(String.format("//a[text()=\"%s\"]", SEARCH_DOMAIN)))) {
                org.junit.Assert.assertTrue("Searched domain founded",true );
            } else {
                googleSearchResultsPage.goToNextResultPage();
                numberOfPagesToCheck = numberOfPagesToCheck - 1;
                if (numberOfPagesToCheck < 1) Assert.fail("Searched domain not founded");
            }
        }
    }
}
