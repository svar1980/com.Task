package com.sample.tests;

import com.sample.pages.ConfirmationDialog;
import com.sample.pages.PizzaPage;
import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NegativeTest extends TestBase {

    @Test()
    public void checkMissingPhoneNum() throws Exception {

        PizzaPage pizzaPage = new PizzaPage(this.driver);

        pizzaPage.setPizza1Type(PizzaTypes.LARE_NOTOPPINGS);

        pizzaPage.setToppings1Type(PizzaToppings.MOZZARELLA);
        pizzaPage.setToppings2Type(PizzaToppings.OLIVES);
        pizzaPage.setPizza1Quantity("1");

        pizzaPage.setCustomerName("Ivanoff");
        pizzaPage.setCustomerEmail("Abra@cadabra");


        pizzaPage.placeOrder();

        ConfirmationDialog confirmationDialog = new ConfirmationDialog(this.driver);

        String text = confirmationDialog.getConformationText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(text,  "Missing phone number");
        softAssert.assertAll();
    }

}
