package org.example.PageObjectClasses;

import AbstractMethods.AbstractMethod1;
import org.example.PageObjectClasses.AddToCartPage_POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatlog_POM extends AbstractMethod1 {
    WebDriver driver;
    public ProductCatlog_POM (WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".mb-3")
    List<WebElement> products;
    By productSelector = By.cssSelector(".mb-3");

    @FindBy(css=".ng-animating")
    WebElement spinner;

    By toast=By.cssSelector("#toast-container");

    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement cartOption;

    public List<WebElement> getproductList(){
        waitForElementToAppear(productSelector);
        return products;
    }

    public WebElement getProductByName(String productname){
        WebElement item=   products.stream().filter(product->product.findElement(By.cssSelector("b"))
                        .getText().equalsIgnoreCase(productname)).
                findFirst().orElse(null);
        return item;
    }



    public AddToCartPage_POM addProductToCart(String productname) throws InterruptedException {
        WebElement item=getProductByName(productname);
        item.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        //waitForElementToDisAppear(spinner);
        //waitForElementToAppear(toast);
        Thread.sleep(3000l);
        cartOption.click();
        AddToCartPage_POM addtocartpage=new AddToCartPage_POM(driver);
        return addtocartpage;
    }

    @FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
    WebElement ordebtn;

    public Boolean orderpage(){
     waitForVisiabilityOfWebElement(ordebtn);
     ordebtn.click();

     OrderListPage_POM orderListPage=new OrderListPage_POM(driver);
      Boolean value=orderListPage.orderpresent();
      return value;


    }
}
