package utils;

import io.restassured.response.Response;
import org.testng.Assert;

public class ApiAssertions {

    public static void assertStatus(Response response, int... expectedStatuses) {
        int actualStatus = response.getStatusCode();
        for (int status : expectedStatuses) {
            if (actualStatus == status) {
                String GREEN = "\u001B[32m";
                String RESET = "\u001B[0m";
                System.out.println(GREEN + "\n »»» Success! «««\n" + RESET);
                return; // ✅ success
            }
        }
        Assert.fail(
                "Unexpected status code: " + actualStatus +
                        "\nExpected: " + java.util.Arrays.toString(expectedStatuses) +
                        "\nResponse body: " + response.getBody().asString()
        );
    }
}