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
    public static By pointsIcon = By.xpath("//a[@data-entrancemode='points']");
    public static By userName = By.xpath("//li[@id='tl-dropdown-roles']//span");
    public static By learnerdropdownTitle = By.xpath("//li[@id='tl-dropdown-roles']//b[1]");
public static By learnerDropdown = By.xpath("//li[@id='tl-dropdown-roles']//ul[@class='dropdown-menu']//li//a");

}

