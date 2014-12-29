Feature: Basic betting functionality

This feature contains scenarios for the betting system

Scenario: Successful Registration
Given I am a user trying to register
When I register providing correct information
Then I should be told that the registration was successful