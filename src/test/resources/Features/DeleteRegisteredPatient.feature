Feature: Deleting the registered Patient details

  @DeleteRegPatient @Regression
  Scenario: Validate User is able to view exiting patient record details successfully in the OpenMRS Application
    Given User enters OpenMRS url in the browser
    When Enter the valid Username and Password in the OpenMRS login page
    And Choose the Inpatient Ward from the Loaction for this session
    Then User click on Log in button
    Then OpenMRS home page should be opened successfully
	  Then User able to click the Find Patient Record icon from home page
	  Then User should redirect to Find Patient Record page
	  When User is enter the Patient ID in the Search text box
	  Then User is able to see the Patient record result for the Patient ID
	  When Click the Patient record from the search result
	  Then User should able to view and validate the full history of existing Patient record
	  Then Click the Delete Patient link under General Actions section
	  Then User able to get popup for confirmation with Reason and Cancel and Confirm button
	  Then Enter the Reason for DELETE the patient details
	  Then Click the Confirm button for DELETE the patient details
