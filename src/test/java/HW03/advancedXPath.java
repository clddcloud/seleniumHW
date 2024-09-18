package HW03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class advancedXPath {
    //User Story
    //- Title: Filling Form Using Advanced Xpath Selectors
    //- As a user,
    //- I want to navigate to `https://syntaxprojects.com/advanceXpath-homework.php`
    //- So that I can fill in specific details in the form using advanced Xpath selectors.
    //
    //
    //Acceptance Criteria

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.syntaxprojects.com/advanceXpath-homework.php");
        driver.manage().window().maximize();

        //1.The user should enter the names of books in reverse order from least favorite to favorite using advanced Xpath
        // (such as `parent`, `following-sibling`, or `preceding-sibling`).
        WebElement line1textbox1= driver.findElement(By.xpath("//input[@id='least-favorite']/preceding-sibling::input[2]"));
        line1textbox1.sendKeys("war and piece");
        WebElement line1textbox2= driver.findElement(By.xpath("//input[@id='least-favorite']/preceding-sibling::input[1]"));
        line1textbox2.sendKeys("harry potter");
        WebElement line1textbox3= driver.findElement(By.xpath("//input[@id='least-favorite']"));
        line1textbox3.sendKeys("dva kapitana");

        //2. The user should enter the name of their favorite book using advanced Xpath.
        WebElement line2textbox1= driver.findElement(By.xpath("//input[@id='favouriteBook']"));
        line2textbox1.sendKeys("1984");
        WebElement line2textbox2= driver.findElement(By.xpath("//input[@id='favouriteBook']/following-sibling::input[1]"));
        line2textbox2.sendKeys("It's me Eddie");
        WebElement line2textbox3= driver.findElement(By.xpath("//input[@id='favouriteBook']/following-sibling::input[2]"));
        line2textbox3.sendKeys("Cat's cradle");

        //3. The user should enter the names of grandparent, parent, and child fields using advanced Xpath.
        WebElement line3textbox1= driver.findElement(By.xpath("//div[@id='familyTree']/child::input[1]"));
        line3textbox1.sendKeys("grandparent");
        WebElement line3textbox2= driver.findElement(By.xpath("//div[@id='familyTree']/child::input[2]"));
        line3textbox2.sendKeys("parent");
        WebElement line3textbox3= driver.findElement(By.xpath("//div[@id='familyTree']/child::input[3]"));
        line3textbox3.sendKeys("child");

        //4. The form should submit successfully only if all fields are filled out correctly using the appropriate advanced Xpath expressions.
        // there is no submit button

        driver.quit();




    }
}
