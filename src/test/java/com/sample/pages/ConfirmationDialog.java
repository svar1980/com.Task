package com.sample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationDialog {

    public ConfirmationDialog(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.ID, using="dialog")
    public WebElement dialog;

    @FindBy(how=How.XPATH, using="//div[@id='dialog']/p")
    public WebElement dialogText;

    public String getConformationText(){
        return dialogText.getText();
    }

}
