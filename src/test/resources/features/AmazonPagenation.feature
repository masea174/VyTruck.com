@wip3
Feature: Amazon Pagenation
  Scenario: User Should be able to see all the pages


    Given User on Amazon Page
    When  User is looking "FLOWERS" in the search box
    Then  User should be able to see all the pages with the web results