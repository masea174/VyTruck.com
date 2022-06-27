Feature: Verification  the click functionality of the "Export Grid" Dropdown
 Background:
  Given  "Truck driver" is on the Login page

Scenario: Verification  the click functionality of the "Export Grid" Dropdown
  When  login as a "Truck Driver"
  And  select Vehicle feature under Fleet module
  Then  Export Grid dropdown should be clickable