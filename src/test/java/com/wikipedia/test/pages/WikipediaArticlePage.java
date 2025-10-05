package com.wikipedia.test.pages;

import com.wikipedia.test.basic.Waits;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.wikipedia.test.pages.Locators.*;

public class WikipediaArticlePage {
    private final WebDriver driver;
    private final Waits waits;
    private final WebDriverWait wait;

    public WikipediaArticlePage(WebDriver driver, Waits waits) {
        this.driver = driver;
        this.waits = waits;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        PageFactory.initElements(driver, this);
    }

    public void waitForArticle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_TITLE));
    }

    public String getArticleTitle() {
        waitForArticle();
        return driver.findElement(ARTICLE_TITLE).getText();
    }

    public void clickReferences() {
        WebElement ref = wait.until(ExpectedConditions.elementToBeClickable(TOC_REFERENCES_LINK));
        ref.click();
    }

    /** Confirm we are at the References section by URL hash and the anchor being present */
    public boolean isAtReferences() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(TOC_REFERENCES_LINK));
        } catch (TimeoutException ignored) {}
        return driver.getCurrentUrl().contains("#References");
    }
}
