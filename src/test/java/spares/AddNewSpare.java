package spares;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {

    final String nameOfSpare = "testSpare";


    @Test
    public void addSpareTest() {
        loginPage.userValidLogin("Student", "909090");
        homePage.clickOnMenuDictionary();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnSubMenuSpares();
        sparesPage.checkCurrentUrl();
        sparesPage.deletingAllSparesWithName(nameOfSpare);
        sparesPage.ckickOnButtonPlus();
        editSparePage.checkCurrentUrl();
        editSparePage.enterSpareName(nameOfSpare);
        editSparePage.selectSpareType("4");
        editSparePage.clickButtonCreate();
        sparesPage.checkCurrentUrl();
        checkAC("New spare wasn't  added", sparesPage.isNewSpareAdded(nameOfSpare),true);

    }



    @After
    public void deletingNewSpare(){
        sparesPage.deletingAllSparesWithName(nameOfSpare);
    }
}




