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
    public static By learnerdropdownTitle = By.xpath("//li[@id='tl-dropdown-roles']//b[1]");
    public static By learnerDropdown = By.xpath("//li[@id='tl-dropdown-roles']//ul[@class='dropdown-menu']//li//a");
    public static By messageText = By.xpath("//li[@id='tl-dropdown-messages']//a");
    public static By messageDropdown = By.xpath("//li[@id='tl-dropdown-messages']//ul[@class='dropdown-menu']//li//a");

    public static By fun(String text) {
        switch (text) {
            case "Himanshu Panchal":
                return By.xpath("//li[@id='tl-dropdown-roles']//span");
            case "HELP":
                return By.xpath("//li[@class='hidden-phone']//a");
            case "Log out":
                return By.xpath("//li[@class='hidden-desktop']//a");
            default:
                return null;
        }
    }
    public static By logouticon = By.xpath("//li[@class='hidden-desktop']//a");
    public static By inputField = By.xpath("//input[@id='tl-grid-mode-search']");
    public static By pointsHeader = By.xpath("//div[@class='modal fade hide in']//div[@class='modal-header']//h3");
    public  static  By pointsDialogueBox = By.xpath("//div[@id='tl-gamification-widget-modal']");

public  static By fun2(String text){
    switch (text){
        case "Points": return By.xpath("//ul[@class='nav nav-tabs']//li//a[text()='Points']");
        case "Levels": return By.xpath("//ul[@class='nav nav-tabs']//li//a[text()='Levels']");
        case "Badges": return By.xpath("//ul[@class='nav nav-tabs']//li//a[text()='Badges']");
        case "Certificates": return By.xpath("//ul[@class='nav nav-tabs']//li//a[text()='Certificates']");
        default:return By.xpath("");
    }
}

public static By countPointDialogueBox = By.xpath("//tr");
public static By rank = By.xpath("//td[@class='tl-ranking-align']");
public static By dp = By.xpath("//td[@class='tl-gamification-user']//img");
    public static By userName = By.xpath("//td[@class='tl-gamification-user']");
    public static By points = By.xpath("//td[@class='tl-gamification-points']");
    public  static  By first3Rank = By.xpath("//td[@class='tl-ranking-align']//img");
}

