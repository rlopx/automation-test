package apiTests;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;

public class Utils {
    public void restConfig() {
        RestAssured.config = RestAssured.config()
                .sslConfig(new SSLConfig()
                        .relaxedHTTPSValidation());
    }
}
