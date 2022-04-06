@task1
Feature: Introduction to cucumber task1
  As a test engineer
  I want to be able to write and execute a scenario outline

  @task1_debugs
  Scenario Outline: task1 error scenario outline
    Given I am on numbers page
    When I enter values on numbers page: "<number>"
    And I click submit number
    Then I see error message: "<message>"
    @not_working
    Examples:
      | number  |  message                        |
      | 101     | Number is too big     |
      | 1       | Number is too small |
      | text    | Please enter a number   |


  Scenario: task1 scenario correct
    Given I am on numbers page
    When I enter values on numbers page: "81"
    And I click submit number
    Then I see solution message: "Square root of 81 is 9.00"
