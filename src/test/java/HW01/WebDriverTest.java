package HW01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverTest {
    /*
    Acceptance Criteria:
1. The user successfully opens Chrome and maximizes the window using `window().maximize()`.
2. The user navigates to `www.google.com`, and the page title is printed correctly.
3. The user navigates to `https://www.syntaxprojects.com/`, and the page title is printed correctly.
4. The user successfully navigates back to `www.google.com` using `navigate().back()`.
5. The page at `www.google.com` is refreshed using `navigate().refresh()`.
6. The browser closes after completing all the navigation steps.
     */
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");
        System.out.println(driver.getTitle());
        driver.navigate().to("https://www.syntaxprojects.com/");
        System.out.println(driver.getTitle());
        driver.navigate().back();
        driver.navigate().back();
        driver.quit();

    }
}
