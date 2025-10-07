package com.wikipedia.test.basic;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;

public final class DriverFactory {
    public static WebDriver create() {
        ChromeOptions options = new ChromeOptions();

        // --- SYSTEM-safe headless setup ---
        options.addArguments("--headless=new");               // no GUI needed
        options.addArguments("--window-size=1920,1080");      // important for interactability
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        // --- give each run its own profile directory to avoid locking ---

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1920,1080));
        return driver;
    }
}