package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static void captureScreenshot(
            WebDriver driver,
            String testName)
            throws IOException {

        // Take screenshot
        File src =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        // Save screenshot
        File dest =
                new File("screenshots/"
                        + testName + ".png");

        FileUtils.copyFile(src, dest);

        System.out.println(
                "Screenshot Saved Successfully");
    }
}