package com.wikipedia.test.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class DriverFactory {
    public static WebDriver create() {
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}