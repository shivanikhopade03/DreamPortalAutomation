package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DiaryPage {

    WebDriver driver;

    // Constructor
    public DiaryPage(WebDriver driver) {

        this.driver = driver;
    }

    // Table rows locator
    By rows =
            By.xpath("//table/tbody/tr");

    // Get all rows
    public List<WebElement> getAllRows() {

        return driver.findElements(rows);
    }

    // Get row count
    public int getRowCount() {

        return getAllRows().size();
    }
}