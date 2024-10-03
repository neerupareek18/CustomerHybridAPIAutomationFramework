package APIAutomationFramework.testCases.CRUD;

import APIAutomationFramework.assertions.AssertActions;
import APIAutomationFramework.base.BaseTest;
import APIAutomationFramework.endpoins.APIConstants;
import APIAutomationFramework.modules.PayloadManager;
import APIAutomationFramework.pojos.ResponsePojo;
import APIAutomationFramework.utilities.PropertyReader;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreateBookingPOST extends BaseTest {

    @Link(name = "TC URL", url = "random.com")
    @Issue("ISS-123")
    @TmsLink("TMS-123")
    @Description("Verify that the POST request is working as expected")
    @Owner("Neeru Pareek")
    @Severity(SeverityLevel.NORMAL)

    @Test
    public void createBooking()
    {
        pm = new PayloadManager();
        ac= new AssertActions();

        rs.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        r = RestAssured.given(rs).relaxedHTTPSValidation().when().body(pm.createBookingPayloadDynamic()).post();

        vr = r.then().log().all();
        vr.statusCode(200);

        ac.verifyStatusCode(r,Integer.parseInt(PropertyReader.readKey("booking.post.statusCode.success", "QA")));

        //Assert.assertTrue(r.jsonPath().getString("booking.firstname").equalsIgnoreCase(PropertyReader.readKey("booking.post.firstname", "QA")));


        ResponsePojo rp = pm.responsePayloadObject(r.asString());

        assertThat(rp.getBookingid()).isNotNull().isNotEmpty().asInt();
        assertThat(rp.getBooking().getFirstname()).hasSizeGreaterThan(1);
        assertThat(rp.getBooking().getFirstname()).isEqualTo("Dawn");
        assertThat(rp.getBooking().getDepositpaid()).isNotNull();

        //assertThat(rp.getBooking().getTotalprice()).isGreaterThanOrEqualTo(50);

    }
}
