Feature: As a user, I want to be able to be a Baileys Bar Barista


	Scenario: As a user, I should be able to log in using valid credentials.
		Given the user is on the login page
		When the user enters correct credentials
		When the user uses the login button
		Then the user should be taken to the user page

	Scenario: As a user, I should be able to sign up for and participate in a maximum of 4 of Bailey's classes at any given time.
		Given the user is on the barista page
		Given the user is currently enrolled no more than 4 classes
		When the user selects the enroll checkbox in the class table
		Then the class should move from the class table to the enrolled table

#		the or statement in the given might be problematic
	Scenario: As a user, I should not be able to sign up for a class if the enrolment has reached 20 baristas or the start date has passed.
		Given the user is on the barista page
		Given there are 20 baristas enrolled in a class or the start date has passed
		Then the class should be removed from the class table

	Scenario: As a user, I should be able to sign up for class challenges.
		Given the user is on the barista page
		When the user selects the enroll in challenge checkbox in the class table
		Then the user should be enrolled in the class challenge

	Scenario: As a user, I should be able to drop Bailey's classes.
		Given the user is on the barista page
		When the user selects the drop class button from the enrolled table
		Then the class should move from the enrolled table to the dropped table

	Scenario: As a user, I should be able to quit one of Bailey's challenges.
		Given the user is on the barista page
		When the user unchecks the accepted box
		Then the user should no longer be signed up for the class challenge

	Scenario: As a user, I should be able to add up to three specialty drinks (chosen from a premade list) to my skills matrix.
		Given the user is on the barista page
		When the user selects a drink from the matrix dropdown menu
		Then the drink should be displayed in the matrix dropdown menu

	Scenario: As a user, I should not be able to add a skill to my skills matrix if I have not completed a class which teaches that skill.
		Given the user is on the barista page
		When the user selects a drink from the matrix dropdown menu
		Then the user should only see drinks from completed classes

	Scenario: As a user, I should be dropped from Bailey's Barista Bar if Bailey has dropped me from 3 classes.
		Given the user is on the barista page
		Given the user has been dropped from 3 classes
		Then the user should see an alert about being dropped and be taken to the login screen

	Scenario: As a user, I should be the class rep if I have the oldest active account.
		Given the user is on the barista page
		Given the user has enrolled in a class
		Given the user has the oldest account for those enrolled in that class
		Then the user should see their name as the class rep for that class

