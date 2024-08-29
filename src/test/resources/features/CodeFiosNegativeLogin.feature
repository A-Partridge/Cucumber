@NegativeLoginFeature @Regression
Feature: Codefios negative login functionality validation

Background:
  Given User in on the codefios login page

@NegativeScenario1 @Smoke
Scenario Outline: User should not be able to login with invalid credentials
  When User enters username as "<username>"
  And User enters password as "<password>"
  But User clicks on the Sign in button
  Then User lands on dashboard page

  Examples:
  | username          | password  |
  | demo@codefios.com | abc124    |
  | demo2@codefios.com| abc123    |
  | demo2@codefios.com| abc124    |
  |                  |            |
