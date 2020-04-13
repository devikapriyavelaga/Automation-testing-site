@valid
Feature: Practice Automation Website

  @TC_03
  Scenario: valid Login
    Given the user launch the application in browser
    When the user clicks on My Accounts
    When the user Enters the valid username and password
    And click on signin button
    Then I validate the outcomes of valid login	

  @TC_04
  Scenario: Invalid Login
    Given the user launch the application in browser
    When the user clicks on My Accounts
    When the user Enters the Invalid username and password
    And click on signin button
    Then I validate the outcomes of invalid login

 