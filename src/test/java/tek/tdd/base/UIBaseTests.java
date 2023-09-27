package tek.tdd.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import tek.tdd.pages.HomePage;
import tek.tdd.pages.LoginSectionPages;
import tek.tdd.tests.smoke.LoginSectionTests;
import tek.tdd.utility.SeleniumUtility;

public class UIBaseTests extends SeleniumUtility {
    protected HomePage homePage;
    protected LoginSectionPages loginSectionPages;
    //Hooks to Open Browser and close browser.
    @BeforeMethod
    public void initializeTest() {
        openBrowser();
        this.homePage = new HomePage();
        this.loginSectionPages = new LoginSectionPages();
    }

    @AfterMethod
    public void closeTest() {
        closeBrowser();
    }
}
