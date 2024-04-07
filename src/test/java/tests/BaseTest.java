package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Booking;
import models.Bookingdates;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class BaseTest {
    RequestSpecification spec;

    @BeforeClass
    public void setup(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .addFilters(Arrays.asList(new RequestLoggingFilter(),new ResponseLoggingFilter()))
                .build();

    }



    public Response CreateBooking(String checkin,String checkout,String firstname,String lastname,int totalprice,boolean depositpaid){
        Bookingdates bookingdates= new Bookingdates(checkin,checkout);
        Booking bookingRequest= new Booking(firstname,bookingdates,totalprice,depositpaid,lastname);

        Response response = given(spec)
                .contentType("application/json")
                .body(bookingRequest)
                .when()
                .post("/booking");

        response
                .then()
                .statusCode(200);

        return response;

    }
}
