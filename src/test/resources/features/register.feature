Feature: Register API
  Scenario: Register successfully
    Given a user with email "eve.holt@reqres.in" and password "pistol"
    When I register the user
    Then the response status should be 200

  Scenario: Register with missing password
    Given a user with email "sydney@fife" and password ""
    When I register the user
    Then the response status should be 400

