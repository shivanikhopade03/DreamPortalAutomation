package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage {

    WebDriver driver;

    // Constructor
    public SummaryPage(WebDriver driver) {

        this.driver = driver;
    }

    // Locators

    By goodDreams =
            By.xpath("//table/tbody/tr[1]/td[2]");

    By badDreams =
            By.xpath("//table/tbody/tr[2]/td[2]");

    By totalDreams =
            By.xpath("//table/tbody/tr[3]/td[2]");

    By recurringDreams =
            By.xpath("//table/tbody/tr[5]/td[2]");

    // Methods

    public String getGoodDreams() {

        return driver.findElement(goodDreams)
                .getText();
    }

    public String getBadDreams() {

        return driver.findElement(badDreams)
                .getText();
    }

    public String getTotalDreams() {

        return driver.findElement(totalDreams)
                .getText();
    }

    public String getRecurringDreams() {

        return driver.findElement(recurringDreams)
                .getText();
    }
}