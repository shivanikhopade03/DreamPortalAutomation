package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DiaryPage;
import pages.HomePage;
import java.io.IOException;
import utils.ScreenshotUtil;
import java.util.List;
import java.util.Set;
import com.aventstack.extentreports.Status;

public class DiaryTest extends BaseTest {

    @Test
    public void verifyDreamTable()
            throws InterruptedException, IOException {
    	test = extent.createTest(
    	        "Diary Page Test");

        // Home Page object
        HomePage homePage =
                new HomePage(driver);
        ScreenshotUtil.captureScreenshot(
                driver,
                "DiaryPage");
        Thread.sleep(3000);

        // Click button
        homePage.clickDreamButton();
        ScreenshotUtil.captureScreenshot(
                driver,
                "DiaryPage");
        Thread.sleep(3000);

        // Switch to diary tab
        Set<String> windows =
                driver.getWindowHandles();

        for(String window : windows) {

            driver.switchTo().window(window);

            if(driver.getCurrentUrl()
                    .contains("dreams-diary.html")) {

                break;
            }
        }

        System.out.println(
                "Dream Diary Page Opened");

        // Diary Page object
        DiaryPage diaryPage =
                new DiaryPage(driver);

        // Row count
        int rowCount =
                diaryPage.getRowCount();

        System.out.println(
                "Total Rows: " + rowCount);

        Assert.assertEquals(rowCount, 10);

        System.out.println(
                "Row Count Verified");

        // Get all rows
        List<WebElement> rows =
                diaryPage.getAllRows();

        // Validate dream types
        for(WebElement row : rows) {

            String dreamType =
                    row.findElement(
                            org.openqa.selenium.By.xpath("./td[3]"))
                            .getText();

            System.out.println(
                    "Dream Type: " + dreamType);

            Assert.assertTrue(
                    dreamType.equals("Good")
                            || dreamType.equals("Bad"));
        }

        System.out.println(
                "Dream Types Verified");
        
        test.log(
                Status.PASS,
                "Diary table verified");
        
        ScreenshotUtil.captureScreenshot(
                driver,
                "DiaryPage");
        Thread.sleep(5000);
    }
}