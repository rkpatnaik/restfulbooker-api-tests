package tests.booking;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetBookingsParameterizedTest {
    @BeforeAll
    public static void setupSsl() {
        RestAssured.useRelaxedHTTPSValidation();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void getBookingById_shouldReturnNonEmptyLastName(int bookingId) {
        given().
            baseUri("https://restful-booker.herokuapp.com").
            pathParam("id", bookingId).
        when().
            get("booking/{id}").
        then().
            statusCode(200).
            body("lastname", notNullValue());
    }

    @ParameterizedTest
    @CsvSource({
        "3, Brown",
        "4, Brown"
    })
    public void getBookingById_shouldReturnLastName(int bookingId, String expectedLastName) {
        given().
            baseUri("https://restful-booker.herokuapp.com").
            pathParam("id", bookingId).
            log().all().
        when().
            get("booking/{id}").
        then().
            log().body().
            statusCode(200).
            body("lastname", equalTo(expectedLastName));
    }
}