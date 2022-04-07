@task2
Feature: Introduction to cucumber task2
  task 2 testing

  @task2_add_1
  Scenario Outline: task2 and New Person creation outline
    Given I am on People with Jobs page
    When I click Add person
    And I enter name on People with Jobs page: "<name>" 
    And I enter job on People with Jobs page: "<job>"
    And I click Add
    Then I see name "<name>" on People with Jobs page
    Then I see job "<job>" on People with Jobs page
    Examples:
      | name                | job           |
      | Albus Dumbledore    | Headmaster    |
      | Tom Riddle          | Dark Lord     |


  @task2_edit_person_2
  Scenario Outline: task2 and Edit
    Given I am on People with Jobs page
    When I click Edit person
    And I enter Edited name on People with Jobs page: "<name>"
    And I enter Edited job on People with Jobs page: "<job>"
    And I click Edit
    Then I see name "<name>" on People with Jobs page
    Then I see job "<job>" on People with Jobs page
    Examples:
      | name                | job                   |
      | Albus Dumbledore    | Former Headmaster     |
      | Tom Riddle          | New Headmaster         |

  @task2_remove_person_3

  Scenario: task2 and Remove
    Given I am on People with Jobs page
    When I click Remove person
    Then I cant see removed name on People with Jobs page
    Then I cant see removed job on People with Jobs page

  @task2_reset_after_add_4

  Scenario Outline: task2 and Reset after New Person creation
    Given I am on People with Jobs page
    When I click Add person
    And I enter name on People with Jobs page: "<name>"
    And I enter job on People with Jobs page: "<job>"
    And I click Add
    Then I see name "<name>" on People with Jobs page
    Then I see job "<job>" on People with Jobs page
    Then I click Reset List
    Then I cant see name "<name>" after reset
    Then I cant see job "<job>" after reset

    Examples:
      | name                | job           |
      | Albus Dumbledore    | Headmaster    |

  @task2_clear_fields_during_add_4
  Scenario Outline: task2 and clearing fields
    Given I am on People with Jobs page
    When I click Add person
    And I enter name on People with Jobs page: "<name>"
    And I enter job on People with Jobs page: "<job>"
    And I click Clear all fields
    Then Age field is empty after Clear all fields
    Then Job field is empty after Clear all fields
    Examples:
      | name                | job           |
      | Albus Dumbledore    | Headmaster    |