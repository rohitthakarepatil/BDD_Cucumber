Feature: User API
  Scenario: Create a user successfully
    Given a user with name "morpheus" and job "leader"
    When I create the user
    Then the response status should be 201

  Scenario: Get user by id
    When I fetch the user with id 2
    Then the response status should be 200
