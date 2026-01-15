package utils;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ApiUtils {
    private static final String BASE_URL = "https://monetis-delta.vercel.app/api";

    private static final HttpClient httpClient = HttpClient
            .newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    /* REST Assured configuration for API testing */
    public static void restConfig() {
        RestAssured.config = RestAssured.config()
                .sslConfig(new SSLConfig()
                        .relaxedHTTPSValidation());
    }

    // ===================== USER MANAGEMENT ENDPOINTS =====================

    /* POST /api/users/register - Create a testing account */
    public static HttpResponse<String> registerUser(String name, String surname, String email, String phoneNumber,
                                                    String streetAddress, String postalCode, String city,
                                                    String country, String password, String confirmPassword) {
        String body = String.format(
                "{\"name\":\"%s\",\"surname\":\"%s\",\"email\":\"%s\",\"phone_number\":\"%s\"," +
                        "\"street_address\":\"%s\",\"postal_code\":\"%s\",\"city\":\"%s\",\"country\":\"%s\"," +
                        "\"password\":\"%s\",\"confirmPassword\":\"%s\"}",
                name, surname, email, phoneNumber, streetAddress, postalCode, city, country, password, confirmPassword);
        try {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(BASE_URL + "/users/register"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            logResponse("POST", BASE_URL + "/users/register", response);
            return response;
        } catch (Exception e) {
            System.out.println("Error registering user: " + e.getMessage());
            return null;
        }
    }

    /* DELETE user account via API (RestAssured fallback method) */
    public static void deleteUserAccount(String email) {
        try {
            Response response = RestAssured
                    .given()
                    .baseUri(BASE_URL)
                    .header("Content-Type", "application/json")
                    .queryParam("email", email)
                    .when()
                    .delete("/users/api/deleteAccount")
                    .then()
                    .extract()
                    .response();

            if (response.getStatusCode() == 200 || response.getStatusCode() == 204) {
                System.out.println("Account deleted successfully for email: " + email);
            } else {
                System.out.println("Failed to delete account. Status: " + response.getStatusCode());
            }
        } catch (Exception e) {
            System.out.println("Error deleting account: " + e.getMessage());
        }
    }

    // ===================== BALANCE MANAGEMENT ENDPOINTS =====================

    /* POST /api/users/api/addMoney - Add money to checking account */
    public static HttpResponse<String> addMoney(String username, String password, String amount) {
        String body = String.format("{\"amount\":\"%s\"}", amount);
        try {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(BASE_URL + "/users/api/addMoney"))
                    .header("Content-Type", "application/json")
                    .header("x-username", username)
                    .header("x-password", password)
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            logResponse("POST", BASE_URL + "/users/api/addMoney", response);
            return response;
        } catch (Exception e) {
            System.out.println("Error adding money: " + e.getMessage());
            return null;
        }
    }

    // ===================== TRANSACTION ENDPOINTS =====================

    /* GET /api/users/api/getIbanByEmail - Get IBANs by email */
    public static HttpResponse<String> getIbanByEmail(String email, String username, String password) {
        try {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(BASE_URL + "/users/api/getIbanByEmail?email=" + email))
                    .header("Content-Type", "application/json")
                    .header("x-username", username)
                    .header("x-password", password)
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            logResponse("GET", BASE_URL + "/users/api/getIbanByEmail", response);
            return response;
        } catch (Exception e) {
            System.out.println("Error getting IBAN: " + e.getMessage());
            return null;
        }
    }

    /* POST /api/account/api/createTransaction - Create a transaction */
    public static HttpResponse<String> createTransaction(String username, String password, String transactionsJsonArray) {
        try {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(BASE_URL + "/account/api/createTransaction"))
                    .header("Content-Type", "application/json")
                    .header("x-username", username)
                    .header("x-password", password)
                    .POST(HttpRequest.BodyPublishers.ofString(transactionsJsonArray))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            logResponse("POST", BASE_URL + "/account/api/createTransaction", response);
            return response;
        } catch (Exception e) {
            System.out.println("Error creating transaction: " + e.getMessage());
            return null;
        }
    }

    // ===================== BANK ACCOUNT ENDPOINTS =====================

    /* POST /api/account/api/create - Create new bank account */
    public static HttpResponse<String> createBankAccount(String username, String password, String accountName, String amount) {
        String body = String.format("{\"name\":\"%s\",\"amount\":%s}", accountName, amount);
        try {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(BASE_URL + "/account/api/create"))
                    .header("Content-Type", "application/json")
                    .header("x-username", username)
                    .header("x-password", password)
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            logResponse("POST", BASE_URL + "/account/api/create", response);
            return response;
        } catch (Exception e) {
            System.out.println("Error creating bank account: " + e.getMessage());
            return null;
        }
    }

    /* DELETE /api/users/api/deleteAccount - Delete a testing account */
    public static HttpResponse<String> deleteAccount(String username, String password) {
        try {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(BASE_URL + "/users/api/deleteAccount"))
                    .header("Content-Type", "application/json")
                    .header("x-username", username)
                    .header("x-password", password)
                    .DELETE()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            logResponse("DELETE", BASE_URL + "/users/api/deleteAccount", response);
            return response;
        } catch (Exception e) {
            System.out.println("Error deleting account: " + e.getMessage());
            return null;
        }
    }

    // ===================== HELPER METHODS =====================

    /* Helper method to log HTTP responses */
    private static void logResponse(String method, String endpoint, HttpResponse<String> response) {
        System.out.println("\n" + method + " " + endpoint);
        System.out.println("Status: " + response.statusCode());
        if (response.body() != null && !response.body().isEmpty()) {
            System.out.println("Body: " + response.body());
        }
    }
}
