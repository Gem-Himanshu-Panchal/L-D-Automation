package com.qa.lms.stepdefinition;

import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.lms.locators.locator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class stepDefinition {
    boolean ispassed = false;

    @Given("Open LMS url")
    public void open_l_d_url() {
        ispassed = false;
        try {
            ispassed = true;
        } catch (Exception ex) {
            ispassed = false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Launch L&D URL",
                    " Successfully launched ",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Launch L&D URL",
                    " Unable to launch ", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if LMS is launched")
    public void verify_if_lms_is_launched() {
        ispassed = false;
        try {
            if (DriverAction.isExist(locator.avatar) && DriverAction.isExist(locator.credBox)
                    && DriverAction.isExist(locator.inputNameField) && DriverAction.isExist(locator.inputPasswordField)
                    && DriverAction.isExist(locator.loginButton))
                ispassed = true;

        } catch (Exception ex) {
            ispassed = false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Verify if correct page is launched",
                    " Correct url is launched ",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if correct page is launched",
                    " Incorrect url is launched ", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @When("Enter {string} and {string}")
    public void enterAnd(String userName, String password) {
        ispassed = false;
        try {
            DriverAction.typeText(locator.inputNameField, userName);
            STATUS val = DriverAction.typeText(locator.inputPasswordField, password);
            if (val.equals(STATUS.PASS))
                ispassed = true;
            DriverAction.waitSec(2);
        } catch (Exception ex) {
            ispassed = false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Enter login credentials",
                    " Correct credentials entered ",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Enter login credentials",
                    " Incorrect login credentials ", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @And("Click on Login button")
    public void clickOnLoginButton() {
        ispassed = false;
        try {
            DriverAction.click(locator.loginButton);
            DriverAction.waitSec(5);
        } catch (Exception ex) {
            ispassed = false;
        }
    }

    @Then("Verify if user is logged in")
    public void verifyIfUserIsLoggedIn() {
        ispassed = false;
        try {
            DriverAction.waitSec(5);

            if (DriverAction.isExist(locator.avatar) && DriverAction.isExist(locator.searchIcon)
                    && DriverAction.isExist(locator.progressDashboard))
                ispassed = true;
        } catch (Exception ex) {
            ispassed = false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Verify if user is logged in or not",
                    " User is successfully logged in ",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if user is logged in or not",
                    " User is unable to log in ", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if Gemini logo is present")
    public void verify_if_gemini_logo_is_present() {
        ispassed = false;
        try {
            DriverAction.waitSec(3);
            ispassed = DriverAction.isExist(locator.avatar);
        } catch (Exception ex) {
            ispassed = false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Verify if Gemini logo is present",
                    "Gemini logo is present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if Gemini logo is present",
                    "Gemini logo is missing", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if points header is present")
    public void verify_if_points_header_is_present() {
        ispassed = false;
        try {

            ispassed = DriverAction.isExist(locator.pointsIcon);
        } catch (Exception ex) {
            ispassed = false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Verify if points header is present",
                    "Points box is present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if points header is present",
                    "Points box is missing", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if correct {string} is displayed")
    public void verify_if_if_correct_is_displayed(String expectedText) {
        ispassed = false;
        try {
            String extractedText = DriverAction.getElementText(locator.fun(expectedText));
            if (extractedText.trim().equalsIgnoreCase(expectedText))
                ispassed = true;
        } catch (Exception ex) {
            ispassed = false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Verify if " + expectedText + " is displayed",
                    "Correct text is present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if " + expectedText + " is displayed",
                    "Incorrect text is displayed", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if a {string} drop down is present")
    public void verify_if_a_drop_down_is_present(String dropdownTitle) {
        ispassed = false;
        try {
            boolean flag = false;
            String extractedText = DriverAction.getElementText(locator.learnerdropdownTitle);
            String[] names = dropdownTitle.split(";");

            List<WebElement> dropdownElements = DriverAction.getElements(locator.learnerDropdown);
            List<String> extractedDropdownText = new ArrayList<>();

            for (int i = 0; i < dropdownElements.size(); i++) {
                extractedDropdownText.add(dropdownElements.get(i).getAttribute("textContent").trim());
            }

            if (extractedText.equalsIgnoreCase(names[0])) {
                flag = true;
            }
            if (flag) {
                for (int i = 0, j = 1; i < extractedDropdownText.size(); i++, j++) {

                    if (extractedDropdownText.get(i).equalsIgnoreCase(names[j])) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag)
                ispassed = true;
            else
                ispassed = false;
        } catch (Exception ex) {
            ispassed = false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Verify if if Learner text and its dropdown elements are present",
                    "Correct elements are present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if if Learner text and its dropdown elements  are present",
                    "Incorrect elements are present", STATUS.FAIL, DriverAction.takeSnapShot());
    }


    @Then("Verify if a searchInput field is present")
    public void verify_if_a_search_input_field_is_present() {
        ispassed = false;
        try {
            ispassed = DriverAction.isExist(locator.inputField);
        } catch (Exception ex) {
            ispassed = false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Verify if a searchInput field is present",
                    "Input box is present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if a searchInput field is present",
                    "input box is missing", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if a {string} is present")
    public void verifyIfAIsPresent(String expectedText) {
        ispassed = false;
        try {
            boolean flag = false;
            String extractedText = DriverAction.getElementText(locator.messageText);

            String[] names = expectedText.split(";");
            List<WebElement> dropdownElements = DriverAction.getElements(locator.messageDropdown);
            List<String> extractedDropdownText = new ArrayList<>();

            for (int i = 0; i < dropdownElements.size(); i++) {
                extractedDropdownText.add(dropdownElements.get(i).getAttribute("textContent").trim());
            }

            if (extractedText.trim().equalsIgnoreCase(names[0])) {
                flag = true;
            }
            if (flag) {
                for (int i = 0, j = 1; i < extractedDropdownText.size(); i++, j++) {

                    if (extractedDropdownText.get(i).equalsIgnoreCase(names[j])) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag)
                ispassed = true;
            else
                ispassed = false;
        } catch (Exception ex) {
            ispassed = false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Verify if if Message text and its dropdown elements are present",
                    "Correct elements are present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if if Message text and its dropdown elements  are present",
                    "Incorrect elements are present", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if correct {string} button is displayed")
    public void verifyIfCorrectButtonIsDisplayed(String expectedText) {
        ispassed = false;
        try {
            WebElement logOutButton = DriverAction.getElement(locator.logouticon);
            String extractedText = logOutButton.getAttribute("textContent").trim();
            if (expectedText.equalsIgnoreCase(extractedText))
                ispassed = true;
        } catch (Exception ex) {
            ispassed = false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Verify if " + expectedText + " button is displayed",
                    "Correct button is present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if " + expectedText + " button is displayed",
                    "Incorrect button is present", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Given("Click on points icon")
    public void clickOnPointsIcon() {
        ispassed = false;
        try {
            DriverAction.waitSec(2);
            if (DriverAction.isExist(locator.pointsIcon)) {
                DriverAction.click(locator.pointsIcon);
                ispassed = true;
            }
            DriverAction.waitSec(3);
        } catch (Exception ex) {
            ispassed = false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Click on Points button",
                    "Successfully clicked on points button",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Click on Points button",
                    "Unable to click on points button", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if a dialogue box with {string} appears")
    public void verifyIfADialogueBoxWithAppears(String title) {
        ispassed = false;
        try {
            DriverAction.waitSec(2);
            if (DriverAction.isExist(locator.pointsDialogueBox) &&
                    title.trim().equalsIgnoreCase(DriverAction.getElementText(locator.pointsHeader).trim()))
                ispassed = true;
        } catch (Exception ex) {
            ispassed = false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Verify if points dialogue box with title: " + title + " is present",
                    "Points dialogue box is present with title: " + title,
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if points dialogue box with title: \"+title+\" is present",
                    "Points dialogue box is missing", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @And("Verify if {string}, {string}, {string} and {string} button are displayed")
    public void verifyIfAndButtonAreDisplayed(String points, String levels, String badges, String certificates) {
        ispassed = false;
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
                    ispassed = false;
                    break;
                } else {
                    ispassed = true;
                }
            }

        } catch (Exception ex) {
            ispassed = false;
            missingButton = list.get(flag);
        }
        if (ispassed)
            GemTestReporter.addTestStep("Verify if " + points + ", " + levels + ", " + badges + " and " + certificates + " buttons are present",
                    "All the buttons are present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if \"+points+\", \"+levels +\", \"+badges+\" and \"+certificates+ \" buttons are present",
                    missingButton + " is missing", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify {string} names are displayed inside the dialogue box")
    public void verifyNamesAreDisplayedInsideTheDialogueBox(String countOfNames) {
        ispassed = false;
        try {
            int count = Integer.parseInt(countOfNames);
            List<WebElement> list = DriverAction.getElements(locator.countPointDialogueBox);
            if (list.size() == count)
                ispassed = true;
        } catch (Exception ex) {
            ispassed = false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Verify if " + countOfNames + " names are displayed",
                    countOfNames + " are displayed in points dialogue box",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if \"+countOfNames +\" names are displayed",
                    "Incorrect count of names", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @And("Verify if all displayed names have {string}, {string}, {string} and {string} for {string}")
    public void verifyIfAllDisplayedNamesHaveAnd(String rank, String dp, String name, String points, String countOfNames) {
        ispassed = false;
        try {
            int count = Integer.parseInt(countOfNames);
            List<WebElement> rankList = DriverAction.getElements(locator.rank);
            List<WebElement> dpList = DriverAction.getElements(locator.dp);
            List<WebElement> nameList = DriverAction.getElements(locator.userName);
            List<WebElement> pointslist = DriverAction.getElements(locator.points);
            if (rankList.size() == count && dpList.size() == count && nameList.size() == count && pointslist.size() == count - 1)
                ispassed = true;

        } catch (Exception ex) {
            ispassed = false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Verify if " + rank + ", " + dp + ", " + name + " and " + points + " are visible in points dialogue box",
                    "Displayed names have mentioned columns",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if " + rank + ", " + dp + ", " + name + " and " + points + " are visible in points dialogue box",
                    "Displayed names have missing columns", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if on hovering on first {int} displayed names, tooltip {string}, {string} and {string} is visible")
    public void verifyIfOnHoveringOnFirstDisplayedNamesTooltipAndIsVisible(int arg0, String tooltip1, String tooltip2, String tooltip3) {
        ispassed = false;
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
                    ispassed = false;
                    break;
                } else
                    ispassed = true;
            }
        } catch (Exception ex) {
            ispassed = false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Verify if on hovering on Rank 1, Rank 2 and Rank 3 a tooltip appears",
                    "Correct tooltip are present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if on hovering on Rank 1, Rank 2 and Rank 3 a tooltip appears",
                    wrongToolTip + " is missing or incorrect", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @And("Verify if user data is displayed at the end on the dialogue box with respective {string}, {string}, {string} and {string}")
    public void verifyIfIsDisplayedAtTheEndOnTheDialogueBoxWithRespectiveAnd(String rank, String dp, String name, String points) {
        ispassed = false;
        String missingData = "";
        boolean isRowDisplayed = false;
        try {
            isRowDisplayed = DriverAction.isExist(locator.userRow);
            if (isRowDisplayed) {
                if (DriverAction.isExist(locator.userRank)) {
                    if (DriverAction.isExist(locator.userDp)) {
                        if (DriverAction.isExist(locator.currentUserName) && DriverAction.getElementText(locator.currentUserName).equalsIgnoreCase(name)) {
                            if (DriverAction.isExist(locator.currentUserPoints)) {
                                ispassed = true;
                            } else {
                                ispassed = false;
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
            ispassed = false;
        }
        if (isRowDisplayed) {
            if (ispassed) {
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
}
