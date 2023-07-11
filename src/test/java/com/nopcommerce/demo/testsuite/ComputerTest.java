package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComputerTest extends BaseTest {
    BuildYourComputer buildYourOwnComputer = new BuildYourComputer();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    CheckOutPage checkoutPage = new CheckOutPage();
    HomePage homePage = new HomePage();
    ComputerPage computerPage = new ComputerPage();
    DeskTopPage desktopPage = new DeskTopPage();

    @Test
    public void verifyProductArrangeInAlphabaticalOrder() throws InterruptedException {
        //1.1 Click on Computer Menu.
        homePage.selectMenu("Computers");
        //1.2 Click on Desktop Category
        computerPage.clickOnDesktopCategory();
        //1.3 Select Sort By position "Name: Z to A"
        desktopPage.clickOnSortByNameZToA();
        //1.4 Verify the Product will arrange in Descending order.
        desktopPage.verifyProductsArrangedInAlphabeticallyDescendingOrder();
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        homePage.selectMenu("Computers");
        //2.2 Click on Desktop
        computerPage.clickOnDesktopCategory();
        //2.3 Select Sort By position "Name: A to Z"
        desktopPage.clickOnSortByNameAToZ();
        //2.4 Click on "Add To Cart"
        Thread.sleep(3000);
        waitUntilVisibilityOfElementLocated(By.xpath("(//button[@type='button'][normalize-space()='Add to cart'])[1]"),5000);
        desktopPage.clickOnAddToCartButton();
        //2.5 Verify the Text "Build your own computer"
        String actualText = buildYourOwnComputer.getTextFromBuildYourComputer();
        String expectedText = "Build your own computer";
        Assert.assertEquals(actualText, expectedText, "Text not Displayed");
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        buildYourOwnComputer.selectProcessor();
        //2.7.Select "8GB [+$60.00]" using Select class.
        buildYourOwnComputer.selectRAM();
        //2.8 Select HDD radio "400 GB [+$100.00]"
        buildYourOwnComputer.selectHDDRadio();
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        buildYourOwnComputer.selectOSRadio();
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        //buildYourOwnComputer.selectSoftwareMS();
        buildYourOwnComputer.selectTotalCommander();
        Thread.sleep(5000);
        //2.11 Verify the price "$1,475.00"
        String actualPriceText = buildYourOwnComputer.getTextFromPrice();
        String expectedPriceText = "$1,475.00";
        Assert.assertEquals(actualPriceText, expectedPriceText, "Text not Displayed");
        //2.12 Click on "ADD TO CARD" Button.
        buildYourOwnComputer.clickOnAddToCartButton();
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        buildYourOwnComputer.verifyTheProductHasBeenAddedToYourShoppingCart();
        buildYourOwnComputer.closeTheBarByClickingOnTheCrossButton();
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        buildYourOwnComputer.mouseHoverOnShoppingCartButton();
        buildYourOwnComputer.clickOnGoToCartButton();

    }
}


