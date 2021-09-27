import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class YandexTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void loginTest() {
        driver.get("https://mail.yandex.com/");

        WebElement inputButton = driver.findElement(By.xpath("//a[contains(@class,'HeadBanner-Button-Enter')]"));
        inputButton.click();

        WebElement loginInput = driver.findElement(By.xpath("//input[@id='passp-field-login']"));
        loginInput.sendKeys(ResourcesProperties.getCredProperty("login"));

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='passp:sign-in']"));
        loginButton.click();

        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='passp-field-passwd']")));
        passwordInput.sendKeys(ResourcesProperties.getCredProperty("password"));

        WebElement loginSecondButton = driver.findElement(By.xpath("//button[@id='passp:sign-in']"));
        loginSecondButton.click();

        Assertions.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'user-account_left-name')]/span[@class='user-account__name']"))).getText(),
                ResourcesProperties.getCredProperty("login"),"Login failed");
    }

    @AfterEach
    public void closeUp() {
        driver.quit();
    }
}
