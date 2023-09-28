package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.tests.smoke.LoginSectionTests;
import tek.tdd.utility.SeleniumUtility;

public class LoginSectionPages extends SeleniumUtility {

    public LoginSectionPages() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(name = "username")
    private WebElement usernameElement;
    @FindBy(name = "password")
    private WebElement passwordElement;

    @FindBy(xpath = "//app-banner/div")
    private WebElement bannerMessageElement;

    public boolean isLoginButtonEnabled() {
        return isElementEnabled(loginButton);
    }

    public void enterCredentials(String username, String password) {
        enterText(usernameElement, username);
        enterText(passwordElement, password);
    }

    public void clickOnLogin() {
        clickOnElement(loginButton);
    }

    public void login(String username, String password) {
        enterCredentials(username, password);
        clickOnLogin();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBannerMessage() {
        return getElementText(bannerMessageElement);
    }
}
