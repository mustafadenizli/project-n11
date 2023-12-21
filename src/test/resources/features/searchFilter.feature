Feature: Store search and filtering

  Scenario Outline: Searching for a random store as a result of filtering
    Given user on the stores page
    When user click on the all stores button
    And user choose the store that starts with the letter "<letter>"
    And user click on a random store
    Then user view the referred store
    Examples:
      | letter |
      | S      |

