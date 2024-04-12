package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateBookingTest extends BaseTest {
    @Test
    public void updateBooking() {
        //CreateToken ->get token
        //CreateBooking -> get booking id
        //get createbooking body -> create update booking body
        //create update booking request
        Response response = UpdateBooking("2024-08-11","2024-08-13","Gökçe","Ozguven",290,true,"2024-08-13","2024-08-15","Umut","Ozguven",295,false);
        Assert.assertEquals("Umut", response.jsonPath().getJsonObject("firstname"));


    }

}
