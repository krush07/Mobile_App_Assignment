@Regression
Feature: Validate the Login functionality test scenarios

	@Sanity
	Scenario Outline: Validate user is able to login using Valid Credentials
		Given User have "Valid" Credentials username "standard_user" and password "secret_sauce"
		 When User enters the Credentials in the Login Screen
		 Then User should be able to successfully login into the application
		 Then User should be able to successfully logout from the application
		 
	@Regression
	Scenario Outline: Validate user is not able to login using InValid Credentials
		Given User have "Invalid" Credentials username <Username> and password <Password>
		 When User enters the Credentials in the Login Screen
		 Then User should see error message <errorMessage> on Login Screen

		Examples: 
			| Username        | Password        | errorMessage                                                   |
			| "invalid_user"  | "secret_sauce"  | "Username and password do not match any user in this service." |
			| "standard_user" | "invalid_sauce" | "Username and password do not match any user in this service." |
			| ""              | "secret_sauce"  | "Username and password do not match any user in this service." |
			| "standard_user" | ""              | "Username and password do not match any user in this service." |
			| ""              | ""              | "Username and password do not match any user in this service." |
