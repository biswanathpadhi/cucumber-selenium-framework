package com.util;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.factory.DriverFactory;

public class ElementUtil {

    private static final Logger logger = LogManager.getLogger();
    private WebDriver driver = DriverFactory.getDriver();

    public void waitUntilElementIsLocated(WebElement element) {
        // Declare and initialise a fluent wait
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(element));
        logger.info("wait is over");
    }
}
