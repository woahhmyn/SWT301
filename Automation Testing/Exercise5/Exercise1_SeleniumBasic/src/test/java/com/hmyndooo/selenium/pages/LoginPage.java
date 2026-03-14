/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmyndooo.selenium.pages;

/**
 *
 * @author hmynd
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Khai báo các địa chỉ nút bấm
    private By userField = By.id("username");
    private By passField = By.id("password");
    private By loginBtn = By.cssSelector("button[type='submit']");

    public void login(String user, String pass) {
        type(userField, user);
        type(passField, pass);
        click(loginBtn);
    }
    // Trong file LoginPage.java

    public void navigate() {
        navigateTo("https://the-internet.herokuapp.com/login");
    }
}
