@Regression
Feature: Validate the Product Details Page Navigation

	@Sanity
	Scenario Outline: Validate user is able to login using Valid Credentials and Navigate to Products details page
		Given User have "Valid" Credentials username "standard_user" and password "secret_sauce"
		 When User enters the Credentials in the Login Screen
		 Then User should be able to successfully login into the application
		 And  User should be able to see the 1st product as "Sauce Labs Backpack"
		 And  User should be able to see the 2nd product as "Sauce Labs Bike Light"
		 Then User should be able to successfully logout from the application