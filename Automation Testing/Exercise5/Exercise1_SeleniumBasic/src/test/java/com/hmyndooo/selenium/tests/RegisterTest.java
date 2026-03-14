/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmyndooo.selenium.tests;

/**
 *
 * @author hmynd
 */
import com.hmyndooo.selenium.pages.RegisterPage;
import org.junit.jupiter.api.Test;

public class RegisterTest extends BaseTest {
    @Test
    void testRegisterSuccessfully() {
        RegisterPage registerPage = new RegisterPage(driver);
        driver.get("https://demoqa.com/automation-practice-form");
        
        registerPage.fillRegistrationForm("Thinh", "Do", "hmyndooo@gmail.com", "0123456789");
        registerPage.submitForm();
        
    }
}