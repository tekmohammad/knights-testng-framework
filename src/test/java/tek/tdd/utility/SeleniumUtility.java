package tek.tdd.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tek.tdd.base.BaseSetup;

import java.time.Duration;
import java.util.List;

public class SeleniumUtility extends BaseSetup {

    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofMinutes(1));
    }

    public String getElementText(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public boolean isElementEnabled(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element)).isEnabled();
    }

    public void enterText(WebElement element, String text) {
        getWait().until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public void clickOnElement(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public List<WebElement> getElements(List<WebElement> elements) {
        return getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void assertEquals(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public void assertEquals(int actual, int expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public void assertFalse(boolean actual, String message) {
        Assert.assertFalse(actual, message);
    }

    public void assertTrue(boolean actual, String message) {
        Assert.assertTrue(actual, message);
    }

    public String takeScreenshot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
    }

    public void waitForInvisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofMinutes(5));
        wait.until(ExpectedConditions.invisibilityOf(element));

    }

}
