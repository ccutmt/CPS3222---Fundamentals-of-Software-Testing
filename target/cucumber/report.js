$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test/resources/features/resources.feature");
formatter.feature({
  "line": 1,
  "name": "Basic betting functionality",
  "description": "\r\nThis feature contains scenarios for the betting system",
  "id": "basic-betting-functionality",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2468049792,
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
  "duration": 2329112142,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_register_providing_correct_information()"
});
formatter.result({
  "duration": 1196164924,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_that_the_registration_was_successful()"
});
formatter.result({
  "duration": 42815668,
  "status": "passed"
});
formatter.after({
  "duration": 1143666119,
  "status": "passed"
});
formatter.before({
  "duration": 1447725343,
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
  "duration": 2513729308,
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
  "duration": 722489659,
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
  "duration": 39802799,
  "status": "passed"
});
formatter.after({
  "duration": 1123493155,
  "status": "passed"
});
formatter.before({
  "duration": 1382814617,
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
  "duration": 2444260072,
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
  "duration": 736193103,
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
  "duration": 41380460,
  "status": "passed"
});
formatter.after({
  "duration": 1147939311,
  "status": "passed"
});
formatter.before({
  "duration": 1395446170,
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
  "duration": 2419666126,
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
  "duration": 730693252,
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
  "duration": 40517118,
  "status": "passed"
});
formatter.after({
  "duration": 1135657116,
  "status": "passed"
});
formatter.before({
  "duration": 1393838541,
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
  "duration": 2535423690,
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
  "duration": 718513279,
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
  "duration": 41922358,
  "status": "passed"
});
formatter.after({
  "duration": 1147414245,
  "status": "passed"
});
formatter.before({
  "duration": 1431959814,
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
  "duration": 2441668816,
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
  "duration": 725953288,
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
  "duration": 37607702,
  "status": "passed"
});
formatter.after({
  "duration": 1126287623,
  "status": "passed"
});
formatter.before({
  "duration": 1393012967,
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
  "duration": 3489794671,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 976513660,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 154047976,
  "status": "passed"
});
formatter.after({
  "duration": 1129778758,
  "status": "passed"
});
formatter.before({
  "duration": 1407457415,
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
  "duration": 4285534943,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 527512804,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 150381545,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 203639418,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 108468220,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 168768710,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 122821941,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5_euros()"
});
formatter.result({
  "duration": 163932273,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_that_i_have_reached_the_maximum_number_of_bets()"
});
formatter.result({
  "duration": 38523181,
  "status": "passed"
});
formatter.after({
  "duration": 1135264652,
  "status": "passed"
});
formatter.before({
  "duration": 1420357456,
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
  "duration": 3122792382,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_5000_euros()"
});
formatter.result({
  "duration": 696042997,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_the_bet_was_successfully_placed()"
});
formatter.result({
  "duration": 153052444,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_place_a_bet_of_1_euros()"
});
formatter.result({
  "duration": 201754271,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_told_that_i_have_reached_the_maximum_cumulative_betting_amount()"
});
formatter.result({
  "duration": 33705218,
  "status": "passed"
});
formatter.after({
  "duration": 1163520513,
  "status": "passed"
});
formatter.before({
  "duration": 1490135819,
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
  "duration": 40232,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_try_to_access_the_betting_screen()"
});
formatter.result({
  "duration": 3294615425,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_should_be_refused_access()"
});
formatter.result({
  "duration": 45424167,
  "status": "passed"
});
formatter.after({
  "duration": 1149950901,
  "status": "passed"
});
formatter.before({
  "duration": 1396148585,
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
  "duration": 3521138527,
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
  "duration": 552412594,
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
  "duration": 35011520,
  "status": "passed"
});
formatter.after({
  "duration": 1130694237,
  "status": "passed"
});
formatter.before({
  "duration": 1404534042,
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
  "duration": 4184648776,
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
  "duration": 509555874,
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
  "duration": 37390122,
  "status": "passed"
});
formatter.after({
  "duration": 1126310613,
  "status": "passed"
});
formatter.before({
  "duration": 1416318265,
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
  "duration": 4294558362,
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
  "duration": 483597331,
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
  "duration": 37360564,
  "status": "passed"
});
formatter.after({
  "duration": 1123254638,
  "status": "passed"
});
});