$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test/resources/features/resources.feature");
formatter.feature({
  "line": 1,
  "name": "Basic betting functionality",
  "description": "\r\nThis feature contains scenarios for the betting system",
  "id": "basic-betting-functionality",
  "keyword": "Feature"
});
formatter.before({
  "duration": 6533514733,
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
  "duration": 3154432641,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_register_providing_correct_information()"
});
formatter.result({
  "duration": 2308973251,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_that_the_registration_was_successful()"
});
formatter.result({
  "duration": 132729227,
  "status": "passed"
});
formatter.after({
  "duration": 1311698340,
  "status": "passed"
});
formatter.before({
  "duration": 1698929424,
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
  "duration": 3143261338,
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
  "duration": 1777255403,
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
  "duration": 94106287,
  "status": "passed"
});
formatter.after({
  "duration": 1327320184,
  "status": "passed"
});
formatter.before({
  "duration": 1649529288,
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
  "duration": 3287041994,
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
  "duration": 1793876473,
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
  "duration": 91751496,
  "status": "passed"
});
formatter.after({
  "duration": 1333944884,
  "status": "passed"
});
formatter.before({
  "duration": 1690533703,
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
  "duration": 3324983455,
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
  "duration": 1803740244,
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
  "duration": 92509331,
  "status": "passed"
});
formatter.after({
  "duration": 1309669508,
  "status": "passed"
});
formatter.before({
  "duration": 1709026374,
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
  "duration": 3137028692,
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
  "duration": 1789866020,
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
  "duration": 93829180,
  "status": "passed"
});
formatter.after({
  "duration": 1288778529,
  "status": "passed"
});
formatter.before({
  "duration": 1647004537,
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
  "duration": 3156651548,
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
  "duration": 1737282646,
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
  "duration": 94424037,
  "status": "passed"
});
formatter.after({
  "duration": 1339658621,
  "status": "passed"
});
formatter.before({
  "duration": 1699274679,
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
  "duration": 3992320653,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 819346898,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 290212506,
  "status": "passed"
});
formatter.after({
  "duration": 1331632377,
  "status": "passed"
});
formatter.before({
  "duration": 1637024177,
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
  "duration": 3972978598,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 755564715,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 278088365,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 555500180,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 219973939,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 410082746,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 411013004,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 426436974,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_that_i_have_reached_the_maximum_number_of_bets()"
});
formatter.result({
  "duration": 81995284,
  "status": "passed"
});
formatter.after({
  "duration": 1355863826,
  "status": "passed"
});
formatter.before({
  "duration": 1667956274,
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
  "duration": 3934661093,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5000_euros()"
});
formatter.result({
  "duration": 979671446,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 261988256,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_1_euros()"
});
formatter.result({
  "duration": 436546650,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_that_i_have_reached_the_maximum_cumulative_betting_amount()"
});
formatter.result({
  "duration": 59283611,
  "status": "passed"
});
formatter.after({
  "duration": 1339897549,
  "status": "passed"
});
formatter.before({
  "duration": 1715107123,
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
  "duration": 78000,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_access_the_betting_screen()"
});
formatter.result({
  "duration": 2972692460,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_refused_access()"
});
formatter.result({
  "duration": 128898174,
  "status": "passed"
});
formatter.after({
  "duration": 1312566608,
  "status": "passed"
});
formatter.before({
  "duration": 1638241394,
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
  "duration": 4059185906,
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
  "duration": 806291679,
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
  "duration": 103973342,
  "status": "passed"
});
formatter.after({
  "duration": 1365785070,
  "status": "passed"
});
formatter.before({
  "duration": 1690321050,
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
  "duration": 4343730244,
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
  "duration": 666663519,
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
  "duration": 88234087,
  "status": "passed"
});
formatter.after({
  "duration": 1368450632,
  "status": "passed"
});
formatter.before({
  "duration": 1625917326,
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
  "duration": 4434327332,
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
  "duration": 682419607,
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
  "duration": 102105848,
  "status": "passed"
});
formatter.after({
  "duration": 1317965880,
  "status": "passed"
});
});