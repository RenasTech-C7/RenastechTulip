Feature: Testing dashboard with data table



@dashboard
  Scenario: Verify dashboard on header with data table
    Given User navigates to website as "https://www.ebay.com/"
    Then User verify all the dashboards on header
      | Saved | Motors | Electronics | Collectibles | Home & Garden | Fashion | Toys | Sporting Goods | Business & Industrial | Jewelry & Watches | eBay Live | Refurbished |
