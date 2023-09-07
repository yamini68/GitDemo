package org.example.PageObjectClasses;

import AbstractMethods.AbstractMethod1;
import org.example.PageObjectClasses.OrderConformationPage_POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaymentPage_POM extends AbstractMethod1 {
    WebDriver driver;
    public PaymentPage_POM (WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }



    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement dropdown;

    @FindBy(xpath = "//div[@class='actions']/a")
    WebElement orderbutton;

    By option=By.xpath("//span[@class='ng-star-inserted']");

    public OrderConformationPage_POM PlaceOrderButton(){
        dropdown.sendKeys("ind");
        waitForVisiabilityOfElement(option);
        List<WebElement> names=driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
        WebElement select= names.stream().filter(s->s.getText().equals("India")).findFirst().orElse(null);
        select.click();
        orderbutton.click();
        OrderConformationPage_POM orderConformationPage=new OrderConformationPage_POM(driver);
        return orderConformationPage;
    }
}
