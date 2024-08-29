@DbLoginFeature @Regression
Feature: Codefios login functionality validation

@DBLoginScenario1
Scenario: User should be able to login with valid credentials	from MySQL database
  Given User in on the codefios login page
  When User enters username as "username" from database
  When User enters password as "password" from database
  But User clicks on the Sign in button
  Then User lands on dashboard page
  

