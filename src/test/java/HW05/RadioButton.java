package HW05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButton {
    public static void main(String[] args) {
        //User Story
        //- Title: Verifying Radio Button Functionality
        //- As a user,
        //- I want to navigate to `https://syntaxprojects.com/basic-radiobutton-demo-homework.php`
        //- So that I can check if all radio buttons are working as expected.
        //
        // Acceptance Criteria

        WebDriver driver = new ChromeDriver();
        driver.get("https://syntaxprojects.com/basic-radiobutton-demo-homework.php");
        driver.manage().window().maximize();

        //1. Choose Your Favorite Beverage:
        //   - Select the Juice radio button from the list of favorite beverages.

        WebElement beverage= driver.findElement(By.xpath("//input[@value='Juice']"));
        beverage.click();

        //2. Preferred Working Environment:
        //   - Retrieve all radio buttons in the Preferred Working Environment section.
        //   - Traverse through the list of radio buttons in code and select the Hybrid option.

       List<WebElement> environment = driver.findElements(By.xpath("//input[@name='working_enviroment']"));
       for (WebElement e:environment){
           if (e.getAttribute("value").equals("hybrid")){
               e.click();
           }
       }

        //3. Choose Your Favorite Season:
        //   - If the Spring radio button is disabled, click on the "Enable Buttons" button.
        //   - Ensure that the Spring option is now enabled, then select it.
        //   - By default, the Winter radio button is hidden. Ensure, through code, that it is not displayed initially. Then click on the "Show Buttons" button.
        //   - Verify that the Winter option is displayed after clicking and is available for selection.

        WebElement spring= driver.findElement(By.xpath("//input[@value='spring']"));
       if (!spring.isEnabled()){
           WebElement enable= driver.findElement(By.xpath("//button[@id='enabledFruitradio']"));
           enable.click();
       }
       if (spring.isEnabled()){
           spring.click();
       }
       WebElement winter= driver.findElement(By.xpath("//input[@value='winter']"));
       if (!winter.isDisplayed()){
           WebElement show= driver.findElement(By.xpath("//button[@id='showRadioButtons']"));
           show.click();
       }
        if (winter.isDisplayed() && winter.isEnabled()){
            winter.click();
        }

        //4. Choose Your Favorite Meal:
        //   - Select the Lunch radio button from the list of favorite meals.

        WebElement meal= driver.findElement(By.xpath("//input[@value='lunch']"));
        meal.click();

        driver.quit();
    }
}
