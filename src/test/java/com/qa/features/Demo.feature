#Author: Aarti Suresh
@Smoke
Feature: To Do MVC functionality

	@Smoke
	Scenario Outline: Validate adding 1 item to TO DO list
		Given I want to add items into TO DO list
		When I enter a TO DO item text "<ItemText>"
		Then I check if the added item "<ItemText>" is displayed in the TO DO list
		Examples:
			|ItemText|
			|This is my first TO DO list|


	@Smoke
	Scenario Outline: Validate adding more than 1 items to TO DO list
		Given I want to add items into TO DO list
		When I enter a TO DO item text "<ItemText1>"
		And I enter a TO DO item text "<ItemText2>"
		Then I check if the added item "<ItemText1>" is displayed in the TO DO list
		And I check if the added item "<ItemText2>" is displayed in the TO DO list
		Examples:
			|ItemText1|ItemText2|
			|This is my first TO DO list|This is my second TO DO list|



