@regression
Feature: Testing Proposals Functionality

  Background:
    Given Navigate to CRM url
    When User enters correct employee email and password
    And Click "Sales" Module from left side navigation menu
    And User clicks Click "Proposals" module

  @newProposal
  Scenario: Create New Proposal for a customer
    And Click New Proposal button from top
    And User fills new proposal info with:
      | subject                | related  | customer | customerName | project | projectName                    |
      | Alex_Proposal_Test_TC5 | Customer | Apple    | Apple LLC    | Apple   | #1 - Apple Project - Apple LLC |
    And User clicks Add Item button and selects items from drop down list and clicks blue check button:
      | item1                 | item2                  | quantity |
      | (253.00) Asus Monitor | (10.00) Ethernet Cable | 2        |
    Then User verifies that Total is "$300.30" and clicks Save & Send button
    And User finds created Proposal by clicking "Sales", "Proposals" and verify that its status is "Sent"