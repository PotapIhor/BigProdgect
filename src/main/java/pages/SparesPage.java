package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage {
EditSparePage editSparePage;


    @FindBy(xpath = ".//*[@data-original-title='Add']")
    private WebElement buttonPlus;

    public SparesPage(WebDriver driver) {
        super(driver, "/dictionary/spares");
        editSparePage = new EditSparePage(webDriver);
    }

    public void deletingAllSparesWithName(String nameOfSpare) {
        while (isSpareInList(nameOfSpare)){
            clickOnSpare(nameOfSpare);
            editSparePage.ckickButtonDelite();
            logger.info("spare with name " + nameOfSpare + "was deleted");
        }
    }

    private void clickOnSpare(String nameOfSpare) {
        actionsWithOurElements.clckOnElement(".//*[text()='" + nameOfSpare + "']");
    }

    private boolean isSpareInList(String nameOfSpare) {
        return actionsWithOurElements.isElementInList(".//*[text()='" + nameOfSpare + "']");
    }

    public void ckickOnButtonPlus() {
        actionsWithOurElements.clckOnElement(buttonPlus);
    }

    public boolean isNewSpareAdded(String nameOfSpare) {
        return actionsWithOurElements.isOneElementInList(".//*[text()='" + nameOfSpare + "']");
    }
}
