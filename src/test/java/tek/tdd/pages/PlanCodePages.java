package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

import java.util.ArrayList;
import java.util.List;

public class PlanCodePages extends SeleniumUtility {

    public PlanCodePages() {
        PageFactory.initElements(getDriver(), this);
    }


    @FindBy(partialLinkText = "Plans")
    private WebElement plansLink;

    @FindBy(xpath = "//table/tbody/tr")
    private List<WebElement> planCodeTableRows;

    @FindBy(xpath = "//table/tbody/tr/td[6]")
    private List<WebElement> planCodeIsExpiredColumn;


    public void clickOnPlanLink() {
        clickOnElement(plansLink);
    }

    public int getPlanCodeTableRowsCount() {
        return getElements(planCodeTableRows).size();
    }

    public List<String> getIsExpiredTexts() {
        List<String> texts = new ArrayList<>();
        List<WebElement> elements = getElements(planCodeIsExpiredColumn);
        for (WebElement element : elements) {
            texts.add(element.getText());
        }
        return texts;
    }

}
