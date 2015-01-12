$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test/resources/features/resources.feature");
formatter.feature({
  "line": 1,
  "name": "Basic betting functionality",
  "description": "\r\nThis feature contains scenarios for the betting system",
  "id": "basic-betting-functionality",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2441021411,
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
  "duration": 4415422902,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_register_providing_correct_information()"
});
formatter.result({
  "duration": 5918170570,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_that_the_registration_was_successful()"
});
formatter.result({
  "duration": 47179587,
  "status": "passed"
});
formatter.after({
  "duration": 1142870925,
  "status": "passed"
});
formatter.before({
  "duration": 1405380552,
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
  "duration": 3053844108,
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
  "duration": 743394595,
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
  "duration": 40042958,
  "status": "passed"
});
formatter.after({
  "duration": 1153680964,
  "status": "passed"
});
formatter.before({
  "duration": 1441549351,
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
  "duration": 3031916545,
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
  "duration": 811023842,
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
  "duration": 49230177,
  "status": "passed"
});
formatter.after({
  "duration": 1203828672,
  "status": "passed"
});
formatter.before({
  "duration": 1328220474,
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
  "name": "I  should  be  told in \"error_dob\"  that  the  data  in  \"dob\"  is \"Invalid Date of Birth. Format: YYYY/MM/DD\"",
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
  "duration": 3326574665,
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
  "duration": 843468736,
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
      "val": "Invalid Date of Birth. Format: YYYY/MM/DD",
      "offset": 68
    }
  ],
  "location": "StepDefinitions.i_should_be_told_in_that_the_data_in_is(String,String,String)"
});
formatter.result({
  "duration": 39510502,
  "status": "passed"
});
formatter.after({
  "duration": 1159161520,
  "status": "passed"
});
formatter.before({
  "duration": 1423048881,
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
  "duration": 3663903125,
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
  "duration": 745757598,
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
  "duration": 42811152,
  "status": "passed"
});
formatter.after({
  "duration": 1149013664,
  "status": "passed"
});
formatter.before({
  "duration": 1386549195,
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
  "name": "I  should  be  told in \"error_cc_exp\"  that  the  data  in  \"cc_exp\"  is \"Invalid Expiry Date. Format: YYYY/MM\"",
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
  "duration": 3763344232,
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
  "duration": 715092755,
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
      "val": "Invalid Expiry Date. Format: YYYY/MM",
      "offset": 74
    }
  ],
  "location": "StepDefinitions.i_should_be_told_in_that_the_data_in_is(String,String,String)"
});
formatter.result({
  "duration": 39252690,
  "status": "passed"
});
formatter.after({
  "duration": 1140389690,
  "status": "passed"
});
formatter.before({
  "duration": 1388734439,
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
  "duration": 4191680721,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 1775040191,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 126237949,
  "status": "passed"
});
formatter.after({
  "duration": 1137408842,
  "status": "passed"
});
formatter.before({
  "duration": 1403497868,
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
  "duration": 3113730786,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 1826395264,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 127723241,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 225989415,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 100078247,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 216184351,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 100536396,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 186802410,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_that_i_have_reached_the_maximum_number_of_bets()"
});
formatter.result({
  "duration": 35450785,
  "status": "passed"
});
formatter.after({
  "duration": 1180848514,
  "status": "passed"
});
formatter.before({
  "duration": 1407558406,
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
  "duration": 5360039722,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5000_euros()"
});
formatter.result({
  "duration": 1677547042,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 122631044,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_1_euros()"
});
formatter.result({
  "duration": 204134516,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_that_i_have_reached_the_maximum_cumulative_betting_amount()"
});
formatter.result({
  "duration": 35901545,
  "status": "passed"
});
formatter.after({
  "duration": 1185925110,
  "status": "passed"
});
formatter.before({
  "duration": 1489227730,
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
  "duration": 32842,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_access_the_betting_screen()"
});
formatter.result({
  "duration": 5749568124,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_refused_access()"
});
formatter.result({
  "duration": 49130829,
  "status": "passed"
});
formatter.after({
  "duration": 1159352416,
  "status": "passed"
});
formatter.before({
  "duration": 1337669199,
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
  "duration": 3813889331,
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
  "duration": 1555456664,
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
  "duration": 39188648,
  "status": "passed"
});
formatter.after({
  "duration": 1149601541,
  "status": "passed"
});
formatter.before({
  "duration": 1364903665,
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
  "duration": 3134299909,
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
  "duration": 1309171947,
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
  "duration": 38580244,
  "status": "passed"
});
formatter.after({
  "duration": 1164825172,
  "status": "passed"
});
formatter.before({
  "duration": 1402841843,
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
  "duration": 3649099465,
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
  "duration": 1555604865,
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
  "duration": 36366674,
  "status": "passed"
});
formatter.after({
  "duration": 1137744244,
  "status": "passed"
});
});