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

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Locators cho các trường thông tin quan trọng
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By userEmail = By.id("userEmail");
    private By genderMale = By.xpath("//label[text()='Male']"); // Click vào abel
    private By userNumber = By.id("userNumber");
    private By submitBtn = By.id("submit");

    public void fillRegistrationForm(String fName, String lName, String email, String phone) {
        type(firstName, fName);
        type(lastName, lName);
        type(userEmail, email);
        click(genderMale);
        type(userNumber, phone);
    }

    public void submitForm() {
        clickByJS(submitBtn);
    }
}
