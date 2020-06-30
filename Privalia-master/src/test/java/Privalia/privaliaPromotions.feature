Feature: Promociones home page

  Scenario: Feature promotions are up to date
    When I am in Privalia home page
    Then All the feature ads are up to date


  Scenario: Current promotions are up to date
    When I am in Privalia home page
    Then All the current ads are up to date

  Scenario: Coming up promotions have start date
    When I am in Privalia home page
    Then Coming up promotions have start date