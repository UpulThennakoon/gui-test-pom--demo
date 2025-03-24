package com.guru99.demo;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestApp;

public class RegisterUserTest1 {
    HomePage homePage;
    RegisterPage registerPage;
    RegisterSuccessPage registerSuccessPage;
    @BeforeMethod
    public void setUp()
    {
        TestApp.getInstance().openBrowser();
        TestApp.getInstance().navigateToURL();
        homePage =new HomePage();
        registerPage =new RegisterPage();
        registerSuccessPage= new RegisterSuccessPage();
    }
    @Test
    public void testRegisterUser()
    {
        registerPage= homePage.clickOnRegister();
        registerSuccessPage=registerPage.setFirstName("Thennakoon").setLastName("upul").setPhoneNumber("0701491880").setEmailAddress("upulthennakoon189@gmail.com").setCountryName("SRI LANKA").setUserName("upulthennakoon.com").setPassword("1234").setConfirmPassword("1234").setSubmit();
        Assert.assertEquals(registerSuccessPage.getConfirmMessageElement(),"Note: Your user name is upulthennakoon.com.","Failed to register  create new account");
    }
    @AfterMethod
    public void tearDown() {
        TestApp.getInstance().closeBrowser();
    }
}
