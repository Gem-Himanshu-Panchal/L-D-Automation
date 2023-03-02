Feature:LMS

  Background:
    Given Open LMS url
    Given Open LMS url
    Then Verify if LMS is launched
    When Enter "himanshu.panchal@geminisolutions.com" and "Gemini#123"
    And Click on Login button
    Then Verify if user is logged in

  Scenario Outline: Verify if all elements are present on Navbar of Home page
    Then Verify if Gemini logo is present
    Then Verify if points header is present
    Then Verify if correct "<title>" is displayed
    Then Verify if a "<Learner>" drop down is present
    Then Verify if a "<Messages>" is present
    Then Verify if correct "<Help>" is displayed
    Then Verify if a searchInput field is present
    Then Verify if correct "<Log out>" button is displayed
    Examples:
      | Learner                                                                               | Messages                                      | Help | Log out | title            |
      | LEARNER;My info;My courses;My certificates;My progress;My groups;My branches;My files | MESSAGES;Go to Inbox;Send message;No messages | HELP | Log out | Himanshu Panchal |
















#  Given: first step, navigation
#  When: action and navigation
#  And: action or verification
#  Then: verification