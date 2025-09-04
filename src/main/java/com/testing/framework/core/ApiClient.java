package com.testing.framework.core;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static com.testing.framework.config.Config.BASE_URL;

public class ApiClient {
    public static Response get(String endpoint) {
        return given().baseUri(BASE_URL)
            .header("x-api-key", "reqres-free-v1")
            .when().get(endpoint);
    }
    public static Response post(String endpoint, Object body) {
        return given().baseUri(BASE_URL)
            .header("x-api-key", "reqres-free-v1")
            .contentType("application/json")
            .body(body)
            .when().post(endpoint);
    }
    public static Response put(String endpoint, Object body) {
        return given().baseUri(BASE_URL)
            .header("x-api-key", "reqres-free-v1")
            .contentType("application/json")
            .body(body)
            .when().put(endpoint);
    }
    public static Response patch(String endpoint, Object body) {
        return given().baseUri(BASE_URL)
            .header("x-api-key", "reqres-free-v1")
            .contentType("application/json")
            .body(body)
            .when().patch(endpoint);
    }
    public static Response delete(String endpoint) {
        return given().baseUri(BASE_URL)
            .header("x-api-key", "reqres-free-v1")
            .when().delete(endpoint);
    }
}
