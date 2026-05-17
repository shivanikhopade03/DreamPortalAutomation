package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    // Locator
    By myDreamButton =
            By.xpath("//button[contains(text(),'My Dreams')]");

    // Action Method
    public void clickDreamButton() {

        driver.findElement(myDreamButton).click();
    }
}
