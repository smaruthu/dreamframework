Feature: To validate login funationality Facebook

Background:
Given  User have to launch browser and Facebook url
And User have to maxmize window

Scenario: To validate login with Invalid username and Invalid password


    When User have to pass InValid username and Invalid password
    #one dimensional map
    |username    |  greens@gmail.com   |
    |password    |  456789             |
    |username1   |  java selenium      |
    |password1   |  456789             |
    
    Then User have to click login button
    And User have to reach invalid login page


Scenario: To validate with Invalid username and Valid password

    When User have to pass InValid username and Valid password
    #two dimensional map
    | username     | password | userId   | pass    |
    | greenstech   | 23456678 | selenium | java    |
    | redtech      | 23456788 | webdrive | testng  |
    | blutech      | 34566788 | cucumber | 345678  |
   
   Then User have to click login button
    And User have to reach invalid login page