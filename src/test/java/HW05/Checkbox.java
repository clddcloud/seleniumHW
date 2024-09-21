package HW05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Checkbox {
    public static void main(String[] args) throws InterruptedException {
        //### User Story
        //-Title: Verifying Checkbox Functionality
        //- As a user,
        //- I want to navigate to `https://syntaxprojects.com/basic-checkbox-demo-homework.php`
        //- So that I can ensure all the checkbox functionality is working as expected.
        //
        //
        //
        //Acceptance Criteria

        WebDriver driver = new ChromeDriver();
        driver.get("https://syntaxprojects.com/basic-checkbox-demo-homework.php");
        driver.manage().window().maximize();

        //1. Subscribe to Newsletter:
        //   - Check if the "Subscribe to Newsletter" checkbox is enabled, and then click on it.
        WebElement subscribe = driver.findElement(By.xpath("//input[@id='newsletter']"));
        if (subscribe.isEnabled()){
            subscribe.click();
        }

        //2.Select Your Hobbies:
        //   - Retrieve the list of all checkboxes in the **Select Your Hobbies** section.
        //   - Traverse through the list and select the **Reading** and **Cooking** checkboxes.

        List <WebElement> hobbies=driver.findElements(By.xpath("//input[@class='cb-element']"));
        for (WebElement hobby:hobbies){
            if (hobby.getAttribute("id").equals("reading") || hobby.getAttribute("id").equals("cooking")  ){
                hobby.click();
            }
        }

        //3. Select Your Interests:
        //   - Verify that the **Support** and **Music** checkboxes are not displayed by default.
        //   - Click on the "Show Checkboxes" button, and then select the **Music** checkbox.

        WebElement support=driver.findElement(By.xpath("//input[@value='Support']"));
        WebElement music=driver.findElement(By.xpath("//input[@value='Music']"));
        if (!support.isDisplayed() && !music.isDisplayed()){
            WebElement showButton= driver.findElement(By.xpath("//button[@id='toggleCheckboxButtons']"));
            showButton.click();
         }
            Thread.sleep(200); //needs some time to load up the checkboxes...
        if (support.isDisplayed() && music.isDisplayed()) {
            support.click();
            music.click();
        }

        //4. Preferences:
        //   - Verify that the **Receive Notifications** checkbox is disabled.
        //   - Click on the "Enable Checkboxes" button, and then select the **Receive Notifications** checkbox.

        WebElement notifications = driver.findElement(By.xpath("//input[@value='Receive-Notifications']"));
        if (!notifications.isEnabled()) {
            WebElement enableButton = driver.findElement(By.xpath("//button[@id='enabledcheckbox']"));
            enableButton.click();
        }
        notifications.click();

        driver.quit();
    }
}
