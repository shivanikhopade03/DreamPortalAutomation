package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.Set;
import java.io.IOException;
import utils.ScreenshotUtil;
import com.aventstack.extentreports.Status;

public class HomePageTest extends BaseTest {


    @Test
    public void verifyTabs()
    
            throws InterruptedException, IOException {
    	 test = extent.createTest(
    	            "Home Page Test");
        // Create object
        HomePage homePage =
                new HomePage(driver);
        ScreenshotUtil.captureScreenshot(
                driver,
                "HomePage");
        Thread.sleep(3000);

        // Click button using POM
        homePage.clickDreamButton();

        System.out.println(
                "Button Clicked Successfully");
        ScreenshotUtil.captureScreenshot(
                driver,
                "HomePage");
        Thread.sleep(3000);

        // Tabs validation
        Set<String> windows =
                driver.getWindowHandles();

        Assert.assertEquals(
                windows.size(), 3);

        System.out.println(
                "Tabs Verified Successfully");
        test.log(
                Status.PASS,
                "Tabs verified successfully");
        ScreenshotUtil.captureScreenshot(
                driver,
                "HomePage");
        Thread.sleep(5000);
    }
}