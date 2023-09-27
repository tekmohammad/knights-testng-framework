package tek.tdd.tests.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseTests;
import tek.tdd.pages.LoginSectionPages;

public class LoginSectionTests extends UIBaseTests {

    /*User Story # 4: As Selenium Activity
As CSR User when navigating to <Tek Insurance Portal>
Login button should be disabled (element.isEnabled())
After entering username and password login
button should be enabled. (element.isEnabled())
  */
    @Test
    public void validateLoginButtonTest() {
        boolean isButtonEnabled = loginSectionPages.isLoginButtonEnabled();
        assertFalse(isButtonEnabled, "Button should be disabled");

        loginSectionPages.enterCredentials("username", "Password");

        isButtonEnabled = loginSectionPages.isLoginButtonEnabled();

        assertTrue(isButtonEnabled, "Button should be enabled");
    }
}
