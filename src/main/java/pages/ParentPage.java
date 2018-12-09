package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    String expectedUrl;
    final String baseUrl = "http://v3.test.itpmgroup.com";
    ActionsWithOurElements actionsWithOurElements;

    public ParentPage(WebDriver driver, String expectedUrl) {
        this.webDriver = driver;
        this.expectedUrl = baseUrl + expectedUrl;
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }


    public void checkCurrentUrl() {
        try {
            Assert.assertEquals("URL isnot expected", expectedUrl, getCurrentUrl());
        } catch (Exception e) {
            logger.error("Cannot work with this URL");
            Assert.fail("Cannot work with this URL");
        }
    }
}
