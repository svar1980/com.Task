package com.sample.pages;

import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class PizzaPage {

    private static final Logger logger = LogManager.getLogger(PizzaPage.class);

    public PizzaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.ID, using="pizza1Pizza")
    private WebElement pizza1;

    @FindBy(how=How.XPATH, using="//div[@id='pizza1']//select[@class='toppings1']")
    private WebElement pizza1Toppings1;

    @FindBy(how=How.XPATH, using="//div[@id='pizza1']//select[@class='toppings2']")
    private WebElement pizza1Toppings2;

    @FindBy(how=How.ID, using="pizza1Qty")
    private WebElement pizza1Quantity;

    @FindBy(how=How.ID, using="pizza1Cost")
    private WebElement pizza1Cost;

    @FindBy(how=How.ID, using="ccpayment")
    private WebElement radioCreditCard;

    @FindBy(how=How.ID, using="cashpayment")
    private WebElement radioCash;

    @FindBy(how=How.ID, using="email")
    private WebElement email;

    @FindBy(how=How.ID, using="name")
    private WebElement name;

    @FindBy(how=How.ID, using="phone")
    private WebElement phone;

    @FindBy(how=How.ID, using="placeOrder")
    private WebElement placeOrderButton;

    @FindBy(how=How.ID, using="reset")
    private WebElement resetButton;

    @FindBy(how=How.ID, using="ccpayment")
    private WebElement cardPayment;

    @FindBy(how=How.ID, using="cashpayment")
    private WebElement cashPayment;




    public void setPizza1Type(PizzaTypes type){
        logger.info(type);
        pizza1.sendKeys(type.getDisplayName());
    }

    public void setPizza1Type(String type){
        logger.info("setPizza1Type "+type);
        pizza1.sendKeys(type);
    }

    public void setToppings1Type(PizzaToppings type){
        pizza1Toppings1.sendKeys(type.getDisplayName());
    }

    public void setToppings2Type(PizzaToppings type){
        pizza1Toppings2.sendKeys(type.getDisplayName());
    }

    public void setPizza1Quantity(String value) throws Exception {
        logger.info("setPizza1Quantity "+value);
        pizza1Quantity.clear();
        pizza1Quantity.sendKeys(value);
        pizza1Quantity.sendKeys(Keys.ENTER);
        Thread.sleep(100);
    }

    public double getPizza1Cost(){
        String value = pizza1Cost.getAttribute("value");
        logger.info("getPizza1Cost "+value);
        return new Double(value);
    }

    public void setCustomerName(String value){
        name.sendKeys(value);
    }

    public void setCustomerEmail(String value){
        email.sendKeys(value);
    }

    public void setCustomerPhone(String value){
        phone.sendKeys(value);
    }

    public void placeOrder(){
        placeOrderButton.click();
    }

    public void setCardPayment(){
        cardPayment.click();
    }


}
