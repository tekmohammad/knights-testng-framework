package tek.tdd.tests.smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.UIBaseTests;
import tek.tdd.pages.HomePage;

public class HomePageTitleTest extends UIBaseTests {

    @Test
    public void validateHomePageTitle() {
        HomePage homePage = new HomePage();
        String actualHeaderTitle = homePage.pageHeaderTitle.getText();

        Assert.assertEquals(actualHeaderTitle,
                "TEK Insurance Portal",
                "Validate page header title");
    }
}
