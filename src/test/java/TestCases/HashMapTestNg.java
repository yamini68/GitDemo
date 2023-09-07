package TestCases;

import org.example.DriverExecution;
import org.example.PageObjectClasses.AddToCartPage_POM;
import org.example.PageObjectClasses.OrderConformationPage_POM;
import org.example.PageObjectClasses.PaymentPage_POM;
import org.example.PageObjectClasses.ProductCatlog_POM;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class HashMapTestNg extends DriverExecution {

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
    public Object[][] getData(){

        HashMap<String,String>map = new HashMap<>();
        map.put("email","anala@example.com");
        map.put("password","Anala@123");
        map.put("product","ZARA COAT 3");

        HashMap<String,String>map1 = new HashMap<>();
        map1.put("email","murali12@gmail.com");
        map1.put("password","Murali@123");
        map1.put("product","adidas original");


        return new Object[][] {{map},{map1}};
    }

    @Test(priority = 2 , groups = {"ordervalid"})
    public void orderValidation(){


        ProductCatlog_POM productCatlog= landingPage.LogInApplication("anala@example.com","Anala@123");
       Boolean value= productCatlog.orderpage();
       Assert.assertTrue(value);

    }

    }


