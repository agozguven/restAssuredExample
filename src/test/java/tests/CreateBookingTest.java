package tests;

import io.restassured.response.Response;
import models.Booking;
import models.Bookingdates;
import models.CreateBookingResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

import static io.restassured.RestAssured.given;


public class CreateBookingTest extends BaseTest {


    @Test
    public void testCreateBookingWithPOJO(){
        Response response = CreateBooking("2024-08-09","2024-08-10","Gokce","Ozguven",294,true);

        CreateBookingResponse createBookingResponse = response.as(CreateBookingResponse.class);

        Assert.assertEquals("Gokce",createBookingResponse.getBooking().getFirstname());


    }



}
