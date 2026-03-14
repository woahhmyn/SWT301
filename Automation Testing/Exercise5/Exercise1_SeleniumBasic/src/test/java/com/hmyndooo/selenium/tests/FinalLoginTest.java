/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmyndooo.selenium.tests;

/**
 *
 * @author hmynd
 */
import com.hmyndooo.selenium.pages.LoginPage;
import org.junit.jupiter.api.Test;

public class FinalLoginTest extends BaseTest {
    @Test
    void testLoginWithPOM() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage.login("tomsmith", "SuperSecretPassword!");
        // Bạn có thể thêm Assert ở đây để kiểm tra kết quả [cite: 325]
    }
}