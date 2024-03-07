@regression @customerProposal
Feature: Testing Customer Proposals Functionality

  Scenario: Create New Proposal for a customer
    Given Navigate to CRM url
    When User enters correct employee email and password
    And Click "Sales" Module from left side navigation menu
    And User clicks "Proposals" module
    When Click New Proposal button from top
    And User fills new proposal info with:
      | subject                | related  | customer | customerName | project | projectName                    |
      | Alex_Proposal_Test_TC5 | Customer | Apple    | Apple LLC    | Apple   | #1 - Apple Project - Apple LLC |
    And User clicks Add Item button and selects items from drop down list and clicks blue check button:
      | item1                 | item2                  | quantity |
      | (253.00) Asus Monitor | (10.00) Ethernet Cable | 2        |
    Then User verifies that Total is "$300.30" and clicks Save & Send button
    And User finds created Proposal by clicking "Sales", "Proposals" and verify that its status is "Sent"

  Scenario: Verify created Proposal as a customer
    Given User navigates to customer url
    And User enters correct customer credentials
    When User verifies that page title is "Apple LLC"
    And User clicks "Proposals" from top navigation menu
    And User searches for proposal "Alex" and verifies following info:
      | subject                | total   |
      | Alex_Proposal_Test_TC5 | $300.30 |
    And User clicks proposal
    Then User verifies that title is "Alex_Proposal_Test_TC5"
    And User verifies info and clicks Accept button after:
      | item1        | item2          |
      | Asus Monitor | Ethernet Cable |
    And From pop up, click Sign and verify user gets red error message that "Please sign the document."
    And User draws a signature in canvas, clicks Sign
    And User verifies "Accepted" status label with green background next to proposal id

  Scenario: Verify approved proposal as employee
    Given Navigate to CRM url
    When User enters correct employee email and password
    And Click "Sales" Module from left side navigation menu
    And User clicks "Proposals" module
    When User sets table length "All" from drop down menu that is next to Export button on top of table
    Then From table verify that approved proposal status label is "Accepted"

  Scenario: Clear New Proposal Data
    Given Navigate to CRM url
    When User enters correct employee email and password
    And Click "Sales" Module from left side navigation menu
    And User clicks "Proposals" module
    Then User deletes the created proposal "Alex_Proposal_Test_TC5"