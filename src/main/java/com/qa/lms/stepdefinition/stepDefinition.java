package com.qa.lms.stepdefinition;

import com.gemini.generic.ui.utils.DriverAction;
import com.qa.lms.locators.locator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
        ispassed=false;
        try{
DriverAction.click(locator.loginButton);
DriverAction.waitSec(5);
        }catch (Exception ex){
            ispassed=false;
        }
    }
}
