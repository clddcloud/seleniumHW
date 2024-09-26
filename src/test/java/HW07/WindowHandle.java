package HW07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandle {
    //User Story
    //- **Title**: Verifying Window Popup Modal Functionality for Buttons B1 and B2
    //- **As a user,**
    //- I want to navigate to `https://syntaxprojects.com/window-popup-modal-demo-homework.php`
    //- So that I can verify the functionality of Buttons B1 and B2.
    //
    //
    //
    //Acceptance Criteria
    //

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/window-popup-modal-demo-homework.php");
        String mainPage=driver.getWindowHandle();

        //1. Click on Button B1:
        //   - Ensure that clicking on the **B1** button opens a new window.
        //   - Verify that the text in the window opened by the **B1** button is **"Welcome to B1 page"**.
        //2. Click on Button B2:
        //   - Ensure that clicking on the **B2** button opens a new window.
        //   - Verify that the text in the window opened by the **B2** button is **"Welcome to B2 page"**.

        List<WebElement> buttons = driver.findElements(By.partialLinkText("Open B"));
        List <String> urls = new ArrayList<>();
        urls.add("https://syntaxprojects.com/b1-page.php");
        urls.add("https://syntaxprojects.com/b2-page.php");
        List <String> texts = new ArrayList<>();
        texts.add("Welcome to B1 page");
        texts.add("Welcome to B2 page");
        if (buttons.size()<= urls.size() && buttons.size()<= texts.size()) {
            for (int i = 0; i < buttons.size(); i++) {
                buttons.get(i).click();
                Set<String> allHandles = driver.getWindowHandles();
                for (String handle : allHandles) {
                    driver.switchTo().window(handle);
                    if (driver.getCurrentUrl().equals(urls.get(i))) {
                        System.out.println("This is a new window");
                        System.out.println(driver.getCurrentUrl());
                        WebElement textB = driver.findElement(By.tagName("h2"));
                        System.out.println("expected text: " + texts.get(i));
                        System.out.println("current text: " + textB.getText());
                        if (textB.getText().equals(texts.get(i))) {
                            System.out.println("Text matches the criteria");
                        } else if (textB.getText().contains("Welcome to B")) {
                            System.out.println("Text partially matches");
                        } else {
                            System.out.println("Text does not match");
                        }
                        break;
                    }
                }
                driver.switchTo().window(mainPage);
                System.out.println();
            }
        }else {
            System.out.println("Check the size of urls and texts to match the web elements");
        }
        driver.quit();

    }

}
