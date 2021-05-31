Feature: Home Page and Login

@Homepage
Scenario Outline: Login flow
Given initialize the browser
And Navigate to landing page of "http://www.qaclickacademy.com/"
And click on login button
When user enters <username> and <password> and <userType>
Then click on login button of loginpage and user is logged in successfull
And click on forgotpassword and enter <emailID>
And click on reset password
And close browser




Examples:
|username				|password	|userType			|emailID	|
|ashishnaggy@gmail.com	|123456		|Non Restricted user|asdasdasd	|
|asdasdasd@gmail.com	|123456		|Restricted user	|asdasdasd	|