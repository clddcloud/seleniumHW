package HW07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Iframe {
    public static void main(String[] args) {
        // User Story
        //- **Title**: Handling Iframe Interactions for Form Submission
        //- **As a user,**
        //- I want to navigate to `https://syntaxprojects.com/handle-iframe-homework.php`
        //- So that I can enter the username, select a city, and click on the age checkbox while correctly handling iframes.
        WebDriver driver = new ChromeDriver();
        driver.get("https://syntaxprojects.com/handle-iframe-homework.php");
        driver.manage().window().maximize();
        //Acceptance Criteria
        //
        //1. Select Age Checkbox:
        //   - Select the **Age** checkbox.
        driver.switchTo().frame(1);
        driver.switchTo().frame(0);
        WebElement button= driver.findElement(By.xpath("//input[@value='Option-1']"));
        button.click();

        //
        //2. **Select City**:
        //   - Select any city from the dropdown.
        driver.switchTo().parentFrame();
        WebElement DD= driver.findElement(By.xpath("//select[@id='cities']"));
        Select sel = new Select(DD);
        sel.selectByVisibleText("Chicago");

        //
        //3. **Enter Username**:
        //   -enter your username in the **Username** field.
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        WebElement username= driver.findElement(By.xpath("//input[@name='Username']"));
        username.sendKeys("Artem123");

    }
}
