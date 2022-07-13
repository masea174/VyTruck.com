Feature: Store manager and sales manager has access to "All Vehicle Contracts" on grid

  Background:
    Given store manager and sales manager on dashboard page
  @US08
  Scenario:
    When store manager and sales manager scrolls to fleet module
    When store manager and sales manager clicks on Vehicle contracts
    Then store manager and sales manager has access to All Vehicle Contracts on grid