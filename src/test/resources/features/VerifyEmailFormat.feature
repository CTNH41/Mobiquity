Feature: Send comment request

  @TC_API_003
  Scenario:Verify Email Format
    Given User sends get request "comments"
    Then User validates the email format

