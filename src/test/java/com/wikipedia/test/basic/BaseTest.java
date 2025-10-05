package com.wikipedia.test.basic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected Waits waits;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.create();
        driver.manage().window().maximize();
        waits = new Waits(driver, 1000);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}