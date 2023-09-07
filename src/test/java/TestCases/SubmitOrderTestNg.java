package TestCases;

import org.example.*;
import org.example.PageObjectClasses.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class SubmitOrderTestNg extends DriverExecution {

    @Test(dataProvider= "getData")
    public void submitordertest(String email, String password, String product) throws IOException, InterruptedException {

         String text="THANKYOU FOR THE ORDER.";
        ProductCatlog_POM productCatlog= landingPage.LogInApplication(email,password);



         List<WebElement> products= productCatlog.getproductList();
        AddToCartPage_POM addtocartpage= productCatlog.addProductToCart(product);


        Boolean value= addtocartpage.correctProductAdded(product);
        Assert.assertTrue(value);
        PaymentPage_POM paymentPage=addtocartpage.checkoutbutton();



        OrderConformationPage_POM orderConformationPage = paymentPage.PlaceOrderButton();


        orderConformationPage.orderconformationMsg(text);



    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][] {{"anala@example.com","Anala@123","ZARA COAT 3"},{"murali12@gmail.com","Murali@123","adidas original"}};
    }

    @Test( groups = {"ordervalid"})
    public void orderValidation(){


        ProductCatlog_POM productCatlog= landingPage.LogInApplication("anala@example.com","Anala@123");
       Boolean value= productCatlog.orderpage();
       Assert.assertTrue(value);

    }

    }


