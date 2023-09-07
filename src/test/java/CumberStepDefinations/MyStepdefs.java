package CumberStepDefinations;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.DriverExecution;
import org.example.PageObjectClasses.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class MyStepdefs extends DriverExecution {
    public LoginPage_POM landingPage;
    public ProductCatlog_POM productCatlog;
    public  AddToCartPage_POM addtocartpage;
    public PaymentPage_POM paymentPage;
    public OrderConformationPage_POM orderConformationPage;


    @Given("I landed on ecommerce page")
    public void iLandedOnEcommercePage() throws IOException {
        landingPage=LaunchApplication();
    }

    @Given("^Log in with username (.+) and password (.+)$")
    public void logInWithUsernameNameAndPasswordPassword(String username, String Password) {
       productCatlog = landingPage.LogInApplication(username,Password);
    }

    @When("^i add product (.+) to cart$")
    public void iAddProductProductnameToCart(String product) throws InterruptedException {

        List<WebElement> products= productCatlog.getproductList();
       addtocartpage= productCatlog.addProductToCart(product);
    }

    @And("^checkout (.+) and submit the order$")
    public void checkoutProductnameAndSubmitTheOrder(String productName) throws InterruptedException {

        Boolean value= addtocartpage.correctProductAdded(productName);
        Assert.assertTrue(value);
      paymentPage=addtocartpage.checkoutbutton();
      orderConformationPage = paymentPage.PlaceOrderButton();
    }

    @Then("{string} message is displayed on conformation page")
    public void messageIsDisplayedOnConformationPage(String string) {
        orderConformationPage.orderconformationMsg(string);
    }

    @Then("{string} message is displayed")
    public void messageIsDisplayed(String string) {
        Assert.assertEquals(string,landingPage.DisplayErrorMessage());
    }
}
