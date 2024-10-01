package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class CommonMethods {
   public static WebDriver driver;
   public static void openBrowserAndLaunchApplication() throws IOException{
       //decide the browser
       switch (ConfigReader.read ("browser")){
           case "Chrome":
               driver = new ChromeDriver();
               break;
           case "FireFox":
               driver = new FirefoxDriver();
               break;
           case "Edge":
               driver = new EdgeDriver();
               break;
           default:
               throw new RuntimeException("Invalid Browser Name");
       }
       //maximize the window
       driver.manage().window().maximize();
       //get the url
       driver.get(ConfigReader.read("url"));
       // call implicit wait
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

   }
   public static void closeBrowser(){
      if (driver!=null) {
          driver.quit();
      }
   }
   public static void sendText(String text, WebElement element){
       element.clear();
       element.sendKeys(text);
   }
   public static WebDriverWait getWait(){
       WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
       return wait;
   }
   public static void waitForElementToBeClickable(WebElement element){
       getWait().until(ExpectedConditions.elementToBeClickable(element));
   }
   public void clickWithExplicitWait (WebElement element){
       waitForElementToBeClickable(element);
       element.click();
   }
}
