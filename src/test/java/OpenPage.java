import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.Test;

public class OpenPage {
    private WebDriver driver;

    @Test(groups = "OpenPage")
    public void openMaxPage(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anahit.khachatryan\\Desktop\\automation\\web_automation\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println(driver.getTitle());
        String expectedtitle = "The Internet";
        String actualtitle =driver.getTitle();
        Assert.assertEquals(expectedtitle, actualtitle," is opening wrong page");

    }
    @Test(dependsOnMethods ="openMaxPage" ,groups = "OpenPage")
    public void openLoginPage() {
        String actualText = driver.findElement(By.linkText("Form Authentication")).getText();
        System.out.println(actualText);
        String expectedText = "Form Authentication";
        Assert.assertEquals(actualText, expectedText, "is not login page");


    }


    @Test(dependsOnMethods ="openLoginPage" ,groups = "OpenPage")

    public void loginPage() {
        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();// poxel css selectorov
        System.out.println(driver.getCurrentUrl());
        String actualUrl = driver.getCurrentUrl();
        String expectedtUrl = "https://the-internet.herokuapp.com/secure";
        Assert.assertEquals(actualUrl,expectedtUrl,"Wrong login or pass");


}
    @Test(dependsOnMethods ="loginPage", groups ="OpenPage")
    public void errorMessageForUserName(){
//         System.setProperty("webdriver.chrome.driver", "C:\\Users\\anahit.khachatryan\\Desktop\\automation\\web_automation\\src\\main\\resources\\chromedriver.exe");
//         driver = new ChromeDriver();
//         driver.manage().window().maximize();
//         driver.get("https://the-internet.herokuapp.com/");
         openMaxPage();
         driver.findElement(By.linkText("Form Authentication")).click();
         driver.findElement(By.id("username")).sendKeys("tomsmit");
         driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
         driver.findElement(By.className("radius")).click();
         String element = driver.findElement(By.cssSelector("div[class='flash error']")).getText();
         System.out.println(element);
         String expectedtErrorUserName = "Your username is invalid!\n" +
                "×";
         Assert.assertEquals(element, expectedtErrorUserName, "Wrong error massig for username ");
         driver.quit();


    }
    @Test(dependsOnMethods = "errorMessageForUserName")
    public void errorMessageForPass(){
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anahit.khachatryan\\Desktop\\automation\\web_automation\\src\\main\\resources\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://the-internet.herokuapp.com/");

         openMaxPage();
         driver.findElement(By.linkText("Form Authentication")).click();
         driver.findElement(By.id("username")).sendKeys("tomsmith");
         driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
         driver.findElement(By.className("radius")).click();
         String element = driver.findElement(By.cssSelector("div[class='flash error']")).getText();
         System.out.println(element);
         String expectedtErrorPass = "Your password is invalid!\n" +
                "×";
         Assert.assertEquals(element, expectedtErrorPass, "Wrong error massig for password");
         driver.quit();

    }



   @AfterGroups(dependsOnGroups = "OpenPage")
   public void closePage(){
        driver.quit();
    }

}