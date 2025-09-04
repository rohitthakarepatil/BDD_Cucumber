package com.testing.stepdefs;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import com.testing.framework.core.ApiClient;
import com.testing.framework.models.User;
import com.testing.framework.models.UserResponse;
import com.testing.framework.utils.TestContext;

public class UserStepDefs {
    private final TestContext testContext;
    private final User user = new User();

    public UserStepDefs(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("a user with name {string} and job {string}")
    public void a_user_with_name_and_job(String name, String job) {
        user.setName(name);
        user.setJob(job);
    }

    @When("I create the user")
    public void i_create_the_user() {
        testContext.setResponse(ApiClient.post("/users", user));
    }

    @When("I fetch the user with id {int}")
    public void i_fetch_the_user_with_id(Integer id) {
        testContext.setResponse(
            com.testing.framework.core.ApiClient.get("/users/" + id)
        );
    }

    @Then("the user email should be {string}")
    public void the_user_email_should_be(String expectedEmail) {
        Response response = testContext.getResponse();
        if (response == null) {
            throw new AssertionError("Response is null in TestContext. Make sure the When step sets the response.");
        }
        UserResponse userResponse = response.as(UserResponse.class);
        String actualEmail = userResponse.getData().getEmail();
        System.out.println("[STEP] User email in response: " + actualEmail);
        org.junit.Assert.assertEquals(expectedEmail, actualEmail);
    }
}
