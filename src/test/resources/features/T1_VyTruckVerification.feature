
@smoke
Feature: Verification  the click functionality of the "Export Grid" Dropdown
 Background:
  Given  Truck Driver on Vehicle Page

Scenario: Verification  the click functionality of the "Export Grid" Dropdown

  When  Export Grid dropdown is clicked
  Then  CSV and XLSX links should be displayed