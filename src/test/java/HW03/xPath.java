package HW03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.xpath.XPath;

public class xPath {
    /*
    User Story : Fill Out Form Using XPath

Given the user navigates to `https://www.syntaxprojects.com/Xpath-homework.php`,
When the user enters the necessary information in the form,
Then all the necessary key points in the acceptance criteria should be met.

### Acceptance Criteria:
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.syntaxprojects.com/Xpath-homework.php");
        driver.manage().window().maximize();

        //1. The user is able to enter their hobbies using XPath.
        WebElement hobbies=driver.findElement(By.xpath("//input[@name='yourHobbies']"));
        hobbies.sendKeys("Swimming, hiking");

        //2. When the user clicks the "Click Here" button using XPath.,
        //   Then the message `"Button clicked:"` should be displayed on the screen
        WebElement button = driver.findElement(By.xpath("//button[text()='Click Here']"));
        button.click();
        WebElement message = driver.findElement(By.xpath("//p[contains(text(),'Button Clicked')]"));
        System.out.println(message.getText());

        //3. The user successfully enters their favorite movie using XPath to find the text boxes.
        WebElement favMovies=driver.findElement(By.xpath("//input[@name='favoriteMovies']"));
        favMovies.sendKeys("Stalker, Sleeping beauty");

        //4. The user uses the `contains()` method of XPath to locate a specific text element on the page and prints it to the console.
        WebElement text=driver.findElement(By.xpath("//label[contains(text(),'ipsum')]"));
        System.out.println(text.getText());

        //5. The user is able to enter the city in the designated field.
        WebElement city=driver.findElement(By.xpath("//input[@id='yourCity']"));
        city.sendKeys("Bilbao");

        //6. The user must use the **indexing technique** learned in class to enter  email addresses.
        WebElement emailPersonal= driver.findElement(By.xpath("(//input[@class='form-control backup'])[1]"));
        emailPersonal.sendKeys("abcder@syntax.com");
        WebElement emailOffice= driver.findElement(By.xpath("(//input[@class='form-control backup'])[2]"));
        emailOffice.sendKeys("office@syntax.com");
        WebElement emailProfessional= driver.findElement(By.xpath("(//input[@class='form-control backup'])[3]"));
        emailProfessional.sendKeys("professional@syntax.com");

       // 7. The user must use the **operators technique** (e.g., `and`, `or`) to enter both the client name and client ID.
        WebElement clientName = driver.findElement(By.xpath("//input[@data-detail='one' and @name='clientName']"));
        clientName.sendKeys("Adam Carpenter");
        WebElement clientID= driver.findElement(By.xpath("//input[@data-detail='two' and @id='clientId']"));
        clientID.sendKeys("123456");

        // 8. The user can use **any XPath technique** to enter the street number and house number.
        WebElement street=driver.findElement(By.xpath("//input[@name='StreetNo']"));
        street.sendKeys("24th Street");
        WebElement house=driver.findElement(By.xpath("//input[@name='HouseNo']"));
        house.sendKeys("2");
        
        driver.quit();
    }
}
