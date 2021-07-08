package steps;

import base.BaseTest;
import frontend.pages.google.FIrstResultPage;
import frontend.pages.google.GoogleHomePage;
import frontend.pages.google.GoogleSearchResultsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class TestStepsDefs extends BaseTest {

    private GoogleHomePage homePage;
    private GoogleSearchResultsPage googleSearchResultsPage;
    private FIrstResultPage fIrstResultPage;

    @Before
    public void initPages() {
        initWebDriver();
        homePage = PageFactory.initElements(getDriver(), GoogleHomePage.class);
    }

    @After
    public void finishIt() {
        quitDriver();
    }

    @Given("I go to  home page")
    public void iGoToHomePage() {
        homePage.navigate();
    }

    @And("I search {string} query")
    public void iSearchQuery(String query) {googleSearchResultsPage = homePage.searchSomething(query);}

    @When("I go to first result")
    public void iGoToFirstResult() {
        fIrstResultPage = googleSearchResultsPage.goToFirstResult();
    }

    @Then("Page title should include {string} word")
    public void pageTitleShouldIncludeWord(String SEARCH_QUERY_STRING) {
        fIrstResultPage.doesTitleInclude(SEARCH_QUERY_STRING);
    }

    @Given("I go to home")
    public void iGoToHome() {
        homePage.navigate();
    }

    @And("I  search {string} query")
    public void SearchQuery(String query) {
        googleSearchResultsPage = homePage.searchSomething(query);

    }

    @Then("I am looking for {string}  at {int} first pages")
    public void iAmLookingForAtFirstPages(String searchDomain, int numberOfPagesToCheck) {
        while (numberOfPagesToCheck >= 1) {
            if (googleSearchResultsPage.isElementPresent(By.xpath(String.format("//a[text()=\"%s\"]", searchDomain)))) {
                org.junit.Assert.assertTrue("Searched domain founded",true );
            } else {
                googleSearchResultsPage.goToNextResultPage();
                numberOfPagesToCheck = numberOfPagesToCheck - 1;
                if (numberOfPagesToCheck < 1) Assert.fail("Searched domain not founded");
            }
        }
    }


}
