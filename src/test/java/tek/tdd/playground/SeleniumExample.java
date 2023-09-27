package tek.tdd.playground;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumExample {
    private WebDriver driver;

    //First Opening browser before each test method.
    @BeforeMethod
    public void initialBrowser() {
        driver = new ChromeDriver();
        driver.get("https://qa.insurance.tekschool-students.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void testApplicationTitle() {
        String applicationTitle = driver.getTitle();
        Assert.assertEquals(applicationTitle,
                "Tek Insurance Service",
                "Validate Application Title");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
