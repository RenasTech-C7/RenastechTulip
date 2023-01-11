Feature: Payment Gateway functional test

  Scenario: Verify that user can buy an Elephant toy
    Given The user wants to go to Payment Gateway Website
    When The user wants to buy an elephant toy
    Then The user wants to provide requested payment information
    And The user wants to click on pay now
    Then The user wants to verify order is successful
