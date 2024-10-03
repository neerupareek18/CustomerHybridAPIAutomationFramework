package APIAutomationFramework.assertions;

import io.restassured.response.Response;
import org.testng.Assert;

public class AssertActions {
    //Common Assertions - which can be re-used

    public void verifyResponseBody (String actual, String expected, String description){
        Assert.assertEquals(actual,expected,description);
    }
    //Method Overloading
    public void verifyResponseBody (int actual, int expected, int description){
        Assert.assertEquals(actual,expected,description);
    }

    public void verifyStatusCode(Response res, int expectedCode){
        Assert.assertEquals(res.getStatusCode(),expectedCode);
    }
}