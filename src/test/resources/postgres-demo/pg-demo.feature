Feature: Postgres Demo REST

  Scenario: Add record
    Given table is empty
    When I add entry "something"
    Then the number of records should be 1000
