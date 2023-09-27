package tek.tdd.playground;


import org.testng.annotations.*;

public class FirstTestNGTest {

    @BeforeTest
    public void runBeforeTestClass() {
        System.out.println("This test will execute before Test Class");
    }

    @AfterTest
    public void runAfterTestClass() {
        System.out.println("This test will execute after test class.");
    }

    @BeforeMethod
    public void runBeforeEachMethod() {
        System.out.println("This method run before each test method. ");
    }

    @AfterMethod
    public void runAfterEachMethod() {
        System.out.println("This will run after each test method");
    }

    @Test
    public void myFirstTest() {
        System.out.println("This is My first test from testNG");
    }

    @Test
    public void mySecondTest() {
        doSomething();
        System.out.println("This is my second test");
    }


    private void doSomething() {

        System.out.println("This is a private method. ");
    }
}
