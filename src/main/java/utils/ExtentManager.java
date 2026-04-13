package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark = new ExtentSparkReporter("reports/extentReport.html");
            spark.config().setReportName("Automation Test Results");
            spark.config().setDocumentTitle("Test Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }
}