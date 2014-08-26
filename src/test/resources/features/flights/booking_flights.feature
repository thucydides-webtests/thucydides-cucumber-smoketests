@tag:component:ui
@issue:FH-15
Feature:  In order to travel to my destination
As a traveller
I want to be able to book a flight online

Scenario: Filter flights by city before booking
Given I want to book a flight
When I enter 'Se' into the 'from' city field
Then I should see the following cities: Seattle, Seoul
