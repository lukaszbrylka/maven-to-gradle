
package com.lukasz.ui.tests;

import com.lukasz.ui.driver.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    protected static final String BASE_URL = "https://conduit-realworld-example-app.fly.dev/#/";
    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        String browser = System.getProperty("browser", "chrome");
        driver = DriverManager.getInstance().getDriver(browser);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        DriverManager.getInstance().takeScreenshot(testInfo.getDisplayName());
        DriverManager.getInstance().quitDriver();
    }
}
