Feature: T2
  Background:
    Given Truck driver should navigate to DashboardPage

    Scenario: Truck Driver navigates to CarEntitlesPage
      When selects Vehicles feature under Fleet module
      Then should navigate to CarEntitlesPage

