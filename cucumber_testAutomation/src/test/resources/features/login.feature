@HROne
Feature: Feature to test login functionality of tekExperience app

  @smoke
  Scenario: To login into tekExperience app with valid credentials
    Given tekExperience app to login
    Then enter username 
    And click on login button
    Then Verify the user login
   
    
