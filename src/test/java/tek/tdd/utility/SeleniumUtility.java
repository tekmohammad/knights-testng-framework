package tek.tdd.utility;

import org.openqa.selenium.WebElement;
import tek.tdd.base.BaseSetup;

public class SeleniumUtility extends BaseSetup {

    public String getElementText(WebElement element) {
        return element.getText();
    }
}
