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
            System.out.println(DriverAction.getElementsText(locator.homeDiv));
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

    @Then("Verify if if correct {string} is displayed")
    public void verify_if_if_correct_is_displayed(String expectedUserName) {
        ispassed = false;
        try {
            String extractedUserName = DriverAction.getElementText(locator.userName);
            if (extractedUserName.equalsIgnoreCase(expectedUserName))
                ispassed = true;

        } catch (Exception ex) {
            ispassed = false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Verify if correct username is displayed",
                    "Correct username is present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if correct username is displayed",
                    "Incorrect username", STATUS.FAIL, DriverAction.takeSnapShot());
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
                    System.out.println(extractedDropdownText.get(i)+"  "+names[j]);
                    if (extractedDropdownText.get(i).equalsIgnoreCase(names[j])){
                        flag = true;
                    }
                    else{
                        flag = false;break;
                    }
                }
            }
            System.out.println(flag);
            if(flag)
                ispassed=true;
            else
                ispassed=false;
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

    @Then("Verify if a {string} button is present")
    public void verify_if_a_button_is_present(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Verify if a searchInput field is present")
    public void verify_if_a_search_input_field_is_present() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Verify if a {string} is present")
    public void verifyIfAIsPresent(String expectedText) {
//        ispassed = false;
//        try {
//            boolean flag = false;
//            String extractedText = DriverAction.getElementText(locator.learnerdropdownTitle);
//            String[] names = dropdownTitle.split(";");
//
//            List<WebElement> dropdownElements = DriverAction.getElements(locator.learnerDropdown);
//            List<String> extractedDropdownText = new ArrayList<>();
//
//            for (int i = 0; i < dropdownElements.size(); i++) {
//                extractedDropdownText.add(dropdownElements.get(i).getAttribute("textContent").trim());
//            }
//
//            if (extractedText.equalsIgnoreCase(names[0])) {
//                flag = true;
//            }
//            if (flag) {
//                for (int i = 0, j = 1; i < extractedDropdownText.size(); i++, j++) {
//                    System.out.println(extractedDropdownText.get(i)+"  "+names[j]);
//                    if (extractedDropdownText.get(i).equalsIgnoreCase(names[j])){
//                        flag = true;
//                    }
//                    else{
//                        flag = false;break;
//                    }
//                }
//            }
//            System.out.println(flag);
//            if(flag)
//                ispassed=true;
//            else
//                ispassed=false;
//        } catch (Exception ex) {
//            ispassed = false;
//        }
//        if (ispassed)
//            GemTestReporter.addTestStep("Verify if if Learner text and its dropdown elements are present",
//                    "Correct elements are present",
//                    STATUS.PASS, DriverAction.takeSnapShot());
//        else
//            GemTestReporter.addTestStep("Verify if if Learner text and its dropdown elements  are present",
//                    "Incorrect elements are present", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Verify if a {string} button is present on screen")
    public void verifyIfAButtonIsPresentOnScreen(String arg0) {
    }
}
