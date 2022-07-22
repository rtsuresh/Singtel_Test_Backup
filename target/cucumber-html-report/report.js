$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/com/qa/features/Demo.feature");
formatter.feature({
  "name": "To Do MVC functionality",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Validate adding 1 item to TO DO list",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "name": "I want to add items into TO DO list",
  "keyword": "Given "
});
formatter.step({
  "name": "I enter a TO DO item text \"\u003cItemText\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "I check if the added item \"\u003cItemText\u003e\" is displayed in the TO DO list",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "ItemText"
      ]
    },
    {
      "cells": [
        "This is my first TO DO list"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Validate adding 1 item to TO DO list",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Smoke"
    },
    {
      "name": "@Smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I want to add items into TO DO list",
  "keyword": "Given "
});
formatter.match({
  "location": "com.qa.stepDefinitions.demoAppSteps.i_want_to_add_items_into_TO_DO_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter a TO DO item text \"This is my first TO DO list\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.qa.stepDefinitions.demoAppSteps.i_enter_a_to_do_item_text(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I check if the added item \"This is my first TO DO list\" is displayed in the TO DO list",
  "keyword": "Then "
});
formatter.match({
  "location": "com.qa.stepDefinitions.demoAppSteps.I_check_if_the_added_item_is_displayed_in_the_to_do_list(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "screnshot of desktop");
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Validate adding more than 1 items to TO DO list",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "name": "I want to add items into TO DO list",
  "keyword": "Given "
});
formatter.step({
  "name": "I enter a TO DO item text \"\u003cItemText1\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "I enter a TO DO item text \"\u003cItemText2\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "I check if the added item \"\u003cItemText1\u003e\" is displayed in the TO DO list",
  "keyword": "Then "
});
formatter.step({
  "name": "I check if the added item \"\u003cItemText2\u003e\" is displayed in the TO DO list",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "ItemText1",
        "ItemText2"
      ]
    },
    {
      "cells": [
        "This is my first TO DO list",
        "This is my second TO DO list"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Validate adding more than 1 items to TO DO list",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Smoke"
    },
    {
      "name": "@Smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I want to add items into TO DO list",
  "keyword": "Given "
});
formatter.match({
  "location": "com.qa.stepDefinitions.demoAppSteps.i_want_to_add_items_into_TO_DO_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter a TO DO item text \"This is my first TO DO list\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.qa.stepDefinitions.demoAppSteps.i_enter_a_to_do_item_text(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter a TO DO item text \"This is my second TO DO list\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.qa.stepDefinitions.demoAppSteps.i_enter_a_to_do_item_text(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I check if the added item \"This is my first TO DO list\" is displayed in the TO DO list",
  "keyword": "Then "
});
formatter.match({
  "location": "com.qa.stepDefinitions.demoAppSteps.I_check_if_the_added_item_is_displayed_in_the_to_do_list(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I check if the added item \"This is my second TO DO list\" is displayed in the TO DO list",
  "keyword": "And "
});
formatter.match({
  "location": "com.qa.stepDefinitions.demoAppSteps.I_check_if_the_added_item_is_displayed_in_the_to_do_list(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png", "screnshot of desktop");
formatter.after({
  "status": "passed"
});
});