package HW04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//User Story
//- Title: Completing Actions on Form Using Selenium Commands
//- As a user,
//- I want to navigate to `https://syntaxprojects.com/selenium_commands_selector-homework.php`
//- So that I can complete all the necessary actions mentioned in the acceptance criteria using Selenium commands.
//
//Acceptance Criteria

public class WebElementsCommands {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.syntaxprojects.com/selenium_commands_selector-homework.php");
        driver.manage().window().maximize();

//1. Retrieve Attribute:
//   - Retrieve the text "inspect me to view my custom attribute" from the element and print it on the console, ensuring the text is correct.
//
        WebElement text=driver.findElement(By.xpath("//div[@id='textattr']"));
        String text1=text.getText();
        String text2="inspect me to view my custom attribute";
        if (text1.contains(text2)){
            System.out.println("text: "+text1);
        }

//2. Meal Preference:
//   - Choose the checkbox for the meal preference "Musical Festival," ensuring the checkbox is enabled before clicking on it.
//   - Ensure that the option for "Tech Talk" is disabled.
//   - Click on "Show More Options" and ensure the "Art Exhibition" option is displayed, then click on it.
//
        WebElement meal=driver.findElement(By.xpath("//input[@value='music_festival']"));
        if (meal.isEnabled()){
            meal.click();
        }
        WebElement techTalk= driver.findElement(By.xpath("//input[@value='tech_talk']"));
        System.out.println("tech talk option is available: "+techTalk.isEnabled());

        WebElement button=driver.findElement(By.xpath("//button[text()='Show More Options']"));
        button.click();

        WebElement artExhibition = driver.findElement(By.xpath("//input[@value='art_exhibition']"));
        System.out.println("Art Exhibition is displayed: " + artExhibition.isDisplayed());
        if (artExhibition.isDisplayed()){
                artExhibition.click();
            }
//3. Mystery Message:
//   - Retrieve the value of the attribute `title` from the element containing the text "Hover me to reveal the secret" and print it on the console.
//
        WebElement mystery= driver.findElement(By.xpath("//div[@id='hidden_message']"));
        String mysteryAttribute = mystery.getAttribute("title");
        System.out.println("mystery attribute: "+mysteryAttribute);

//Option Box:
//   - If "Checkbox 1" is enabled, click on it.
//   - Ensure that "Checkbox 2" is disabled.---
//
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@value='CheckboxFirst']"));
         if (checkbox1.isEnabled()){
             checkbox1.click();
         }

        WebElement checkbox2 = driver.findElement(By.xpath("//input[@value='disabledCheckbox']"));
        System.out.println("checkbox2 is enabled: "+checkbox2.isEnabled());

//5. Input Field:
//   - clear the text in the input box and send the text "here is the custom text entered" using selenium commands.
        WebElement textBox= driver.findElement(By.xpath("//input[@id='inputField']"));
        textBox.clear();
        textBox.sendKeys("here is the custom text entered");


        //just to observe
        Thread.sleep(6000);
        driver.quit();

    }
}
