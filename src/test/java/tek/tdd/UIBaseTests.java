package tek.tdd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import tek.tdd.utility.SeleniumUtility;

public class UIBaseTests extends SeleniumUtility {

    //Hooks to Open Browser and close browser.
    @BeforeMethod
    public void initializeTest() {
        openBrowser();
    }

    @AfterMethod
    public void closeTest() {
        closeBrowser();
    }
}
