package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

import java.util.List;

public class AccountsPage extends SeleniumUtility {

    public AccountsPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(partialLinkText = "Accounts")
    private WebElement accountsLink;

    @FindBy(xpath = "//app-spinner//mat-spinner")
    private WebElement spinner;

    @FindBy(xpath = "//table/tbody/tr")
    private List<WebElement> accountsTableRow;

    @FindBy(xpath = "//mat-paginator//mat-select")
    private WebElement itemPerPagePageDropdown;
    @FindBy(xpath = "//mat-option")
    private List<WebElement> itemPerPageOptions;

    public void clickOnAccountsLinkAndWaitForSpinner() {
        clickOnElement(accountsLink);

        //Wait for Spinner
        waitForInvisibilityOfElement(spinner);
    }

    public int accountsTableRowCount() {
        return getElements(accountsTableRow).size();
    }

    public void selectItemPerPage(String option) {
        clickOnElement(itemPerPagePageDropdown);
        List<WebElement> optionElements = getElements(itemPerPageOptions);
        for (WebElement element : optionElements) {
            String text = getElementText(element);
            if (text.equalsIgnoreCase(option)) {
                clickOnElement(element);
            }
        }
    }
}
