package org.example;

import org.example.*;
import org.example.PageObjectClasses.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SubmitOrderTest extends DriverExecution {

    public static void main(String args[]) throws InterruptedException {


         LoginPage_POM landingPage=new LoginPage_POM(driver);
         landingPage.titlepage();
         String text="THANKYOU FOR THE ORDER.";
         driver.manage().window().maximize();
         ProductCatlog_POM productCatlog= landingPage.LogInApplication("anala@example.com","Anala@123");
           String productname="ZARA COAT 3";


         List<WebElement> products= productCatlog.getproductList();
         productCatlog.addProductToCart(productname);


        AddToCartPage_POM addtocartpage=new AddToCartPage_POM(driver);
        Boolean value= addtocartpage.correctProductAdded(productname);
        Assert.assertTrue(value);
        addtocartpage.checkoutbutton();


        PaymentPage_POM paymentPage=new PaymentPage_POM(driver);
        paymentPage.PlaceOrderButton();

        OrderConformationPage_POM orderConformationPage=new OrderConformationPage_POM(driver);
        orderConformationPage.orderconformationMsg(text);



    }

    public void method1(){
        LoginPage_POM landingPage=new LoginPage_POM(driver);
        landingPage.titlepage();
        driver.manage().window().maximize();
        ProductCatlog_POM productCatlog= landingPage.LogInApplication("anala@example.com","Anala@123");


    }




    }




