$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test/resources/features/resources.feature");
formatter.feature({
  "line": 1,
  "name": "Basic betting functionality",
  "description": "\r\nThis feature contains scenarios for the betting system",
  "id": "basic-betting-functionality",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3751270586,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Successful Registration",
  "description": "",
  "id": "basic-betting-functionality;successful-registration",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I am a user trying to register",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I register providing correct information",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I should be told that the registration was successful",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.i_am_a_user_trying_to_register()"
});
formatter.result({
  "duration": 3831750608,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_register_providing_correct_information()"
});
formatter.result({
  "duration": 1994886866,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_that_the_registration_was_successful()"
});
formatter.result({
  "duration": 118543822,
  "status": "passed"
});
formatter.before({
  "duration": 1637034851,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Change field names",
  "description": "",
  "id": "basic-betting-functionality;change-field-names;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 11,
  "name": "I am a user trying to register",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "I fill in a form with correct data and I change the \"name\" field to have incorrect input",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "I  should  be  told in \"error_name\"  that  the  data  in  \"name\"  is \"Invalid Name\"",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.i_am_a_user_trying_to_register()"
});
formatter.result({
  "duration": 3534424874,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "name",
      "offset": 53
    }
  ],
  "location": "StepDefinitions.i_fill_in_a_form_with_correct_data_and_I_change_the_field_to_have_incorrect_input(String)"
});
formatter.result({
  "duration": 1789677587,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "error_name",
      "offset": 24
    },
    {
      "val": "name",
      "offset": 59
    },
    {
      "val": "Invalid Name",
      "offset": 70
    }
  ],
  "location": "StepDefinitions.i_should_be_told_in_that_the_data_in_is(String,String,String)"
});
formatter.result({
  "duration": 92583227,
  "status": "passed"
});
formatter.before({
  "duration": 1144404249,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Change field names",
  "description": "",
  "id": "basic-betting-functionality;change-field-names;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 11,
  "name": "I am a user trying to register",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "I fill in a form with correct data and I change the \"surname\" field to have incorrect input",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "I  should  be  told in \"error_surname\"  that  the  data  in  \"surname\"  is \"Invalid Surname\"",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.i_am_a_user_trying_to_register()"
});
formatter.result({
  "duration": 3604266049,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "surname",
      "offset": 53
    }
  ],
  "location": "StepDefinitions.i_fill_in_a_form_with_correct_data_and_I_change_the_field_to_have_incorrect_input(String)"
});
formatter.result({
  "duration": 1696782769,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "error_surname",
      "offset": 24
    },
    {
      "val": "surname",
      "offset": 62
    },
    {
      "val": "Invalid Surname",
      "offset": 76
    }
  ],
  "location": "StepDefinitions.i_should_be_told_in_that_the_data_in_is(String,String,String)"
});
formatter.result({
  "duration": 81560534,
  "status": "passed"
});
formatter.before({
  "duration": 1658427084,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Change field names",
  "description": "",
  "id": "basic-betting-functionality;change-field-names;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 11,
  "name": "I am a user trying to register",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "I fill in a form with correct data and I change the \"dob\" field to have incorrect input",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "I  should  be  told in \"error_dob\"  that  the  data  in  \"dob\"  is \"Invalid Date of Birth\"",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.i_am_a_user_trying_to_register()"
});
formatter.result({
  "duration": 3201028046,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "dob",
      "offset": 53
    }
  ],
  "location": "StepDefinitions.i_fill_in_a_form_with_correct_data_and_I_change_the_field_to_have_incorrect_input(String)"
});
formatter.result({
  "duration": 1663928578,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "error_dob",
      "offset": 24
    },
    {
      "val": "dob",
      "offset": 58
    },
    {
      "val": "Invalid Date of Birth",
      "offset": 68
    }
  ],
  "location": "StepDefinitions.i_should_be_told_in_that_the_data_in_is(String,String,String)"
});
formatter.result({
  "duration": 89027639,
  "status": "passed"
});
formatter.before({
  "duration": 1646984832,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Change field names",
  "description": "",
  "id": "basic-betting-functionality;change-field-names;;5",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 11,
  "name": "I am a user trying to register",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "I fill in a form with correct data and I change the \"cc_num\" field to have incorrect input",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "I  should  be  told in \"error_cc_num\"  that  the  data  in  \"cc_num\"  is \"Invalid Credit Card\"",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.i_am_a_user_trying_to_register()"
});
formatter.result({
  "duration": 3154278283,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "cc_num",
      "offset": 53
    }
  ],
  "location": "StepDefinitions.i_fill_in_a_form_with_correct_data_and_I_change_the_field_to_have_incorrect_input(String)"
});
formatter.result({
  "duration": 1668799500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "error_cc_num",
      "offset": 24
    },
    {
      "val": "cc_num",
      "offset": 61
    },
    {
      "val": "Invalid Credit Card",
      "offset": 74
    }
  ],
  "location": "StepDefinitions.i_should_be_told_in_that_the_data_in_is(String,String,String)"
});
formatter.result({
  "duration": 84522908,
  "status": "passed"
});
formatter.before({
  "duration": 1097269000,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Change field names",
  "description": "",
  "id": "basic-betting-functionality;change-field-names;;6",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 11,
  "name": "I am a user trying to register",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "I fill in a form with correct data and I change the \"cc_exp\" field to have incorrect input",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "I  should  be  told in \"error_cc_exp\"  that  the  data  in  \"cc_exp\"  is \"Invalid Credit Card Expiry Date\"",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.i_am_a_user_trying_to_register()"
});
formatter.result({
  "duration": 3046053917,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "cc_exp",
      "offset": 53
    }
  ],
  "location": "StepDefinitions.i_fill_in_a_form_with_correct_data_and_I_change_the_field_to_have_incorrect_input(String)"
});
formatter.result({
  "duration": 1687242496,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "error_cc_exp",
      "offset": 24
    },
    {
      "val": "cc_exp",
      "offset": 61
    },
    {
      "val": "Invalid Credit Card Expiry Date",
      "offset": 74
    }
  ],
  "location": "StepDefinitions.i_should_be_told_in_that_the_data_in_is(String,String,String)"
});
formatter.result({
  "duration": 83170216,
  "status": "passed"
});
formatter.before({
  "duration": 1628000759,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Successful bet on free account",
  "description": "",
  "id": "basic-betting-functionality;successful-bet-on-free-account",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "I am a user with a free account",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "I try to place a bet of 5 euros",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "I should be told the bet was successfully placed",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.i_am_a_user_with_a_free_account()"
});
formatter.result({
  "duration": 3787158994,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 742591601,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 274947822,
  "status": "passed"
});
formatter.before({
  "duration": 1627114838,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "Verify maximum bets for free accounts",
  "description": "",
  "id": "basic-betting-functionality;verify-maximum-bets-for-free-accounts",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 30,
  "name": "I am a user with a free account",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "I try to place a bet of 5 euros",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "I should be told the bet was successfully placed",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "I try to place a bet of 5 euros",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "I should be told the bet was successfully placed",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "I try to place a bet of 5 euros",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "I should be told the bet was successfully placed",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "I try to place a bet of 5 euros",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "I should be told that I have reached the maximum number of bets",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.i_am_a_user_with_a_free_account()"
});
formatter.result({
  "duration": 3757585337,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 956221233,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 245526881,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 410123388,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 302737323,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 399206613,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 280408673,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 407385573,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_that_i_have_reached_the_maximum_number_of_bets()"
});
formatter.result({
  "duration": 94197835,
  "status": "passed"
});
formatter.before({
  "duration": 1636314783,
  "status": "passed"
});
formatter.scenario({
  "line": 40,
  "name": "Verify maximum cumulative bet for premium accounts",
  "description": "",
  "id": "basic-betting-functionality;verify-maximum-cumulative-bet-for-premium-accounts",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 41,
  "name": "I am a user with a premium account",
  "keyword": "Given "
});
formatter.step({
  "line": 42,
  "name": "I try to place a bet of 5000 euros",
  "keyword": "When "
});
formatter.step({
  "line": 43,
  "name": "I should be told the bet was successfully placed",
  "keyword": "Then "
});
formatter.step({
  "line": 44,
  "name": "I try to place a bet of 1 euros",
  "keyword": "When "
});
formatter.step({
  "line": 45,
  "name": "I should be told that I have reached the maximum cumulative betting amount",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.i_am_a_user_with_a_premium_account()"
});
formatter.result({
  "duration": 3804301847,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5000_euros()"
});
formatter.result({
  "duration": 738999065,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 275240119,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_1_euros()"
});
formatter.result({
  "duration": 401973575,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_that_i_have_reached_the_maximum_cumulative_betting_amount()"
});
formatter.result({
  "duration": 72707896,
  "status": "passed"
});
formatter.before({
  "duration": 1602568513,
  "status": "passed"
});
formatter.scenario({
  "line": 47,
  "name": "Verify access restriction for guest users",
  "description": "",
  "id": "basic-betting-functionality;verify-access-restriction-for-guest-users",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 48,
  "name": "I am a user who has not yet logged on",
  "keyword": "Given "
});
formatter.step({
  "line": 49,
  "name": "I try to access the betting screen",
  "keyword": "When "
});
formatter.step({
  "line": 50,
  "name": "I should be refused access",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.i_am_a_user_who_has_not_yet_logged_on()"
});
formatter.result({
  "duration": 61990,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_access_the_betting_screen()"
});
formatter.result({
  "duration": 3072608137,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_refused_access()"
});
formatter.result({
  "duration": 151410740,
  "status": "passed"
});
formatter.before({
  "duration": 1694616821,
  "status": "passed"
});
formatter.scenario({
  "line": 60,
  "name": "Verify that free users can only place low-risk bets",
  "description": "",
  "id": "basic-betting-functionality;verify-that-free-users-can-only-place-low-risk-bets;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 53,
  "name": "I am a user with a free account",
  "keyword": "Given "
});
formatter.step({
  "line": 54,
  "name": "I try to place a \"low\" bet of 5 euros",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 55,
  "name": "I should be \"Bet Successful!\" to bet",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.i_am_a_user_with_a_free_account()"
});
formatter.result({
  "duration": 3750855541,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "low",
      "offset": 18
    },
    {
      "val": "5",
      "offset": 30
    }
  ],
  "location": "StepDefinitions.i_try_to_place_a_bet_of_euros(String,String)"
});
formatter.result({
  "duration": 716127698,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Bet Successful!",
      "offset": 13
    }
  ],
  "location": "StepDefinitions.i_should_be_to_bet(String)"
});
formatter.result({
  "duration": 117407890,
  "status": "passed"
});
formatter.before({
  "duration": 1672428983,
  "status": "passed"
});
formatter.scenario({
  "line": 61,
  "name": "Verify that free users can only place low-risk bets",
  "description": "",
  "id": "basic-betting-functionality;verify-that-free-users-can-only-place-low-risk-bets;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 53,
  "name": "I am a user with a free account",
  "keyword": "Given "
});
formatter.step({
  "line": 54,
  "name": "I try to place a \"medium\" bet of 5 euros",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 55,
  "name": "I should be \"You are not allowed to place bets with risk medium or higher!\n\nPlease register as a premium user\" to bet",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.i_am_a_user_with_a_free_account()"
});
formatter.result({
  "duration": 3859214150,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "medium",
      "offset": 18
    },
    {
      "val": "5",
      "offset": 33
    }
  ],
  "location": "StepDefinitions.i_try_to_place_a_bet_of_euros(String,String)"
});
formatter.result({
  "duration": 798338098,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "You are not allowed to place bets with risk medium or higher!\n\nPlease register as a premium user",
      "offset": 13
    }
  ],
  "location": "StepDefinitions.i_should_be_to_bet(String)"
});
formatter.result({
  "duration": 153520446,
  "status": "passed"
});
formatter.before({
  "duration": 1612356336,
  "status": "passed"
});
formatter.scenario({
  "line": 62,
  "name": "Verify that free users can only place low-risk bets",
  "description": "",
  "id": "basic-betting-functionality;verify-that-free-users-can-only-place-low-risk-bets;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 53,
  "name": "I am a user with a free account",
  "keyword": "Given "
});
formatter.step({
  "line": 54,
  "name": "I try to place a \"high\" bet of 5 euros",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 55,
  "name": "I should be \"You are not allowed to place bets with risk medium or higher!\n\nPlease register as a premium user\" to bet",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.i_am_a_user_with_a_free_account()"
});
formatter.result({
  "duration": 3811909352,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "high",
      "offset": 18
    },
    {
      "val": "5",
      "offset": 31
    }
  ],
  "location": "StepDefinitions.i_try_to_place_a_bet_of_euros(String,String)"
});
formatter.result({
  "duration": 686366838,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "You are not allowed to place bets with risk medium or higher!\n\nPlease register as a premium user",
      "offset": 13
    }
  ],
  "location": "StepDefinitions.i_should_be_to_bet(String)"
});
formatter.result({
  "duration": 99844656,
  "status": "passed"
});
});