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

  Scenario Outline: Verify if all elements are present on Navbar of Home page
    Given Enter "<userName>" and "<password>"
    And Click on Login button
    Then Verify if Gemini logo is present
    Then Verify if points header is present
    Then Verify if if correct "<title>" is displayed
    Then Verify if a "<Learner>" drop down is present
#    Then Verify if a "<Messages>" is present
#    Then Verify if a "<Help>" button is present on screen
#    Then Verify if a searchInput field is present
#    Then Verify if a "<Log out>" button is present
    Examples:
      | userName                             | Learner                                                                               | Messages                                      | Help | Log out | title            | password   |
      | himanshu.panchal@geminisolutions.com | LEARNER;My info;My courses;My certificates;My progress;My groups;My branches;My files | MESSAGES;Go to Inbox;Send message;No messages | HELP | LOG OUT | Himanshu Panchal | Gemini#123 |
















#  Given: first step, navigation
#  When: action and navigation
#  And: action or verification
#  Then: verification