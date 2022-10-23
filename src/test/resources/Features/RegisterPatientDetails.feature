Feature: Register a Patient Details

  @Register @Regression
  Scenario: Validate User is able to register a patient details successfully in the OpenMRS Application
    Given User enters OpenMRS url in the browser
    When Enter the valid Username and Password in the OpenMRS login page
    And Choose the Inpatient Ward from the Loaction for this session
    Then User click on Log in button
    Then OpenMRS home page should be opened successfully
    Then User able to click the Register a patient icon from home page
    Then User should redirect to Register a patient page to fill the required fields
    Then Enter the patient given and family Name detail
    Then Click the next button
    Then Select the patient gender detail
    Then Click the next button
    Then Enter the patient birth date detail
    Then Click the next button
    Then Enter the patient address detail
    Then Click the next button
    Then Enter the patient phone number detail
    Then Click the next button
		Then Enter the patient Relatives detail
		Then Click the next button
		Then Click the Confirm button
		Then User should see the registered patient details along with patient id