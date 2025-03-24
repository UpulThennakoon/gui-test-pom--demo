package com.guru99.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.PropertyFileReader;
import utils.TestApp;

public class RegisterPage {
    PropertyFileReader propertyFileReader=new PropertyFileReader();
    WebDriver driver= TestApp.getInstance().getDriver();
    String firstNameElement=propertyFileReader.getProperty("RegisterPage","first.name.element");
    String lastNameElement=propertyFileReader.getProperty("RegisterPage","last.name.element");
    String phoneNumberElement=propertyFileReader.getProperty("RegisterPage","phone.number.element");
    String emailAddressElement=propertyFileReader.getProperty("RegisterPage","email.address.element");
    String countryNameElement=propertyFileReader.getProperty("RegisterPage","country.name.element");
    String userNameElement=propertyFileReader.getProperty("RegisterPage","user.name.element");
    String passwordElement=propertyFileReader.getProperty("RegisterPage","password.element");
    String confirmPasswordElement=propertyFileReader.getProperty("RegisterPage","confirm.password.element");
    String submitElement=propertyFileReader.getProperty("RegisterPage","submit.element");

    public RegisterPage setFirstName(String firstName)
    {
        TestApp.getInstance().waitNextElementAppears(By.name(firstNameElement),10);
        TestApp.getInstance().setText(By.name(firstNameElement),firstName);
        return this;
    }
    public RegisterPage setLastName(String lastName)
    {
        TestApp.getInstance().waitNextElementAppears(By.name(lastNameElement),10);
        TestApp.getInstance().setText(By.name(lastNameElement),lastName);
        return this;
    }
    public RegisterPage setPhoneNumber(String phoneNumber)
    {
        TestApp.getInstance().waitNextElementAppears(By.name(phoneNumberElement),10);
        TestApp.getInstance().setText(By.name(phoneNumberElement),phoneNumber);
        return this;

    }
    public RegisterPage setEmailAddress(String emailAddress)
    {
        TestApp.getInstance().waitNextElementAppears(By.name(emailAddressElement),10);
        TestApp.getInstance().setText(By.name(emailAddressElement),emailAddress);
        return  this;

    }
    public RegisterPage setCountryName(String countryName)
    {
        TestApp.getInstance().waitNextElementAppears(By.name(countryNameElement),10);
        Select dropDownCountryMenu=new Select(driver.findElement(By.name(countryNameElement)));
        dropDownCountryMenu.selectByVisibleText(countryName);
        return this;
    }
    public RegisterPage setUserName(String userName)
    {
        TestApp.getInstance().waitNextElementAppears(By.name(userNameElement),10);
        TestApp.getInstance().setText(By.name(userNameElement),userName);
        return this;

    }
    public RegisterPage setPassword(String password)
    {
        TestApp.getInstance().waitNextElementAppears(By.name(passwordElement),10);
        TestApp.getInstance().setText(By.name(passwordElement),password);
        return  this;

    }
    public RegisterPage setConfirmPassword(String confirmPassword)
    {
        TestApp.getInstance().waitNextElementAppears(By.name(confirmPasswordElement),10);
        TestApp.getInstance().setText(By.name(confirmPasswordElement),confirmPassword);
        return this;
    }
    public RegisterSuccessPage setSubmit()
    {
        TestApp.getInstance().waitNextElementAppears(By.name(submitElement),10);
        driver.findElement(By.name(submitElement)).click();
        return new RegisterSuccessPage();
    }

}
