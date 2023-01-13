Feature: Functional testing on OrangeHRM

  @LoginFunctionality
  Scenario: Login to OrangeHRM
    Given The user wants to go to OrangeHRM Website
    When The user wants to enter username and password
    Then The user wants to click on Login button
    And The user wants to verify that browser landed on Dashboard
