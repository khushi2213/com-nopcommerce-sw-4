package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElectronicsTest extends BaseTest {


    ElectronicsPage electronicsPage = new ElectronicsPage();
    CellPhonePage cellPhonesPage = new CellPhonePage();
    NokiaLumia1020Page nokiaLumia1020Page = new NokiaLumia1020Page();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    CheckOutPage checkoutPage = new CheckOutPage();
    HomePage homePage = new HomePage();

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        //1.1 Mouse Hover on “Electronics” Tab
        electronicsPage.hoverOnElectronics();
        //1.2 Mouse Hover on “Cell phones” and click
        electronicsPage.hoverOnCellPhoneAndClick();
        //1.3 Verify the text “Cell phones”
        String actualText = cellPhonesPage.getCellPhoneText();
        Assert.assertEquals(actualText, "Cell phones", "Text not Displayed");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        //2.1 Mouse Hover on “Electronics” Tab
        electronicsPage.hoverOnElectronics();
        //2.2 Mouse Hover on “Cell phones” and click
        electronicsPage.hoverOnCellPhoneAndClick();
        //2.3 Verify the text “Cell phones”
        String actualText = cellPhonesPage.getCellPhoneText();
        Assert.assertEquals(actualText, "Cell phones", "Text not Displayed");
        //2.4 Click on List View Tab
        cellPhonesPage.clickOnListViewTab();
        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        cellPhonesPage.clickOnNokiaLumia1020();
        //2.6 Verify the text “Nokia Lumia 1020”
        String actualNokiaLumiaText = nokiaLumia1020Page.getNokiaLumiaText();
        Assert.assertEquals(actualNokiaLumiaText, "Nokia Lumia 1020", "Text not Displayed");
        //2.7 Verify the price “$349.00”
        String actualNokiaPriceText = nokiaLumia1020Page.getNokiaPriceText();
        Assert.assertEquals(actualNokiaPriceText, "$349.00", "Text not Displayed");
        //2.8 Change quantity to 2
        nokiaLumia1020Page.changeQuantity();
        //2.9 Click on “ADD TO CART” tab
        nokiaLumia1020Page.clickOnAddToCartButton();
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar  After that close the bar clicking on the cross button.
        String actualTextShoppingCart = nokiaLumia1020Page.getTextFromProductAddedToCart();
        Assert.assertEquals(actualTextShoppingCart, "The product has been added to your shopping cart", "Text not Displayed");
        nokiaLumia1020Page.closeTheBarByClickingOnTheCrossButton();
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        nokiaLumia1020Page.mouseHoverOnShoppingCart();
        nokiaLumia1020Page.clickOnShoppingCart();
        //2.12 Verify the message "Shopping cart"
        String actualShoppingCartMessage = shoppingCartPage.getShoppingCartText();
        Assert.assertEquals(actualShoppingCartMessage, "Shopping cart", "error");
        Thread.sleep(2000);
        //2.13 Verify the quantity is 2
        String actualQuantity = shoppingCartPage.getVerifyQuantity();
        Assert.assertEquals(actualQuantity, "(2)", "Error");
        //2.14 Verify the Total $698.00
        String actualTotal = shoppingCartPage.getVerifyTotal();
        Assert.assertEquals(actualTotal, "$698.00", "Error");
        //2.15 click on checkbox “I agree with the terms of service”
        shoppingCartPage.clickOnTermsOfServiceCheckBox();
        //2.16 Click on “CHECKOUT”
        shoppingCartPage.clickOnCheckOutButton();
        //2.17 Verify the Text “Welcome, Please Sign In!”
        String actualWelcomeText = loginPage.getWelcomePageSignInText();
        Assert.assertEquals(actualWelcomeText, "Welcome, Please Sign In!", "Error");
        //2.18 Click on “REGISTER” tab
        loginPage.clickOnRegisterButton();
        //2.19 Verify the text “Register”
        String actualRegisterText = registerPage.getRegisterText();
        Assert.assertEquals(actualRegisterText, "Register", "Error");
        //2.20 Fill the mandatory fields
        registerPage.inputFirstname("Khushi");
        registerPage.inputLastname("Mishra");
        registerPage.inputEmail("khushi1233@gmail.com");
        registerPage.inputPassword("Khushi123");
        registerPage.inputConfirmPassword("Khushi123");
        //2.21 Click on “REGISTER” Button
        registerPage.clickOnRegisterButton();
        //2.22 Verify the message “Your registration completed”
        String actualRegisterSuccessMessage = registerPage.getRegisterSuccessText();
        Assert.assertEquals(actualRegisterSuccessMessage, "Your registration completed", "error");
        //2.23 Click on “CONTINUE” tab
        registerPage.clickOnContinueButton();
        //2.24 Verify the text “Shopping card”
        shoppingCartPage.getShoppingCartText();
        //2.25 click on checkbox “I agree with the terms of service”
        // Doesn't work after this due to the Bug in the Website

    }

}