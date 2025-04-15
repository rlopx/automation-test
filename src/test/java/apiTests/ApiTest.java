package apiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest {
    @Test
    public void testUserSignupApi() {
        Utils util = new Utils();
        util.restConfig();
        try {
            // Given
            RestAssured.baseURI = "https://monetis-delta.vercel.app";
            String requestBody = """
                    {"name": "Julie",
                    "surname": "Jolly",
                    "email": "email15645@nttdata.com",
                    "phone_number": "123123123",
                    "street_address": "Couves",
                    "postal_code": "1231-123",
                    "city": "Lisbon",
                    "country": "PT",
                    "password": "mYpas$w0rd",
                    "confirmPassword": "mYpas$w0rd"
                    }""";

            // When
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    //.header("Content-Type", "application/json")
                    .body(requestBody)
                    .when()
                    .post("/api/users/register");

            // Then Validate the response
            System.out.println(response.asString());
            Assert.assertEquals(response.getStatusCode(), 200);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

        }
    }
}
