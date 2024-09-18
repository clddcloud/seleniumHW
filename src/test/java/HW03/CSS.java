package HW03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// User Story
//- Title: Form Submission Using Unique CSS Selectors
//- As a user,
//- I want to navigate to `https://syntaxprojects.com/cssSelector-homework.php`
//- So that I can successfully fill the form using appropriate CSS selectors.
//
//
//Acceptance Criteria
//1. The user should fill in all the text boxes in the form using*CSS selectors that are unique and return only one element (1/1).

public class CSS {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://syntaxprojects.com/cssSelector-homework.php");
        driver.manage().window().maximize();
        WebElement userID=driver.findElement(By.cssSelector("input[id='UserID']"));
        userID.sendKeys("123490");
        WebElement userName=driver.findElement(By.cssSelector("input#UserName"));
        userName.sendKeys("Jane Smith");
        WebElement lecture=driver.findElement(By.cssSelector("input[name='LectureIntro']"));
        lecture.sendKeys("css");
        WebElement feedback1=driver.findElement(By.cssSelector("input#FeedbackFromRay"));
        feedback1.sendKeys("nice");
        WebElement feedback2=driver.findElement(By.cssSelector("input#FeedbackfromDucky"));
        feedback2.sendKeys("not completely satisfied");
        WebElement ClientID=driver.findElement(By.cssSelector("input[name='ClientID']"));
        ClientID.sendKeys("9876543210");
        WebElement email=driver.findElement(By.cssSelector("input[name='email']"));
        email.sendKeys("Jane@syntaxprojects.com");
        WebElement topic=driver.findElement(By.cssSelector("input[data-content*='intermediate']"));
        topic.sendKeys("Selenium");

        driver.quit();






    }
}
