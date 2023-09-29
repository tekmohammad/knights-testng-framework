package tek.tdd.base;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tek.tdd.pages.AccountsPage;
import tek.tdd.pages.HomePage;
import tek.tdd.pages.LoginSectionPages;
import tek.tdd.pages.PlanCodePages;
import tek.tdd.tests.smoke.LoginSectionTests;
import tek.tdd.utility.SeleniumUtility;
@Listeners({ExtentITestListenerClassAdapter.class})
public class UIBaseTests extends SeleniumUtility {
    protected HomePage homePage;
    protected LoginSectionPages loginSectionPages;
    protected PlanCodePages planCodePages;
    protected AccountsPage accountsPage;
    //Hooks to Open Browser and close browser.
    @BeforeMethod
    public void initializeTest() {
        openBrowser();
        this.homePage = new HomePage();
        this.loginSectionPages = new LoginSectionPages();
        this.planCodePages = new PlanCodePages();
        this.accountsPage = new AccountsPage();
    }

    @AfterMethod
    public void closeTest(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshot = takeScreenshot();
            ExtentTestManager.getTest()
                    .fail("Test Failed",
                            MediaEntityBuilder
                                    .createScreenCaptureFromBase64String(screenshot, "failure_screenshot")
                                    .build());

        }

        closeBrowser();
    }
}
