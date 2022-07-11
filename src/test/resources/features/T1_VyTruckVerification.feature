
@smoke @wip2
Feature: Verification  the click functionality of the "Export Grid" Dropdown
 Background:
  Given  "TruckDriver" is on "Vehicles" page

Scenario: Verification  the click functionality of the "Export Grid" Dropdown

  When  Export Grid dropdown is clicked
  Then  CSV and XLSX links should be displayed