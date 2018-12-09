package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    HomaPage homaPage;

    @FindBy(name = "_username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(tagName = "button")
    private WebElement submitButton;


    public LoginPage(WebDriver driver) {
        super(driver, "/login");
        homaPage = new HomaPage(webDriver);
    }

    public void openPage() {
        try {
            webDriver.get(baseUrl + "/login");
            checkCurrentUrl();
            logger.info("Login Page was opened");
        } catch (Exception e) {
            logger.error("Cannot open login page");
            Assert.fail("Cannot open login page");
        }
    }

    public void enterLogin(String login) {
        actionsWithOurElements.enterTextToElement(userNameInput, login);
    }


    public void enterPass(String pass) {
        actionsWithOurElements.enterTextToElement(passwordInput, pass);
    }


    public void clickOnSubmiButton() {
        actionsWithOurElements.clckOnElement(submitButton);
    }

    /**
     * Metod valid login /
     *
     * @param login ONLY VALID LOGIN
     * @param pass  ONLY VALID PASS
     */

    public void userValidLogin(String login, String pass) {
        openPage();
        enterLogin(login);
        enterPass(pass);
        clickOnSubmiButton();
        homaPage.checkCurrentUrl();
        homaPage.isAvatarPresent();
    }
}

