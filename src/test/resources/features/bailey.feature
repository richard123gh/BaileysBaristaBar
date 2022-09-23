Feature: As Bailey, I want to run this bar and school.

	Scenario: As Bailey, I should be able to create classes with challenges.
		Given Bailey is on Bailey's page
		When Bailey types a class name
		When Bailey enters a start date
		When Bailey enters a challenge
		When Bailey clicks the create class button
		Then the class should appear in the classes table

 	Scenario: As Bailey, I should be able to drop Baristas from my classes.
		Given Bailey is on Bailey's page
		When Bailey clicks the drop button on the barista table
		Then the class should be removed from the barista's enrolled classes list

	Scenario: As Bailey, I should be able to endorse/unendorse my Baristas' skills.
		Given Bailey is on Bailey's page
		When Bailey checks the endorse button on the barista table
		Then the barista's skill should be endorsed
		When Bailey unchecks the endorse button on the barista table
		Then the barista's skill should be unendorsed

	Scenario: As Bailey, I should be able to add/remove skills from the premade skills list.
		Given Bailey is on Bailey's page
		When Bailey types a skill name
		When Bailey clicks the add button
		Then the skill should be added to the skills table
		When selects the remove button in the skills table
		Then the skill should be removed from the skills table

	Scenario: As Bailey, I should be able to view detailed class and challenge information (e.g number of Baristas enrolled).
		Given Bailey is on Bailey's page
		Then the class information table should be displayed

	Scenario: As Bailey, I should be able to view information about all Baristas.
		Given Bailey is on Bailey's page
		Then the barista information table should be displayed
