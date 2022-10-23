Feature: Add an attachment for the exiting Patient

  @AddAttachment @Regression
  Scenario: Validate User is able to Book an appointment with successfully in the OpenMRS Application
    Given User enters OpenMRS url in the browser
    When Enter the valid Username and Password in the OpenMRS login page
    And Choose the Inpatient Ward from the Loaction for this session
    Then User click on Log in button
    Then OpenMRS home page should be opened successfully
	  Then User should able to click the Find Patient Record icon from home page
	  Then User should redirect to Find Patient Record page
	  Then User able to see the Search text box in the Find Patient Record page
	  When User should able to enter the Patient ID in the Search text box
	  Then User is able to see the Patient record result for the Patient ID
	  When Click the Patient record from the search result
	  And 