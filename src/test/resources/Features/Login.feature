Feature: Login Scenario

  @Login @Regression
  Scenario: Validate User is able to login to the OpenMRS Application
    Given User enters OpenMRS url in the browser
    When Enter the valid Username and Password in the OpenMRS login page
    And Choose the Inpatient Ward from the Loaction for this session
    Then User click on Log in button
    Then OpenMRS home page should be opened successfully

 
