package com.wikipedia.test.pages;

import com.wikipedia.test.basic.Waits;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import static com.wikipedia.test.pages.Locators.SEARCH_INPUT;

public class WikipediaHomePage {
    private final WebDriver driver;
    private final Waits waits;

    public WikipediaHomePage(WebDriver driver, Waits waits) {
        this.driver = driver;
        this.waits = waits;
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        waitForHomePageReady();
    }

    private void waitForHomePageReady() {
        try {
            waits.presence(SEARCH_INPUT);
            waits.visible(SEARCH_INPUT);
            waits.clickable(SEARCH_INPUT);
        } catch (TimeoutException e) {
            System.out.println("[WARN] Search input not ready on Wikipedia main page");
        }
    }

    public WikipediaArticlePage typeSearchQuery(String query) {
        By searchSelector = By.cssSelector("input#searchInput, input[name='search']");
        WebElement sb = waits.presence(searchSelector);
        sb.clear();
        sb.sendKeys(query, Keys.ENTER);
        return new WikipediaArticlePage(driver, waits);
    }




}
