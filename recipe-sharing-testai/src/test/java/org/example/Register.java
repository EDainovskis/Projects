package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {
    private WebDriver driver;

    @BeforeEach
    void SetUp() {

        driver = new ChromeDriver();
        driver.get("http://localhost:5173/login");
        driver.manage().window().maximize();
    }



    @Test
    void TestRegister() {
        WebElement specialLink = driver.findElement(By.cssSelector(".special-link"));
        specialLink.click();

        WebElement email = driver.findElement(By.cssSelector("input#email"));
        email.sendKeys("test@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("input#password"));
        password.sendKeys("Password1!");

        WebElement passwordR = driver.findElement(By.cssSelector("input#confirmPassword"));
        passwordR.sendKeys("Password1!");

        WebElement displayName = driver.findElement(By.cssSelector("input#displayName"));
        displayName.sendKeys("Nikasaasddas");

        WebElement firstName = driver.findElement(By.cssSelector("input#firstName"));
        firstName.sendKeys("Giedrius");

        WebElement lastName = driver.findElement(By.cssSelector("input#lastName"));
        lastName.sendKeys("Giedas");

        WebElement selectGender = driver.findElement(By.cssSelector(" select#gender"));
        selectGender.click();

        WebElement selectGender2 = driver.findElement(By.cssSelector("select#gender > option[value='Male']"));
        selectGender2.click();

        WebElement submit = driver.findElement(By.cssSelector(".btn.btn-primary"));
        submit.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String expected = "Registration Successful!";

        WebElement actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleModalCenterTitle")));
        String actualFinall = actual.getText();
        Assertions.assertEquals(expected, actualFinall);


    }

    @Test
    void TestFalseRegister() {
        WebElement specialLink = driver.findElement(By.cssSelector(".special-link"));
        specialLink.click();

        WebElement email = driver.findElement(By.cssSelector("input#email"));
        email.sendKeys("testgmail.com");

        WebElement password = driver.findElement(By.cssSelector("input#password"));
        password.sendKeys("Pas!");

        WebElement passwordR = driver.findElement(By.cssSelector("input#confirmPassword"));
        passwordR.sendKeys("Pas");

        WebElement displayName = driver.findElement(By.cssSelector("input#displayName"));
        displayName.sendKeys("N");

        WebElement firstName = driver.findElement(By.cssSelector("input#firstName"));
        firstName.sendKeys("G");

        WebElement lastName = driver.findElement(By.cssSelector("input#lastName"));
        lastName.sendKeys("G");

        WebElement selectGender = driver.findElement(By.cssSelector(" select#gender"));
        selectGender.click();

        WebElement selectGender2 = driver.findElement(By.cssSelector("select#gender > option[value='Male']"));
        selectGender2.click();

        WebElement submit = driver.findElement(By.cssSelector(".btn.btn-primary"));
        submit.click();

        WebElement errorMessage= driver.findElement(By.cssSelector("div:nth-of-type(1) > .invalid-feedback"));
        String actualErrorMessage = errorMessage.getText();


        String expectedErrorMessage = "Invalid email address!";
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    void TestBadWordsRegister() {
        WebElement specialLink = driver.findElement(By.cssSelector(".special-link"));
        specialLink.click();

        WebElement displayName = driver.findElement(By.cssSelector("input#displayName"));
        displayName.sendKeys("Dick");

        WebElement submit = driver.findElement(By.cssSelector(".btn.btn-primary"));
        submit.click();

        WebElement errorMessage= driver.findElement(By.cssSelector("div:nth-of-type(4) > .invalid-feedback"));
        String actualErrorMessage = errorMessage.getText();

        String expectedErrorMessage = "Display name contains offensive words!";
        assertEquals(expectedErrorMessage, actualErrorMessage);

//    @AfterEach
//    void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }
}
