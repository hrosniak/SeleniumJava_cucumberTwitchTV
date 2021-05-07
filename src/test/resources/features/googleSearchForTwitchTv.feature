Feature: Coming up for Google page and opened first link

  Scenario Outline: Search for Twitch.Tv
    Given Google page is opened
    When I close private politics frame
    And I search for phrase "<searchPhrase>"
    And I click for first element on page
    Then I accept cookie
    Examples:
      | searchPhrase |
      | twitch.tv    |
      | twitchtv     |
      | twitch       |