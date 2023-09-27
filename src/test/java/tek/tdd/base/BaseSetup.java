package tek.tdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseSetup {
    //Encapsulate Driver
    private static WebDriver driver;

    private final static String APP_URL = "https://qa.insurance.tekschool-students.com";
    public void openBrowser() {
        //Chrome
        driver = new ChromeDriver();
        driver.get(APP_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    public void closeBrowser() {
        if (driver != null)
            driver.quit();

    }

    public WebDriver getDriver() {
        return driver;
    }
}
