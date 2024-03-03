@regression @salesModule
Feature: Testing Sales Module Functionality

  Background:
    Given Navigate to CRM url
    When User enters correct employee email and password
    And Click "Sales" Module from left side navigation menu

  Scenario: Verify sub modules of Sales and their order
    Then Verify that there are 6 sub module under Sales module
    And Verify that order of sub modules are:
      | Proposals    |
      | Estimates    |
      | Invoices     |
      | Payments     |
      | Credit Notes |
      | Items        |

  Scenario: Verify New Proposal button background color
    Then User clicks Click "Proposals" module
    And User verifies that there is button New Proposal and it's background-color is "rgba(37, 99, 235, 1)"