package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class HomePage extends SeleniumUtility {
    /* Each Page have to Initialize with driver
    in the constructor of class. using.
    PageFactory and initElements().

     */
    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    //@FindBy approach
    @FindBy(xpath = "//mat-toolbar/span[1]")
    public WebElement pageHeaderTitle;


}
