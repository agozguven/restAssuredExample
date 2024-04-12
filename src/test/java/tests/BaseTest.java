package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Auth;

import models.Booking;
import models.Bookingdates;
import models.CreateBookingResponse;
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

    public String CreateToken(){
        Auth authBody = new Auth("password123","admin");

        Response response = given(spec)
                .contentType("application/json")
                .body(authBody)
                .when()
                .post("/auth");

        return response.jsonPath().getJsonObject("token");

    }
    public Response UpdateBooking(String checkin,String checkout,String firstname,String lastname,int totalprice,boolean depositpaid,String updatedcheckin,String updatedcheckout,String updatedfirstname,String updaatedlastname,int updatedtotalprice,boolean updateddepositpaid){
        Bookingdates bookingdates= new Bookingdates(updatedcheckin,updatedcheckout);
        Booking updatebookingRequest= new Booking(updatedfirstname,bookingdates,updatedtotalprice,updateddepositpaid,updaatedlastname);
        String token = CreateToken();
        Response newBooking = CreateBooking(checkin, checkout, firstname, lastname, totalprice, depositpaid);
        CreateBookingResponse createBookingResponse = newBooking.as(CreateBookingResponse.class);
        int bookingId = createBookingResponse.getBookingid();

        Response response = given(spec)
                .contentType("application/json")
                .header("Cookie", "token=" + token)
                .body(updatebookingRequest)
                .when()
                .put("/booking/" + bookingId);

        response
                .then()
                .statusCode(200);

        return response;

    }

}


