Feature: Data Driven Testin - Using External files - Login to Orange HRM

  @ExcelFile
  Scenario: Login to OrangeHRM using Excel File(External File)
    Given The user wants to login to OrangeHRM using Excel file(External File)
    And The user wants to verify that browser landed on "Dashboard"