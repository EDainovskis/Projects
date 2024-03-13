package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;

public class Main {
    private WebDriver driver;

    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        driver.get("http://localhost:5173/login");
        driver.manage().window().maximize();
    }

    @Test
    void testLogin() {
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        WebElement passwordInput = driver.findElement(By.cssSelector("#password"));
        passwordInput.sendKeys("password");
        WebElement emailInput = driver.findElement(By.cssSelector("#email"));
        emailInput.sendKeys("test@gmail.com");

        loginButton.click();
    }
    @Test
    void testRegister() {
        WebElement specialLink = driver.findElement(By.cssSelector(".special-link"));
        specialLink.click();

        WebElement email = driver.findElement(By.cssSelector("input#email"));
        email.sendKeys("test@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("input#password"));
        password.sendKeys("Password1!");

        WebElement passwordR = driver.findElement(By.cssSelector("input#confirmPassword"));
        passwordR.sendKeys("Password1!");

        WebElement displayName = driver.findElement(By.cssSelector("input#displayName"));
        displayName.sendKeys("Nikas");

        WebElement firstName = driver.findElement(By.cssSelector("input#firstName"));
        firstName.sendKeys("Giedrius");

        WebElement lastName = driver.findElement(By.cssSelector("input#lastName"));
        lastName.sendKeys("Gied");

        WebElement selectGender = driver.findElement(By.cssSelector(" select#gender"));
        selectGender.click();

        WebElement selectGender2 = driver.findElement(By.cssSelector("select#gender > option[value='Male']"));
        selectGender2.click();

        WebElement submit = driver.findElement(By.cssSelector(".btn.btn-primary"));
        submit.click();


    }

    @Test
    void testFalseRegister() {
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

//    @AfterEach
//    void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }
//}
