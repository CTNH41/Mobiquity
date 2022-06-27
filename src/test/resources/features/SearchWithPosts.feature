Feature: Search with Posts


@Us-2
  Scenario Outline:
    Given User send a get request "posts"
    Then Verify response body contain "<param>"

    Examples:
      | param  |
      | userId |
      | id     |
      | title  |
      | body   |


  Scenario Outline: Verify Specific idNumber
    Given User sets a new url "posts" "<idNumber>"

    Then Verify specific "<bodyTitle>"
    Examples:
      | idNumber | bodyTitle                   |
      | 7        | magnam facilis autem        |
      | 10       | optio molestias id quia eum |
      | 15       | eveniet quod temporibus     |


