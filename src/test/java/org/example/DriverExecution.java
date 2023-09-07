package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.example.PageObjectClasses.LoginPage_POM;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public  class DriverExecution {
    public static WebDriver driver;
    public static LoginPage_POM landingPage;
    public static void allDrivers() throws IOException {
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream("D:\\Selenium\\src\\main\\java\\resources\\GoblaData.properties");
        prop.load(fis);
       String browsername= System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
       // String browsername= prop.getProperty("browser");

     if(browsername.contains("chrome")){
         System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--remote-allow-origins=*");
         if(browsername.contains("headless")){
             options.addArguments("headless");
         }

          driver = new ChromeDriver(options);
         driver.manage().window().setSize(new Dimension(1440,900));
     }

     else if(browsername.equalsIgnoreCase("edge")){

         System.setProperty("webdriver.edge.driver", "D:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
          driver=new EdgeDriver();
     }

     else{
         System.out.println("intilise the firefox");
     }

    }

    public List<HashMap<String, String>> getJsonDataToMap(String path) throws IOException {

        String jsoncontent= FileUtils.readFileToString(new File(path),
                StandardCharsets.UTF_8);

        // string to hashmap
        ObjectMapper mapper= new ObjectMapper();

        List<HashMap<String,String>> data= mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>() {
        });

        return data;
    }


    public String getScreenShot(String testcase,WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        File file= new File(System.getProperty("user.dir")+ "\\Reports\\"+ testcase +".png");
        FileUtils.copyFile(source,file);
        return  testcase +".png";

    }


    @BeforeMethod(alwaysRun = true)
    public static LoginPage_POM LaunchApplication() throws IOException {

        allDrivers();
        landingPage=new LoginPage_POM(driver);
        landingPage.titlepage();
        driver.manage().window().maximize();
        return landingPage;

    }

   @AfterMethod(alwaysRun = true)
 public void closeapplication(){
       driver.quit();
   }


}
