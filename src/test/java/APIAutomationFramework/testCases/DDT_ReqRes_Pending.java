package APIAutomationFramework.testCases;

import APIAutomationFramework.utilities.ReadExcel;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DDT_ReqRes_Pending {

    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;
    @Test(dataProvider="getData", dataProviderClass = ReadExcel.class)
    public void createUser(String name, String job){
        rs = new RequestSpecBuilder().setRelaxedHTTPSValidation()
                .setBasePath("https://reqres.in/api")
                .setBaseUri("/users")
                .build();

        System.out.println(name+"-->"+job);
    }
}
