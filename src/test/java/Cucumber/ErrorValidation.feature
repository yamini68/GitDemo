@tag
Feature: purchase the order from ecoomerce website

  @Errorvalidation
  Scenario Outline:Positive test for submitting the order
    Given I landed on ecommerce page
    When Log in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed
    Examples:
      | name              | password |
      | anala@example.com | Anala@12|