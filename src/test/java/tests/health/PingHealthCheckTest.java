package tests.health;

import org.junit.Test;

import static io.restassured.RestAssured.*;

public class PingHealthCheckTest {

    @Test
    public void healthCheck_shouldReturn201() {
        given().
        when().
            get("https://restful-booker.herokuapp.com/ping").
        then().
            statusCode(201);
    }
}
