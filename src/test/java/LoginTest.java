

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.List;

public class LoginTest {
    private WebDriver driver;


    @BeforeSuite
    public void openPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anahit.khachatryan\\Desktop\\automation\\web_automation\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

    }

    @BeforeTest
    public void openLoginPage() {
        String actualText = driver.findElement(By.linkText("Form Authentication")).getText();
        String expectedText = "Form Authentication";
        Assert.assertEquals(actualText, expectedText, "is not login page");


    }

    @Test
    public void loginPage() {
        WebElement linkText = driver.findElement(By.linkText("Form Authentication"));
        linkText.click();
        WebElement userName = driver.findElement(By.id("username"));
        userName.click();
        userName.sendKeys("tomsmith");
        WebElement pass = driver.findElement(By.id("password"));
        pass.click();
        pass.sendKeys("SuperSecretPassword!");
        WebElement login =driver.findElement(By.className("radius"));
        login.click();
        System.out.println(driver.getCurrentUrl());
        String actualUrl = driver.getCurrentUrl();
        String expectedtUrl = "https://the-internet.herokuapp.com/secure";
        Assert.assertEquals(actualUrl,expectedtUrl,"Wrong login or pass");

    }
}





















