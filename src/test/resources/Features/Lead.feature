Feature: Lead fuctionlity

Background: 
Given user should be on home page 

@lead
Scenario: TC05_Lead_E2E
When user click on leads then click on new lead
Then user should be land on new lead page 
And user enter title and fisrt name and last name and company name
And user click on save button
Then lead should be created successfully
And close browser

