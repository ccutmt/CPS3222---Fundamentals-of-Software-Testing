Feature: Basic betting functionality

This feature contains scenarios for the betting system

Scenario: Successful Registration
Given I am a user trying to register
When I register providing correct information
Then I should be told that the registration was successful

Scenario Outline: Change field names
Given I am a user trying to register
When I fill in a form with correct data and I change the "<fieldname>" field to have incorrect input
Then  I  should  be  told in "<errorMessage>"  that  the  data  in  "<fieldname>"  is "<incorrect>"

Examples:

|fieldname     |incorrect            |errorMessage	|
|name     |Invalid Name   |error_name|
|surname      |Invalid Surname   |error_surname	|
|dob           |Invalid Date of Birth |error_dob		|
|cc_num    |Invalid Credit Card         |error_cc_num|
|cc_exp   |Invalid Credit Card Expiry Date|error_cc_exp	|

Scenario: Successful bet on free account
Given I am a user with a free account
When I try to place a bet of 5 euros
Then I should be told the bet was successfully placed

Scenario: Verify maximum bets for fre accounts
Given I am a user with a free account
When I try to place a bet of 5 euros
Then I should be told the bet was successfully placed
When I try to place a bet of 5 euros
Then I should be told the bet was successfully placed
When I try to place a bet of 5 euros
Then I should be told the bet was successfully placed
When I try to place a bet of 5 euros
Then I should be told that I have reached the maximum number of bets