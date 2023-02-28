Feature:LMS

  Scenario Outline:Launch LMS portal and login
    Given Open LMS url
    Then Verify if LMS is launched
    When Enter "<userName>" and "<password>"
    And Click on Login button
    Then Verify if user is logged in
    Examples:
      | userName                             | password   |
      | himanshu.panchal@geminisolutions.com | Gemini#123 |













#  Given: first step, navigation
#  When: action and navigation
#  And: action or verification
#  Then: verification