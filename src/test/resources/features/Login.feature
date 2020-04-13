
Feature: Test project login scenario
@login
  Scenario Outline: Test login with valid credentials and Invalid credentials
    Given Open chrome and start application
    When I enter valid "<usernameNumber>" 
    When user should be able to login
    When user should  navigate to shop
    When user should add to cart 
    When user should checkout
    Then application should be closed

    Examples: 
   |usernameNumber|
   | 1  	|
   