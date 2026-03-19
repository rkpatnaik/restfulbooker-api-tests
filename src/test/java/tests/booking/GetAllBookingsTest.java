package tests.booking;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAllBookingsTest {

    // Check the response status code
    @Test
    public void getAllBookings_shouldReturn200() {
        given().
        when().
            get("https://restful-booker.herokuapp.com/booking").
        then().
            statusCode(200);
    }

    // Check response content type
    @Test
    public void getAllBookings_shouldReturnApplicationJson() {
        given().
        when().
            get("https://restful-booker.herokuapp.com/booking").
        then().
            contentType(ContentType.JSON);
    }

    // Log request and response
    @Test
    public void getAllBookings_shouldLogRequestAndResponse() {
        given().
            log().all().
        when().
            get("https://restful-booker.herokuapp.com/booking").
        then().
            assertThat().
            statusCode(200);
    }

    //  Assert response body
    @Test
    public void getBookingById_checkFirstName_shouldReturnSusan() {
        given().
            log().all().
        when().
            get("https://restful-booker.herokuapp.com/booking/1").
        then().
            log().body().
            assertThat().
            body("firstname", equalTo("Susan"));
    }

}