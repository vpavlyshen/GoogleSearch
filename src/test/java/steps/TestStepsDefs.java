package steps;

import base.BaseTest;
import frontend.pages.google.FIrstResultPage;
import frontend.pages.google.GoogleHomePage;
import frontend.pages.google.GoogleSearchResultsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TestStepsDefs extends BaseTest {

    private GoogleHomePage homePage;
    private GoogleSearchResultsPage googleSearchResultsPage;
    private FIrstResultPage fIrstResultPage;

    @Before
    public void initPages() {
        initWebDriver();
        homePage = PageFactory.initElements(getDriver(), GoogleHomePage.class);
    }


    @Given("I go to  home page")
    public void iGoToHomePage() {
        homePage.navigate();
    }

    @And("I search {string} query")
    public void iSearchQuery(String query) {
        googleSearchResultsPage = homePage.searchSomething(query);
    }

    @When("I go to first result")
    public void iGoToFirstResult() {
        fIrstResultPage = googleSearchResultsPage.goToFirstResult();
    }

    @Then("Page title should include {string} word")
    public void pageTitleShouldIncludeWord(String SEARCH_QUERY_STRING) {
        Assert.assertTrue(fIrstResultPage.doesTitleInclude(SEARCH_QUERY_STRING), "Title include correct phrase validation");
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
            if (googleSearchResultsPage.isElementPresent(searchDomain)) {
                Assert.assertTrue(true, "Searched domain founded");
            } else {
                googleSearchResultsPage.goToNextResultPage();
                numberOfPagesToCheck = numberOfPagesToCheck - 1;
                if (numberOfPagesToCheck < 1) Assert.fail("Searched domain not founded");
            }
        }
    }

    @After
    public void finishIt(Scenario scenario) {
        try {
            String screenShotName = scenario.getName();
            if (scenario.isFailed()) {
                TakesScreenshot screenTaker = (TakesScreenshot) getDriver();
                byte[] screenshot = screenTaker.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", screenShotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        quitDriver();
    }
}
