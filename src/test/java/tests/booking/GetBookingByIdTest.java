package tests.booking;

import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetBookingByIdTest {

    @Test
    public void getBookingById_shouldReturnDetailsOfBookingId1() {

        given().
            baseUri("https://restful-booker.herokuapp.com").
            pathParam("id", 1).
        when().
            get("/booking/{id}").
        then().
            statusCode(200).
            log().all();
    }

}
