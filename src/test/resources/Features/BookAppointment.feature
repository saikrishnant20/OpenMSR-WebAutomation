Feature: Book an appointment

 @BookAppoinmnet @Regression
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
	  When Click the Schedule Appointment under General Actions section
	  Then User able to see the Schedule a New Appointment option
	  Then User able to select Service Type using search box
	  Then Click the Search button
	  Then User able to select the available slots
	  Then Click the Next button after select slot
	  Then User should redirect to Appointment Requests page
	  Then Click the Save the Appointment request
	  Then User should able to view and validate the full history of existing Patient record
	  Then User able to see the booked Appointment details
