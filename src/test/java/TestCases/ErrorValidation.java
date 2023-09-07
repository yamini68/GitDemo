package TestCases;

import ReportTestNg.retry;
import org.example.DriverExecution;
import org.example.PageObjectClasses.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ErrorValidation extends DriverExecution {

    @Test(retryAnalyzer = retry.class)
    public void LoginErrorValidation() throws IOException, InterruptedException {


        ProductCatlog_POM productCatlog= landingPage.LogInApplication("an@example.com","Anala@123");
        Assert.assertEquals("Incorre email or password.",landingPage.DisplayErrorMessage());

    }

    @Test
    public void producterrorvalidation() throws IOException, InterruptedException {


        ProductCatlog_POM productCatlog= landingPage.LogInApplication("anala@example.com","Anala@123");
       String productName="ZARA COAT 3";


        List<WebElement> products= productCatlog.getproductList();
        AddToCartPage_POM addtocartpage= productCatlog.addProductToCart(productName);


        Boolean value= addtocartpage.correctProductAdded(productName);
        Assert.assertTrue(value);
    }

    }


