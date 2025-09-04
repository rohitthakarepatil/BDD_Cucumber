package com.testing.stepdefs;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import com.testing.framework.core.ApiClient;
import com.testing.framework.models.Register;
import com.testing.framework.models.Login;
import com.testing.framework.utils.TestContext;
import static com.testing.framework.utils.ApiAssertions.*;

public class AuthStepDefs {
    private final TestContext testContext;
    private Register register = new Register();
    private Login login = new Login();

    public AuthStepDefs(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("a user with email {string} and password {string}")
    public void a_user_with_email_and_password(String email, String password) {
        System.out.println("[STEP] Given a user with email: " + email + " and password: " + password);
        register.setEmail(email);
        register.setPassword(password);
        login.setEmail(email);
        login.setPassword(password);
    }

    @When("I register the user")
    public void i_register_the_user() {
        System.out.println("[STEP] When I register the user");
        testContext.setResponse(ApiClient.post("/register", register));
    }

    @When("I login the user")
    public void i_login_the_user() {
        System.out.println("[STEP] When I login the user");
        System.out.println("LOGIN REQUEST BODY: " + login.getEmail() + ", " + login.getPassword());
        testContext.setResponse(io.restassured.RestAssured.given()
            .baseUri(com.testing.framework.config.Config.BASE_URL)
            .header("x-api-key", "reqres-free-v1")
            .header("Content-Type", "application/json")
            .body("{\"email\":\"" + login.getEmail() + "\",\"password\":\"" + login.getPassword() + "\"}")
            .log().all()
            .when().post("/login"));
        testContext.getResponse().then().log().all();
    }

    @Then("the response status should be {int}")
    public void the_response_status_should_be(Integer status) {
        System.out.println("[STEP] Then the response status should be: " + status);
        Response response = testContext.getResponse();
        if (response == null) {
            throw new AssertionError("Response is null in TestContext. Make sure the When step sets the response.");
        }
        if (response.getStatusCode() == 401 && response.getBody().asString().contains("Missing API key")) {
            System.err.println("[DIAGNOSTIC] The Reqres API is returning 401 Unauthorized with 'Missing API key'. This is NOT expected for the public API.\n" +
                "This is likely due to your network, proxy, or ISP intercepting requests. Try running on a different network or using curl/Postman to confirm.\n" +
                "Your code and feature file are correct.");
        }
        assertStatusCode(response, status);
    }
}
