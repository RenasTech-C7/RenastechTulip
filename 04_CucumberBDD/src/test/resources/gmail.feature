Feature: Login to Gmail, Google search
  #We always have to start with Feature keyword otherwise, it will not work and test cases will not be run



  # This is a positive scenario / happy path
  Scenario: Verify that login to gmail with positive credentials is successful
    Given The user wants to go to Google
    When The user wants to click on Gmail
    Then The user wants to verify If Gmail Page is opened successfully
    And The user wants to click on Sign-In button
    And The user wants to enter correct email address
    And The user wants to enter correct password
    And The user wants to click on login button
    Then The user wants to verify that signing was successfull



  Scenario: Verify that user is able to search in emails
    Given The user wants to go to Google
    When The user wants to click on Gmail
    Then The user wants to verify If Gmail Page is opened successfully
    And The user wants to click on Sign-In button
    And The user wants to enter correct email address
    And The user wants to enter correct password
    And The user wants to click on login button
    Then The user wants to verify that signing was successfull
    And The user wants to search for Renastech in emails
    Then The user wants to verify that search was successful


  #Make a search on Google for Renastech and click on first related website
  # and make sure website opened successfully

  Scenario: Verify that the user is able to go to Renastech using google search
    Given The user wants to go to Google.com
    When The user wants to search for renastech.com
    And The user wants to click on I'm feeling lucky button
    Then The user wants to verify that the browser is redirected to renastech



  Scenario:  Verify that the user is able to go to Renastech using google search button
    Given The user wants to go to Google.com
    When The user wants to search for renastech
    And The user wants to click on Search Button
    Then The user wants to verify that the browser is redirected to renastech
