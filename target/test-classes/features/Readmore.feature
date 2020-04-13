Feature: Readmore about a book
@Readmore
Scenario: Read more about a book
    Given the user launches the app in browser
    When  user clicks on Shop
    Then user clicks Read more
    Then I validate the outcomes of Read more