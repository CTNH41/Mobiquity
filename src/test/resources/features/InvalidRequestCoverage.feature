Feature: Invalid  Test Coverage
  Scenario Outline: Negative Test Coverages
    When the user sends invalid request "<invalidEndPoint>"
    Then Status code should be 404

    Examples: | invalidEndPoint|
    |post            |
    |comment         |
    |album           |
    |photo           |
    |todo            |
    |user            |

