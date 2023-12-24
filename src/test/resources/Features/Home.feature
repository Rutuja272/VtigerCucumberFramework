Feature: Home funtionality

Background:
Given user should be on home page 

@home
Scenario: TC07_verify the all footer link in home page 
When user scrolldown to footer section
Then user should be able to see all links
And user open this all links in different tab
And close all links one by one
