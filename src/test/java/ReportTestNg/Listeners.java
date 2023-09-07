package ReportTestNg;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.DriverExecution;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;


import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends DriverExecution implements ITestListener {
    ExtentTest test;
  ExtentReports extents=Extentreports.getreportObject();
  ThreadLocal<ExtentTest> sync=new ThreadLocal<ExtentTest>();
    @Override
    public void onTestStart(ITestResult result) {
        // Logic for when a test starts

     test =   extents.createTest(result.getMethod().getMethodName());
     sync.set(test);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Logic for when a test is successful
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Logic for when a test fails
        sync.get().fail(result.getThrowable());

        //screenshot
      try {
        driver=(WebDriver) result.getTestClass().getRealClass()
                .getField("driver").get(result.getInstance());
      } catch (Exception e) {
        e.printStackTrace();
      }
      String filepath=null;
      try {
         filepath=getScreenShot(result.getMethod().getMethodName(),driver);
      } catch (IOException e) {
        e.printStackTrace();
      }
      sync.get().addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());

    }

  @Override
  public void onFinish(ITestContext context) {
    // Logic for when a test is finished
    extents.flush();
  }



  // Other overridden methods

}





