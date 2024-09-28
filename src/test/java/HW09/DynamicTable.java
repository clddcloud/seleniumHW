package HW09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DynamicTable {
    //User Story
    //- **Title**: Searching and Deleting an Employee by ID
    //- **As a user,**
    //- I want to navigate to `http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login`
    //- So that I can search for an employee ID in the table and delete it dynamically.
    //#### Acceptance Criteria
    //
    //1. Look for an Employee ID on Page 3:
    //   take any employee id on page 3 manually.
    //
    //2. Dynamic Search and Deletion:
    //   - Write dynamic code logic that goes to the website, searches for the employee ID across multiple pages , and once found, selects the checkbox associated with that employee.
    //
    //3. Dynamic Logic:
    //   - The code should be **dynamic**, meaning that it should work even if the employee ID is located on other pages (such as 4, 5, 7, etc.) without changing any part of the logic.
    //   - The script should be able to navigate across pages dynamically and locate the employee ID without requiring manual input of page numbers.
    public static void main(String[] args) {
        String employeeID="111000A";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();

        //click on PIM option
        driver.findElement(By.id("menu_pim_viewPimModule")).click();

        //get the column ID
        List<WebElement> allIDs = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));

        boolean notFound=true;
        int pageCount=1;
        while (notFound) {
            int count = 1;
            for (WebElement id : allIDs) {
                if (id.getText().equals(employeeID)) {
                    System.out.println("line number: "+count+" at page number: "+pageCount);
                    driver.findElement(By.xpath("//table/tbody/tr[" + count + "]/td[1]")).click();
                    WebElement data=driver.findElement(By.xpath("//table/tbody/tr[" + count + "]"));
                    System.out.println(data.getText());
                    notFound=false;
                }
                count++;
            }
            if (notFound) {
                WebElement nextButton= driver.findElement(By.xpath("//a[text()='Next'][1]"));
                nextButton.click();
                allIDs = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
                pageCount++;
            }
        }
        driver.quit();
    }
}
