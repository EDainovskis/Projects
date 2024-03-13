
import io.github.bonigarcia.wdm.WebDriverManager;
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
        WebDriverManager.chromedriver().setup();
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

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
