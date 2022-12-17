Feature: Orange HRM Dashboard page test

Background: Login to orange hrm
Given user is on login page
When user enters username as "Admin" as password as "admin123"
And clicks on login button

@dashboard
Scenario: Test dashboard page after login
Then dashboard page should be displayed
And dashboard page should have 11 menu items as below
|Admin|
|PIM|
|Leave|
|Time|
|Recruitment|
|My Info|
|Performance|
|Dashboard|
|Directory|
|Maintenance|
|Buzz|
