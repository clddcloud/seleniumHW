package HW01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {
    /*
1. The user should be able to launch a web browser and navigate to the URL `https://www.syntaxprojects.com/`.
2. The user should be able to maximize the browser window
2. The current URL should be printed on the console and match `https://www.syntaxprojects.com/`.
3. The page title retrieved should be printed on the console and match `Syntax - Website to practice Syntax Automation Platform`.
4. The browser should close automatically after retrieving both the URL and title.
     */
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.syntaxprojects.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.quit();
    }

}
