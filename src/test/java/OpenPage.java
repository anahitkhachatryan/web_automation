import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class OpenPage {
    private WebDriver driver;

    @Test
    public void openMaxPage(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anahit.khachatryan\\Desktop\\automation\\web_automation\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        System.out.println(driver.getTitle());


        String expectedtitle = "The Internet";
        String actualtitle =driver.getTitle();

        Assert.assertEquals(expectedtitle, actualtitle," is opening wrong page");
      //  System.out.println("barev");
      //  WebElement elememnt = (WebElement) driver.findElements(By.cssSelector("div"));
      //  elememnt.click();
       driver.quit();
    }

}