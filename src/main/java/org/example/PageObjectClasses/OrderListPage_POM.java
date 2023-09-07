package org.example.PageObjectClasses;

import AbstractMethods.AbstractMethod1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderListPage_POM extends AbstractMethod1 {

    WebDriver driver;
    public OrderListPage_POM (WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//table//tr//td[2]")
    List<WebElement> productList;

    By items= By.xpath("//table//tr//td[2]");





    public Boolean orderpresent(){
        waitForVisiabilityOfListOfeleemnts(items);
        Boolean anyMatch= productList.stream().anyMatch(product->product.getText()
               .equalsIgnoreCase("ZARA COAT 3"));

       return anyMatch;
    }
}
