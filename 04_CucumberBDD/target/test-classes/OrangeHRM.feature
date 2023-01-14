Feature: Functional testing on OrangeHRM

  @LoginFunctionality
  Scenario: Login to OrangeHRM
    Given The user wants to go to OrangeHRM Website
    When The user wants to enter username and password
    Then The user wants to click on Login button
    And The user wants to verify that browser landed on Dashboard


    @ParameterizedDashboard @TC100
  Scenario: Login to OrangeHRM with Parameterized message
    Given The user wants to go to OrangeHRM Website
    When The user wants to enter username and password
    Then The user wants to click on Login button
    And The user wants to verify that browser landed on "Dashboard"

    @TC_200
  Scenario: Adding a new employee
    Given The user wants to go to OrangeHRM Website
    When The user wants to enter username and password
    Then The user wants to click on Login button
    And The user wants to verify that browser landed on "Dashboard"
    Then The user wants to click on PIM Module
    And The user wants to go to Add Employee Page
    Then The user wants to add first name as "Mehmet"
    Then The user wants to add last name as "Renastech2"
    Then The user wants to save personal information
    Then The user should be able to see "Personal Details"

      #In this scenario we are using Map to provide multiple pieces of information
  @TC300
  Scenario: Adding a new employee - different format - using map
    Given The user wants to go to OrangeHRM Website
    When The user wants to enter username and password
    Then The user wants to click on Login button
    And The user wants to verify that browser landed on "Dashboard"
    Then The user wants to click on PIM Module
    And The user wants to go to Add Employee Page
    Then The user wants to add employee's first and last name
    # Key            Value
    |FirstName |     Eloise12  |
    |LastName  | Renastech1212 |
    Then The user wants to add login details as following
    # Key            Value
    |UserName   |   Eloise1232     |
    |Password   | Renastech!123@  |
    |Status     | Disabled        |
    Then The user wants to save personal information
    Then The user should be able to see "Personal Details"