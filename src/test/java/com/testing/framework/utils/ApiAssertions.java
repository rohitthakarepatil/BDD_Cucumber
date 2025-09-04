package com.testing.framework.utils;

import static org.junit.Assert.*;
import io.restassured.response.Response;

public class ApiAssertions {
    public static void assertStatusCode(Response response, int expected) {
        assertEquals(expected, response.getStatusCode());
    }
    public static void assertFieldEquals(Response response, String field, String expected) {
        assertEquals(expected, response.jsonPath().getString(field));
    }
}
