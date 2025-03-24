package com.guru99.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyFileReader;
import utils.TestApp;

public class HomePage {
    WebDriver driver= TestApp.getInstance().getDriver();
    PropertyFileReader propertyFileReader=new PropertyFileReader();
    String registerelement=propertyFileReader.getProperty("HomePage","register.element");
    public RegisterPage clickOnRegister()
    {
        TestApp.getInstance().waitNextElementAppears(By.linkText(registerelement),10);
        driver.findElement(By.linkText(registerelement)).click();
        return new RegisterPage();
    }
}
