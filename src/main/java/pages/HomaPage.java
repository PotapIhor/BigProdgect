package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomaPage extends ParentPage {

    @FindBy(xpath = ".//*[@class='pull-left image']//img[@class='img-circle']")
    WebElement avatar;

    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement subMenuSpare;


    public HomaPage(WebDriver driver) {
        super(driver, "/");
    }

    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementDisplate(avatar);
    }

    public void clickOnMenuDictionary() {
        actionsWithOurElements.clckOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpares() {
        actionsWithOurElements.clckOnElement(subMenuSpare);
    }
}
