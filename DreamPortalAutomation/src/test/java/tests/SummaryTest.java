package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SummaryPage;
import utils.ScreenshotUtil;
import java.io.IOException;
import java.util.Set;
import com.aventstack.extentreports.Status;

public class SummaryTest extends BaseTest {

    @Test
    public void verifySummaryData()
            throws InterruptedException, IOException {
    	test = extent.createTest(
    	        "Summary Page Test");
        // Home Page object
        HomePage homePage =
                new HomePage(driver);
        ScreenshotUtil.captureScreenshot(
                driver,
                "SummaryPage");
        Thread.sleep(3000);

        // Click button
        homePage.clickDreamButton();
        ScreenshotUtil.captureScreenshot(
                driver,
                "SummaryPage");
        Thread.sleep(3000);

        // Switch to summary tab
        Set<String> windows =
                driver.getWindowHandles();

        for(String window : windows) {

            driver.switchTo().window(window);

            if(driver.getCurrentUrl()
                    .contains("dreams-total.html")) {

                break;
            }
        }

        System.out.println(
                "Dream Total Page Opened");

        // Summary Page object
        SummaryPage summaryPage =
                new SummaryPage(driver);

        // Get values
        String goodDreams =
                summaryPage.getGoodDreams();

        String badDreams =
                summaryPage.getBadDreams();

        String totalDreams =
                summaryPage.getTotalDreams();

        String recurringDreams =
                summaryPage.getRecurringDreams();

        // Print values
        System.out.println(
                "Good Dreams: " + goodDreams);

        System.out.println(
                "Bad Dreams: " + badDreams);

        System.out.println(
                "Total Dreams: " + totalDreams);

        System.out.println(
                "Recurring Dreams: "
                        + recurringDreams);

        // Assertions
        Assert.assertEquals(goodDreams, "6");

        Assert.assertEquals(badDreams, "4");

        Assert.assertEquals(totalDreams, "10");

        Assert.assertEquals(recurringDreams, "2");

        System.out.println(
                "Summary Data Verified");
        
        test.log(
                Status.PASS,
                "Summary data verified");
        
        ScreenshotUtil.captureScreenshot(driver,"SummaryPage");

        Thread.sleep(5000);
    }
}