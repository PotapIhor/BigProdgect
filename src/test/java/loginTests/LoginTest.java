package loginTests;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {
    @Test
    public void validLogIn(){
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("909090");
        loginPage.clickOnSubmiButton();
        checkAC("Avatar is not present", homaPage.isAvatarPresent(), true );
    }

    @Test
    public void UnValidLogIn(){
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("");
        loginPage.clickOnSubmiButton();
        checkAC("Avatar is not present", homaPage.isAvatarPresent(), false );
    }
}
