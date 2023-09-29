package tek.tdd.tests.smoke;

import com.aventstack.extentreports.service.ExtentTestManager;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseTests;

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

    @Test(dataProvider = "negativeLoginData")
    public void loginWithNegativeDateTest(String username,
                                          String password ,
                                          String expectedErrorMessage) {
        ExtentTestManager.getTest()
                        .info("Staring negative testing");
        loginSectionPages.login(username, password);
        String actualErrorMessage= loginSectionPages.getBannerMessage();

        assertEquals(actualErrorMessage,
                expectedErrorMessage,
                "Validate login negative testing");
    }

    @DataProvider(name = "negativeLoginData")
    public String[][] negativeTestDate() {
        return new String[][]{
                {"Wrong username", "tek_supervisor", "User not found"},
                {"supervisor", "invalidPassword", "Password Not Matched"},
                {"Wrong username", "invalid password", "User not found"},
                {"mohammad", "some password", "Password Not Matched"}
        };
    }

    @Test
    public void validateUsersLoggedIn(){
        loginSectionPages.login("supervisor", "tek_supervisor");

        String actualPageHeaderTitleText =homePage.getPageHeaderTitleText();
        assertEquals(actualPageHeaderTitleText,
                "Tek Insurance App",
                "Validate page header");

        String usernameText = homePage.getUsernameElementText();
        String actualUsername = usernameText
                .replace("account_circle", "")
                .trim();

        assertEquals(actualUsername,
                "Supervisor",
                "Validate logged in username");
    }
}
