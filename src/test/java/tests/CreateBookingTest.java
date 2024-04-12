package tests;

import io.restassured.response.Response;
import models.CreateBookingResponse;
import org.testng.Assert;
import org.testng.annotations.Test;



public class CreateBookingTest extends BaseTest {


    @Test
    public void testCreateBookingWithPOJO(){
        Response response = CreateBooking("2024-08-09","2024-08-10","Gokce","Ozguven",294,true);

        CreateBookingResponse createBookingResponse = response.as(CreateBookingResponse.class);

        Assert.assertEquals("Gokce",createBookingResponse.getBooking().getFirstname());


    }



}
