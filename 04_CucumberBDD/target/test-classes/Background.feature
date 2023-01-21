Feature: We are testing background keyword in this feature file

  #@Before annotation in JUnit or TestNg is used to specify
  # that a method should be run before each test method in test class.
  # This method can be used to set up the test environment, such as initializing
  # variables or creating test objects
  #Whereas, Background is to reduce steps and have common steps in one place instead of repetiton.
  #Possible interview question: What is the difference between Hooks and Background keyword
  #Hooks are global throughout the framework, but background is local to the feature file
  #How would decide what to put in hooks and background keyword
  Background: The user wants to go to OrangeHRM Website
    Given The user wants to go to OrangeHRM Website
    When The user wants to enter username and password
    Then The user wants to click on Login button
    And The user wants to verify that browser landed on "Dashboard"


  @TC_200 @Regression @BackGroundKeywordTest
  Scenario: Adding a new employee
    Then The user wants to click on PIM Module
    And The user wants to go to Add Employee Page
    Then The user wants to add first name as "Mehmet"
    Then The user wants to add last name as "Renastech2"
    Then The user wants to save personal information
    Then The user should be able to see "Personal Details"

      #In this scenario we are using Map to provide multiple pieces of information
  @TC300 @Smoke @BackGroundKeywordTest
  Scenario: Adding a new employee - different format - using map
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


  @TC400 @Regression @BackGroundKeywordTest
  Scenario: Adding a new employee - Third format using List
    Then The user wants to click on PIM Module
    And The user wants to go to Add Employee Page
    Then The user wants to add employee's first and last name using a List Method
     #First name   LastName
      |Benjamin  | Renastech22|
      |Abdul     |Renastech33 |
      |Anil      |Renastech44 |
    Then The user wants to add Login details in a List way
     #Username       Password       Status
      |renastech234| Renastech!@@@2| Disabled|
      |abcRenastechh| RenasRenas!@!| Enabled |
      |abc123Renas  |Renastech123@!|Enabled  |
    Then The user wants to save personal information
    Then The user should be able to see "Personal Details"

     #Scenario outline is the place where we implement DDT(DataDrivenTesting)
     # We have 4 examples therefore this scenario will be running 4 times

  @Scenario_Outline_TC1
  Scenario Outline: Adding a new employee - Using Scenario Outline
    Then The user wants to click on PIM Module
    And The user wants to go to Add Employee Page
    Then The user wants to add employee's first and last name using a List Method
     #First name   LastName
      |Benjamin  | Renastech22|
      |Abdul     |Renastech33 |
      |Anil      |Renastech44 |
    Then The user wants to add login information "<username>" "<password>" "<status>"
    Then The user wants to save personal information
    Then The user should be able to see "Personal Details"

    Examples:
      | username | password        | status  |
      |renastech234| Renastech!@@@2| Disabled|
      |abcRenastechh| RenasRenas!@!| Enabled |
      |abc123Renas  |Renastech123@!|Enabled  |
      |Santos123    |RenasRenas12! |Disabled |

  @Scenario_Outline_TC2
  Scenario Outline: Adding a new employee using scenario outline
    Then The user wants to click on PIM Module
    And The user wants to go to Add Employee Page
    Then the user wants to add employee's first name as "<firstname>" and last name as "<lastname>"
    Then The user wants to add login information "<username>" "<password>" "<status>"
    Then The user wants to save personal information
    Then The user should be able to see "Personal Details"

    #"<firstname>" the column should contain exactly how we use the name in steps otherwise
    #Cucumber wont be able to read data we provided
    Examples:
      |firstname|lastname     | username | password  | status        |
      |Benjamin  | Renastech22|renastech234| Renastech!@@@2| Disabled|
      |Abdul     |Renastech33 |abcRenastechh| RenasRenas!@!| Enabled |
      |Anil      |Renastech44 |abc123Renas  |Renastech123@!|Enabled  |
      |Ferah     |RenasRenas32|Santos123    |RenasRenas12! |Disabled |

  @Scenario_Outline_TC3 @BackGroundKeywordTest
  Scenario Outline: Adding new nationalities to Nationalities Page
    And The user wants to go to Admin Module
    Then The user wants to go to Nationalities Page
    And The user wants to click on add new nationality
    Then The user wants to add new nationalities as "<Nationalities>"

    Examples:
      |Nationalities|
      |American     |
      |Ecuador      |
      |Kurdish      |
      |Cuban        |
      |Israeli      |
      |Mexican      |
      |Brazilian    |
      |Turkish      |
      |Iraqi        |


