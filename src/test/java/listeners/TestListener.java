package listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import utils.ExtentManager;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    public static ThreadLocal<ExtentTest> tl = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        tl.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        tl.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        tl.get().fail(result.getThrowable());

        // Get driver
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            File folder = new File("screenshots");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String fileName = result.getName() + "_" + System.currentTimeMillis() + ".png";
            File dest = new File(folder, fileName);

            FileUtils.copyFile(src, dest);

            // Attach screenshot to report
            tl.get().addScreenCaptureFromPath(dest.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }
}