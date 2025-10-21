package com.wikipedia.test.tests;

import com.wikipedia.test.basic.BaseTest;
import com.wikipedia.test.pages.WikipediaArticlePage;
import com.wikipedia.test.pages.WikipediaHomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WikipediaFlowTest extends BaseTest {

    @DataProvider(name = "searchTerms")
    public String[] provideSearchTerms() {
        return new String[]{
                "Laptop",
                "Mouse"
        };
    }

    @Test(dataProvider = "searchTerms")
    public void searchTypeaheadAndNavigateReferences(String searchTerm) {
        WikipediaHomePage home = new WikipediaHomePage(driver, waits);
        home.openHomePage();

        WikipediaArticlePage article = home.typeSearchQuery(searchTerm);

        article.waitForArticle();
        String title = article.getArticleTitle();
        System.out.println("[INFO] Article title: " + title);

        article.clickReferences();

        boolean ok = article.isAtReferences();
        Assert.assertTrue(ok, "[FAIL] URL does not contain #References — navigation to References section failed for " + searchTerm);

        System.out.println("[PASS] URL contains #References for " + searchTerm);
    }
}
