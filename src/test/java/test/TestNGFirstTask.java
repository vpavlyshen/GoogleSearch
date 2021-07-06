package test;

import base.BaseTest;
import frontend.pages.google.FIrstResultPage;
import frontend.pages.google.GoogleHomePage;
import frontend.pages.google.GoogleSearchResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGFirstTask extends BaseTest {

    private GoogleHomePage homePage;
    private static final String SEARCH_QUERY_STRING = "automation";


    @BeforeClass
    public void initPages() {
        homePage = PageFactory.initElements(getDriver(), GoogleHomePage.class);
    }

    @Test
    public void firstTest() {
        FIrstResultPage fIrstResultPage = homePage.searchSomething(SEARCH_QUERY_STRING)
                .goToFirstResult();
        String titleText = fIrstResultPage.getTitle();
        Assert.assertTrue(titleText.toLowerCase().contains(SEARCH_QUERY_STRING.toLowerCase()), "Title contain search query valildation");
    }

}
