Feature: Solving Lab1 in Study Hall

@StudyHall
  Scenario: Handling DropDown without select tab
    Given User navigates to the websites "https://renas-practice.herokuapp.com/projects/insurance"
    When User clicks Get a Quote button
    Then User chooses vehicle year as "2023"
    And User make vehicle as "GMC"
    Then User make model as "Hummer EV"
    And The next button is enabled and click Next button

  @StudyHall1
  Scenario: Handling Calender
    Given User navigates to the websites "https://renas-practice.herokuapp.com/projects/insurance"
    When User clicks Get a Quote button
    Then User clicks Coverage Start date
    And User choose start date