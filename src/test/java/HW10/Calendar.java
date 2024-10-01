package HW10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class Calendar {
    // method to return integer value for month number
    private static int monthToNumber(String month) {
        switch (month) {
            case "January":
                return 1;
            case "February":
                return 2;
            case "March":
                return 3;
            case "April":
                return 4;
            case "May":
                return 5;
            case "June":
                return 6;
            case "July":
                return 7;
            case "August":
                return 8;
            case "September":
                return 9;
            case "October":
                return 10;
            case "November":
                return 11;
            case "December":
                return 12;
            default:
                return 0;
        }
    }

        // ### User Story
        //- **Title**: Verifying Dynamic Date Selection in the jQuery Date Picker
        //- **As a user,**
        //- I want to navigate to `https://syntaxprojects.com/jquery-date-picker-demo-homework.php`
        //- So that I can ensure the correct "To" and "From" dates are selected from the calendar.
        //
        //#### Acceptance Criteria
        //
        //1. **Select "From" and "To" Dates**:
        //   - Select the **From** date and the **To** date in the jQuery date picker.
        //   - The code logic should be **dynamic**, meaning it should work with any selected dates without requiring any changes to the core logic.
        //   - The selection should not rely on hard-coded date values and should be adaptable if the date range changes.
        public static void main (String[]args){
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.get("https://syntaxprojects.com/jquery-date-picker-demo-homework.php");
            int startDay = 20;
            String startMonth = "October";
            int startYear = 2022;
            int endDay=10;
            String endMonth = "May";
            int endYear = 2026;
            // I would add if else condition here to check if the end date is not before the start date. But the calendar on the website does not care
            // first box
            driver.findElement(By.id("from_date")).click();
            boolean notDate = true;
            while (notDate) {
                    WebElement currentYearElement = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
                    int currentYear = Integer.parseInt(currentYearElement.getText());
                    WebElement currentMonthElement = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
                    String currentMonth = currentMonthElement.getText();
                    if (currentYear == startYear && currentMonth.equals(startMonth)) {
                        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
                        for (WebElement date : dates) {
                            if (date.getText().equals(String.valueOf(startDay))) {
                                date.click();
                                notDate = false;
                                break;
                            }
                        }
                    } else {
                        if (currentYear < startYear) {
                            WebElement nextButton = driver.findElement(By.xpath("//a[@title='Next']"));
                            nextButton.click();
                        } else if (currentYear == startYear && monthToNumber(currentMonth) < monthToNumber(startMonth)) {
                            WebElement nextButton = driver.findElement(By.xpath("//a[@title='Next']"));
                            nextButton.click();
                        } else {
                            WebElement prevButton = driver.findElement(By.xpath("//a[@title='Prev']"));
                            prevButton.click();
                        }
                    }
                }
            // second box
            driver.findElement(By.id("to_date")).click();
            notDate = true;
            while (notDate) {
                    WebElement currentYearElement = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
                    int currentYear = Integer.parseInt(currentYearElement.getText());
                    WebElement currentMonthElement = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
                    String currentMonth = currentMonthElement.getText();
                    if (currentYear == endYear && currentMonth.equals(endMonth)) {
                        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
                        for (WebElement date : dates) {
                            if (date.getText().equals(String.valueOf(endDay))) {
                                date.click();
                                notDate = false;
                                break;
                            }
                        }
                    } else {
                        if (currentYear < endYear) {
                            WebElement nextButton = driver.findElement(By.xpath("//a[@title='Next']"));
                            nextButton.click();
                        } else if (currentYear == endYear && monthToNumber(currentMonth) < monthToNumber(endMonth)) {
                            WebElement nextButton = driver.findElement(By.xpath("//a[@title='Next']"));
                            nextButton.click();
                        } else {
                            WebElement prevButton = driver.findElement(By.xpath("//a[@title='Prev']"));
                            prevButton.click();
                        }
                    }
                }
            }
}
