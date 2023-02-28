package com.qa.lms.locators;

import org.openqa.selenium.By;

public class locator {

    public static By avatar = By.xpath("//img[@class='avatar-square']");
    public static By credBox = By.xpath("//div[@class='tl-auth-form--handle-display active']");
    public static By inputNameField = By.xpath("//input[@name='login']");
    public static By inputPasswordField = By.xpath("//input[@name='password']");
    public static By loginButton = By.xpath("//input[@value='Login']");
    public static By homeDiv = By.xpath("//div[@class='tl-title tl-ellipsis']");
    public static By searchIcon = By.xpath("//input[@id='tl-grid-mode-search']");
    public static By progressDashboard = By.xpath("//div[@id='tl-microstats-learner-dashboard']");
    public static By list_Icons = By.xpath("//div[@class='tl-icons-block']");


}

