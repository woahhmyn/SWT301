/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hmyndooo.selenium.utils;

/**
 *
 * @author hmynd
 */
import java.util.HashMap;
import java.util.Map;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();

        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--incognito");
        return new ChromeDriver(options);
    }
}