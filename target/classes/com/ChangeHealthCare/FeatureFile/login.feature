#Author: Varadharajan T
#Project: ESS - Salesforce Service Cloud

@First @Smoke
Feature: Salesforce LoginPage

@tags1
Scenario: After Login, Landing page should be HomePage
Given Enter the Username and Password
When Get the Verification code from the mail

@tags2
Scenario Outline: Home page should be landing page
Given Enter the user with data "<data>"
When Enter the pass with data pass "<pas>"

Examples:
		|data|pas|
		|Selenium|Sel123|
		|Variab|Verify| 


