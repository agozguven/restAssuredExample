package tests;

import io.restassured.response.Response;
import models.CreateBookingResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

import static io.restassured.RestAssured.given;

public class GetBookingByIdTest extends BaseTest {

      @Test
      public void getBookingByIdWitPOJO() {

            Response newBooking = CreateBooking("2024-08-11","2024-08-12","Umut","Ozguven",260,false);
            CreateBookingResponse getBookingResponse = newBooking.as(CreateBookingResponse.class);
            int bookingId = getBookingResponse.getBookingid();
            Response response = given(spec)
                    .when()
                    .get("/booking/" + bookingId);

            System.out.println(bookingId + " booking id'si alınmıştır.");
            Assert.assertEquals(response.getStatusCode(), 200);
            Assert.assertEquals("Umut", getBookingResponse.getBooking().getFirstname());
            Assert.assertEquals("Ozguven", getBookingResponse.getBooking().getLastname());
            Assert.assertEquals(260,getBookingResponse.getBooking().getTotalprice());






      }

}
