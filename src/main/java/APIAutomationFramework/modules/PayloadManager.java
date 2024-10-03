package APIAutomationFramework.modules;

import APIAutomationFramework.pojos.*;
import com.github.javafaker.Faker;
import com.google.gson.Gson;

public class PayloadManager {

    //Serialization and De-Serialization
    Gson g = new Gson();
    public String createBookingPayloadDynamic(){
        Faker f = new Faker();
        BookingPojo bp = new BookingPojo();
        bp.setFirstname(f.name().firstName());
        bp.setLastname(f.name().lastName());
        bp.setDepositpaid(true);
        bp.setTotalprice(f.random().nextInt(3));
        bp.setAdditionalneeds(f.food().ingredient());

        BookingDatesPojo bdp = new BookingDatesPojo();
        bdp.setCheckin("10-09-2024");
        bdp.setCheckout("10-10-2024");
        bp.setBookingdates(bdp);

        //Converting Java Object to String
        Gson g = new Gson();
        String payload = g.toJson(bp);

        return payload;
    }

    public String createBookingPayloadHardCoded(){

        BookingPojo bp = new BookingPojo();
        bp.setFirstname("Neeru");
        bp.setLastname("Pareek");
        bp.setDepositpaid(true);
        bp.setTotalprice(123);
        bp.setAdditionalneeds("Breakfast");

        BookingDatesPojo bdp = new BookingDatesPojo();
        bdp.setCheckin("10-09-2024");
        bdp.setCheckout("10-10-2024");
        bp.setBookingdates(bdp);

        //Converting Java Object to String

        String payload = g.toJson(bp);

        return payload;
    }

    public ResponsePojo responsePayloadObject(String responseString){
        g = new Gson();
        ResponsePojo resPayload = g.fromJson(responseString,ResponsePojo.class);

        System.out.println("Request Payload --> "+resPayload);

        return resPayload;

    }

    //getToken

    public String setAuthPayload(){
g= new Gson();
        TokenPayload tp = new TokenPayload();
        tp.setUsername("admin");
        tp.setPassword("password123");

        String payload = g.toJson(tp);

        return payload;
    }

    public String getTokenFromJson(String tokenResponse){
        TokenReponse tr = g.fromJson(tokenResponse, TokenReponse.class);
        return tr.getToken();
    }

    //getBookingID_CreateBooking
}
