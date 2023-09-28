package tek.tdd.tests.regression;

import org.testng.annotations.Test;
import tek.tdd.base.UIBaseTests;

import java.util.List;

public class PlanCodesTests extends UIBaseTests {
    /* User Story # 8:
    As CSR User when login with valid username and password
   And navigating to plans I should Plans as Section Title,
   And also table contains 4 row and all of them are valid.
     */
    @Test
    public void validatePlanCodeTableRows() throws InterruptedException{
        loginSectionPages.login("supervisor", "tek_supervisor");

        planCodePages.clickOnPlanLink();
        Thread.sleep(2000);

        int tableRowCount = planCodePages.getPlanCodeTableRowsCount();
        assertEquals(tableRowCount, 4, "Plan Code Table Count should be 4");

        List<String> actualColumnsText = planCodePages.getIsExpiredTexts();
        for (String actual: actualColumnsText) {
            assertEquals(actual, "Valid", "Validate Plan Expired Page");
        }
    }
}
