Feature: Validation

@ValidationTitle
Scenario: Valid Title
Given initialize the browser
And Navigate to landing page of "http://www.qaclickacademy.com/"
When get the title
Then compare expected string "FEATURED COURSES123" with actual and show the result
And close browser

@ValidationNavbar
Scenario: Validate Navbar
Given initialize the browser
And Navigate to landing page of "http://www.qaclickacademy.com/"
When find the navigation bar
Then Verify navigation bar is displayed
And close browser