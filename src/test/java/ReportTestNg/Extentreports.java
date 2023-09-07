package ReportTestNg;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreports {
    static ExtentReports extents=new ExtentReports();
    public static ExtentReports getreportObject(){

          String path=System.getProperty("user.dir")+"\\Reports\\testcase2.html";
            ExtentSparkReporter spark=new ExtentSparkReporter(path);
            spark.config().setReportName("Web Automation Results");
            spark.config().setDocumentTitle("Test Results");

            extents=new ExtentReports();
            extents.attachReporter(spark);
            extents.setSystemInfo("Tester","Yamini");

            return extents;

    }

}
