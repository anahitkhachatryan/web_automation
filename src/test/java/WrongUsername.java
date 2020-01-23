import org.openqa.selenium.WebDriver;


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
import org.testng.asserts.SoftAssert;

import java.util.List;
public class WrongUsername {
    private WebDriver driver;
    SoftAssert softAssert= new SoftAssert();

    @BeforeTest

    public void openPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anahit.khachatryan\\Desktop\\automation\\web_automation\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement linkText = driver.findElement(By.linkText("Form Authentication"));
        linkText.click();
    }

        @Test
          public void errorMassiForUserName(){
             WebElement userName = driver.findElement(By.id("username"));
             userName.click();
             userName.sendKeys("tomsmit");
             WebElement pass = driver.findElement(By.id("password"));
             pass.click();
             pass.sendKeys("SuperSecretPassword!");
             WebElement login = driver.findElement(By.className("radius"));
             login.click();

             String element = driver.findElement(By.cssSelector("div[class='flash error']")).getText();
           //  System.out.println(element);
             String expectedtErrorUserName = "Your username is invalid!\n" +
                     "×";
             Assert.assertEquals(element, expectedtErrorUserName, "Wrong error massig for username ");
             driver.quit();
        }


    }


