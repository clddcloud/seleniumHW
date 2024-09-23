package HW07;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    // User Story
    //- **Title**: Verifying JavaScript Alerts Functionality
    //- **As a user,**
    //- I want to navigate to `https://syntaxprojects.com/javascript-alert-box-demo-homework.php`
    //- So that I can make sure the alerts functionality is working as expected.
    //
    //
    //
    //Acceptance Criteria

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://syntaxprojects.com/javascript-alert-box-demo-homework.php");
        driver.manage().window().maximize();
        //1. Birthday Reminder:
        //   - Click on the "Birthday Reminder" button.
        //   - When the alert appears, accept the alert.
        WebElement box1= driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));
        box1.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();

        //2. Delete Confirmation:
        //   - Click on the **"Delete File"** button.
        //   - When the confirmation alert appears, **dismiss** the alert.
        //   - Print the status of the action (e.g., "File deletion canceled") that appears on the screen, to the console.
        WebElement box2= driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
        box2.click();
        alert.dismiss();
        WebElement text= driver.findElement(By.xpath("//p[@id='confirm-demo']"));
        System.out.println(text.getText());

        //3. Name Collection:
        //   - Click on the **"Enter Your Name"** button.
        //   - Accept the alert and provide a name.
        //   - Retrieve the name that appears on the screen UI and print it on the console, verifying that the correct name is displayed.
        WebElement box3= driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
        box3.click();
        String name="Artem";
        alert.sendKeys(name);
        alert.accept();
        WebElement text2 = driver.findElement(By.xpath("//p[@id='prompt-demo']"));
        System.out.println(text2.getText());
        if (text2.getText().equals(name)){
            System.out.println("Name is correctly displayed");
        } else if (text2.getText().contains(name)){
            System.out.println("Check for extra symbols. Otherwise name is displayed but output or criteria should be corrected");
        }else {
            System.out.println("Name is NOT displayed correctly");
        }
       driver.quit();

    }

}
