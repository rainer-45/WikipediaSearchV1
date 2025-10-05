package com.wikipedia.test.pages;

import org.openqa.selenium.By;

public final class Locators {
    // Home page search
    public static final By SEARCH_INPUT = By.cssSelector("input#searchInput, input[name='search']");

    // Article page
    public static final By ARTICLE_TITLE = By.cssSelector("h1#firstHeading");
    public static final By TOC_REFERENCES_LINK = By.partialLinkText("References");

}
