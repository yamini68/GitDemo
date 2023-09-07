package org.example.PageObjectClasses;

import AbstractMethods.AbstractMethod1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_POM extends AbstractMethod1 {
    WebDriver driver;
    public LoginPage_POM(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="userEmail")    // this statement is equlitent to driver.findElement(By.id("userEmail")) that result will be stored in usermail.
    WebElement useremail;

    @FindBy(id="userPassword")
    WebElement userpassword;

    @FindBy(id="login")
    WebElement loginButton;

    public void titlepage(){
        driver.get("https://rahulshettyacademy.com/client/");
    }

    //div[@aria-label='Incorrect email or password.']

    @FindBy(css="[class*='flyInOut']")
    WebElement errormessage;

    public String DisplayErrorMessage(){
        waitForVisiabilityOfWebElement(errormessage);
     String text=   errormessage.getText();
        return text;
    }

    public ProductCatlog_POM LogInApplication(String mail , String password){
        useremail.sendKeys(mail);
        userpassword.sendKeys(password);
        loginButton.click();
        ProductCatlog_POM productCatlog=new ProductCatlog_POM(driver);
        return productCatlog;
    }


}
