package parentTest;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EditSparePage;
import pages.HomaPage;
import pages.LoginPage;
import pages.SparesPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected LoginPage loginPage;
    protected HomaPage homaPage;
    protected SparesPage sparesPage;
    protected EditSparePage editSparePage;

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        homaPage = new HomaPage(webDriver);
        sparesPage= new SparesPage(webDriver);
        editSparePage = new EditSparePage(webDriver);

    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    protected void checkAC(String message, boolean actuale, boolean expected) {
        if (actuale != expected) {
            logger.error("AC failed " + message);
        }
        Assert.assertEquals(message, actuale, expected);

    }
}
