@DashboardFeature @Regression
Feature: Codefios Dashboard functionality validation

	@DashboardScenario1  
	Scenario: User should be able to login with valid credentials
		Given User in on the google login page
		When User enters username as "demo@codefios.com"
		When User enters password as "abc123"
		When User clicks on the Sign in button
		Then User lands on dashboard page
		Then user validates dashboard button
		Then user validates user profile button
