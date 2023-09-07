package TestCases;

import org.apache.commons.io.FileUtils;
import org.example.DriverExecution;
import org.example.PageObjectClasses.AddToCartPage_POM;
import org.example.PageObjectClasses.OrderConformationPage_POM;
import org.example.PageObjectClasses.PaymentPage_POM;
import org.example.PageObjectClasses.ProductCatlog_POM;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class JsonFormatTestNg extends DriverExecution {

    @Test(priority = 1,dataProvider= "getData")
    public void submitordertest1(HashMap<String,String> input) throws IOException, InterruptedException {

        String text="THANKYOU FOR THE ORDER.";
        ProductCatlog_POM productCatlog= landingPage.LogInApplication(input.get("email"),input.get("password"));



         List<WebElement> products= productCatlog.getproductList();
        AddToCartPage_POM addtocartpage= productCatlog.addProductToCart(input.get("product"));


        Boolean value= addtocartpage.correctProductAdded(input.get("product"));
        Assert.assertTrue(value);
        PaymentPage_POM paymentPage=addtocartpage.checkoutbutton();



        OrderConformationPage_POM orderConformationPage = paymentPage.PlaceOrderButton();


        orderConformationPage.orderconformationMsg(text);



    }

    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String,String>> data = getJsonDataToMap("D:\\Selenium\\src\\test\\java\\jsonfiles\\userDetails.json");

        return new Object[][] {{data.get(0)},{data.get(1)}};
    }



    @Test(priority = 2 , groups = {"ordervalid"})
    public void orderValidation(){


        ProductCatlog_POM productCatlog= landingPage.LogInApplication("anala@example.com","Anala@123");
       Boolean value= productCatlog.orderpage();
       Assert.assertTrue(value);

    }

    }


