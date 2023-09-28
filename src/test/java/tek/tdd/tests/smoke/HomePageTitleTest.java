package tek.tdd.tests.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseTests;
import tek.tdd.pages.HomePage;

public class HomePageTitleTest extends UIBaseTests {

    @Test
    public void validateHomePageTitle() {
        String actualHeaderTitle = homePage.getPageHeaderTitleText();
        assertEquals(actualHeaderTitle,
                "TEK Insurance Portal",
                "Validate page header title");
    }

    /* US_3
        As User when navigating Tek Insurance App
        I should see "TEK Insurance Portal" as Header Title
        And Also Login Section title should "Customer Service Portal"
     */
    @Test
    public void validateLoginSectionTitle() {
        String actualSectionCardTitleText = homePage.getSectionCardTitleText();
        assertEquals(actualSectionCardTitleText,
                "Customer Service portal",
                "Validate Card Title");
    }
}
