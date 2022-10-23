Feature: Logout Scenario

  @Logout @Regression
  Scenario: Validate User is able to Logout from the OpenMRS Application
    Given User enters OpenMRS url in the browser
    When Enter the valid Username and Password in the OpenMRS login page
    And Choose the Inpatient Ward from the Loaction for this session
    Then User click on Log in button
    Then OpenMRS home page should be opened successfully
    Then User click on Logout button from the OpenMRS Application
    Then User able to see the Login page successfully
