import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Locators {
    WebDriver driver = new ChromeDriver();

    WebElement loginInput = driver.findElement(By.xpath("//input[@id='passp-field-login']"));
    WebElement loginInput1 = driver.findElement(By.id("passp-field-login"));
    WebElement loginInput2 = driver.findElement(By.cssSelector("input[id=passp-field-login]"));
    WebElement loginInput3 = driver.findElement(By.name("login"));

    WebElement inputButton = driver.findElement(By.xpath("//a[contains(@class,'HeadBanner-Button-Enter')]"));
    WebElement inputButton1 = driver.findElement(By.className("HeadBanner-Button-Enter"));
    WebElement inputButton2 = driver.findElement(By.cssSelector("a[class=passp-field-login]"));

    List<WebElement> inputButtons = driver.findElements(By.tagName("a"));

    WebElement forgotButton = driver.findElement(By.linkText("I forgot"));
    WebElement forgotButton1 = driver.findElement(By.partialLinkText("forgot"));
}
