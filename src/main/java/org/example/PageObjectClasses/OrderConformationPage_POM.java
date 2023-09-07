package org.example.PageObjectClasses;

import AbstractMethods.AbstractMethod1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderConformationPage_POM extends AbstractMethod1 {

    WebDriver driver;
    public OrderConformationPage_POM (WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }



    By msg=By.xpath("//h1[@class='hero-primary']");
    @FindBy(xpath = "//h1[@class='hero-primary']")
    WebElement ordermsg;

    public void orderconformationMsg(String text){
        waitForVisiabilityOfElement(msg);
     Boolean conform =   ordermsg.getText().equalsIgnoreCase(text);
     Assert.assertTrue(conform);

    }
}
