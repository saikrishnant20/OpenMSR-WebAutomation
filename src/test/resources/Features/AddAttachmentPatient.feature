Feature: Add an attachment for the exiting Patient

  @AddAttachment @Regression
  Scenario: Validate User is able to Book an appointment with successfully in the OpenMRS Application
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
	  Then Click the Start Visit
	  Then Click the Confirm
	  Then Click the Attachments button
	  Then Click the area contain Click or drop a file here
	  Then Enter the Caption 
	  Then Click the Upload file button