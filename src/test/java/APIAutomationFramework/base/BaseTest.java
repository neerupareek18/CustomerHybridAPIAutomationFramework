package APIAutomationFramework.base;

//Common to all TestCases -- Single Inheritence

import APIAutomationFramework.assertions.AssertActions;
import APIAutomationFramework.endpoins.APIConstants;
import APIAutomationFramework.modules.PayloadManager;
import APIAutomationFramework.utilities.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.Collection;
import java.util.List;
import java.util.Map;

//TC -- Common Header - Ex.
public class BaseTest {

public RequestSpecification rs;
public Response r;
public ValidatableResponse vr;
public AssertActions ac;
public PayloadManager pm;
public JsonPath jp;

    @BeforeTest
    public void setUp(){

//        rs = RestAssured
//                .given().relaxedHTTPSValidation()
//                .baseUri(APIConstants.BASE_URL)
//                .contentType(ContentType.JSON)
//                .log().all();

        rs = new RequestSpecBuilder().setRelaxedHTTPSValidation()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type","application/json")
                .build().log().all();

    }


    public String getToken(){
        rs = new RequestSpecBuilder().setRelaxedHTTPSValidation()
                .setBasePath(PropertyReader.readKey("URL","QA"))
                .setBaseUri("/auth")
                .setBody(pm.setAuthPayload())
                .build().log().all();

        r = rs.when().post();
        String token = pm.getTokenFromJson(r.asString());

        return token;
    }

}
