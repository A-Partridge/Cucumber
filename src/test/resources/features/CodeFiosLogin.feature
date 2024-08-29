@LoginFeature @Regression
Feature: Codefios login functionality validation

Background:
  Given User in on the codefios login page
  When User enters username as "demo@codefios.com"

@LoginScenario1
Scenario: User should be able to login with valid credentials	
  When User enters password as "abc123"
  But User clicks on the Sign in button
  Then User lands on dashboard page
  
@LoginScenario2 @Smoke
Scenario: User should be able to login with valid credentials
  When User enters password as "abc124"
  But User clicks on the Sign in button
  Then User lands on dashboard page
