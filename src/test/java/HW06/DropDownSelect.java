package HW06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownSelect {
    //User Story
    //- **Title**: Verifying Dropdown and Multi-Select Functionality
    //- **As a user,**
    //- I want to navigate to `https://syntaxprojects.com/basic-select-dropdown-demo.php`
    //- So that I can verify that users can select the correct options from both single and multi-select dropdowns.
    //
    //
    //
    //Acceptance Criteria

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://syntaxprojects.com/basic-select-dropdown-demo-homework.php");
        driver.manage().window().maximize();
        //1. Select List Demo:
        //   - Use the **Select** class to select the option **"Pear"** from the dropdown.
        //   - You can use any method from the **Select** class (e.g., `selectByVisibleText`, `selectByValue`, `selectByIndex`).
        //   - Use the **getAllOptions** method to retrieve all options from the dropdown and print them on the console.
        WebElement menu1= driver.findElement(By.xpath("//select[@id='fav_fruit_selector']"));
        Select sel=new Select (menu1);
        sel.selectByValue("Pear");
        List<WebElement> options= sel.getOptions();
        for (WebElement option:options){
            System.out.println(option.getText());
        }

        //2. Select Multiple Options:
        //   - First, verify that the **Select** dropdown is multi-select by checking the dropdown’s properties.
        //   - Using the **Select** class, make the following selections:
        //     - **Traveling**
        //     - **Cooking**
        //     - **Gardening**
        //   - Click the **"Get All Selected"** button and print the result on the console.
        //   - After a delay of 5 seconds, deselect the **Traveling** option using the **Select** class.
        //   - Click the **"Get All Selected"** button again and print the result on the console.
        WebElement menu2= driver.findElement(By.xpath("//select[@id='select_multi_hobbies']"));
        Select sel2=new Select (menu2);
        System.out.println("drop down is multiselect: "+sel2.isMultiple());
        sel2.selectByValue("Traveling");
        sel2.selectByValue("Cooking");
        sel2.selectByValue("Gardening");
        WebElement button= driver.findElement(By.xpath("//button[@id='get_all']"));
        button.click();
        WebElement text= driver.findElement(By.xpath("//p[@class='get_selected_values']"));
        String tmpText= text.getText();
        System.out.println(text.getText());
        Thread.sleep(5000);
        sel2.deselectByVisibleText("Traveling");
        button.click();
        System.out.println(text.getText());
        if (text.getText().equals(tmpText)) {
            System.out.println("Message to developers. The Get All Selected button will not work. Fix it!");
        }
        driver.quit();



    }

}
