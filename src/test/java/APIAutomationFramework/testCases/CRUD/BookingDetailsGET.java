package APIAutomationFramework.testCases.CRUD;

import APIAutomationFramework.base.BaseTest;
import APIAutomationFramework.endpoins.APIConstants;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingDetailsGET extends BaseTest {

    @Link(name = "TC URL", url = "random.com")
    @Issue("ISS-123")
    @TmsLink("TMS-123")
    @Description("Verify that the booking details are fetched as expected")
    @Owner("Neeru Pareek")
    @Severity(SeverityLevel.NORMAL)

    @Test
    public void getBookingDetails()
    {


    }
}
