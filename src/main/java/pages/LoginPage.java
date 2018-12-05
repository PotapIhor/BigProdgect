package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{

    @FindBy (name = "_username")
    private WebElement userNameInput;

    @FindBy (id = "password")
    private WebElement passwordInput;

    @FindBy (tagName = "button")
    private WebElement submitButton;


    public LoginPage(WebDriver driver) {
        super(driver, "/login");
        }

        public void openPage(){
        try {
            webDriver.get(baseUrl + "/login");
            checkCurrentUrl();
            logger.info("Login Page was opened");
        }catch (Exception e){
            logger.error("Cannot open login page");
            Assert.fail("Cannot open login page");
        }
        }

        public void enterLogin(String login){
        try {
        userNameInput.clear();
        userNameInput.sendKeys(login);
        logger.info(login + "was input into login");
        }

        catch (Exception e){
            logger.error("Cannot enter Login");
        Assert.fail("Cannot enter Login");
        }}


    public void enterPass(String pass){
        try {
            passwordInput.clear();
            passwordInput.sendKeys(pass);
            logger.info(pass + "was input into password");
        }

        catch (Exception e){
            logger.error("Cannot enter password");
            Assert.fail("Cannot enter password");
        }}

        public void clickOnSubmiButton(){
        try {
            submitButton.click();
            logger.info("Succses clicked on button");

        }catch (Exception e){
            logger.error("Cannot click Button");
            Assert.fail("Cannot click Button");
        }
        }
}

