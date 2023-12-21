Feature: Filtering and Sorting

  Scenario Outline: Product search filtering by number of reviews and free shipping
    Given user is on the home page
    When user searches for "<telephone>"
    Then user search results should contain "<searchResult>"
    When user selects the second brand
    And user sorts the results by review count
    Then user sorting is correct
    When user filters for free shipping
    Then user results should only contain products with free shipping
    Examples:
      | telephone | searchResult         |
      | telefon   | Telefon Cep Telefonu |