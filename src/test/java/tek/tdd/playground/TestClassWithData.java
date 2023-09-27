package tek.tdd.playground;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClassWithData {
    @Test(dataProvider = "names")
    public void testWithMethods(String firstParam, String secondParam) {
        //print first name,
        System.out.println("First name " + firstParam);
        System.out.println("Last Name " + secondParam);
    }
    //Data Provider = is a method that return 2D array object.
    @DataProvider(name = "names")
    private String[][] testData() {
        String[][] data =  {
                {"Mohammad" , "Shokriyan"},
                {"John" , "Smith"},
                {"Humaira", "Halimi"},
                {"Idress" , "Noori"}
        };
        return data;
    }
}
