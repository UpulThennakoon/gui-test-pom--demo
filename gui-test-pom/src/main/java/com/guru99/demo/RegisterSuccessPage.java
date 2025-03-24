package com.guru99.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;
import utils.TestApp;

public class RegisterSuccessPage {
    PropertyFileReader propertyFileReader=new PropertyFileReader();
    WebDriver driver= TestApp.getInstance().getDriver();
    String confirmMessageElement=propertyFileReader.getProperty("RegisterSuccessPage","confirm.message.element");
    public String getConfirmMessageElement()
    {
        TestApp.getInstance().waitNextElementAppears(By.xpath(confirmMessageElement),10);
        return driver.findElement(By.xpath(confirmMessageElement)).getText();
    }
}
