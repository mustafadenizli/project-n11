Feature: Product Transactions

  Scenario Outline: Adding products and adding them to cart
    Given user is on the home page
    When user searches for "<telephone>"
    Then user search results should contain "<searchResult>"
    When user adds the first product to the cart
    And user adds the last product to the cart
    And user goes to the shopping cart
    And user proceeds to checkout as a guest
    Then user is redirected to the payment page
    Examples:
      | telephone | searchResult              |
      | iphone    | Iphone Apple Cep Telefonu |