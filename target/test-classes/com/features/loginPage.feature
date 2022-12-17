Feature: Orange HRM login

Scenario: Test title of login page 
Given user is on login page
When user gets the title of the page
Then the page title should be "OrangeHRM"

Scenario: Test Forgot your password
Given user is on login page
Then forgot your password link should be displayed

@login
Scenario: Test login of orange hrm
Given user is on login page
When user enters username as "Admin" as password as "admin123"
And clicks on login button
Then dashboard page should be displayed
