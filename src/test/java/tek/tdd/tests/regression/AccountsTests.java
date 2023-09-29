package tek.tdd.tests.regression;

import org.testng.annotations.Test;
import tek.tdd.base.UIBaseTests;
import tek.tdd.pages.AccountsPage;

public class AccountsTests extends UIBaseTests {

    //US_9
    @Test
    public void validateAccountsTableRows() {
        //Step 1) Login
        loginSectionPages.login("supervisor", "tek_supervisor");
        accountsPage.clickOnAccountsLinkAndWaitForSpinner();

        int rowCount = accountsPage.accountsTableRowCount();

        assertEquals(rowCount, 10, "Validate account table row");
    }
}
