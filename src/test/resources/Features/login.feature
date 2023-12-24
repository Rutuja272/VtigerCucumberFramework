Feature: Login fuctionlity

Background:
Given user should be on login page

Scenario: TC01_verifyAppUrl
When user enter valid crednatial and click on login button
Then verify the title
And close browser

Scenario: TC02_verifyLogo
When user enter valid crednatial and click on login button
Then verify the logo
And close browser

@Test
Scenario: TC03_VerifyValidLogin
When user enter valid crednatial and click on login button
Then user should be navigate to home page and validate the logout 
And close browser

@Test
Scenario: TC04_VerifyInValidLogin
When user enter invalid crednatial and click on login button
Then user should be navigate to login page and validate the error msg
And close browser

Scenario Outline: valid login
When user enter valid userid as "<userid>" and password as "<password>" and click on login button
Then user should be navigate to home page and validate the logout 
And close browser
Examples:
|userid|password|
|admin|admin|
|admin|admin|
|admin|admin|

@Test
Scenario: TC06_validateTheTheme
When user enter valid crednatial and select the theme and click on login button
Then user should be navigate to home page and validate the logout 
And close browser

@theme
Scenario Outline: validate the theme
When user enter valid userid as "<userid>" and password as "<password>" and theme as "<theme>" and click on login button
Then user should be navigate to home page and validate the logout 
And close browser
Examples:
|userid|password|theme|
|admin|admin|Aqua|
|admin|admin|orange|
|admin|admin|blue|