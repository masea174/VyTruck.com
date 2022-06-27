Feature: Verification  the click functionality of the "Export Grid" Dropdown
 Background:
  Given  Truck Driver on DashboardPage

Scenario: Verification  the click functionality of the "Export Grid" Dropdown

  When  select Vehicle feature under Fleet module
  Then  Export Grid dropdown should be clickable