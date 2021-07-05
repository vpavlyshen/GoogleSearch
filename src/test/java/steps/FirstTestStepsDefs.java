package steps;

import base.BaseTest;
import frontend.pages.google.FIrstResultPage;
import frontend.pages.google.GoogleHomePage;
import frontend.pages.google.GoogleSearchResultsPage;
import io.cucumber.core.options.CucumberProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class FirstTestStepsDefs extends BaseTest {

    private GoogleHomePage homePage;
    private GoogleSearchResultsPage googleSearchResultsPage;
    private FIrstResultPage fIrstResultPage;
    private static final String SEARCH_QUERY_STRING = "automation";

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
        homePage.navigate(CucumberProperties.fromPropertiesFile().get("url"));
    }

    @And("I search query")
    public void iSearchQuery() {
        googleSearchResultsPage = homePage.searchSomething(SEARCH_QUERY_STRING);
    }

    @When("I go to first result")
    public void iGoToFirstResult() {
        fIrstResultPage = googleSearchResultsPage.goToFirstResult();
    }

    @Then("Page title should include {string} word")
    public void pageTitleShouldIncludeWord(String arg0) {
        fIrstResultPage.diesTitleInclude(SEARCH_QUERY_STRING);
    }
}
