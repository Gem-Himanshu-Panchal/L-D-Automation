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



  Scenario Outline: Verify functionality of Points icon
  Given Click on points icon
  Then Verify if a dialogue box with "<title>" appears
  And Verify if "<points1>", "<levels>", "<badges>" and "<certificates>" button are displayed
  Then Verify "<displayedNames>" names are displayed inside the dialogue box
  And Verify if all displayed names have "<rank>", "<dp>", "<name>" and "<points>" for "<displayedNames>"
  Then Verify if on hovering on first 3 displayed names, tooltip "<tooltip1>", "<tooltip2>" and "<tooltip3>" is visible
#  And Verify if "<userName>" is displayed at the end on the dialogue box with respective "<rank>", "<dp>", "<name>" and "<points>"
#  Then Verify if "<button>" is present
#  And Click on "<button>" button
#  Then Verify if 8 points are present with the text "<text>"
#  And Verify if on hovering on few points, tooltip "<tooltip4>" and "<tooltip5>" is visible
#  Then Click on "<back>" button and verify if user goes back to dialogue box home page
    Examples:
      | title       | points1 | levels | badges | certificates | displayedNames | rank | dp | name | points | tooltip1 | tooltip2 | tooltip3 | userName         | button | text                                                                                                                                                                                                                                                                                                                                         | tooltip4                 | tooltip5                       | back |
      | Leaderboard | Points  | Levels | Badges | Certificates | 101            | Rank | DP | Name | Points | 1st      | 2nd      | 3rd      | Himanshu Panchal | Back   | Each login gives 1 point;Each unit completion gives 5 points;Each course completion gives 20 points;Each certificate gives 20 points;Each successful test completion gives 20 points;Each successful assignment completion gives 10 points;Each discussion topic or comment gives 5 points;Each upvote on discussion comments gives 1 point; | multiplied by test score | multiplied by assignment grade | Back |














#  Given: first step, navigation
#  When: action and navigation
#  And: action or verification
#  Then: verification