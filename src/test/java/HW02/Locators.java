package HW02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Locators {
    /*
  User Story
- Title:Form Submission Using Locators
- As a user,
- I want to fill out and submit a form on `https://www.syntaxprojects.com/locator-homework.php` using different locators
- So that I can verify that the form is submitted successfully and displays the entered information.

Acceptance Criteria
1. The user should fill the form using any of the locators (`id`, `name`, `tagname`, `linktext`, `partial linktext`).
2. If the email address is not in the correct format (i.e., it doesn't contain an `@` sign), the form should not be submitted, and an error message should be displayed.
3. When the user clicks on the "Click Here" link, a new tab should open in the browser.
4. When the user clicks the "Submit" button, all the entered options should be displayed on the screen.
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.syntaxprojects.com/locator-homework.php");
        driver.manage().window().maximize();
        WebElement firstName = driver.findElement(By.id("fullName"));
        firstName.sendKeys("John Smith");
        WebElement eMail = driver.findElement(By.name("yourEmail"));
        eMail.sendKeys("john@syntax.com");
        //   eMail.sendKeys("john'at'syntax.com");
        WebElement clientName = driver.findElement(By.id("clientNameId"));
        clientName.sendKeys("John Smith");
        WebElement clientID= driver.findElement(By.id("ClientId"));
        clientID.sendKeys("2128506");
        WebElement clientFeedback=driver.findElement(By.id("ClientfeedbackId"));
        clientFeedback.sendKeys("Everything was good and nothing hurts");
        WebElement projectName=driver.findElement(By.id("ProjectNameId"));
        projectName.sendKeys("Test case");
        WebElement projectDeadline=driver.findElement(By.id("ProjectTimeId"));
        projectDeadline.sendKeys("September 21, 2024");
        WebElement currentAddress=driver.findElement(By.id("CurrentAddressId"));
        currentAddress.sendKeys("12345, West Avenue 45"+"\n"+"Key West, FL");
        WebElement permanentAddress=driver.findElement(By.id("PermanentAddressId"));
        permanentAddress.sendKeys("54321, East Street 54"+"\n"+"Seattle, WA");
        WebElement clickHere=driver.findElement(By.partialLinkText("Click Here"));
        clickHere.click();
        WebElement submit = driver.findElement(By.id("btn-submit"));
        submit.click();

        List<WebElement> form=driver.findElements(By.id("form-results")); // elements (many) under tag <a
        for (int i = 0; i < form.size(); i++) {
            WebElement element = form.get(i);
            System.out.println(element.getText());
        }
        driver.quit();

    }
}
