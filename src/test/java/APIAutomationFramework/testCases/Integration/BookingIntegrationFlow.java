package APIAutomationFramework.testCases.Integration;

import APIAutomationFramework.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class BookingIntegrationFlow extends BaseTest {

    @Owner("Neeru")
    @Description("Verify that the booking is created successfully")
    @Test(groups = "Integration", priority = 1)
    public void createBooking(ITestContext iTestContext){

        iTestContext.setAttribute("token", getToken());

    }

    @Owner("Neeru")
    @Description("Verify the booking details by ID")
    @Test(groups = "Integration", priority = 2)
    public void bookingDetailsById(ITestContext iTestContext){

    }

    @Owner("Neeru")
    @Description("Verify that the booking is upadte successfully")
    @Test(groups = "Integration", priority = 3)
    public void updateBooking(ITestContext iTestContext){
        String token = (String) iTestContext.getAttribute("token");

    }

    @Owner("Neeru")
    @Description("Verify that the booking is deleted successfully")
    @Test(groups = "Integration", priority = 4)
    public void deleteBooking(ITestContext iTestContext){

    }
}
