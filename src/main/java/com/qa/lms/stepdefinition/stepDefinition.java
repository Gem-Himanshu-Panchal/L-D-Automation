package com.qa.lms.stepdefinition;

import com.gemini.generic.ui.utils.DriverAction;
import com.qa.lms.locators.locator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.awt.peer.TextAreaPeer;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class stepDefinition {
    boolean passed = false;

    @Then("Verify if LMS is launched")
    public void verify_if_lms_is_launched() {
        passed = false;
        try {
            if (DriverAction.isExist(locator.avatar) && DriverAction.isExist(locator.credBox)
                    && DriverAction.isExist(locator.inputNameField) && DriverAction.isExist(locator.inputPasswordField)
                    && DriverAction.isExist(locator.loginButton))
                passed = true;

        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if correct page is launched",
                    " Correct url is launched ",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if correct page is launched",
                    " Incorrect url is launched ", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @When("Enter {string} and {string}")
    public void enterAnd(String userName, String password) {
        passed = false;
        try {
            DriverAction.typeText(locator.inputNameField, userName);
            STATUS val = DriverAction.typeText(locator.inputPasswordField, password);
            if (val.equals(STATUS.PASS))
                passed = true;
            DriverAction.waitSec(2);
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Enter login credentials",
                    " Correct credentials entered ",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Enter login credentials",
                    " Incorrect login credentials ", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @And("Click on Login button")
    public void clickOnLoginButton() {
        passed = false;
        try {
            DriverAction.click(locator.loginButton);
            DriverAction.waitSec(5);
        } catch (Exception ex) {
            passed = false;
        }
    }

    @Then("Verify if user is logged in")
    public void verifyIfUserIsLoggedIn() {
        passed = false;
        try {
            DriverAction.waitSec(5);

            if (DriverAction.isExist(locator.avatar) && DriverAction.isExist(locator.searchIcon)
                    && DriverAction.isExist(locator.progressDashboard))
                passed = true;
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if user is logged in or not",
                    " User is successfully logged in ",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if user is logged in or not",
                    " User is unable to log in ", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if Gemini logo is present")
    public void verify_if_gemini_logo_is_present() {
        passed = false;
        try {
            DriverAction.waitSec(2);
            passed = DriverAction.isExist(locator.avatar);
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if Gemini logo is present",
                    "Gemini logo is present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if Gemini logo is present",
                    "Gemini logo is missing", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if points header is present")
    public void verify_if_points_header_is_present() {
        passed = false;
        try {

            passed = DriverAction.isExist(locator.pointsIcon);
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if points header is present",
                    "Points box is present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if points header is present",
                    "Points box is missing", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if correct {string} is displayed")
    public void verify_if_if_correct_is_displayed(String expectedText) {
        passed = false;
        try {
            String extractedText = DriverAction.getElementText(locator.fun(expectedText));
            if (extractedText.trim().equalsIgnoreCase(expectedText))
                passed = true;
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if " + expectedText + " is displayed",
                    "Correct text is present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if " + expectedText + " is displayed",
                    "Incorrect text is displayed", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if a {string} drop down is present")
    public void verify_if_a_drop_down_is_present(String dropdownTitle) {
        passed = false;
        boolean flag = false;
        try {
            String extractedText = DriverAction.getElementText(locator.learnerdropdownTitle);
            String[] names = dropdownTitle.split(";");

            List<WebElement> dropdownElements = DriverAction.getElements(locator.learnerDropdown);
            List<String> extractedDropdownText = new ArrayList<>();

            for (WebElement dropdownElement : dropdownElements) {
                extractedDropdownText.add(dropdownElement.getAttribute("textContent").trim());
            }

            if (extractedText.equalsIgnoreCase(names[0])) {
                flag = true;
            }
            if (flag) {
                for (int i = 0, j = 1; i < extractedDropdownText.size(); i++, j++) {

                    if (!extractedDropdownText.get(i).equalsIgnoreCase(names[j])) {
                        flag = false;
                        break;
                    }
                }
            }

            passed = flag;
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if if Learner text and its dropdown elements are present",
                    "Correct elements are present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if if Learner text and its dropdown elements  are present",
                    "Incorrect elements are present", STATUS.FAIL, DriverAction.takeSnapShot());
    }


    @Then("Verify if a searchInput field is present")
    public void verify_if_a_search_input_field_is_present() {
        passed = false;
        try {
            passed = DriverAction.isExist(locator.inputField);
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if a searchInput field is present",
                    "Input box is present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if a searchInput field is present",
                    "input box is missing", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if a {string} is present")
    public void verifyIfAIsPresent(String expectedText) {
        passed = false;
        try {
            boolean flag = false;
            String extractedText = DriverAction.getElementText(locator.messageText);

            String[] names = expectedText.split(";");
            List<WebElement> dropdownElements = DriverAction.getElements(locator.messageDropdown);
            List<String> extractedDropdownText = new ArrayList<>();

            for (WebElement dropdownElement : dropdownElements) {
                extractedDropdownText.add(dropdownElement.getAttribute("textContent").trim());
            }

            if (extractedText.trim().equalsIgnoreCase(names[0])) {
                flag = true;
            }
            if (flag) {
                for (int i = 0, j = 1; i < extractedDropdownText.size(); i++, j++) {

                    if (!extractedDropdownText.get(i).equalsIgnoreCase(names[j])) {
                        flag = false;
                        break;
                    }
                }
            }

            passed = flag;
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if if Message text and its dropdown elements are present",
                    "Correct elements are present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if if Message text and its dropdown elements  are present",
                    "Incorrect elements are present", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if correct {string} button is displayed")
    public void verifyIfCorrectButtonIsDisplayed(String expectedText) {
        passed = false;
        try {
            WebElement logOutButton = DriverAction.getElement(locator.logouticon);
            String extractedText = logOutButton.getAttribute("textContent").trim();
            if (expectedText.equalsIgnoreCase(extractedText))
                passed = true;
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if " + expectedText + " button is displayed",
                    "Correct button is present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if " + expectedText + " button is displayed",
                    "Incorrect button is present", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Given("Click on points icon")
    public void clickOnPointsIcon() {
        passed = false;
        try {
            DriverAction.waitSec(2);
            if (DriverAction.isExist(locator.pointsIcon)) {
                DriverAction.click(locator.pointsIcon);
                passed = true;
            }
            DriverAction.waitSec(3);
        } catch (Exception ex) {
            passed = false;
        }
//        if (passed)
//            GemTestReporter.addTestStep("Click on Points button",
//                    "Successfully clicked on points button",
//                    STATUS.PASS, DriverAction.takeSnapShot());
//        else
//            GemTestReporter.addTestStep("Click on Points button",
//                    "Unable to click on points button", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if a dialogue box with {string} appears")
    public void verifyIfADialogueBoxWithAppears(String title) {
        passed = false;
        try {
            if (DriverAction.isExist(locator.pointsDialogueBox) &&
                    title.trim().equalsIgnoreCase(DriverAction.getElementText(locator.pointsHeader).trim()))
                passed = true;
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if points dialogue box with title: " + title + " is present",
                    "Points dialogue box is present with title: " + title,
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if points dialogue box with title: \"+title+\" is present",
                    "Points dialogue box is missing", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @And("Verify if {string}, {string}, {string} and {string} button are displayed")
    public void verifyIfAndButtonAreDisplayed(String points, String levels, String badges, String certificates) {
        passed = false;
        String missingButton = "";
        int flag = 0;
        List<String> list = new ArrayList<>();
        try {
            list.add(points);
            list.add(badges);
            list.add(levels);
            list.add(certificates);
            for (int i = 0; i < list.size(); i++) {
                flag = i;
                if (!DriverAction.isExist(locator.fun2(list.get(i)))) {
                    passed = false;
                    break;
                } else {
                    passed = true;
                }
            }

        } catch (Exception ex) {
            passed = false;
            missingButton = list.get(flag);
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if " + points + ", " + levels + ", " + badges + " and " + certificates + " buttons are present",
                    "All the buttons are present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if \"+points+\", \"+levels +\", \"+badges+\" and \"+certificates+ \" buttons are present",
                    missingButton + " is missing", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify {string} names are displayed inside the dialogue box")
    public void verifyNamesAreDisplayedInsideTheDialogueBox(String countOfNames) {
        passed = false;
        try {
            int count = Integer.parseInt(countOfNames);
            List<WebElement> list = DriverAction.getElements(locator.countPointDialogueBox);
            if (list.size() == count)
                passed = true;
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if " + countOfNames + " names are displayed",
                    countOfNames + " are displayed in points dialogue box",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if \"+countOfNames +\" names are displayed",
                    "Incorrect count of names", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @And("Verify if all displayed names have {string}, {string}, {string} and {string} for {string}")
    public void verifyIfAllDisplayedNamesHaveAnd(String rank, String dp, String name, String points, String countOfNames) {
        passed = false;
        try {
            int count = Integer.parseInt(countOfNames);
            List<WebElement> rankList = DriverAction.getElements(locator.rank);
            List<WebElement> dpList = DriverAction.getElements(locator.dp);
            List<WebElement> nameList = DriverAction.getElements(locator.userName);
            List<WebElement> pointsList = DriverAction.getElements(locator.points);
            if (rankList.size() == count && dpList.size() == count && nameList.size() == count && pointsList.size() == count - 1)
                passed = true;

        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if " + rank + ", " + dp + ", " + name + " and " + points + " are visible in points dialogue box",
                    "Displayed names have mentioned columns",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if " + rank + ", " + dp + ", " + name + " and " + points + " are visible in points dialogue box",
                    "Displayed names have missing columns", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if on hovering on first three displayed names, tooltip {string}, {string} and {string} is visible")
    public void verifyIfOnHoveringOnFirstDisplayedNamesTooltipAndIsVisible(String tooltip1, String tooltip2, String tooltip3) {
        passed = false;
        String wrongToolTip = "";
        try {
            DriverAction.waitSec(2);

            List<String> tooltipText = new ArrayList<>();
            tooltipText.add(tooltip1);
            tooltipText.add(tooltip2);
            tooltipText.add(tooltip3);
            List<WebElement> ranks = DriverAction.getElements(locator.first3Rank);

            for (int i = 0; i < ranks.size(); i++) {
                if (!ranks.get(i).getAttribute("title").equalsIgnoreCase(tooltipText.get(i))) {
                    wrongToolTip = ranks.get(i).getAttribute("title");
                    passed = false;
                    break;
                } else
                    passed = true;
            }
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if on hovering on Rank 1, Rank 2 and Rank 3 a tooltip appears",
                    "Correct tooltip are present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if on hovering on Rank 1, Rank 2 and Rank 3 a tooltip appears",
                    wrongToolTip + " is missing or incorrect", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @And("Verify if user data is displayed at the end on the dialogue box with respective {string}, {string}, {string} and {string}")
    public void verifyIfIsDisplayedAtTheEndOnTheDialogueBoxWithRespectiveAnd(String rank, String dp, String name, String points) {
        passed = false;
        String missingData = "";
        boolean isRowDisplayed = false;
        try {
            isRowDisplayed = DriverAction.isExist(locator.userRow);
            if (isRowDisplayed) {
                if (DriverAction.isExist(locator.userRank)) {
                    if (DriverAction.isExist(locator.userDp)) {
                        if (DriverAction.isExist(locator.currentUserName) && DriverAction.getElementText(locator.currentUserName).equalsIgnoreCase(name)) {
                            if (DriverAction.isExist(locator.currentUserPoints)) {
                                passed = true;
                            } else {
                                passed = false;
                                missingData = points;
                            }
                        } else
                            missingData = name;
                    } else
                        missingData = dp;
                } else
                    missingData = rank;

            }

        } catch (Exception ex) {
            passed = false;
        }
        if (isRowDisplayed) {
            if (passed) {
                GemTestReporter.addTestStep("Verify if user data row is displayed",
                        "User data row is displayed and have correct data",
                        STATUS.PASS, DriverAction.takeSnapShot());
            } else
                GemTestReporter.addTestStep("Verify if user data row is displayed",
                        missingData + " is missing", STATUS.FAIL, DriverAction.takeSnapShot());
        } else
            GemTestReporter.addTestStep("Verify if user data row is displayed",
                    "User data row is displayed but have incorrect data", STATUS.FAIL, DriverAction.takeSnapShot());

    }

    @Then("Verify if {string} is present")
    public void verifyIfIsPresent(String text) {
        passed = false;
        boolean flag = false;
        try {
            flag = DriverAction.isExist(locator.button(text));
            if (flag) {
                if (DriverAction.getElementText(locator.button(text)).trim().equalsIgnoreCase(text)) {
                    passed = true;
                }
            }
        } catch (Exception ex) {
            passed = false;
        }
        if (passed && flag)
            GemTestReporter.addTestStep("Verify if " + text + " button is present",
                    text + " button is present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if \"+text+\" button is present",
                    text + " button is missing", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @And("Click on {string} button")
    public void clickOnButton(String text) {
        passed = false;
        try {
            if (DriverAction.isExist(locator.button(text))) {
                DriverAction.waitSec(2);
                DriverAction.click(locator.button(text));
                passed = true;
            }
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Click on " + text + " button",
                    text + " button is clicked",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Click on " + text + " button",
                    "Unable to click on " + text + " button",
                    STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if {string} dialogue box appears")
    public void verifyIfDialogueBoxAppears(String text) {
        passed = false;
        try {
            if (DriverAction.getElementText(locator.howToCollectPointsHeader).equalsIgnoreCase(text) &&
                    DriverAction.isExist(locator.backButton)) {
                passed = true;
            }
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if " + text + " dialogue box appears",
                    text + " dialogue box is visible",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if " + text + " dialogue box appears",
                    text + " dialogue box is missing",
                    STATUS.FAIL, DriverAction.takeSnapShot());
    }


    @And("Verify if on hovering on few points, tooltip {string} and {string} is visible")
    public void verifyIfOnHoveringOnFewPointsTooltipAndIsVisible(String tooltip1, String tooltip2) {
        passed = false;
        try {
            List<WebElement> infoIcons = DriverAction.getElements(locator.infoIcon);
            List<String> li = new ArrayList<>();
            li.add(tooltip1);
            li.add(tooltip2);
            for (int i = 0; i < infoIcons.size(); i++) {
                DriverAction.hoverOver(infoIcons.get(i));
                if (DriverAction.isExist(locator.hoverIcon) && DriverAction.getElementText(locator.hoverIcon)
                        .trim().equalsIgnoreCase(li.get(i)))
                    passed = true;
                else break;
            }

        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if on hovering on info icons a tooltip appears",
                    "Correct tooltips appears",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if on hovering on info icons a tooltip appears",
                    "Incorrect tooltips appears",
                    STATUS.FAIL, DriverAction.takeSnapShot());
    }


    @And("Click on {string} button for directing to home page")
    public void clickOnButtonForDirectingToHomePage(String btnName) {
        passed = false;
        try {
            DriverAction.waitSec(1);
            if (DriverAction.getElementText(locator.backButton).equalsIgnoreCase(btnName)) {
                DriverAction.click(locator.backButton);
                passed = true;
            }

        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Click on " + btnName + " button",
                    "Clicked on " + btnName + " button",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Click on \"+btnName+\" button",
                    "Unable to click on " + btnName + " button",
                    STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if user goes back to {string} box home page")
    public void verifyIfUserGoesBackToBoxHomePage(String title) {
        passed = false;
        try {
            if (DriverAction.isExist(locator.pointsDialogueBox) &&
                    title.trim().equalsIgnoreCase(DriverAction.getElementText(locator.pointsHeader).trim()))
                passed = true;
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if user goes back to " + title + " page",
                    "User is on " + title + " page",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if user goes back to \"+title+\" page",
                    "Unable to go back to " + title + " page",
                    STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @And("Verify if {int} {string} lines are present")
    public void verifyIfLinesArePresent(int countOfLines, String text) {
        passed = false;
        try {
            String[] lines = text.split(";");
            List<WebElement> presentLines = DriverAction.getElements(locator.getHowToCollectPointsLists(lines.length));
            if (presentLines.size() == lines.length) {
                for (int i = 0; i < countOfLines; i++) {
                    if (presentLines.get(i).isDisplayed() && presentLines.get(i).getText().equalsIgnoreCase(lines[i]))
                        passed = true;
                    else break;
                }
            } else passed = false;
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if " + countOfLines + " lines are present on Points page",
                    "Lines are present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if " + countOfLines + " lines are present on Points page",
                    "Lines are missing",
                    STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @And("Verify if user data is displayed at the end on Levels page with respective {string}, {string}, {string} and {string}")
    public void verifyIfUserDataIsDisplayedAtTheEndOnLevelsPageWithRespectiveAnd(String rank, String dp, String name, String levels) {
        passed = false;
        String missingData = "";
        boolean isRowDisplayed = false;
        try {
            isRowDisplayed = DriverAction.isExist(locator.userRow);
            if (isRowDisplayed) {
                if (DriverAction.isExist(locator.userRankLevels)) {
                    if (DriverAction.isExist(locator.userDp)) {
                        if (DriverAction.isExist(locator.currentUserName) && DriverAction.getElementText(locator.currentUserName).equalsIgnoreCase(name)) {
                            if (DriverAction.isExist(locator.currentUserLevel)) {
                                passed = true;
                            } else {
                                passed = false;
                                missingData = levels;
                            }
                        } else missingData = name;
                    } else missingData = dp;
                } else missingData = rank;
            }
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if current user data is displayed",
                    "Current user data is displayed",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if current user data is displayed",
                    missingData + " is missing from Levels page",
                    STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @And("Click on {string} button present on navbar")
    public void clickOnButtonPresentOnNavbar(String text) {
        passed = false;
        try {
            DriverAction.waitSec(1);
            DriverAction.click(locator.pointsBtn(text));
            passed = true;
        } catch (Exception ex) {
            passed = false;
        }
//        if (passed)
//            GemTestReporter.addTestStep("Click on " + text + " button",
//                    "Successfully clicked on " + text + " button",
//                    STATUS.PASS, DriverAction.takeSnapShot());
//        else
//            GemTestReporter.addTestStep("Click on " + text + " button",
//                    "Unable to click on " + text + " button",
//                    STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if {string} page is open")
    public void verifyIfPageIsOpen(String text) {
        passed = false;
        try {
            DriverAction.waitSec(2);
            if (DriverAction.isExist(locator.isLevelSelected) &&
                    DriverAction.getElementText(locator.pointsBtn(text)).trim().equalsIgnoreCase(text))
                passed = true;
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if " + text + " page is open",
                    "User is on " + text + " page",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if " + text + " page is open",
                    "Unable to go on " + text + " page",
                    STATUS.FAIL, DriverAction.takeSnapShot());
    }


    @Then("Verify if How to level up page opens")
    public void verifyIfHowToLevelUpPageOpens() {
        passed = false;
        try {
            if (DriverAction.isExist(locator.pointsHeader) && DriverAction.getElementText(locator.pointsHeader).trim()
                    .equalsIgnoreCase("How to level up"))
                passed = true;
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if How to level up page opens",
                    "User is on How to level up page",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if How to level up page opens",
                    "Unable to redirect on How to level up page",
                    STATUS.FAIL, DriverAction.takeSnapShot());
    }


    @Then("Verify if {string} is present for displayed names for {string}")
    public void verifyIfIsPresentForDisplayedNames(String playicon, String cont) {
        passed = false;
        try {
            List<WebElement> playIcons = DriverAction.getElements(locator.playIcon);
            int contactsCount = Integer.parseInt(cont);
            if (playIcons.size() == contactsCount)
                passed = true;
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if play icon is present for all the contacts resent in Badges tab",
                    "Play icon are present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if play icon is present for all the contacts resent in Badges tab",
                    "Play icon is missing",
                    STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @And("Verify if user data is displayed at the end on Badges page with respective {string}, {string}, {string}, {string} and {string}")
    public void verifyIfUserDataIsDisplayedAtTheEndOnBadgesPageWithRespectiveAnd(String rank, String dp, String name, String points, String playIcon) {
        passed = false;
        String missingData = "";
        boolean isRowDisplayed = false;
        try {
            isRowDisplayed = DriverAction.isExist(locator.userRow);
            if (isRowDisplayed) {
                if (DriverAction.isExist(locator.userRankBadges)) {
                    if (DriverAction.isExist(locator.userDp)) {
                        if (DriverAction.isExist(locator.currentUserName) && DriverAction.getElementText(locator.currentUserName).equalsIgnoreCase(name)) {
                            if (DriverAction.isExist(locator.currentUserBadgePoint)) {
                                if (DriverAction.isExist(locator.playIcon)) {
                                    passed = true;
                                } else {
                                    passed = false;
                                    missingData = playIcon;
                                }
                            } else missingData = points;
                        } else missingData = name;
                    } else missingData = dp;
                } else missingData = rank;
            }
        } catch (Exception ex) {
            passed = false;
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if current user data is displayed",
                    "Current user data is displayed",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if current user data is displayed",
                    missingData + " is missing from Levels page",
                    STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @And("Click on {string} button and verify if badges detail page is displayed")
    public void clickOnButtonAndVerifyIfBadgesDetailPageIsDisplayed(String playIcon) {
        passed=false;
        try{
            DriverAction.waitSec(3);
            List<WebElement> pointsElements = DriverAction.getElements(locator.points);

            List<WebElement> li = DriverAction.getElements(locator.playIcon);
            for(int i=0;i< pointsElements.size();i++){
                int count = Integer.parseInt(pointsElements.get(i).getText());

                if(li.get(i).isDisplayed()){
                    li.get(i).click();

                    List<WebElement> badgesCount =  DriverAction.getElements(locator.badges);
                    if(DriverAction.isExist(locator.badges) && badgesCount.size()==count){
                        passed=true;
                        DriverAction.getElement(locator.backButton).click();
                    }
                    else break;
                }else break;
            }
        }catch (Exception ex){
            passed=false;
        }
        if (passed)
            GemTestReporter.addTestStep("Click on Play button to view badges",
                    "Successfully clicked on Play button",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Click on Play button to view badges",
                    "Unable to click on Play button",
                    STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @And("Click on {string} button for current user and verify if badges detail page is displayed")
    public void clickOnButtonForCurrentUserAndVerifyIfBadgesDetailPageIsDisplayed(String arg0) {
        passed=false;
        try{
            DriverAction.waitSec(3);

            List<WebElement> li = DriverAction.getElements(locator.playIcon);
            int point = Integer.parseInt(DriverAction.getElementText(locator.currentUserBadgePoint));
            li.get(li.size()-1).click();

                    List<WebElement> badgesCount =  DriverAction.getElements(locator.badges);
                    if(DriverAction.isExist(locator.badges) && badgesCount.size()==point){
                        passed=true;
                        DriverAction.getElement(locator.backButton).click();
                    }
        }catch (Exception ex){
            passed=false;
        }
        if (passed)
            GemTestReporter.addTestStep("Click on Play button to view badges for current user",
                    "Successfully clicked on Play button",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Click on Play button to view badges for current user",
                    "Unable to click on Play button",
                    STATUS.FAIL, DriverAction.takeSnapShot());
    }
}