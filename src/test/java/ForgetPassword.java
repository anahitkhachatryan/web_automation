import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ForgetPassword {

 //  private OpenPage openPage;
    private WebDriver driver;
 //SoftAssert softAssert = new SoftAssert();


    @BeforeMethod
    public void openMaxPage() {
   //     openPage= new OpenPage();
  //      openPage.openMaxPage();

     System.setProperty("webdriver.chrome.driver", "C:\\Users\\anahit.khachatryan\\Desktop\\automation\\web_automation\\src\\main\\resources\\chromedriver.exe");
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://the-internet.herokuapp.com/");

    }
    @Test
    public void forgetPassword(){
        driver.get("https://the-internet.herokuapp.com/");
        String actualText = driver.findElement(By.linkText("Forgot Password")).getText();
        driver.findElement(By.linkText("Forgot Password")).click();


        driver.findElement(By.id("email")).sendKeys("khachatryan.anahit@gmail.com");
        driver.findElement(By.id("form_submit")).click();
        String element = driver.findElement(By.cssSelector("div[id='content']")).getText();
      //  System.out.println(element);

       String expectedText = "Your e-mail's been sent!";
       Assert.assertEquals(element, expectedText, "is not Forgot Password  page");


        }
 @Test(dependsOnMethods = "forgetPassword")
      public void forgatPasswordEmptyEmailFildes() {


    String actualText = driver.findElement(By.linkText("Forgot Password")).getText();
    // System.out.println(actualText);
    driver.findElement(By.linkText("Forgot Password")).click();
    driver.findElement(By.id("form_submit")).click();
    String actualErroeMassig = driver.findElement(By.cssSelector("body")).getText();
    String expectedErroeMassig = "Internal Server Error";
    Assert.assertEquals(actualErroeMassig, expectedErroeMassig, "DOnt show massig");

 }
 @AfterMethod
    public void ClossPage(){
        driver.quit();
 }
        }





