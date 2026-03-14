/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmyndooo.selenium.tests;

/**
 *
 * @author hmynd
 */
import com.hmyndooo.selenium.utils.DriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    protected static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = DriverFactory.createDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) driver.quit();
    }
}