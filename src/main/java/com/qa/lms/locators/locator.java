package com.qa.lms.locators;

import org.openqa.selenium.By;

public class locator {

    public static By avatar = By.xpath("//img[@class='avatar-square']");
public  static By credBox = By.xpath("//div[@class='tl-auth-form--handle-display active']");
public static By inputNameField = By.xpath("//input[@name='login']");
    public static By inputPasswordField = By.xpath("//input[@name='password']");
    public  static  By loginButton = By.xpath("//input[@value='Login']");
}

