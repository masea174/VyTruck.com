@smoke @regression
Feature: TC2 Verification of the "Export Grid" Left location

  Background:

    Given "TruckDriver" is on "Vehicles" page

  Scenario: TC2 Verification of the "Export Grid" Left location

    When Truck Driver is looking for Export Grid Dropdown
    Then Truck Driver should see it on the left side of the page

