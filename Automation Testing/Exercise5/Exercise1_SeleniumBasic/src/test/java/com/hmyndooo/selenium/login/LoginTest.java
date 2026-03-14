/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmyndooo.selenium.login;

/**
 *
 * @author hmynd
 */
import com.hmyndooo.selenium.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {

    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    static void setUp() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
    }

    @Test
    @Order(1)
    void testLoginSuccess() {

        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement successMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".flash.success"))
        );

        assertTrue(successMsg.getText().contains("You logged into a secure area!"));
    }

    @Test
    @Order(2)
    void testLoginFail() {

        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("invalid");
        driver.findElement(By.id("password")).sendKeys("wrongpassword");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement errorMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".flash.error"))
        );

        assertTrue(errorMsg.getText().contains("Your username is invalid!"));
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @ParameterizedTest(name = "CSV File: {0} / {1}")
    @CsvFileSource(resources = "/login-data.csv", numLinesToSkip = 1)
    void testLoginFromCSV(String username, String password, String expected) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate(); // Hàm vào trang login

        username = (username == null) ? "" : username.trim(); // Xử lý khoảng trắng
        password = (password == null) ? "" : password.trim();

        loginPage.login(username, password); // Gọi logic từ Page Object

        // Kiểm tra kết quả dựa trên 'expected' từ file CSV
    }
}
