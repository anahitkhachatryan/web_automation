import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenPage {
    private WebDriver driver;
   // private SoftAssert softAssert;

    @BeforeTest
    public void openMaxPage() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anahit.khachatryan\\Desktop\\automation\\web_automation\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
      //  softAssert = new SoftAssert();

        driver.manage().window().maximize();

    }
    @Test
            public void openTestedPage(){
           driver.get("https://the-internet.herokuapp.com/");
           System.out.println(driver.getTitle());
           String expectedtitle = "The Internet";
            String actualtitle =driver.getTitle();

           Assert.assertEquals(expectedtitle, actualtitle," is opening wrong page");

    }
    @Test(dependsOnMethods = "openTestedPage")
    public void openLoginPage() {
        String actualText = driver.findElement(By.linkText("Form Authentication")).getText();
        System.out.println(actualText);
        String expectedText = "Form Authentication";
        Assert.assertEquals(actualText,expectedText,"is not login page");
       // softAssert.assertEquals(actualText,expectedText,"is not login page");


      // softAssert.assertAll();



    }


    @Test(dependsOnMethods ="openLoginPage" )

    public void loginPage() {
        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();// poxel css selectorov

        String actualUrl = driver.getCurrentUrl();
        String expectedtUrl = "https://the-internet.herokuapp.com/secure";
        Assert.assertEquals(actualUrl, expectedtUrl, "Wrong login or pass");
      // softAssert.assertEquals(actualUrl, expectedtUrl, "Wrong login or pass");
     //  softAssert.assertAll();
    }

@Test(dependsOnMethods ="loginPage" )
        public void logOut(){
           driver.findElement(By.cssSelector("a[class='button secondary radius']")).click();
           String actualUrl = driver.getCurrentUrl();
           String expectedtUrl = "https://the-internet.herokuapp.com/login";
          Assert.assertEquals(actualUrl, expectedtUrl, "logout don't work");
          // softAssert.assertEquals(actualUrl, expectedtUrl, "logout don't work");
        //  softAssert.assertAll();

        }

    @Test(dependsOnMethods ="logOut")
    public void errorMessageForUserName(){


       driver.findElement(By.id("username")).sendKeys("tomsmit");
       driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
       driver.findElement(By.className("radius")).click();
        String element = driver.findElement(By.cssSelector("div[class='flash error']")).getText();

        String expectedtErrorUserName = "Your username is invalid!\n" +
                "×";
        Assert.assertEquals(element, expectedtErrorUserName, "Wrong error massig for username ");
     //  softAssert.assertEquals(element, expectedtErrorUserName, "Wrong error massig for username ");
    //    softAssert.assertAll();



    }
    @Test(dependsOnMethods = "errorMessageForUserName")
    public void errorMessageForPass(){



        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.className("radius")).click();
        String element = driver.findElement(By.cssSelector("div[class='flash error']")).getText();

        String expectedtErrorPass = "Your password is invalid!\n" +
                "×";
        Assert.assertEquals(element, expectedtErrorPass, "Wrong error massig for password");
       // softAssert.assertEquals(element, expectedtErrorPass, "Wrong error massig for password");
    //    softAssert.assertAll();
    }



    @AfterClass
    public void closePage(){
        driver.quit();
    }


}