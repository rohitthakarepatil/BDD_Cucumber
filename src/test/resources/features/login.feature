Feature: Login API
  Scenario: Login successfully
    Given a user with email "eve.holt@reqres.in" and password "cityslicka"
    When I login the user
    Then the response status should be 200

  Scenario: Login with missing password
    Given a user with email "peter@klaven" and password ""
    When I login the user
    Then the response status should be 400

