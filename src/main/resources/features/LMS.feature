Feature:LMS

  Scenario Outline:Launch LMS portal and login
    Given Open LMS url
    Then Verify if LMS is launched
    When Enter "<userName>" and "<password>"
    And Click on Login button
    Examples:
      | userName                             | password    |
      | himanshu.panchal@geminisolutions.com | Killvibes@18 |




