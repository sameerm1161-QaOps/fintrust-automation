Feature: Booking API

@smoke
Scenario: Verify booking flow 1
  Given user creates a booking
  When user fetches booking by id
  Then booking price should be correct

Scenario: Verify booking flow 2
  Given user creates a booking
  When user fetches booking by id
  Then booking price should be correct

Scenario: Verify booking flow 3
  Given user creates a booking
  When user fetches booking by id
  Then booking price should be correct