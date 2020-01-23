import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class WrongPass {
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
    public void errorMassiForPass(){
        WebElement userName = driver.findElement(By.id("username"));
        userName.click();
        userName.sendKeys("tomsmith");
        WebElement pass = driver.findElement(By.id("password"));
        pass.click();
        pass.sendKeys("SuperSecretPassword");
        WebElement login = driver.findElement(By.className("radius"));
        login.click();

        String element = driver.findElement(By.cssSelector("div[class='flash error']")).getText();
       // System.out.println(element);
        String expectedtErrorPass = "Your password is invalid!\n" +
                "×";
        Assert.assertEquals(element, expectedtErrorPass, "Wrong error massig for password");
        driver.quit();
    }

}


