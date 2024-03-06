@customer
Feature: Testing Customer Proposals Functionality

  Background:
    Given User navigates to customer url
    And User enters correct customer credentials

  Scenario:
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
