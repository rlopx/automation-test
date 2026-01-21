package utils;

import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

public class ApiUtils {
    public ApiUtils() throws Exception {
    }

    /* REST Assured configuration for API testing */
    public static void restConfig() {
        RestAssured.config = RestAssured.config()
                .sslConfig(new SSLConfig()
                        .relaxedHTTPSValidation());
    }

    // ===================== USER MANAGEMENT ENDPOINTS =====================

    /* POST /api/users/register - Create a testing account */
    public static Response registerUser(JsonNode user) {
        return RestAssured
                .given()
                .contentType("application/json")
                .body(user.toString())
                .when()
                .post("/users/register")
                .then()
                .extract()
                .response();
    }


    /* DELETE user account */
    public static void deleteUserAccount(String email, String password) {
        System.out.println("Deleting user account: " + email);
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .header("x-username", email)
                .header("x-password", password)
                .when()
                .delete("/users/api/deleteAccount")
                .then()
                .extract()
                .response();
        ApiAssertions.assertStatus(response, 200, 204);
    }

    // ===================== BALANCE MANAGEMENT ENDPOINTS =====================

    /* POST /api/users/api/addMoney - Add money to checking account */
    public static Response addMoney(String username, String password, String amount) {
        return RestAssured
                .given()
                .contentType("application/json")
                .header("x-username", username)
                .header("x-password", password)
                .body("{\"amount\":\"" + amount + "\"}")
                .when()
                .post("/users/api/addMoney")
                .then()
                .extract()
                .response();
    }

    // ===================== TRANSACTION ENDPOINTS =====================

    /* GET /api/users/api/getIbanByEmail - Get IBANs by email */
    public static Response getIbanByEmail(String email, String username, String password) {
        return RestAssured
                .given()
                .contentType("application/json")
                .header("x-username", username)
                .header("x-password", password)
                .queryParam("email", email)
                .when()
                .get("/users/api/getIbanByEmail")
                .then()
                .extract()
                .response();
    }

    /* POST /api/account/api/createTransaction - Create a transaction */
    public static Response createTransaction(String username, String password, String transactionsJsonArray) {
        return RestAssured
                .given()
                .contentType("application/json")
                .header("x-username", username)
                .header("x-password", password)
                .body(transactionsJsonArray)
                .when()
                .post("/account/api/createTransaction")
                .then()
                .extract()
                .response();
    }

    // ===================== BANK ACCOUNT ENDPOINTS =====================

    /* POST /api/account/api/create - Create new bank account */
    public static Response createBankAccount(String username, String password, String accountName, String amount) {
        String body = String.format("{\"name\":\"%s\",\"amount\":%s}", accountName, amount);
        return RestAssured
                .given()
                .contentType("application/json")
                .header("x-username", username)
                .header("x-password", password)
                .body(body)
                .when()
                .post("/account/api/create")
                .then()
                .extract()
                .response();
    }

}
