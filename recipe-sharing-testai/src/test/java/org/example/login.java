package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class login {

    private WebDriver driver;

    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        driver.get("http://localhost:5173/login");
        driver.manage().window().maximize();
    }


    @Test
    void testLogin() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.cssSelector("form > .btn.btn-primary"));

        WebElement passwordInput = driver.findElement(By.cssSelector("input#password"));
        passwordInput.sendKeys("Password1!");
        WebElement emailInput = driver.findElement(By.cssSelector("#email"));
        emailInput.sendKeys("test@gmail.com");

        loginButton.click();
        TimeUnit.SECONDS.sleep(2);


        String currentUrl = driver.getCurrentUrl();


        assertEquals("http://localhost:5173/login-successful", currentUrl, "successfully logged in");
    }

    @Test
    void testFalseLogin() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.cssSelector("form > .btn.btn-primary"));

        WebElement passwordInput = driver.findElement(By.cssSelector("input#password"));
        passwordInput.sendKeys("Passw");
        WebElement emailInput = driver.findElement(By.cssSelector("#email"));
        emailInput.sendKeys("tesgmail.com");

        loginButton.click();
        TimeUnit.SECONDS.sleep(2);


        String currentUrl = driver.getCurrentUrl();


        assertEquals("http://localhost:5173/login", currentUrl, "loggin failed");
    }
}
