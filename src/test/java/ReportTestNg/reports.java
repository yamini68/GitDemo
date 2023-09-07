package ReportTestNg;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.model.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.List;

public class reports {

    static ExtentReports  extents=new ExtentReports();
@BeforeMethod
    public static void config(){

    String path=System.getProperty("user.dir")+"\\Reports\\index.html";
    ExtentSparkReporter spark=new ExtentSparkReporter(path);
    spark.config().setReportName("Web Automation Results");
    spark.config().setDocumentTitle("Test Results");

    extents=new ExtentReports();
    extents.attachReporter(spark);
    extents.setSystemInfo("Tester","Yamini");
    }

    @Test
    public void intialdemo(){
        extents.createTest("initial demo");

        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
       WebDriver driver = new ChromeDriver(options);
       driver.get("https://mvnrepository.com/artifact/org.apache.spark/spark-core_2.13/3.4.0");
        System.out.println(driver.getTitle());

        extents.flush();
    }
}
