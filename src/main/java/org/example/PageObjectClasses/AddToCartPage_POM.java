package org.example.PageObjectClasses;

import AbstractMethods.AbstractMethod1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage_POM extends AbstractMethod1 {

    WebDriver driver;
    public AddToCartPage_POM (WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='cartSection']/h3")
    WebElement value;
    By cartPageLoad=By.xpath("//div[@class='cartSection']/h3");

    public Boolean correctProductAdded(String productadded){
        waitForElementToAppear(cartPageLoad);
        Boolean ele= value.getText().equalsIgnoreCase(productadded);
        return ele;
    }



        @FindBy(xpath = "//*[contains(@class,'subtotal')]//button")
        WebElement checkout;

        By button=By.xpath("//*[contains(@class,'subtotal')]//button");

    public PaymentPage_POM checkoutbutton() throws InterruptedException {
        waitForVisiabilityOfElement(button);
        Thread.sleep(3000l);
        checkout.click();
        PaymentPage_POM paymentPage=new PaymentPage_POM(driver);
        return paymentPage;


    }

}
