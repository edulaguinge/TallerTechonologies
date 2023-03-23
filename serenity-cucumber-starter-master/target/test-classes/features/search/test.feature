
Feature: Taller Technologies test

  Scenario: Test
  Given I open Google homepage
  When I input "Weather in a selected location" in the search bar
  And I click on submit bottom
  And I click on weather.us link
  And accept Terms and conditions of Weather.us
  And input "Córdoba" on Weather worldwide searcher
  And I execute the webservice to get our temperature in Cordoba
  Then I get my temperatures from Weather.us and the web service execution

