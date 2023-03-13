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
    public static By userRankLevels = By.xpath("//div[@class='tl-gamification-my-list']//td[@class='tl-ranking-align']//img");
    public static By currentUserLevel=  By.xpath("//td[@class='tl-gamification-points tl-gamification-levels']");
    public static By currentUserBadgePoint = By.xpath("//td[@class='tl-gamification-points ']");
    public static By userRankBadges= By.xpath("//div[@class='tl-gamification-my-list']//div[@class='tl-ranking-number']");

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
    public static By pointsDialogueBox = By.xpath("//div[@id='tl-gamification-widget-modal']");

    public static By fun2(String text) {
        switch (text) {
            case "Points":
                return By.xpath("//ul[@class='nav nav-tabs']//li//a[text()='Points']");
            case "Levels":
                return By.xpath("//ul[@class='nav nav-tabs']//li//a[text()='Levels']");
            case "Badges":
                return By.xpath("//ul[@class='nav nav-tabs']//li//a[text()='Badges']");
            case "Certificates":
                return By.xpath("//ul[@class='nav nav-tabs']//li//a[text()='Certificates']");
            default:
                return By.xpath("");
        }
    }

    public static By userRow = By.xpath("//div[@class='tl-gamification-my-list']//tr");
    public static By countPointDialogueBox = By.xpath("//tr");
    public static By rank = By.xpath("//td[@class='tl-ranking-align']");
    public static By dp = By.xpath("//td[@class='tl-gamification-user']//img");
    public static By userName = By.xpath("//td[@class='tl-gamification-user']");
    public static By points = By.xpath("//td[@class='tl-gamification-points']");
    public static By first3Rank = By.xpath("//td[@class='tl-ranking-align']//img");
    public static By userRank = By.xpath("//div[@class='tl-gamification-my-list']//div[@class='tl-ranking-number']");
    public static By userDp = By.xpath("//div[@class='tl-gamification-my-list']//td[@class='tl-gamification-user']//img");

    public static By currentUserName = By.xpath("//div[@class='tl-gamification-my-list']//td[@class='tl-gamification-user']");
    public static By currentUserPoints = By.xpath("//div[@class='tl-gamification-my-list']//td[@class='tl-gamification-points tl-gamification-points-tab']");
    public static By button(String text){
        switch (text){
            case "How to collect points": return By.xpath("//a[contains(text(),'How to collect points')]");
            case "How to level up":return By.xpath("//a[contains(text(),'How to level up')]");
            default:return null;
        }
    }
    public static By howToCollectPointsHeader = By.xpath("//h3[text()='How to collect points']");
    public static By getHowToCollectPointsLists(int num){
        switch (num){
            case 8: return By.xpath("//ul[@id='tl-get-points-conditions']//li");
            case 3: return By.xpath("//ul[@id='tl-upgrade-levels-conditions']//li");
            default:return By.xpath("");
        }
    }
    public static By backButton = By.xpath("//a[@class='btn']//span");
    public static By infoIcon = By.xpath("//li[@class='tl-bold-item']//i[@class='icon-info-circle tl-info-icon']");
    public static By hoverIcon = By.xpath("//div[@class='tooltip fade right in']");

public static  By isLevelSelected = By.xpath("//li[@class='hide active']");
public static By pointsBtn(String text){
    switch (text){
        case "Levels": return By.xpath("//a[contains(text(),\"Levels\")]");
        case "Badges": return By.xpath("//a[contains(text(),\"Badges\")]");
        default:return null;
    }
}

public static  By playIcon = By.xpath("//i[@class='icon-play tl-icon15']");
public static By badges = By.xpath("//div[@id='tl-userbadges-images']//img");
}

